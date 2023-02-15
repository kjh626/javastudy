package ex03_Sever_Client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientMainClass {

	public static void main(String[] args) {
	
		Socket socket = null;
		// 클라이언트가 서버쪽으로 데이터를 보낸다.
		BufferedWriter writer = null;	// 서버로 텍스트를 보내는 출력 스트림
		Scanner sc = null;
		
		try { 
			// 네트워크 통신에서의 httpURLConnection. con이랑 socket이 비슷하다고 생각하면 된다. 
			socket = new Socket();
			socket.connect(new InetSocketAddress("localhost", 9090));	// 어느 서버에 접속할 것인지. 서버주소는 localhost이고, 포트번호는 9090이다.
			
			// socket 정보를 이용하는 클라이언트를 스레드로 생성
			Client client = new Client(socket);    // localhost:9090 서버로 연결할 수 있는 socket 정보를 넘김.
			client.start();    // 클라이언트 스레드 실행
			
			sc = new Scanner(System.in);
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));	// 소켓은 바이트 기반이기 때문에 Writer를 바이트기반으로 읽어줄 Writer를 찾아 써야함.
			
			while(true) {
				System.out.print(">>> ");
				String message = sc.nextLine();		// 채팅 내용을 입력
				writer.write(message + "\n");		// 서버가 엔터까지를 입력으로 인식할 수 있도록 \n을 추가해서 보냄.
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
	
}
