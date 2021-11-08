package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.EmpDAO;

public class EmpFindEmpListService implements EmpService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		
		EmpDAO empDAO = EmpDAO.getInstance();
		request.setAttribute("empList", empDAO.selectEmpList());
		
		return new ModelAndView("views/selectEmpList.jsp", false);
		
	}

}
