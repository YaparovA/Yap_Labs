package com.info.web.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.web.model.CityModel;

public interface CityRepository extends JpaRepository<CityModel, Long>{
	Optional<CityModel> findByName(String url);
}