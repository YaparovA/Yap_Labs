package com.info.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.info.web.model.RoleModel;
import com.info.web.service.RoleService;

import jakarta.validation.Valid;


@Controller
public class RoleController {
	private RoleService roleService;
	
	@Autowired
	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}
	  
	@GetMapping("/roles")
	public String getAllRoles(Model model) {
	  model.addAttribute("roles", roleService.findAllRoles());
	  return "roles";
	}
	
	@GetMapping("/roles/create")
	public String createRoleForm(Model model) {
		RoleModel role = new RoleModel();
		model.addAttribute("role", role);
		return "role-create";
	}
	
	@PostMapping("/roles/create")
	public String saveRoleForm(@Valid @ModelAttribute("role") RoleModel role, 
							BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("role",role);
	        return "role-create";
		}
		roleService.saveRole(role);
		return "redirect:/roles";
	}
	
	@GetMapping("/roles/{roleId}/edit")
	public String editRoleForm(@PathVariable("roleId") long roleId, Model model) {
		RoleModel role = roleService.findRoleById(roleId);
		model.addAttribute("role", role);
		return "role-edit";
	}
	
	@PostMapping("/roles/{roleId}/edit")
	public String updateRoleForm(@PathVariable("roleId") long roleId, 
								@Valid @ModelAttribute("role") RoleModel role,
								BindingResult result, Model model) {
		if(result.hasErrors()) {
            model.addAttribute("role", role);
            return "role-edit";
        }
		role.setId(roleId);
		roleService.updateRole(role);
		return "redirect:/roles";
	}
	  
	@GetMapping("/roles/{roleId}/delete")
	public String deleteRole(@PathVariable("roleId") Long roleId) {
		roleService.deleteRole(roleId);
		return "redirect:/roles";
	}
	

}
