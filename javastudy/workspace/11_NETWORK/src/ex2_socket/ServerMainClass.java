package ex2_socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMainClass {

	public static void main(String[] args) {
		
		// ServerSocket : 서버 측 소켓
		
		ServerSocket server = null;
		
		try {

			// 서버 생성
			server = new ServerSocket();
			
			// 호스트, 포트번호
			server.bind( new InetSocketAddress("localhost", 9090) );
			
			// 클라이언트로 메시지를 보낼 출력 스트림
			BufferedWriter bw = null;
			
			// 서버는 항상 ON
			while (true) {
				
				// Socket : 클라이언트 측 소켓
				// 클라이언트의 접속 허용
				Socket client = server.accept();
				
				// 클라이언트에게 웰컴 메시지 전송
				String message = "Welcome to Server!";
				bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
				bw.write(message);
				bw.flush();  // 스트림 비우기 (데이터 밀어내기)
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if ( !server.isClosed() ) {
					server.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
	}

}
