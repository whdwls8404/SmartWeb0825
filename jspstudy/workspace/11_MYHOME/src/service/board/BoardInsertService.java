package service.board;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.ModelAndView;
import dao.BoardDao;
import dto.Board;

public class BoardInsertService implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 첨부 파일이 저장될 디렉터리
		// storage/년도/월/일

		String year = new SimpleDateFormat("yyyy").format(new Date());
		String month = new SimpleDateFormat("MM").format(new Date());
		String day = new SimpleDateFormat("dd").format(new Date());
		
		String path = "storage" + File.separator + year + File.separator + month + File.separator + day;
		String realPath = request.getServletContext().getRealPath(path);
		File dir = new File(realPath);
		if (dir.exists() == false) {
			dir.mkdirs();
		}
		
		// 첨부 업로드
		MultipartRequest mr = new MultipartRequest(request, realPath, 10 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());
		
		// 파라미터 처리
		String writer = mr.getParameter("writer");
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		String fileName = mr.getOriginalFileName("fileName");
		String saveName = mr.getFilesystemName("fileName");
		
		// DB로 보낼 Board
		Board board = new Board();
		board.setWriter(writer);
		board.setTitle(title);
		board.setContent(content);
		board.setFileName(fileName);
		board.setSaveName(saveName);
		
		System.out.println(board);  // dto.Board의 toString() 동작
		
		// DB에 삽입
		int result = BoardDao.getInstance().insertBoard(board);
		
		PrintWriter out = response.getWriter();
		if (result > 0) {
			out.println("<script>");
			out.println("alert('게시글 등록 성공')");
			out.println("location.href='list.board'");
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('게시글 등록 실패')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		}
		
		return null;
		
	}

}
