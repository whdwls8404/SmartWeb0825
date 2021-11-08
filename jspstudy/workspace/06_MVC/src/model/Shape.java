package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Shape {
	public void execute(HttpServletRequest request, HttpServletResponse response);
}
