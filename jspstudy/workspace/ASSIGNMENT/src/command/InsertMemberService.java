package command;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.MemberDao;
import dto.Member;

public class InsertMemberService implements MemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String no = request.getParameter("no");
			String name = request.getParameter("name");
			String birthday = request.getParameter("birthday");
			Optional<String> optAge = Optional.ofNullable(request.getParameter("age"));
			int age = Integer.parseInt(optAge.orElse("0"));
			if(age > 100 || age < 0) {
				throw new RuntimeException();
			}
			Member member = new Member();
			member.setNo(no);
			member.setName(name);
			member.setBirthday(birthday);
			member.setAge(age);
			
			int result = MemberDao.getInstance().insertMember(member);
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			JSONObject obj = new JSONObject();
			obj.put("result", result);
			out.println(obj);
			out.close();
			
		}catch(NumberFormatException e) {
			
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("나이는 정수만 입력 가능합니다");
			response.setStatus(2001);
			out.close();
			
		}catch(SQLIntegrityConstraintViolationException e) {
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("동일한 회원번호는 입력할 수 없습니다.");
			response.setStatus(2002);
			out.close();
		}catch(SQLException e) {
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("입력 데이터를 확인하세요.");
			response.setStatus(2003);
			out.close();
		}catch (RuntimeException e) {
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("나이는 0 ~ 100사이만 입력 가능합니다");
			response.setStatus(2003);
			out.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
