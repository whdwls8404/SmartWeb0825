package model;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import common.ModelAndView;
import dao.ProductDao;
import dto.Product;

public class SelectListService implements ProductService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Product> list = ProductDao.getInstance().selectList();
		
		// list를 JSON 데이터로 변경 후 반환
		JSONArray arr = new JSONArray(list);
		
		// 결과 반환
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println(arr);  // arr이 ajax success로 넘기는 데이터
		
		// 페이지 이동을 막기 위해서 null 반환
		return null;
		
	}

}
