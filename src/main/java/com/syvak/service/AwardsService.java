package com.syvak.service;

import com.syvak.domain.Award;
import com.syvak.repository.AwardsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AwardsService implements AbstractService<Award, Integer> {

  private final AwardsRepository awardsRepository;

  public AwardsService(AwardsRepository awardsRepository) {
    this.awardsRepository = awardsRepository;
  }

  @Override
  public List<Award> getAll() {
    return awardsRepository.findAll();
  }

  @Override
  public Award getById(Integer id) {
    return awardsRepository.getOne(id);
  }

  @Override
  public Award create(Award comment) {
    return awardsRepository.save(comment);
  }

  @Override
  public Award update(Integer id, Award comment) {
    if (awardsRepository.findById(id).isPresent()) {
      return awardsRepository.save(comment);
    } else {
      return null;
    }

  }

  @Override
  public void deleteById(Integer id) {
    if (awardsRepository.findById(id).isPresent()) {
      awardsRepository.deleteById(id);
    }

  }
}
