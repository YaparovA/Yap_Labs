package com.info.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.info.web.model.CityModel;
import com.info.web.model.RoleModel;
import com.info.web.model.UserModel;
import com.info.web.service.UserService;

import jakarta.validation.Valid;

@Controller
public class UserController {

	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/users")
	public String getAllUsers(Model model) {
	  model.addAttribute("users", userService.findAllUsers());
	  return "users";
	}
	  
	@GetMapping("/users/create")
	public String createUserForm(Model model) {
	  UserModel user = new UserModel();
	  model.addAttribute("user", user);
	  model.addAttribute("roles", userService.findAllRoles());
	  model.addAttribute("cities", userService.findAllCities());
	  return "user-create";
	}
	
	@PostMapping("/users/create")
	public String saveUser(@Valid @ModelAttribute("user") UserModel user,
						BindingResult bindingResult,
						@RequestParam Long roleId,
						@RequestParam Long cityId,						 
						Model model) {
		if (bindingResult.hasErrors()) {
	        model.addAttribute("roles", userService.findAllRoles());
	        model.addAttribute("cities", userService.findAllCities());
	        return "user-create";
	    }
	    RoleModel role = userService.findRoleById(roleId);
	    CityModel city = userService.findCityById(cityId);

	    if (role != null && city != null) {
	        user.setRole(role);
	        user.setCity(city);
	    } else {
	        model.addAttribute("roles", userService.findAllRoles());
	        model.addAttribute("cities", userService.findAllCities());
	        model.addAttribute("error", "Роль или город не найдены");
	        return "user-create";
	    }

	    userService.createUser(roleId, cityId, user);
	    return "redirect:/users";
	}
	
	@GetMapping("/users/{userId}/edit")
	public String editUserForm(@PathVariable("userId") long userId, Model model) {
		 UserModel user = userService.getUserById(userId);
		    if (user == null) {
		        return "redirect:/users";
		    }
		    model.addAttribute("user", user);
		    model.addAttribute("roles", userService.findAllRoles());
		    model.addAttribute("cities", userService.findAllCities());
		    return "user-edit";
		}
	
	@PostMapping("/users/{userId}/edit")
	public String updateUser(@PathVariable("userId") long userId, 
	                         @Valid @ModelAttribute("user") UserModel user,
	 						 BindingResult bindingResult,
	                         @RequestParam Long roleId,
	 						 @RequestParam Long cityId,
	 						 Model model) {
		UserModel userPre = userService.findUserById(userId);
		if (bindingResult.hasErrors()) {
			if (userPre != null) {
	 	    	user.setRole(userPre.getRole());
	 	    	user.setCity(userPre.getCity());
			}
 	        model.addAttribute("roles", userService.findAllRoles());
 	        model.addAttribute("cities", userService.findAllCities());
 	        return "user-edit";
 	    }
 	    RoleModel role = userService.findRoleById(roleId);
 	    CityModel city = userService.findCityById(cityId);
		

 	    if (role != null && city != null) {
 	        user.setRole(role);
 	        user.setCity(city);
 	    } else {
 	    	user.setRole(userPre.getRole());
 	    	user.setCity(userPre.getCity());
 	        model.addAttribute("roles", userService.findAllRoles());
 	        model.addAttribute("cities", userService.findAllCities());
 	        model.addAttribute("error", "Роль или город не найдены");
 	        return "user-edit";
 	    }

	    user.setId(userId); 
	    userService.updateUser(user); 
	    return "redirect:/users"; 
	}

	  
	@GetMapping("/users/{userId}/delete")
	public String deleteUser(@PathVariable("userId") Long userId) {
		userService.deleteUser(userId);
		return "redirect:/users";
	}
	
	
}
