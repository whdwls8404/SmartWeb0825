package com.koreait.ex15.util;

public class PageUtils {

	private int totalRecord;          // 전체 게시글 갯수(DB에서 가져옴)
	private int recordPerPage = 10;   // 한 페이지에 표시하는 게시글 갯수(여기서 정함)
	private int totalPage;            // 전체 페이지 갯수(totalRecord, recordPerPage로 계산)

	/************************************************
		- 전체 11개 게시글
		- 한 페이지당 3개 게시글
		page = 1, beginRecord = 1,  endRecord = 3
		page = 2, beginRecord = 4,  endRecord = 6
		page = 3, beginRecord = 7,  endRecord = 9
		page = 4, beginRecord = 10, endRecord = 11
	 **************************************************/
	private int page;                 // 현재 페이지 번호(파라미터로 받아옴)
	private int beginRecord;          // 각 페이지에 표시하는 시작 게시글 번호(page, recordPerPage로 계산)
	private int endRecord;            // 각 페이지에 표시하는 종료 게시글 번호(beginRecord, recordPerPage, totalRecord로 계산)
	
	/*********************************************************************
		- 전체 12 페이지
		- 한 블록당 5개 페이지
		1block <  1  2  3  4  5  >   page=1~5,   beginPage=1,  endPage=5
		2block <  6  7  8  9  10  >  page=6~10,  beginPage=6,  endPage=10
		3block <  11 12  >           page=11~15, beginPage=11, endPage=12 
	**********************************************************************/
	private int pagePerBlock = 5;     // 한 블록에 표시하는 페이지 갯수(여기서 정함)
	private int beginPage;            // 각 블록에 표시하는 시작 페이지 번호(page, pagePerBlock로 계산)
	private int endPage;              // 각 블록에 표시하는 종료 페이지 번호(beginPage, pagePerBlock, totalPage로 계산) 
	
	public void setPageEntity(int totalRecord, int page) {
		
		this.totalRecord = totalRecord;
		this.page = page;
		
		// totalPage
		totalPage = totalRecord / recordPerPage;
		if (totalRecord % recordPerPage != 0) {
			totalPage++;
		}
		
		// beginRecord, endRecord
		beginRecord = (page - 1) * recordPerPage + 1;
		endRecord = beginRecord + recordPerPage - 1;
		endRecord = (totalRecord < endRecord) ? totalRecord : endRecord;
		
		// beginPage, endPage
		beginPage = ((page - 1) / pagePerBlock) * pagePerBlock + 1;
		endPage = beginPage + pagePerBlock - 1;
		endPage = (totalPage < endPage) ? totalPage : endPage;
		
	}
	
	/*
 	getPageEntity() 메소드는 <a> 태그로 구성된다.
 	<a> 태그는 페이지 이동을 의미하므로,
 	페이지 이동이 없는 ajax로 처리하는 경우에는 사용할 수 없다.
	*/
	
	public String getPageEntity(String path) {
		
		StringBuilder sb = new StringBuilder();
		
		// path에 ?가 포함되어 있으면 path에 파라미터가 포함되어 있다는 의미임.
		// 예
		// path = find.notice?column=WRITER&query=admin
		
		// 위와 같은 경우 page 파라미터는 "&page=" 로 path에 추가해야 함.
		// path = find.notice?column=WRITER&query=admin&page=
		
		// 1페이지로 이동 : 1페이지는 링크가 필요 없음.
		if (page == 1) {
			sb.append("◀◀&nbsp;");
		} else {
			if (path.contains("?")) {
				sb.append("<a href=\"" + path + "&page=1\">◀◀</a>&nbsp;");
			} else {
				sb.append("<a href=\"" + path + "?page=1\">◀◀</a>&nbsp;");
			}
		}
		
		String concat = path.contains("?") ? "&" : "?";
		
		// 이전 블록으로 이동 : 1블록은 링크가 필요 없음.
		if (page <= pagePerBlock) {
			sb.append("◀&nbsp;");
		} else {
			sb.append("<a href=\"" + path + concat + "page=" + (beginPage - 1) + "\">◀</a>&nbsp;");
		}
		// 페이지 번호 : 현재 페이지는 링크가 필요 없음.
		for (int i = beginPage; i <= endPage; i++) {
			if (page == i) {
				sb.append(i + "&nbsp;");
			} else {
				sb.append("<a href=\"" + path + concat + "page=" + i + "\">" + i + "</a>&nbsp;");
			}
		}
		// 다음 블록으로 이동 : 마지막 블록은 링크가 필요 없음.
		if (endPage == totalPage) {
			sb.append("▶&nbsp;");
		} else {
			sb.append("<a href=\"" + path + concat + "page=" + (endPage + 1) + "\">▶</a>&nbsp;");
		}
		// 마지막 페이지로 이동 : 마지막 페이지는 링크가 필요 없음.
		if (page == totalPage) {
			sb.append("▶▶");
		} else {
			sb.append("<a href=\"" + path + concat + "page=" + totalPage + "\">▶▶</a>");
		}
		
		return sb.toString();
		
	}

	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getRecordPerPage() {
		return recordPerPage;
	}
	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getBeginRecord() {
		return beginRecord;
	}
	public void setBeginRecord(int beginRecord) {
		this.beginRecord = beginRecord;
	}
	public int getEndRecord() {
		return endRecord;
	}
	public void setEndRecord(int endRecord) {
		this.endRecord = endRecord;
	}
	public int getPagePerBlock() {
		return pagePerBlock;
	}
	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}
	public int getBeginPage() {
		return beginPage;
	}
	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
}