package model;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.EmpDao;

public class UpdateFormService implements EmpService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// 파라미터 num 받기 (num이 전달되지 않으면 null, null이면 "0"을 대신 사용)
		Optional<String> optNum = Optional.ofNullable(request.getParameter("num"));
		Long num = Long.parseLong(optNum.orElse("0"));
		
		// DB 접속하는 DAO
		EmpDao dao = EmpDao.getInstance();
		
		// 사원번호 num과 일치하는 사원 정보를 DB에서 가져오기
		// 가져온 사원 정보를 request에 저장하고, update.jsp로 이동하기
		request.setAttribute("emp", dao.selectEmpByNum(num));
		
		return new ModelAndView("views/update.jsp", false);
		
	}

}
