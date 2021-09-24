#include<stdio.h>  // 표준 입출력 헤더파일 (표준 입출력 함수 사용 위해서)

// 꼭 필요한 함수 : main() 함수
int main() {
	
	// 변수
	// 1. C는 String이 없다. char[] 사용한다.
	// 2. 변수 선언을 꼭 함수 시작부에 넣는다. (중간에 선언할 수 없다.) 
	// 3. char 변수는 1byte이다. 한글 저장이 불가능하다. (Java는 2byte) 
	
	char   a = 'T';
	int    b = 10;
	double c = 1.5;
	char str[6] = "hello";  // 반드시 배열 크기는 최소 저장하려는 문자열 크기 + 1 
	
	printf("문자: %c\n", a);
	printf("정수: %d\n", b);
	printf("실수: %f\n", c);    // 소수 6자리 , %f : float
	printf("실수: %.1f\n", c);  // 소수 1자리 
	printf("실수: %lf\n", c);   // 소수 6자리 , %lf : long float -> double 
	printf("실수: %.2lf\n", c); // 소수 2자리 
	printf("실수: %g\n", c);
	
	printf("문자열: %s\n", str);  // 배열의 이름으로 전체 내용 출력 
	
	return 0;  // 정상 종료를 의미 (비정상 종료 return -1;)
	
}







