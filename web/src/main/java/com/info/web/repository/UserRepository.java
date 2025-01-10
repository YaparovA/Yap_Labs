package com.info.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.web.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>{

}
