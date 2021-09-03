package ex2_socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientMainClass {

	public static void main(String[] args) {
		
		// Socket : 클라이언트 측 소켓
		
		Socket client = null;
		
		try {
			
			// 클라이언트 생성
			client = new Socket();
			
			// 서버에 접속
			client.connect(new InetSocketAddress("localhost", 9090));
			
			// 서버의 웰컴 메시지 받기
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			char[] cbuf = new char[500];
			int readCount = br.read(cbuf);
			System.out.println(new String(cbuf, 0, readCount));
			
			br.close();
			client.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}










