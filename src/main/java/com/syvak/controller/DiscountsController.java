package com.syvak.controller;

import com.syvak.domain.Discounts;
import com.syvak.dto.DiscountsDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.syvak.service.DiscountsService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/discounts")
@RestController
public class DiscountsController {
  private final DiscountsService discountsService;

  public DiscountsController(DiscountsService discountsService) {
    this.discountsService = discountsService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<DiscountsDto>> getAll() {
    List<Discounts> discounts = discountsService.getAll();
    List<DiscountsDto> storyLineDtos = new ArrayList<>();
    for (Discounts discount : discounts) {
      DiscountsDto discountsDto = new DiscountsDto(
          discount.getId(),
          discount.getName(),
          discount.getCost(),
          discount.getAgency_id()
      );
      storyLineDtos.add(discountsDto);
    }
    return new ResponseEntity<>(storyLineDtos, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<DiscountsDto> getById(@PathVariable Integer id) {
    Discounts discount = discountsService.getById(id);
    if (discount != null) {
      DiscountsDto storyLineDto = new DiscountsDto(
              discount.getId(),
              discount.getName(),
              discount.getCost(),
              discount.getAgency_id()
      );
      return new ResponseEntity<>(storyLineDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Void> create(@RequestBody Discounts newDiscounts) {
    discountsService.create(newDiscounts);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.PUT,
      value = "/{id}",
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<DiscountsDto> update(@PathVariable Integer id,
                                             @RequestBody Discounts discounts) {
    Discounts discountsOld = discountsService.getById(id);
    System.out.println(discountsOld);

    if (discountsOld != null) {
      discounts.setId(id);
      discountsService.update(id, discounts);
      DiscountsDto pilotOldDto = new DiscountsDto(
          discountsOld.getId(),
          discountsOld.getName(),
          discountsOld.getCost(),
          discountsOld.getAgency_id()
      );
      return new ResponseEntity<>(pilotOldDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
    if (discountsService.getById(id) != null) {
      discountsService.deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
