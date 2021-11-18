package service.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;

public interface NoticeService {
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
