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

		// session에 저장된 "notice"가 있는 경우는 댓글이 추가된 경우이다.
		// 이 때는 댓글리스트만 DB에서 새로 가져오고,
		// 게시글내용은 session에 저장된 "notice"를 사용한다.
		
		// session 꺼내기
		HttpSession session = request.getSession();
		
		// session에 저장된 notice 꺼내기
		Notice notice = (Notice) session.getAttribute("notice");
		
		// 상세 보기를 수행할 게시글번호(nNo)를 받아 와야 함.
		// 전달되지 않는다면 0(없는 게시글번호)을 사용함.
		// Long nNo는 상세 보기와 댓글 리스트에서 모두 필요함.
		Optional<String> opt = Optional.ofNullable(request.getParameter("nNo"));
		Long nNo = Long.parseLong( opt.orElse("0") );
		
		// 상세 보기를 처음 실행한 경우
		if (notice == null) {
			// 조회수 증가.
			NoticeDao.getInstance().updateNoticeHit(nNo);

			// 게시글번호와 일치하는 공지사항을 가져 옴.
			notice = NoticeDao.getInstance().selectNoticeView(nNo);
			
			// session에 저장해 둠. (수정, 삭제 작업으로 이동할 때 파라미터를 넘길 필요가 없음.)
			session.setAttribute("notice", notice);
		}
		// 댓글 달고 상세 보기로 이동한 경우
		else {
			// 할 일 없음
		}
		
		// 일치하는 공지사항이 있는 경우.
		if (notice != null) {
			// 댓글 리스트 가져옴.
			List<Reply> replyList = ReplyDao.getInstance().selectReplyList(nNo);
			// request에 저장해 둠. (JSP에서 확인할 수 있도록)
			request.setAttribute("replyList", replyList);
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
