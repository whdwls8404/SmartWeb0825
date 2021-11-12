package model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import common.ModelAndView;
import dao.ProductDao;
import dto.Product;

public class InsertService implements ProductService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 파라미터
		String name = request.getParameter("name");
		String strPrice = request.getParameter("price");
		int price = 0;
		if (strPrice.isEmpty() == false) {
			price = Integer.parseInt(strPrice);
		}
		
		// DTO
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		
		// DB에 삽입
		int result = ProductDao.getInstance().insert(product);
		
		// JSONObject 생성 (JSON 데이터)
		JSONObject obj = new JSONObject();
		obj.put("result", result);
		
		// JSONObject obj
		// {"result": 1} 또는 {"result": 0}
		
		// JSONObject 응답
		response.setContentType("application/json; charset=UTF");
		PrintWriter out = response.getWriter();
		out.println(obj);  // obj가 $.ajax의 success function()으로 전달
		out.close();
		
		return null;
		
	}

}
