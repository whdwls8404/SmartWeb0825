package service.free;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.FreeDao;

public class FreeDeleteService implements FreeService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("fNo"));
		Long fNo = Long.parseLong(opt.orElse("0"));
		
		int result = FreeDao.getInstance().deleteFree(fNo);
		
		PrintWriter out = response.getWriter();
		if (result > 0) {
			out.println("<script>");
			out.println("alert('게시글 삭제 성공')");
			out.println("location.href='list.free'");
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('게시글 삭제 실패')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		}
		return null;
		
	}

}