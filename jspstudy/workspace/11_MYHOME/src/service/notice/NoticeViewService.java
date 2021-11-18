package service.notice;

import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.NoticeDao;
import dao.ReplyDao;
import dto.Notice;
import dto.Reply;

public class NoticeViewService implements NoticeService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 상세 보기를 수행할 게시글번호(nNo)를 받아 와야 함.
		// 전달되지 않는다면 0(없는 게시글번호)을 사용함.
		// Long nNo는 상세 보기와 댓글 리스트에서 모두 필요함.
		Optional<String> opt = Optional.ofNullable(request.getParameter("nNo"));
		Long nNo = Long.parseLong( opt.orElse("0") );
		
		// session 꺼내기
		HttpSession session = request.getSession();
		
		// 게시글을 열면 session에 "open"값 저장하기로 함.
		// 조회수 증가.
		if (session.getAttribute("open") == null) {
			session.setAttribute("open", true);
			NoticeDao.getInstance().updateNoticeHit(nNo);
		}		

		// 게시글번호와 일치하는 공지사항을 가져 옴.
		Notice notice = NoticeDao.getInstance().selectNoticeView(nNo);
				
		// 일치하는 공지사항이 있는 경우.
		if (notice != null) {
			
			// session에 저장해 둠. (수정, 삭제 작업으로 이동할 때 파라미터를 넘길 필요가 없음.)
			session.setAttribute("notice", notice);
			
			// 댓글 리스트 가져옴.
			List<Reply> replyList = ReplyDao.getInstance().selectReplyList(nNo);
			
			// view.jsp에서 보여줄 수 있도록 request에 저장해 둠.
			request.setAttribute("replyList", replyList);
			
			// view.jsp에서 보여줄 수 있도록 request에 저장해 둠.
			request.setAttribute("notice", notice);
			
			// notice/view.jsp로 forward 이동
			return new ModelAndView("notice/view.jsp", false);
			
		}
		// 일치하는 공지사항이 없는 경우 경고 메시지 작성함.
		else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('일치하는 공지사항이 없습니다. 다시 시도하세요.')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
			return null;
		}
		
	}

}
