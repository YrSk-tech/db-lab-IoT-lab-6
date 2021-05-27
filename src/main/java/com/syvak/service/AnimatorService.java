package com.syvak.service;

import com.syvak.domain.Animator;
import com.syvak.repository.AnimatorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimatorService implements AbstractService<Animator, Integer> {

  private final AnimatorRepository animatorRepository;

  public AnimatorService(AnimatorRepository animatorRepository) {
    this.animatorRepository = animatorRepository;
  }

  @Override
  public List<Animator> getAll() {
    return animatorRepository.findAll();
  }

  @Override
  public Animator getById(Integer id) {
    return animatorRepository.getOne(id);
  }

  @Override
  public Animator create(Animator animator) {
    return animatorRepository.save(animator);
  }

  @Override
  public Animator update(Integer id, Animator animator) {
    if (animatorRepository.findById(id).isPresent()) {
      return animatorRepository.save(animator);
    } else {
      return null;
    }
  }

  @Override
  public void deleteById(Integer id) {
    if (animatorRepository.findById(id).isPresent()) {
      animatorRepository.deleteById(id);
    }
  }
}
