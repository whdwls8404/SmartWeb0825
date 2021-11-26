package service.comments;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommentsService {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
