package com.info.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.web.model.RoleModel;
import com.info.web.repository.RoleRepository;

@Service
public class RoleService {
	private RoleRepository roleRepository;
	
	 @Autowired
	 public RoleService(RoleRepository roleRepository) {
		 this.roleRepository = roleRepository;
	 }
	 
	  public List<RoleModel> findAllRoles() {
		return roleRepository.findAll();
	  }
	  
	  public RoleModel findRoleById(Long id) {
	    return roleRepository.findById(id).orElse(null);
	  }
	  
	  public void saveRole(RoleModel role) {
	    roleRepository.save(role);
	  }
	  
	  public void updateRole(RoleModel role) {
		  RoleModel existingRole = roleRepository.findById(role.getId()).orElse(null);
		  if (existingRole != null) {
		        existingRole.setName(role.getName());
		        roleRepository.save(existingRole);
		  }
		  roleRepository.save(existingRole);
	  }
	  
	  public void deleteRole(Long id) {
	    roleRepository.deleteById(id);
	  }
}
