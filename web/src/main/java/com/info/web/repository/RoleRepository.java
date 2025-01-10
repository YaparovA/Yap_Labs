package com.info.web.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.web.model.RoleModel;

public interface RoleRepository extends JpaRepository<RoleModel, Long>{
	Optional<RoleModel> findByName(String url);
}
