package com.koreait.ex15.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.ex15.domain.Board;
import com.koreait.ex15.domain.BoardAttach;
import com.koreait.ex15.repository.BoardRepository;

import net.coobird.thumbnailator.Thumbnails;

@Service
public class BoardServiceImpl implements BoardService {

	private BoardRepository boardRepository;
	
	public BoardServiceImpl(SqlSessionTemplate sqlSession) {
		boardRepository = sqlSession.getMapper(BoardRepository.class);
	}
	
	@Override
	public Map<String, Object> addBoard(MultipartHttpServletRequest multipartRequest) {
		
		// 파라미터 처리
		String writer = multipartRequest.getParameter("writer");
		String title = multipartRequest.getParameter("title");
		String content = multipartRequest.getParameter("content");
		Optional<String> opt = Optional.ofNullable(multipartRequest.getHeader("X-Forwarded-For"));
		String ip = opt.orElse(multipartRequest.getRemoteAddr());
		
		// DB에 writer, title, content, ip 전달
		Board board = Board.builder()
				.writer(writer)
				.title(title)
				.content(content)
				.ip(ip)
				.build();

		// System.out.println("DB수행전:" + board);  // DB삽입 이전에는 boardNo가 없고,
		int boardResult = boardRepository.insertBoard(board);  // DB삽입하면서 SelectKey를 이용해서 board에 boardNo를 채움
		// System.out.println("DB수행후:" + board);  // DB삽입 이후에는 boardNo가 있다.
		
		
		// 첨부파일 저장 결과
		int boardAttachResult = 0;
		
		// 저장 경로 : resources/upload/2021/12/17
		String sep = Matcher.quoteReplacement(File.separator);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String path = "resources" + sep + "upload"  + sep + sdf.format(new Date()).replaceAll("-", sep);
		String realPath = multipartRequest.getServletContext().getRealPath(path);
		
		// 저장될 경로에 디렉터리 만들기 : 없으면 새로 만들어야 한다.
		File dir = new File(realPath);
		if (dir.exists() == false) {
			dir.mkdirs();
		}

		// 썸네일 목록 list
		List<String> thumbnails = new ArrayList<String>();
		
		// 서버에 파일 저장
		List<MultipartFile> files = multipartRequest.getFiles("files");  // 다중첨부 상황
		
		for (MultipartFile file : files) {  // 첨부 하나씩 DB에 넣기
		
			try {
			
				if (file != null && !file.isEmpty()) {  // 첨부가 있으면(둘 다 필요)
				
					//  첨부파일의 본래 이름 origin
					String origin = file.getOriginalFilename();
					
					// 첨부파일의 확장자 [".jsp", ".jpeg", ".gif", ".png"]
					String extension = origin.substring(origin.lastIndexOf("."));
					
					// 하이픈 없는 UUID
					String uuid = UUID.randomUUID().toString().replaceAll("-", "");
					
					// 첨부파일 서버에 업로드 (예외 처리 필요)
					File uploadFile = new File(realPath, uuid + extension);  // new File(경로, 파일)
					file.transferTo(uploadFile);  // 업로드 진행 코드
					
					// 썸네일 이미지 생성 (예외 처리 필요)
					Thumbnails.of(uploadFile)
					.size(100, 100)
					.toFile(new File(realPath, "s_" + uuid + extension));
					
					// 썸네일 목록 저장
					thumbnails.add("s_" + uuid + extension);
					
					// DB에 uuid, path, origin, fileType, boardNo 전달
					BoardAttach boardAttach = new BoardAttach();
					boardAttach.setUuid(uuid);
					boardAttach.setPath(path);
					boardAttach.setOrigin(origin);
					boardAttach.setFileType("I");
					boardAttach.setBoardNo(board.getBoardNo());
					
					// DB에 boardAttach 저장
					boardAttachResult = boardRepository.insertBoardAttach(boardAttach);
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		// 응답할 데이터
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardResult", boardResult);  // 게시판 성공 유무
		map.put("boardAttachResult", boardAttachResult);  // 첨부 성공 유무
		map.put("path", path);  // 첨부 파일 경로
		map.put("thumbnails", thumbnails);  // 첨부된 썸네일 이름
		return map;
		
	}

}
