package com.info.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HelloController {

	@GetMapping("/")
    public String hello(Model model) {
        return "hello"; // имя HTML-шаблона без расширения
    }
}
