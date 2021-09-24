#include<stdio.h>

int main() {
	
	char   a;  // 쓰레기(garbage) 상태 
	int    b;
	double c;
	char str[11];
	
	printf("문자 입력 >>> ");
	scanf("%c", &a);  // 일반 변수는 '&변수명'
	 
	printf("정수 입력 >>> ");
	scanf("%d", &b);
	
	printf("실수 입력 >>> ");
	scanf("%lf", &c);
	
	printf("문자열 입력 >>> ");
	scanf("%s", str);  // 배열은 '배열명' 또는 '&배열명[0]' , 중간에 공백이 포함 안 됨 
	// 공백 입력이 가능한 것들 
	// gets(str);
	// fgets(str, sizeof(str), stdin); 
	
	printf("한 방에 출력 : %c, %d, %lf, %s\n", a, b, c, str);

	return 0;
	
} 
