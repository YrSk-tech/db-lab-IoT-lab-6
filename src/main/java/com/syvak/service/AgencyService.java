package com.syvak.service;

import com.syvak.domain.Agency;
import com.syvak.repository.AgencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyService implements AbstractService<Agency, Integer> {

  private final AgencyRepository agencyRepository;

  public AgencyService(AgencyRepository agencyRepository) {
    this.agencyRepository = agencyRepository;
  }

  @Override
  public List<Agency> getAll() {
    return agencyRepository.findAll();
  }

  @Override
  public Agency getById(Integer id) {
    return agencyRepository.getOne(id);
  }

  @Override
  public Agency create(Agency agency) {
    return agencyRepository.save(agency);
  }

  @Override
  public Agency update(Integer id, Agency agency) {
    if (agencyRepository.findById(id).isPresent()) {
      return agencyRepository.save(agency);
    } else {
      return null;
    }
  }

  @Override
  public void deleteById(Integer id) {
    if (agencyRepository.findById(id).isPresent()) {
      agencyRepository.deleteById(id);
    }
  }
}
