package ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet3
 */
@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// 1. 사용자 요청 처리
		
		// 디폴트 처리
		// name이 전달되지 않으면 "민경태" 사용
		// age가 전달되지 않으면 44 사용
		
		// 1) 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		
		// 2) 파라미터 처리
		//    파라미터는 항상 String으로 전달됨.
		String name = request.getParameter("name");
		if (name == null || name.isEmpty()) {  // 자바는 문자열을 equals()로 비교함. name.equals("")
			name = "민경태";
		}
		String strAge = request.getParameter("age");
		if (strAge == null || strAge.isEmpty()) {
			strAge = "44";
		}
		int age = Integer.parseInt(strAge);
		
		// 2. 사용자 응답 처리
		
		// 1) 응답 타입 & 인코딩 처리
		response.setContentType("text/html; charset=UTF-8");
		
		// 2) 응답 스트림(사용자에게 정보를 출력하는 스트림)
		//    코드 작성을 위해서 문자 출력 스트림을 사용 : PrintWriter 사용
		PrintWriter out = response.getWriter();
		
		// 3) 응답 코드 작성
		out.println("<script>");
		out.println("alert('전송된 이름은 " + name + "이고, 나이는 " + age + "살입니다.');");
		out.println("history.back();");
		out.println("</script>");
		out.close();
		out.flush();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost() 들렸음.");
		doGet(request, response);
	}

}
