package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// URLMapping의 suffix가 .do인 모든 요청을 처리하는 컨트롤러
@WebServlet("*.do")

public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MyController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// URLMapping 확인
		String requestURI = request.getRequestURI();
		String command = requestURI.substring(requestURI.lastIndexOf("/") + 1);
		
		// command에 따른 model 선택
		switch (command) {
		case "rectangle.do":
			
			break;
		case "circle.do":
			
			break;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
