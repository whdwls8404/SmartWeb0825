package service.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.jdbc.BoardDAO;
import dto.Board;

public class BoardListService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// 목록 가져 옴.
		List<Board> list = BoardDAO.getInstance().selectBoardList();

		// JSON 데이터로 변환함.
		// 1. JSONObject : Board
		// 2. JSONArray  : List<Board>
		// JSONArray arr = new JSONArray(list);  정상 동작 안해서 빈 배열에 강제 삽입하였음.

		JSONArray arr = new JSONArray();
		for (Board board : list) {
			JSONObject obj = new JSONObject();
			obj.put("bNo", board.getbNo());
			obj.put("writer", board.getWriter());
			obj.put("content", board.getContent());
			obj.put("bDate", board.getbDate());
			arr.put(obj);
		}
		
		// JSON 데이터로 변환된 목록 반환함.
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(arr);  // index.jsp의 success: function(boards) { }로 반환됨.
		out.close();
		
	}

}