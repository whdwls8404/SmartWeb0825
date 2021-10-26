package ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 * javadoc : 주석이 문서화가 됨.
 * 
 * - servlet 실행 -> 웹 서버를 통해서 웹 브라이저가 실행됨.
 * - URL 구성 -> http://localhost:9090/01_SERVLET/MyServlet
 */

@WebServlet("/MyServlet")  // @WebServlet(URLMapping)

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * 1. 생성자
     *     1) 가장 먼저 실행된다.
     *     2) 실행 후 init() 메소드를 실행한다.
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("MyServlet 생성자 호출");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 * 2. init() 메소드
	 *    1) 최초 1번만 실행된다.
	 *    2) 환경 설정(Config) 용도로 사용한다.
	 *    3) init() 실행 뒤 service()가 실행된다.
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init() 메소드 호출");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 * 3. service() 메소드
	 *    1) 실제 업무 처리를 할 수 있다.
	 *    2) 실제 업무 : 요청(request)과 응답(response)
	 *       (1) 요청(request)
	 *           ① 사용자가 서버로 데이터를 보내는 것이다.
	 *           ② 매개변수 HttpServletRequest request 객체를 이용한다.
	 *       (2) 응답(response)
	 *           ① 서버가 사용자에게 데이터를 보내는 것이다.
	 *           ② 매개변수 HttpServletResponse response 객체를 이용한다.
	 *    3) service() 메소드가 없으면 doGet(), doPost() 메소드가 대신 업무를 처리한다.
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service() 메소드 호출");
		if (request.getMethod().equalsIgnoreCase("get")) {  // 대소문자 무시 이유 : <form method="get" method="GET">
			System.out.println("doGet() 메소드 호출하겠음.");
			doGet(request, response);
		} else if (request.getMethod().equalsIgnoreCase("post")) {
			System.out.println("doPost() 메소드 호출하겠음.");
			doPost(request, response);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 4. doGet() 메소드
	 *    1) get 방식의 요청을 처리하는 서버 측 메소드이다.
	 *       (1) 주소창(URL)을 이용한 접근
	 *       (2) <form method="get"> 또는 <form>
	 *       (3) $.ajax({
	 *       	     'type': 'get'
	 *           });
	 *    2) 사용자의 요청은 HttpServletRequest request로 처리한다.
	 *       (1) URL에 포함된 파라미터(http://호스트:포트/컨택스트패스/URL매핑?파라미터=값&파라미터=값)
	 *       (2) <form method="get">
	 *       	     <input name="파라미터">
	 *       		 <select name="파라미터">
	 *       		 <textarea name="파라미터">
	 *       	 </form>
	 *       (3) $.ajax({
	 *       	     'type': 'get',
	 *               'data': 파라미터=값&파라미터=값
	 *           });
	 *       (4) 위의 3가지 모든 경우 getParameter("파라미터")를 통해서 요청을 알아낸다.
	 *    3) 사용자에게 돌려 줄 응답은 HttpServletResponse response로 처리한다.
	 *    4) service() 메소드가 없으면 실제 업무 처리는 doGet()이 담당한다.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// 1. 사용자의 요청 파라미터 처리하기
		
		// 1) 요청에 포함된 한글 처리
		request.setCharacterEncoding("UTF-8");
		// 2) 요청 파라미터 꺼내기
		String userName = request.getParameter("userName");
		String userAge = request.getParameter("userAge");
		// 3) 확인
		System.out.println("userName: " + userName);
		System.out.println("userAge: " + userAge);
		
		// 2. 사용자에게 보여 줄 응답 만들기
		
		// 1) 사용자에게 보여 줄 응답 형식 지정(HTML문서로 응답)
		response.setContentType("text/html; charset=UTF-8");
		
		// 2) 응답의 한글 처리
		response.setCharacterEncoding("UTF-8");
		
		// 3) 응답 만들기
		//    (1) HTML 문서를 만들기 위해서 필요한 스트림은 "문자 기반 스트림"이다.
		//    (2) FileWriter, BufferedWriter, PrintWriter 등을 사용할 수 있다. (수업은 PrintWriter 사용)
		
		// 3-1) 응답 스트림 생성
		PrintWriter out = response.getWriter();
		
		// 3-2) 응답 내용(HTML) 생성
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"ko\">");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>나의 첫 서블릿</title>");
		out.println("<style>body { background-color: yellow; }</style>");
		out.println("<script>alert('이름과 나이를 확인하세요.');</script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>이름: " + userName + "</h1>");
		out.println("<h1>나이: " + userAge + "</h1>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 5. doPost() 메소드
	 *    1) post 방식의 요청을 처리하는 메소드이다.
	 *       (1) <form method="post">
	 *       (2) $.ajax({
	 *       	     'type': 'post'
	 *           });
	 *    2) doPost()는 아무 일도 하지 않는다. 모든 업무를 doGet() 메소드에게 위임한다.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
