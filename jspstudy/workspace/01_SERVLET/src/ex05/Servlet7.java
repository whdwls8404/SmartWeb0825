package ex05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet7
 */
@WebServlet("/Servlet7")
public class Servlet7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet7() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("UTF-8");
		
		// String 변수 파라미터 : getParameter()
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		String secret = request.getParameter("secret");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String info = request.getParameter("info");
		
		// String[] 배열 파라미터 : getParameterValues()
		String[] nicknames = request.getParameterValues("nicknames");
		String[] hobbies = request.getParameterValues("hobbies");
		
		// 응답
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"ko\">");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>제목</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>이름: " + name + "</h3>");
		out.println("<h3>비번: " + pw + "</h3>");
		out.println("<h3>비밀: " + secret + "</h3>");
		out.println("<h3>성별: " + (gender.equals("M") ? "남자" : "여자") + "</h3>");
		out.println("<h3>주소: " + address + "</h3>");
		out.println("<h3>정보</h3>");
		out.println("<pre>" + info + "</pre>");
		out.println("<h3>별명들</h3>");
		for (int i = 0; i < nicknames.length; i++) {
			out.println(nicknames[i] + "<br>");			
		}
		out.println("<h3>취미들</h3>");
		out.println("<ul>");
		for (String hobby : hobbies) {
			out.println("<li>" + hobby + "</li>");			
		}
		out.println("</ul>");
		out.println("<input type=\"button\" value=\"돌아가기\" onclick=\"history.back()\">");
		out.println("</body>");
		out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
