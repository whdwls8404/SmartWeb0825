package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Now;
import model.Today;

// @WebServlet({"/today.do", "/now.do"})

// suffix 값이 .do인 모든 요청을 처리하시오.
@WebServlet("*.do")

public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MyController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// request.getRequestURI() : 요청을 확인하는 용도로 사용함.
		
		// String[] arr = request.getRequestURI().split("/");
		// System.out.println(arr[arr.length - 1]);
		
		int begin = request.getRequestURI().lastIndexOf("/");
		String command = request.getRequestURI().substring(begin + 1);
		
		
		// 요청에 따른 Model의 선택
		
		/*
		if (command.equals("today.do")) {
			Today today = new Today();
			today.execute();
		} else if (command.equals("now.do")) {
			
		}
		*/
		
		switch (command) {
		case "today.do":
			Today today = new Today();
			today.execute(request);
			break;
		case "now.do":
			Now now = new Now();
			now.execute();
			break;
		}
		
		
		request.getRequestDispatcher("views/output.jsp").forward(request, response);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}




