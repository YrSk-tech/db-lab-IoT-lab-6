package com.syvak.controller;

import com.syvak.domain.Award;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.syvak.dto.AwardsDto;
import com.syvak.service.AwardsService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/award")
@RestController
public class AwardsController {
  private final AwardsService awardService;

  public AwardsController(AwardsService awardService) {
    this.awardService = awardService;
  }

  @RequestMapping(method = RequestMethod.GET)

  public ResponseEntity<List<AwardsDto>> getAll() {
    List<Award> awards = awardService.getAll();
    List<AwardsDto> awardsDtos = new ArrayList<>();
    for (Award award : awards) {
      AwardsDto commentDto = new AwardsDto(
              award.getId(),
              award.getName(),
              award.getYear(),
              award.getNomination(),
              award.getAgency_id()
      );
      awardsDtos.add(commentDto);
    }
    return new ResponseEntity<>(awardsDtos, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<AwardsDto> getById(@PathVariable Integer id) {
    Award award = awardService.getById(id);
    if (award != null) {
      AwardsDto awardsDto = new AwardsDto(
              award.getId(),
              award.getName(),
              award.getYear(),
              award.getNomination(),
              award.getAgency_id()
      );
      return new ResponseEntity<>(awardsDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Void> create(@RequestBody Award newAwards) {
    awardService.create(newAwards);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.PUT,
      value = "/{id}",
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<AwardsDto> update(@PathVariable Integer id,
                                          @RequestBody Award award) {
    Award awardOld = awardService.getById(id);
    if (awardOld != null) {
      award.setId(id);
      awardService.update(id, award);
      AwardsDto awardOldDto = new AwardsDto(
              awardOld.getId(),
              awardOld.getName(),
              awardOld.getYear(),
              awardOld.getNomination(),
              awardOld.getAgency_id()
      );
      return new ResponseEntity<>(awardOldDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
    if (awardService.getById(id) != null) {
      awardService.deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }


}
