package com.koreait.ex12.batch;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.mybatis.spring.SqlSessionTemplate;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.koreait.ex12.domain.Gallery;
import com.koreait.ex12.repository.GalleryRepository;

public class FileJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		try {
			
			String apiURL = "http://localhost:9099/ex12/gallery/selectFileList";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ( (line = br.readLine()) != null ) {
				sb.append(line);
			}
			
			JSONObject obj = new JSONObject(sb.toString());
			String realPath = (String) obj.get("realPath");			
			List<String> serverFiles = new ArrayList<>();  // 서버에 저장되어 있는 첨부파일들
			fileCollector(realPath, serverFiles);
			
			JSONArray arr = obj.getJSONArray("arr");
			List<Object> list = arr.toList();
			List<String> dbFiles = new ArrayList<>();  // DB에 저장되어 있는 첨부파일들
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void fileCollector(String realPath, List<String> list) {
		
		File dir = new File(realPath);
		File[] files = dir.listFiles();
		
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile()) {
				list.add(files[i].getPath());
			} else if (files[i].isDirectory()) {
				fileCollector(files[i].getPath(), list);
			}
		}
		
	}
	
}
