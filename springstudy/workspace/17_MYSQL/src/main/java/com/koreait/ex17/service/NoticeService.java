package com.koreait.ex17.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.koreait.ex17.domain.Notice;

public interface NoticeService {

	public void findAll(Model model);
	public void find(Model model);
	public Notice detail(Long no);
	public void add(Notice notice, HttpServletResponse response);
	public void modify(Notice notice, HttpServletResponse response);
	public void remove(Long no, HttpServletResponse response);
	
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
