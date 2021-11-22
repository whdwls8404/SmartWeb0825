package service.free;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;

public interface FreeService {
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
