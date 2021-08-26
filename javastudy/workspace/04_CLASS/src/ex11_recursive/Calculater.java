package ex11_recursive;

public class Calculater {

	// 팩토리얼 (factorial)
	// 계승값
	// 5! = 5x4x3x2x1  5! = 5 x 4!
	// 4! = 4x3x2x1    4! = 4 x 3!
	// 3! = 3x2x1      3! = 3 x 2!
	// 2! = 2x1        2! = 2 x 1!
	// 1! = 1          1! = 1 x 0!
	// 0! = 1
	
	public int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}
	
}
