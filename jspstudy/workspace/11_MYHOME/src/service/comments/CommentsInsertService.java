package service.comments;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.CommentsDao;
import dto.Comments;

public class CommentsInsertService implements CommentsService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 파라미터
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		Long bNo = Long.parseLong(request.getParameter("bNo"));
		
		// DB로 보낼 comment
		Comments comment = new Comments();
		comment.setContent(content);
		comment.setWriter(writer);
		comment.setbNo(bNo);
		
		// DB에 삽입
		int result = CommentsDao.getInstance().insertComments(comment);
		
		// 결과를 JSON 데이터로 생성
		JSONObject obj = new JSONObject();
		obj.put("result", result);
		
		// JSON 데이터를 ajax로 반환
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(obj);
		out.close();
		
	}

}
