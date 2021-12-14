package com.koreait.ex14.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data  // @Getter, @Setter, @ToString, @NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

	private int departmentId;
	private String departmentName;
	private int managerId;
	private int locationId;
	
}
