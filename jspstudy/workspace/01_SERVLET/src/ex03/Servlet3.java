package ex03;

import java.io.IOException;
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
		if (name == null) {
			name = "민경태";
		}
		String strAge = request.getParameter("age");
		if (strAge == null) {
			strAge = "44";
		}
		int age = Integer.parseInt(strAge);
		
		System.out.println(name + ", " + age);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
