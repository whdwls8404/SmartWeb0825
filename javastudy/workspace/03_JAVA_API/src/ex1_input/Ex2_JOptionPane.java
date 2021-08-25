package ex1_input;

import javax.swing.JOptionPane;

public class Ex2_JOptionPane {

	public static void main(String[] args) {
		
		// JOptionPane 클래스
		// 1. 객체를 생성하지 않는다.
		// 2. 클래스를 이용해 메소드를 호출한다.
		
		String strAge = JOptionPane.showInputDialog("몇 살이니?");
		int age = Integer.parseInt(strAge);
		
		JOptionPane.showMessageDialog(null, "넌 " + age + "살이구나~");

	}

}
