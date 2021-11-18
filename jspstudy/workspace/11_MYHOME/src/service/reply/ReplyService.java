package service.reply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;

public interface ReplyService {
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
