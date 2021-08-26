package ex2_two_dimension;

public class MainClass {

	private static void method1() {
		
		int[][] arr = new int[3][2];  // 3행 2열의 형태
		 
		// 행 인덱스 : 0, 1, 2
		// 열 인덱스 : 0, 1
		 
		arr[0][0] = 10;
		arr[0][1] = 20;
		arr[1][0] = 30;
		arr[1][1] = 40;
		arr[2][0] = 50;
		arr[2][1] = 60;
		 
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		
	}
	
	private static void method2() {
		
		int[][] arr = new int[3][2];  // 2개를 저장할 수 있는 1차원 배열이 3개 있다.
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		
	}
	
	private static void method3() {
		
		int[] a = new int[3];
		int[] b = new int[2];
		int[] c = new int[4];
		
		int[][] arr = new int[3][];  // 길이가 다른 1차원 배열 3개를 처리하는 배열
		arr[0] = a;
		arr[1] = b;
		arr[2] = c;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		method3();
	}

}
