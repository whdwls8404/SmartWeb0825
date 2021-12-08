package com.koreait.ex10.service;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.koreait.ex10.domain.Notice;

public interface NoticeService {
	
	public List<Notice> selectNoticeList();
	public void insertNotice(Notice notice, HttpServletResponse response);
	public Notice selectNoticeByNo(Long no);
	public void updateNotice(Notice notice, HttpServletResponse response);
	public void deleteNotice(Long no, HttpServletResponse response);
	
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
