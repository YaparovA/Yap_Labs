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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.info.web.model.AccessRightsModel;
import com.info.web.model.UserModel;
import com.info.web.service.AccessRightsService;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/access-rights")
public class AccessRightsController {

    private final AccessRightsService accessRightsService;

    @Autowired
    public AccessRightsController(AccessRightsService accessRightsService) {
        this.accessRightsService = accessRightsService;
    }

    @GetMapping
    public String getAllAccessRights(Model model) {
        model.addAttribute("accessRights", accessRightsService.findAllAccessRights());
        return "access-rights";
    }

    @GetMapping("/create")
    public String createAccessRightsForm(Model model) {
        model.addAttribute("accessRights", new AccessRightsModel());
        model.addAttribute("users", accessRightsService.findAllUsers());
        return "access-rights-create";
    }

    @PostMapping("/create")
    public String saveAccessRights(@Valid @ModelAttribute("accessRights") AccessRightsModel accessRights,
                                    @RequestParam Long userId,
                                    BindingResult bindingResult, 
                                    Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("users", accessRightsService.findAllUsers());
            return "access-rights-create";
        }
            
        UserModel user = accessRightsService.findUserById(userId);
        if (user != null) {
            accessRights.setUser(user);
            accessRightsService.createAccessRights(accessRights);
        } else {
            model.addAttribute("users", accessRightsService.findAllUsers());
            model.addAttribute("error", "Пользователь не найден");
            return "access-rights-create";
        }

        return "redirect:/access-rights";
    }

    @GetMapping("/{accessRightsId}/edit")
    public String editAccessRightsForm(@PathVariable("accessRightsId") long accessRightsId, Model model) {
        AccessRightsModel accessRights = accessRightsService.getAccessRightsById(accessRightsId);
        if (accessRights == null) {
            return "redirect:/access-rights";
        }
        model.addAttribute("accessRights", accessRights);
        model.addAttribute("users", accessRightsService.findAllUsers());
        return "access-rights-edit";
    }

    @PostMapping("/{accessRightsId}/edit")
    public String updateAccessRights(@PathVariable("accessRightsId") long accessRightsId, 
                                      @Valid @ModelAttribute("accessRights") AccessRightsModel accessRights,
                                      @RequestParam Long userId,
                                      BindingResult bindingResult, 
                                      Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("users", accessRightsService.findAllUsers());
            return "access-rights-edit";
        }

        UserModel user = accessRightsService.findUserById(userId);
        if (user != null) {
            accessRights.setUser(user);
            accessRights.setId(accessRightsId);
            accessRightsService.updateAccessRights(accessRights);
        } else {
            model.addAttribute("users", accessRightsService.findAllUsers());
            model.addAttribute("error", "Пользователь не найден");
            return "access-rights-edit";
        }

        return "redirect:/access-rights";
    }

    @GetMapping("/{accessRightsId}/delete")
    public String deleteAccessRights(@PathVariable("accessRightsId") Long accessRightsId) {
        accessRightsService.deleteAccessRights(accessRightsId);
        return "redirect:/access-rights";
    }
}
