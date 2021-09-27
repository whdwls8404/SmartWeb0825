#include <stdio.h>

void w1() {
	
	FILE * f = fopen("text1.txt", "wt");  // wt모드 : write + text (텍스트 파일을 항상 새로 만든다.)

	if (f == NULL) {
		fprintf(stderr, "file open error\n");  // stderr : 표준 에러 스트림 (에러 메시지 출력에서 사용) 
		return; 
	}
	
	// fputc() 함수, 파일에 한 글자만 보낼 때 
	fputc('T', f);
	fputc('a', f);

	fclose(f);
	
}

void w2() {
	
	FILE * f = fopen("text1.txt", "at");  // at모드 : append + text (기존 텍스트 파일에 내용을 추가한다. 파일이 없으면 새로 만든다.) 
	
	if (f == NULL) {
		fprintf(stderr, "file open error\n");
		return;
	} 
	
	// fputs() 함수, 파일에 문자열을 보낼 때
	fputs("nos", f);
	
	fclose(f);
	
}

void w3() {
	
	char name[] = "민경태";
	int age = 44;
	
	FILE * f = fopen("text2.txt", "wt");
	
	if (f == NULL) {
		fprintf(stderr, "file open error\n");
		return;
	}
	
	// fprintf() 함수, 파일을 대상으로 printf() 사용
	fprintf(f, "이름: %s, 나이: %d살\n", name, age);
	
	fclose(f); 
	
}

void r() {
	
	int ch;
	FILE * f = fopen("text1.txt", "rt");  // rt모드 : read + text (텍스트 파일 읽기)
	
	if (f == NULL) {
		fprintf(stderr, "file open error\n");
		return;
	}
	
	// fgetc() 함수, 파일에서 한 글자만 읽을 때 
	// 읽어 들인 문자는 int 에 저장
	
	// 무한루프로 구성
	while (1) {  // 무한루프, 1은 TRUE를 의미함 
		ch = fgetc(f);
		if (ch == EOF) {  // EOF : End Of File, 파일의 끝을 알리는 문자 
			break;
		}
		printf("%c", ch);
	} 
	
	fclose(f);
	
}

int main() {
	r();
}
