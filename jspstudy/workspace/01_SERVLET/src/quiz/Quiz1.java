package quiz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Quiz1
 */
@WebServlet("/Quiz1")
public class Quiz1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Quiz1() {
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
		
		// cmd 요청이 없으면 시간을 보여 주는 것으로 처리
		Optional<String> optCmd = Optional.ofNullable(request.getParameter("cmd"));
		String cmd = optCmd.orElse("now");
		
		// Calendar
		Calendar cal = Calendar.getInstance();  // 현재 날짜와 시간을 구함.
		
		// result
		String result = null;
		
		switch (cmd) {
		case "now":
			int hour = cal.get(Calendar.HOUR);
			int minute = cal.get(Calendar.MINUTE);
			int second = cal.get(Calendar.SECOND);
			result = hour + ":" + minute + ":" + second;
			break;
		case "today":
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH) + 1;  // Calendar.MONTH : 0~11
			int day = cal.get(Calendar.DATE);
			result = year + "-" + month + "-" + day;
			break;
		}
		
		// response.setHeader("Content-Type", "text/html; charset=UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('" + result + "');");
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
