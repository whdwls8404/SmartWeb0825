package com.koreait.integration.batch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class BookJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		// 저자 "황순원", "생텍쥐베리" 중 임의로 한 명의 정보를 이용하여 도서를 검색한
		// 결과를 출력하시오. (파일을 생성하시오.)

		try {
			String[] authors = {"황순원", "생텍쥐베리"};
			String author = URLEncoder.encode(authors[(int)(Math.random() * authors.length)], "UTF-8");	
			String apiURL = "http://localhost:9099/integration/book/findBook?column=AUTHOR&query=" + author;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = "";
			while ( (line = br.readLine()) != null ) {
				sb.append(line);
			}
			JSONObject obj = new JSONObject(sb.toString());
			System.out.println("status : " + obj.getInt("status"));
			System.out.println("message : " + obj.getString("message"));
			System.out.println();
			JSONArray arr = obj.getJSONArray("list");
			for (int i = 0; i < arr.length(); i++) {
				JSONObject o = arr.getJSONObject(i);
				System.out.println("번호 : " + o.getInt("no"));
				System.out.println("제목 : " + o.getString("title"));
				System.out.println("미리보기 : " + o.getString("preview"));
				System.out.println("저자 : " + o.getString("author"));
				System.out.println("가격 : " + o.getInt("price"));
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
