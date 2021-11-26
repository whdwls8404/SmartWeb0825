package service.comments;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.CommentsDao;
import dto.Comments;

public class CommentsListService implements CommentsService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Long bNo = Long.parseLong(request.getParameter("bNo"));
		
		List<Comments> list = CommentsDao.getInstance().selectCommentsList(bNo);
		
		JSONArray comments = new JSONArray();
		for (Comments comment : list) {
			JSONObject obj = new JSONObject();
			obj.put("cNo", comment.getcNo());
			obj.put("writer", comment.getWriter());
			obj.put("content", comment.getContent());
			obj.put("bNo", comment.getbNo());
			obj.put("state", comment.getState());
			obj.put("created", comment.getCreated());
			comments.put(obj);
		}
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(comments);
		out.close();
		
	}

}
