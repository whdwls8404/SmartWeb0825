package service.reply;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.ReplyDao;
import dto.Reply;

public class ReplyInsertService implements ReplyService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		Long nNo = Long.parseLong(request.getParameter("nNo"));
		String ip = request.getRemoteAddr();
		
		Reply reply = new Reply();
		reply.setWriter(writer);
		reply.setContent(content);
		reply.setnNo(nNo);
		reply.setIp(ip);
		
		int result = ReplyDao.getInstance().insertReply(reply);
		
		if (result > 0) {
			
			// 댓글이 삽입되면 댓글리스트(replyList)를 DB에서 새로 가져와야 한다.
			// 따라서, 댓글리스트(replyList)를 DB에서 가져오는 서비스인 NoticeViewService를
			// 실행할 수 있는 "view.notice" 매핑으로 이동한다.
			
			// "view.notice"로 redirect 이동함. (삽입, 수정, 삭제 이후에는 redirect)
			
			// "view.notice" 이동은 항상 nNo를 파라미터로 전달해야 함.
			
			return new ModelAndView("view.notice?nNo=" + nNo, true);
			
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('댓글 달기 실패')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
			return null;
		}
		
	}

}
