package com.koreait.ex15.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Board {
	private Long boardNo;
	private String title;
	private String content;
	private String writer;
	private String ip;
	private Date created;
	private Date lastModified;
}
