package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import service.free.FreeService;


@WebServlet("*.free")

public class FreeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FreeController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length() + 1);
		
		FreeService service = null;
		ModelAndView mav = null;
		
		switch (command) {
		
		}
		
		if (service != null) {
			try {
				mav = service.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (mav == null) {
			return;
		}
		
		if (mav.isRedirect()) {
			response.sendRedirect(mav.getView());
		} else {
			request.getRequestDispatcher(mav.getView()).forward(request, response);
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
