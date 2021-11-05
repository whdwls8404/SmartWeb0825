package model;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Lotto {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		Set<Integer> lotto = new HashSet<Integer>();
		while (lotto.size() < 6) {
			lotto.add( (int)(Math.random() * 45) + 1 );
		}
		
		request.setAttribute("result", lotto.toString());
		
	}
	
}
