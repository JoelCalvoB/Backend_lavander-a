package com.entrecodigos.lavamax.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class vistaController {

	@GetMapping({"","/","/index"})
	public String index() {
		return "index";
	}
}
