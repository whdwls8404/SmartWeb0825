package service.notice;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.NoticeDao;
import dto.Notice;

public class NoticeUpdateService implements NoticeService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Long nNo = Long.parseLong(request.getParameter("nNo"));
		
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);
		notice.setnNo(nNo);
		
		int result = NoticeDao.getInstance().updateNotice(notice);
		
		PrintWriter out = response.getWriter();
		if (result > 0) {
			out.println("<script>");
			out.println("alert('공지사항 수정 성공')");
			out.println("location.href='view.notice?nNo=" + nNo + "'");
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('공지사항 수정 실패')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		}
		
		return null;
		
	}

}