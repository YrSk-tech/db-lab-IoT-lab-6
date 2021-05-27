package com.syvak.controller;

import com.syvak.domain.Animator;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.syvak.dto.AnimatorDto;
import com.syvak.service.AnimatorService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/animator")
@RestController
public class AnimatorController {
  private final AnimatorService animatorService;

  public AnimatorController(AnimatorService animatorService) {
    this.animatorService = animatorService;
  }

  @RequestMapping(method = RequestMethod.GET)

  public ResponseEntity<List<AnimatorDto>> getAll() {
    List<Animator> animators = animatorService.getAll();
    List<AnimatorDto> animatorDtos = new ArrayList<>();
    for (Animator animator : animators) {
      AnimatorDto animatorDto = new AnimatorDto(
          animator.getId(),
          animator.getName(),
          animator.getSurname(),
          animator.getLastName(),
          animator.getAge()
      );
      animatorDtos.add(animatorDto);
    }
    return new ResponseEntity<>(animatorDtos, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<AnimatorDto> getById(@PathVariable Integer id) {
    Animator animatorOld = animatorService.getById(id);
    if (animatorOld != null) {
      AnimatorDto animatorDto = new AnimatorDto(
          animatorOld.getId(),
          animatorOld.getName(),
          animatorOld.getSurname(),
          animatorOld.getLastName(),
          animatorOld.getAge()
      );
      return new ResponseEntity<>(animatorDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Void> create(@RequestBody Animator newAnimator) {
    animatorService.create(newAnimator);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.PUT,
      value = "/{id}",
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<AnimatorDto> update(@PathVariable Integer id,
                                            @RequestBody Animator animator) {
    Animator animatorOld = animatorService.getById(id);
    if (animatorOld != null) {
      animatorService.update(id, animator);
      AnimatorDto animatorOldDto = new AnimatorDto(
              animator.getId(),
              animator.getName(),
              animator.getSurname(),
              animator.getLastName(),
              animator.getAge()
      );
      return new ResponseEntity<>(animatorOldDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
    if (animatorService.getById(id) != null) {
      animatorService.deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
