package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.ProductDao;

public class SelectListService implements ProductService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setAttribute("list", ProductDao.getInstance().selectList());
		
		return new ModelAndView("views/selectList.jsp", false);
		
	}

}
