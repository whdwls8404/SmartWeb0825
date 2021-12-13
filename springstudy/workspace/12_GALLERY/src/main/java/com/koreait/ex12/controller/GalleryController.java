package com.koreait.ex12.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.ex12.domain.Gallery;
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
	
	@GetMapping(value="insertPage")
	public String insertPage() {
		return "gallery/insert";
	}
	
	@PostMapping(value="insertGallery")
	public void insertGallery(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) {
		service.insertGallery(multipartRequest, response);
	}
	
	@GetMapping(value="selectGalleryByNo")
	public String selectGalleryByNo(@RequestParam("no") Long no, Model model) {
		model.addAttribute("gallery", service.selectGalleryByNo(no));
		return "gallery/detail";
	}
	
	@PostMapping(value="download")
	public void download(HttpServletRequest request, HttpServletResponse response) {
		service.download(request, response);
	}
	
	@PostMapping(value="updateGallery")
	public void updateGallery(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) {
		service.updateGallery(multipartRequest, response);
	}
	
	@PostMapping(value="deleteGallery")
	public void deleteGallery(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) {
		service.deleteGallery(multipartRequest, response);
	}
	
	@GetMapping(value="selectFileList", produces="application/json")
	@ResponseBody
	public Map<String, Object> selectFileList(HttpServletRequest request) {
		return service.selectFileList(request);
	}
	
}
