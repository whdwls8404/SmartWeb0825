package model;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import common.ModelAndView;
import dao.ProductDao;

public class DeleteService implements ProductService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 파라미터
		Optional<String> optPno = Optional.ofNullable(request.getParameter("pno"));
		Long pno = Long.parseLong(optPno.orElse("0"));
		
		// 실제 삭제
		int result = ProductDao.getInstance().delete(pno);
		
		// 응답할 JSON 데이터
		JSONObject obj = new JSONObject();
		obj.put("result", result);
		// obj  ->  {"result": 0} 또는 {"result": 1}
		
		// 응답 처리
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(obj);
		out.close();
		
		return null;
		
	}

}
