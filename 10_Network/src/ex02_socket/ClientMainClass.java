package ex02_socket;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientMainClass {

	// ※ InputStream, OutputStream는 한글 처리 불가 (=> 둘 중 하나는 쓸 줄 알아야한다.)
	// 1. InputStreamReader, OutputStreamWriter로 변환해서 한글 처리하기 가능 <추천 방법, 보편적인 방법>
	// 2. DataOutputStream, DataInputStream 만 한글 처리 가능하다(writeUTF(), readUTF() 를 사용해서). 나머지는 불가
	
	public static void main(String[] args) {

		// Socket : 클라이언트가 사용하는 Socket 
		Socket socket = null;
		
		try {
			
			socket = new Socket();
			
			// InetSocketAddress : 접속할 서버의 정보를 이용해서 생성
			InetSocketAddress address = new InetSocketAddress("localhost", 9090);
			
			// 서버에 접속
			socket.connect(address);  // address에 접속할게
										// IOException 처리가 필요
			
			System.out.println("[클라이언트] 접속 성공");
			
			// 서버가 보낸 welcome 메시지 확인하기 (데이터를 받는다)
			DataInputStream in = new DataInputStream(socket.getInputStream());
			String welcomeMessage = in.readUTF();	// output이랑 세트니까 연관지어 생각
			System.out.println("[클라이언트] " + welcomeMessage);
			
			// 서버에게 메시지 보내기 (socket을 쓰면 된다)
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));	// Socket에서 getInputStream/getOutputStream 을 제공한다.
			//						버퍼드(빠름) <-			 문자 			<-바이트
			out.write("반갑습니다!");  // write는 한글 원래 안 깨짐.(BufferedWriter라 그런듯)
			
			// 스트림 종료
			out.close();
			in.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(socket.isClosed() == false) {
					socket.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
