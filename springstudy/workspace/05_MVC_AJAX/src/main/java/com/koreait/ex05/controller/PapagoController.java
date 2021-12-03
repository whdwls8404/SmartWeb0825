package com.koreait.ex05.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PapagoController {

	@GetMapping("openPapago.do")
	public String openPapago() {
		return "papago";
	}
	
	@ResponseBody
	@PostMapping(value="papago.do",
			produces="application/json; charset=UTF-8")
	public String papago(@RequestBody Map<String, String> param, HttpServletResponse response) {
		
		String clientId = "bi0zFUfar9qogHzkL2G2";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "DTN7EPOmAv";//애플리케이션 클라이언트 시크릿값";

        String apiURL = "https://openapi.naver.com/v1/papago/n2mt";

        String source = param.get("source");
        String target = param.get("target");
        String text = param.get("text");
        
        try {
            text = URLEncoder.encode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("인코딩 실패", e);
        }
		
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        
        String result = null;
        
        try {
        	
        	URL url = new URL(apiURL);
        	HttpURLConnection con = (HttpURLConnection)url.openConnection();
        	String postParams = "source="+source+"&target="+target+"&text=" + text;
        	con.setRequestMethod("POST");
        	for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
            	con.setRequestProperty(header.getKey(), header.getValue());
            }
        	con.setDoOutput(true);
        	try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
        		wr.write(postParams.getBytes());
        		wr.flush();
        	}
        	int responseCode = con.getResponseCode();
        	if (responseCode == HttpURLConnection.HTTP_OK) {  // 정상 응답
        		InputStreamReader streamReader = new InputStreamReader(con.getInputStream());
        		BufferedReader lineReader = new BufferedReader(streamReader);
        		StringBuilder responseBody = new StringBuilder();
        		String line;
        		while ((line = lineReader.readLine()) != null) {
        			responseBody.append(line);
        		}
        		result = responseBody.toString();
        	} else {
        		InputStreamReader streamReader = new InputStreamReader(con.getErrorStream());
        		BufferedReader lineReader = new BufferedReader(streamReader);
        		StringBuilder responseBody = new StringBuilder();
        		String line;
        		while ((line = lineReader.readLine()) != null) {
        			responseBody.append(line);
        		}
        		result = responseBody.toString();
        	}
        	
        } catch (Exception e) {
        	try {
        		response.setContentType("text/plain; charset=UTF-8");
        		PrintWriter out = response.getWriter();
        		out.println("API 실패");
        		out.close();
        	} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
        
        return result;
        
	}
	
}
