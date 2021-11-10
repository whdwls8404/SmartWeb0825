package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.EmpDao;

public class InsertEmpService implements EmpService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// 새 사원의 이름, 연봉이 insert.jsp로부터 전달
		// 사원번호와 입사일자는 DB에서 직접 처리		
		String name = request.getParameter("name");
		int salary = Integer.parseInt(request.getParameter("salary"));
		
		// DB로 보낼 데이터가 2개 이상이면 DTO 또는 Map 이용하기
		/*
		EmpDto empDto = new EmpDto();
		empDto.setName(name);
		empDto.setSalary(salary);
		*/
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("salary", salary);
		
		// DB 접근 DAO
		EmpDao empDao = EmpDao.getInstance();
		
		// 삽입 실행
		int result = empDao.insertEmp(map);
		
		// 결과에 따른 응답(response) 처리
		PrintWriter out = response.getWriter();
		
		// DML(insert, update, delete) 작업 후에는 redirect 해야 한다.
		// 자바 스크립트의 location.href는 redirect 이동과 같은 역할이다.
		if (result > 0) {
			out.println("<script>");
			out.println("alert('등록 성공');");
			out.println("location.href='/MYBATIS/selectEmpList.do';");
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('등록 실패');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
			
		return null;
		
	}

}
