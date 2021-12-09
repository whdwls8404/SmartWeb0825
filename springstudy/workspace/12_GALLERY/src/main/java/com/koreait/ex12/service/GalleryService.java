package com.koreait.ex12.service;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.ex12.domain.Gallery;

public interface GalleryService {
	
	// abstract method
	public List<Gallery> selectGalleryList();
	public Gallery selectGalleryByNo(Long no);
	public void insertGallery(MultipartHttpServletRequest multipartRequest, HttpServletResponse response);
	public int updateGallery(Gallery gallery);
	public int deleteGallery(Long no);
	
	// default method
	public default void message(int result, HttpServletResponse response, 
			String success, String fail, String path) {
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if (result > 0) {
				out.println("<script>");
				out.println("alert('" + success + "')");
				out.println("location.href='" + path + "'");
				out.println("</script>");
				out.close();
			} else {
				out.println("<script>");
				out.println("alert('" + fail + "')");
				out.println("history.back()");
				out.println("</script>");
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
