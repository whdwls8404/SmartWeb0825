package model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.EmpDAO;
import dto.EmpDTO;

public class EmpAddService2 implements EmpService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		
		String name = request.getParameter("name");
		
		EmpDTO empDTO = new EmpDTO();
		empDTO.setName(name);
		
		EmpDAO empDAO = EmpDAO.getInstance();
		int result = empDAO.insertEmp(empDTO);
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
			if (result > 0) {
				out.println("<script>");
				out.println("alert('등록 성공');");
				out.println("location.href='/JDBC/selectList.emp';");
				out.println("</script>");
				out.close();
			} else {
				out.println("<script>");
				out.println("alert('등록 실패');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

}
