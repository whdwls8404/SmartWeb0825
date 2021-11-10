package model;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;

public interface EmpService {
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
