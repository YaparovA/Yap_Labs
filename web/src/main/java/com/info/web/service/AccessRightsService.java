package com.info.web.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.web.model.AccessRightsModel;
import com.info.web.model.UserModel;
import com.info.web.repository.AccessRightsRepository;
import com.info.web.repository.UserRepository;

@Service
public class AccessRightsService {
    private final AccessRightsRepository accessRightsRepository;
    private final UserRepository userRepository;

    @Autowired
    public AccessRightsService(AccessRightsRepository accessRightsRepository, UserRepository userRepository) {
        this.accessRightsRepository = accessRightsRepository;
        this.userRepository = userRepository;
    }

    public List<AccessRightsModel> findAllAccessRights() {
        return accessRightsRepository.findAll();
    }
	
    public UserModel findUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
    
    public List<UserModel> findAllUsers() {
        return userRepository.findAll(); // Add this line to retrieve all users
    }

    public void createAccessRights(AccessRightsModel accessRights) {
        accessRightsRepository.save(accessRights);
    }

    public AccessRightsModel getAccessRightsById(Long id) {
        return accessRightsRepository.findById(id).orElse(null);
    }

    public void updateAccessRights(AccessRightsModel accessRights) {
        AccessRightsModel existingAccessRights = accessRightsRepository.findById(accessRights.getId()).orElse(null);
        if (existingAccessRights != null) {
            LocalDateTime createdOn = existingAccessRights.getCreatedOn();
            
            existingAccessRights.setName(accessRights.getName());
            existingAccessRights.setUser(accessRights.getUser());
            existingAccessRights.setCreatedOn(createdOn);
            
            accessRightsRepository.save(existingAccessRights);
        }
    }

    public void deleteAccessRights(Long id) {
        accessRightsRepository.deleteById(id);
    }
}
