package com.koreait.ex08.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.ex08.service.ContactService;

@Controller
@RequestMapping(value="contact")
public class ContactController {

	
	// field
	@Autowired
	private ContactService service;
	
	
	// method
	@GetMapping(value="selectContactList")
	public String selectContactList(Model model) {
		model.addAttribute("list", service.findAllContact());
		return "contact/list";
	}
	
}








