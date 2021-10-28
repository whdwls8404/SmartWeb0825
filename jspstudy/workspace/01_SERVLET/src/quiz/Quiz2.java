package quiz;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Quiz2
 */
@WebServlet("/Quiz2")
public class Quiz2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Quiz2() {
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
		
		String date = request.getParameter("date");
		
		String from = request.getParameter("from");
		if (from.isEmpty()) {
			from = "민경태";
		}
		
		String to = request.getParameter("to");
		if (to.isEmpty()) {
			to = "배수지";
		}
		
		String content = request.getParameter("content");
		if (content.isEmpty()) {
			content = "사랑해~";
		}
		
		// 작성자 IP 알아내는 법
		// 1. 직접 접속한 경우   : request.getRemoteAddr()
		// 2. 거쳐서 접속한 경우 : request.getHeader("X-Forwarded-For")
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null) {
			ip = request.getRemoteAddr();
		}
		
		// 파일명
		String filename = date + "_" + from + ".txt";
		
		// 디렉터리
		File dir = new File("D:\\SmartWeb0825\\jspstudy\\workspace\\01_SERVLET\\storage");
		if (dir.exists() == false) {
			dir.mkdirs();
		}
		
		// 파일 저장 경로
		File file = new File(dir, filename);
		
		// 문자 기반 출력 스트림 생성
		// FileWriter, PrintWriter, BufferedWriter 등
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		
		// 데이터 보내기
		bw.write("작성일 : " + date + "\n");
		bw.write("보내는사람 : " + from + "\n");
		bw.write("받는사람 : " + to + "\n");
		bw.write(content + "\n");
		
		// 스트림 닫기
		if (bw != null) bw.close();
		
		// 응답
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('" + file.getAbsolutePath() + " 파일이 생성되었습니다.');");
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
