package model;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.EmpDAO;
import dto.EmpDTO;

public class EmpModifyService implements EmpService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		
		Long num = Long.parseLong(request.getParameter("num"));
		String name = request.getParameter("name");
		String hire = request.getParameter("hire");
		
		EmpDTO empDTO = new EmpDTO();
		empDTO.setNum(num);
		empDTO.setName(name);
		empDTO.setHire(new java.sql.Date(new Date(hire.replaceAll("-", "//")).getTime()));
		
		EmpDAO empDAO = EmpDAO.getInstance();
		int result = empDAO.updateEmp(empDTO);
		
		ModelAndView modelAndView = null;
		if (result > 0) {
			modelAndView = new ModelAndView("/JDBC/selectDto.emp?num=" + num, true);
		} else {
			PrintWriter out = null;
			try {
				out = response.getWriter();
				out.println("<script>");
				out.println("alert('사원 정보가 수정되지 않았습니다.');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return modelAndView;
		
	}

}





