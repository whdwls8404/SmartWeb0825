package model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import common.ModelAndView;
import dao.ProductDao;

public class NameCheckService implements ProductService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 파라미터 처리 (insert.jsp - $.ajax의 data 참고)
		String name = request.getParameter("name");
		
		// ProductDao
		ProductDao dao = ProductDao.getInstance();
		
		// nameCheck()
		// result == true 이면 동일한 제품 없음.
		boolean result = dao.nameCheck(name);
		
		// result를 ajax로 반환할 수 있도록 JSON 데이터로 변환
		JSONObject obj = new JSONObject();
		obj.put("result", result);
		
		// JSONObject obj
		// {"result": true}, {"result": false}
		
		// JSON 데이터를 반환 : 응답 처리
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(obj);  // JSON 데이터를 직접 응답 (insert.jsp - $.ajax  success: function(resData){}  매개변수 resData로 obj가 전달됨.) 
		out.close();
		
		// ajax 처리인 경우 null 반환 -> controller에서 redirect/forward 이동을 막아 줌.		
		return null;
		
	}

}
