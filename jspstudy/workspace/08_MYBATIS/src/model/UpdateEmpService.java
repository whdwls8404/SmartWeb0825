package model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.EmpDao;
import dto.EmpDto;

public class UpdateEmpService implements EmpService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// 전달되는 파라미터
		// num : 수정할 사원의 사원 번호
		// name, salary : 수정할 내용
		
		Long num = Long.parseLong(request.getParameter("num"));
		String name = request.getParameter("name");
		int salary = Integer.parseInt(request.getParameter("salary"));
		
		// DB로 보낼 데이터가 2개 이상인 경우
		// 하나로 묶는다. (Dto 또는 Map)
		// 여기서는 Dto 생성
		EmpDto empDto = new EmpDto();
		empDto.setNum(num);
		empDto.setName(name);
		empDto.setSalary(salary);
		
		// DB 접근을 위한 DAO
		EmpDao dao = EmpDao.getInstance();
		
		// 수정 실행
		int result = dao.updateEmp(empDto);
		
		// 결과에 따른 응답(response) 처리
		PrintWriter out = response.getWriter();
		
		// DML(insert, update, delete) 작업 후에는 redirect 해야 한다.
		// 자바 스크립트의 location.href는 redirect 이동과 같은 역할이다.
		if (result > 0) {
			out.println("<script>");
			out.println("alert('수정 성공');");
			out.println("location.href='/MYBATIS/selectEmp.do?num=" + num + "';");
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('수정 실패');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		
		return null;
		
	}

}






