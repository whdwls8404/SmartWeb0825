package model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import common.ModelAndView;
import dao.ProductDao;
import dto.Product;

public class PrevInsertNameService implements ProductService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 마지막에 등록된 제품 가져오기
		Product product = ProductDao.getInstance().prevInsertName();
		
		// JSONObject 객체 생성
		JSONObject obj = new JSONObject();
		obj.put("name", product.getName());
		
		// JSONObject obj
		// {"name": "홈런볼"}
		
		// 응답
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(obj);
		out.close();
		
		return null;
		
	}

}
