#include <stdio.h>
#include <string.h>

#define LENGTH 10

typedef struct book {  // 기존 타입은 struct book 
	int bookNo;
	char title[31];
	char author[31];
} Book;  // Book 타입의 정의 

Book books[LENGTH];  // Book books[10];
int idx = 0;

void menu() {
	printf("1. 등록\n");
	printf("2. 조회\n");
	printf("3. 전체\n");
	printf("0. 종료\n");
}

void addBook() {
	int bookNo;
	char title[31];
	char author[31];
	// Book을 저장할 인덱스는 idx이다.
	// 인덱스 가용 범위 : 0 ~ (LENGTH - 1)
	if (idx == LENGTH) {
		printf("배열이 꽉 찼습니다.\n");
		return; 
	}
	// 책 번호 : 1001 ~ 9999
	printf("책 번호 입력 >>> ");
	scanf("%d", &bookNo);
	if (bookNo <= 1000 || bookNo >= 10000) {
		printf("잘못된 책 번호 입니다.\n");
		return;
	}
	printf("책 제목 입력 >>> ");
	scanf("%s", title);
	printf("책 저자 입력 >>> ");
	scanf("%s", author);
	books[idx].bookNo = bookNo;
	strcpy(books[idx].title, title);
	strcpy(books[idx].author, author);
	idx++;
} 

void queryBook() {
	int findNo;
	int i;
	if (idx == 0) {
		printf("책이 없습니다.\n");
		return;
	}
	printf("조회할 책 번호 >>> ");
	scanf("%d", &findNo);
	// Book은 books배열에 idx만큼 저장되어 있다.
	for (i = 0; i < idx; i++) {
		if (findNo == books[i].bookNo) {
			printf("제목: %s, 저자: %s\n", books[i].title, books[i].author);
			return;  // 찾았으니 queryBook() 함수를 끝낸다. 
		}
	}
	// 조회가 끝나면 없는 책이다.
	printf("책 번호 %d은 없는 책입니다.\n", findNo); 
}

void printBook() {
	int i;
	if (idx == 0) {
		printf("책이 없습니다.\n");
		return;
	}
	for (i = 0; i < idx; i++) {
		printf("%d, %s, %s\n", books[i].bookNo, books[i].title, books[i].author);
	}
}

int main() {
	int choice;
	while (1) {
		menu();
		printf("작업 선택 >>> ");
		scanf("%d", &choice);
		switch (choice) {
			case 1: addBook(); break;
			case 2: queryBook(); break;
			case 3: printBook(); break;
			case 0: printf("종료합니다.\n"); return 0;
			default: printf("없는 작업입니다. 다시 입력하세요\n");
		}
	}
}

