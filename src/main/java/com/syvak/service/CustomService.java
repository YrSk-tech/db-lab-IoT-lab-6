package com.syvak.service;

import com.syvak.domain.Custom;
import com.syvak.repository.CustomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomService implements AbstractService<Custom, Integer> {

  private final CustomRepository customRepository;

  public CustomService(CustomRepository customRepository) {
    this.customRepository = customRepository;
  }

  @Override
  public List<Custom> getAll() {
    return customRepository.findAll();
  }

  @Override
  public Custom getById(Integer id) {
    return customRepository.getOne(id);
  }

  @Override
  public Custom create(Custom custom) {
    return customRepository.save(custom);
  }

  @Override
  public Custom update(Integer id, Custom custom) {
    if (customRepository.findById(id).isPresent()) {
      return customRepository.save(custom);
    } else {
      return null;
    }
  }

  @Override
  public void deleteById(Integer id) {
    if (customRepository.findById(id).isPresent()) {
      customRepository.deleteById(id);
    }
  }
}
