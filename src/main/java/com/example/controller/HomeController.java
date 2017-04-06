package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ozgen.gures on 05.04.2017.
 */
@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public String index(){
		return "index";
	}
}
