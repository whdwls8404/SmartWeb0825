package service.board;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDao;

public class BoardDeleteService implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 파라미터
		String param = request.getParameter("bNo");
		if (param == null || param.isEmpty()) {
			param = "0";
		}
		Long bNo = Long.parseLong(param);
		String path = request.getParameter("path");
		String saveName = request.getParameter("saveName");
		
		// 첨부 삭제
		String realPath = request.getServletContext().getRealPath(path);
		File file = new File(realPath, saveName);
		if (file.exists()) {
			file.delete();
		}
		
		// DB 삭제
		int result = BoardDao.getInstance().deleteBoard(bNo);
		
		PrintWriter out = response.getWriter();
		if (result > 0) {
			out.println("<script>");
			out.println("alert('게시글 삭제 성공')");
			out.println("location.href='list.board'");
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