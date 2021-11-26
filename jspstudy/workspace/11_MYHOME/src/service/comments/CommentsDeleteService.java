package service.comments;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentsDao;

public class CommentsDeleteService implements CommentsService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Long cNo = Long.parseLong(request.getParameter("cNo"));
		int result = CommentsDao.getInstance().deleteComments(cNo);
		
		if (result == 0) {
			throw new RuntimeException("댓글 삭제 실패");
		}
		
	}

}
