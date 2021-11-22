package service.free;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.FreeDao;
import dto.Free;

public class FreeUpdateService implements FreeService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Long fNo = Long.parseLong(request.getParameter("fNo"));
		String content = request.getParameter("content");
		
		Free free = new Free();
		free.setfNo(fNo);
		free.setContent(content);
		
		int result = FreeDao.getInstance().updateFree(free);
		
		PrintWriter out = response.getWriter();
		if (result > 0) {
			out.println("<script>");
			out.println("alert('게시글 수정 성공')");
			out.println("location.href='view.free?fNo=" + fNo + "'");
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('게시글 수정 실패')");
			out.println("history.go(-2)");
			out.println("</script>");
			out.close();
		}
		
		return null;
		
	}

}
