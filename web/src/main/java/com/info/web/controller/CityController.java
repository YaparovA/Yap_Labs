package com.info.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.info.web.model.CityModel;
import com.info.web.service.CityService;

import jakarta.validation.Valid;

@Controller
public class CityController {
	private CityService cityService;
	
	@Autowired
	public CityController(CityService cityService) {
		this.cityService = cityService;
	}
	  
	@GetMapping("/cities")
	public String getAllCities(Model model) {
	  model.addAttribute("cities", cityService.findAllCities());
	  return "cities";
	}
	
	@GetMapping("/cities/create")
	public String createCityForm(Model model) {
		CityModel City = new CityModel();
		model.addAttribute("city", City);
		return "city-create";
	}
	
	@PostMapping("/cities/create")
	public String saveCityForm(@Valid @ModelAttribute("city") CityModel City, 
							BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("City",City);
	        return "city-create";
		}
		cityService.saveCity(City);
		return "redirect:/cities";
	}
	
	@GetMapping("/cities/{cityId}/edit")
	public String editCityForm(@PathVariable("cityId") long CityId, Model model) {
		CityModel City = cityService.findCityById(CityId);
		model.addAttribute("city", City);
		return "city-edit";
	}
	
	@PostMapping("/cities/{cityId}/edit")
	public String updateCityForm(@PathVariable("cityId") long CityId, 
								@Valid @ModelAttribute("city") CityModel City,
								BindingResult result, Model model) {
		if(result.hasErrors()) {
            model.addAttribute("city", City);
            return "city-edit";
        }
		City.setId(CityId);
		cityService.updateCity(City);
		return "redirect:/cities";
	}
	  
	@GetMapping("/cities/{cityId}/delete")
	public String deleteCity(@PathVariable("cityId") Long CityId) {
		cityService.deleteCity(CityId);
		return "redirect:/cities";
	}
}
