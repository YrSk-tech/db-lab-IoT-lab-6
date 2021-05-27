package com.syvak.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.syvak.domain.Agency;
import com.syvak.dto.AgencyDto;
import com.syvak.service.AgencyService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/agency")
@RestController
public class AgencyController {
  private final AgencyService agencyService;

  public AgencyController(AgencyService agencyService) {
    this.agencyService = agencyService;
  }

  @RequestMapping(method = RequestMethod.GET)

  public ResponseEntity<List<AgencyDto>> getAll() {
    List<Agency> agencies = agencyService.getAll();
    List<AgencyDto> agencyDtos = new ArrayList<>();
    for (Agency reaction : agencies) {
      AgencyDto agencyDto = new AgencyDto(
          reaction.getId(),
          reaction.getName(),
          reaction.getPhone_number()
      );
      agencyDtos.add(agencyDto);
    }
    return new ResponseEntity<>(agencyDtos, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<AgencyDto> getById(@PathVariable Integer id) {
    Agency reaction = agencyService.getById(id);
    if (reaction != null) {
      AgencyDto agencyDto = new AgencyDto(
          reaction.getId(),
          reaction.getName(),
          reaction.getPhone_number()
      );
      return new ResponseEntity<>(agencyDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Void> create(@RequestBody Agency newAgency) {
    agencyService.create(newAgency);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.PUT,
      value = "/{id}",
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<AgencyDto> update(@PathVariable Integer id,
                                          @RequestBody Agency agency) {
    Agency agencyOld = agencyService.getById(id);
    if (agencyOld != null) {
      agencyService.update(id, agency);
      AgencyDto reactionsOldDto = new AgencyDto(
          agencyOld.getId(),
          agencyOld.getName(),
          agencyOld.getPhone_number()
      );
      return new ResponseEntity<>(reactionsOldDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
    if (agencyService.getById(id) != null) {
      agencyService.deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
