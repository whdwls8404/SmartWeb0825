package ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet4
 */
@WebServlet("/Servlet4")
public class Servlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		// request 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// Optional 클래스 : jdk 1.8 이상 지원
		// null 처리
		
		// Optional.of(인수) : 인수가 null이 아니면 처리
		/*
		String name = request.getParameter("name");
		Optional<String> optName = Optional.of(name);  // name이 null이 아니면 처리한다.
		System.out.println("이름 : " + optName.get());
		*/
		
		/*
		String name = request.getParameter("name");
		Optional<String> optName = Optional.ofNullable(name);  // name이 null인 경우도 처리한다.
		if (optName.isPresent()) {  // optName으로 감싼(wrap) 데이터가 있으면
			System.out.println("이름 : " + optName.get());
		}
		*/
		
		Optional<String> optName = Optional.ofNullable(request.getParameter("name"));
		String name = optName.orElse("민혁");  // optName으로 감싼 데이터가 null이면 "민혁" 사용
		
		Optional<String> optAge = Optional.ofNullable(request.getParameter("age"));
		int age = Integer.parseInt(optAge.orElse("34"));
		
		
		// response 타입
		response.setContentType("text/html; charset=UTF-8");
		
		// response 출력 스트림
		PrintWriter out = response.getWriter();
		
		out.println("<script>");
		out.println("alert('이름: " + name + ", 나이: " + age + "');");
		out.println("history.back();");
		out.println("</script>");
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
