package com.info.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.web.model.CityModel;
import com.info.web.model.RoleModel;
import com.info.web.model.UserModel;
import com.info.web.repository.CityRepository;
import com.info.web.repository.RoleRepository;
import com.info.web.repository.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private CityRepository cityRepository;
	
	@Autowired
	 public UserService(UserRepository userRepository, RoleRepository roleRepository, CityRepository cityRepository) {
		 this.userRepository = userRepository;
		 this.roleRepository = roleRepository;
		 this.cityRepository = cityRepository;
	 }
	  
	public List<UserModel> findAllUsers() {
	  return userRepository.findAll();
	}
	
	public List<RoleModel> findAllRoles() {
	    return roleRepository.findAll();
	}

	public List<CityModel> findAllCities() {
	    return cityRepository.findAll();
	}
	
	public UserModel findUserById(Long userId) {
	    return userRepository.findById(userId).orElse(null);
	}
	
	public RoleModel findRoleById(Long roleId) {
	    return roleRepository.findById(roleId).orElse(null);
	}

	public CityModel findCityById(Long cityId) {
	    return cityRepository.findById(cityId).orElse(null);
	}
	
	public void createUser(Long roleId, Long cityId, UserModel user) {
		RoleModel role = roleRepository.findById(roleId).orElse(null);
		CityModel city = cityRepository.findById(cityId).orElse(null);
		 if (role != null && city != null) {
		        user.setRole(role); 
		        user.setCity(city); 
		        userRepository.save(user); 
		    } else {
		        throw new IllegalArgumentException("Роль или город не найдены");
		    }
	}
	  
	public UserModel getUserById(Long id) {
	  return userRepository.findById(id).orElse(null);
	}
	  
	public void updateUser(UserModel user) {
		  UserModel existingUser = userRepository.findById(user.getId()).orElse(null);
		  if (existingUser != null) {
			  existingUser.setName(user.getName());
		      existingUser.setAge(user.getAge());
		      existingUser.setRole(user.getRole());
		      existingUser.setCity(user.getCity()); 
		      userRepository.save(existingUser);
		  }
		  userRepository.save(existingUser);
	  }
	  
	public void deleteUser(Long id) {
	  userRepository.deleteById(id);
	}
}
