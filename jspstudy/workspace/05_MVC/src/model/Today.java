package model;

import javax.servlet.http.HttpServletRequest;

public class Today {

	public void execute(HttpServletRequest request) {
		System.out.println(request.getParameter("name"));
	}

}
