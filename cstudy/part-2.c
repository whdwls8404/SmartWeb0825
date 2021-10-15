#include <stdio.h>

// 매크로 상수 
#define LENGTH 3

// 구조체 정의 
typedef struct student {
	char name[31];  // 30 + 널 문자
	int kor, eng, mat;
	int total;
	double average;
} Student;

// 전역(global) 배열
Student students[LENGTH];


void inputInformation() {
	int i; 
	printf("학생 3명의 정보를 차례대로 입력하세요\n\n");
	for (i = 0; i < LENGTH; i++) {
		printf("학생 %d 이름 >>> ", i + 1);
		gets(students[i].name);  // 공백 포함 입력
		// scanf("%s", students[i].name]);
		do {
			printf("국어 >>> ");
			scanf("%d", &students[i].kor); 	
		} while (students[i].kor < 0 || students[i].kor > 100);
		do {
			printf("영어 >>> ");
			scanf("%d", &students[i].eng); 	
		} while (students[i].eng < 0 || students[i].eng > 100);
		do {
			printf("수학 >>> ");
			scanf("%d", &students[i].mat); 	
		} while (students[i].mat < 0 || students[i].mat > 100);
		// 입력 버퍼 비우기
		fflush(stdin);
		// 합계/평균
		students[i].total = students[i].kor + students[i].eng + students[i].mat;
		students[i].average = (double)students[i].total / LENGTH; 
	}
}

void generateFile() {
	int i;
	FILE * fp = fopen("score.csv", "wt");
	if (fp == NULL) {
		fprintf(stderr, "file open error!");
		return;
	}
	fprintf(fp, "성명,국어,영어,수학,총점,평균\n");
	for (i = 0; i < LENGTH; i++) {
		fprintf(fp, "%s,%d,%d,%d,%d,%.2f\n", students[i].name
		                                   , students[i].kor
										   , students[i].eng
										   , students[i].mat
										   , students[i].total
										   , students[i].average);
	}
}

int main() {
	inputInformation();
	generateFile();
	return 0;
}

