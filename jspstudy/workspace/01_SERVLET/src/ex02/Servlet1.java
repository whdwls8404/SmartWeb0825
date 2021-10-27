package ex02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 * 
 * 1. 서블릿 실행
 *    1) 톰캣이 실행한다.
 *    2) 톰캣의 컨테이너에 서블릿이 담긴다.
 *    3) URL
 *       http://hostname:port/contextpath/URLMapping
 * 2. Context Path
 *    1) 디폴트는 프로젝트명과 같다.
 *    2) 프로젝트의 Properties(속성)에서 수정할 수 있다.
 *       Properties - Web Project Settings - Context root
 * 3. URLMapping
 *    1) @WebServlet 애너테이션을 수정한다.
 *    2) web.xml에서 <servlet>, <servlet-mapping> 태그를 추가한다.
 */

// URLMapping이 2개 이상인 경우 문자열 배열로 등록
@WebServlet({ "/Servlet1", "/S1" })

public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
