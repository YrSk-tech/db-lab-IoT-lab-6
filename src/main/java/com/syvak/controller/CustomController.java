package com.syvak.controller;

import com.syvak.domain.Custom;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.syvak.dto.CustomDto;
import com.syvak.service.CustomService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/custom")
@RestController
public class CustomController {
    private final CustomService customService;

    public CustomController(CustomService customService) {
        this.customService = customService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CustomDto>> getAll() {
        List<Custom> customs = customService.getAll();
        List<CustomDto> customDtos = new ArrayList<>();
        for (Custom custom : customs) {
            CustomDto customDto = new CustomDto(
                    custom.getId(),
                    custom.getDate(),
                    custom.getDuration_in_hours(),
                    custom.getAddress(),
                    custom.getCost_in_uah()
            );
            customDtos.add(customDto);
        }
        return new ResponseEntity<>(customDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<CustomDto> getById(@PathVariable Integer id) {
        Custom custom = customService.getById(id);
        if (custom != null) {
            CustomDto customDto = new CustomDto(
                    custom.getId(),
                    custom.getDate(),
                    custom.getDuration_in_hours(),
                    custom.getAddress(),
                    custom.getCost_in_uah()
            );
            return new ResponseEntity<>(customDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody Custom newCustom) {
        customService.create(newCustom);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CustomDto> update(@PathVariable Integer id,
                                            @RequestBody Custom custom) {
        Custom customOld = customService.getById(id);
        if (customOld != null) {
            customService.update(id, custom);
            CustomDto flightOldDto = new CustomDto(
                    customOld.getId(),
                    customOld.getDate(),
                    customOld.getDuration_in_hours(),
                    customOld.getAddress(),
                    customOld.getCost_in_uah()
            );
            return new ResponseEntity<>(flightOldDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (customService.getById(id) != null) {
            customService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
