package com.info.web.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.web.model.AccessRightsModel;
import com.info.web.model.RoleModel;

public interface AccessRightsRepository extends JpaRepository<AccessRightsModel, Long>{
	Optional<AccessRightsModel> findByName(String url);
}
