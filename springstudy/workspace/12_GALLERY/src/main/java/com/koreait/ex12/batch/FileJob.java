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
			JSONArray arr = new JSONArray(sb.toString());
			List<Object> list = arr.toList();
			
			
			File dir = new File();
			File[] files = dir.listFiles();
			
			for (File f : files) {
				System.out.println(f.getAbsolutePath());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
