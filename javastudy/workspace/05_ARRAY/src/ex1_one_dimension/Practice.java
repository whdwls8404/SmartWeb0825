package ex1_one_dimension;

import java.util.Scanner;

public class Practice {

	private static void quiz1() {
		
		// 성적 관리하기
		// 학생 3명의 이름은 "피카츄", "뽀로로", "브레드"이다.
		// 실행 예)
		// 피카츄의 점수 입력 >>> 10
		// 뽀로로의 점수 입력 >>> 11
		// 브레드의 점수 입력 >>> 12
		// 평균 : 11.0점
		// 1등  : 브레드
		// 3등  : 피카츄
		
		String[] names = new String[] { "피카츄", "뽀로로", "브레드" };
		int[] scores = new int[names.length];
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < scores.length; i++) {
			System.out.print(names[i] + "의 점수 입력 >>> ");
			scores[i] = sc.nextInt();
		}
		
		// 합계, 최대, 최소
		int total = scores[0];
		int max = scores[0];  int top = 0;
		int min = scores[0];  int last = 0;
		
		for (int i = 1; i < scores.length; i++) {
			total += scores[i];
			if (max < scores[i]) {
				max = scores[i];
				top = i;
			}
			if (min > scores[i]) {
				min = scores[i];
				last = i;
			}
		}
		
		System.out.println("평균: " + (double)total / scores.length + "점");
		System.out.println("1등: " + names[top]);
		System.out.println(scores.length + "등: " + names[last]);
		
		sc.close();
		
	}

	private static void quiz2() {
		
		// 윷 놀이
		// "도", 1칸 이동한다.
		// "개", 2칸 이동한다.
		// "걸", 3칸 이동한다.
		// "윷", "걸", 7칸 이동한다.
		
		// 도개걸윷모의 이동횟수는 인덱스와 일치한다.
		String[] yutnori = new String[] { "", "도", "개", "걸", "윷", "모" };
		
		int total = 0;
		while (true) {
			
			// 이동횟수는 랜덤 생성한다.
			int move = (int)(Math.random() * 5) + 1;
			System.out.print(yutnori[move]);
			
			// 이동횟수 누적
			total += move;
			
			if (move <= 3) {
				System.out.println(", " + total + "칸 이동한다.");
				break;
			} else {
				System.out.print(", ");
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		quiz2();
	}

}
