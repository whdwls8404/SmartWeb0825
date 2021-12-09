package com.koreait.ex12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.ex12.service.GalleryService;

@Controller
@RequestMapping("gallery")
public class GalleryController {

	private GalleryService service;
	
	public GalleryController(GalleryService service) {
		super();
		this.service = service;
	}

	@GetMapping(value="selectGalleryList")
	public String selectGalleryList(Model model) {
		model.addAttribute("list", service.selectGalleryList());
		return "gallery/list";
	}
	
}





