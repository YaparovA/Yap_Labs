package com.info.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.web.model.CityModel;
import com.info.web.repository.CityRepository;

@Service
public class CityService {
	private CityRepository cityRepository;
	
	 @Autowired
	 public CityService(CityRepository cityRepository) {
		 this.cityRepository = cityRepository;
	 }
	 
	  public List<CityModel> findAllCities() {
		return cityRepository.findAll();
	  }
	  
	  public CityModel findCityById(Long id) {
	    return cityRepository.findById(id).orElse(null);
	  }
	  
	  public void saveCity(CityModel role) {
		  cityRepository.save(role);
	  }
	  
	  public void updateCity(CityModel role) {
		  CityModel existingCity = cityRepository.findById(role.getId()).orElse(null);
		  if (existingCity != null) {
			  existingCity.setName(role.getName());
		      cityRepository.save(existingCity);
		  }
		  cityRepository.save(existingCity);
	  }
	  
	  public void deleteCity(Long id) {
	    cityRepository.deleteById(id);
	  }
}
