package org.lessons.java.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class PageController 
{

	
	@GetMapping("/")		// just "/" instead of /homepage making the home page the root of my domain
	public String homepage( Model model )
	{
		model.addAttribute("name", "Nasty");
		return "homepage";
	}
