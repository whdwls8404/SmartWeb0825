package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Now {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("a h:mm:ss");
		String result = sdf.format(new Date());
		
		// 응답 View인 output.jsp로 보내기 위한 데이터 저장
		request.setAttribute("result", result);
		
	}
	
}
