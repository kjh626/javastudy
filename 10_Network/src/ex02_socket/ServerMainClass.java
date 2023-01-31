package ex02_socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMainClass {

	public static void main(String[] args) {

		// ServerSocket : 서버가 사용하는 Socket
		ServerSocket serverSocket = null;
		
		try {
			
			serverSocket = new ServerSocket();	// IOException 처리가 필요하다.
			
			// InetSocketAddress : Socket 사용 시 "호스트", "포트번호"를 관리하는 클래스
			// 인터넷 쓸 때 포트번호 : 80, FTP 사용 : 21,22,...,  , Oracle의 포트번호 : 1521 => 기본적으로 정해진 번호들이 있다.
			InetSocketAddress address = new InetSocketAddress("localhost", 9090);    // 완성되는 주소 - localhost:9090
			
			// bind : ServerSocket에 InetSocketAddress 정보 전달 - localhost:9090 이 서버주소이다.
			serverSocket.bind(address);
			
			// 무한루프로 serverSocket 구성 => 서버는 꺼지지 않으니까..
			while(true) {
				
				System.out.println("[서버] 클라이언트 접속을 기다리고 있습니다.");
				
				// 클라이언트의 접속 요청을 허용
				Socket clientSocket = serverSocket.accept();	// clientSocket은 serverSocket이 받아준 소켓이다. <= Socket으로 받아야 한다.
																// 누군가 접속할 때까지 무한루프중 accept에서 기다리는중....
				
				// 클라이언트의 접속 확인을 위해서 InetSocketAddress를 활용
				InetSocketAddress clientAddress = (InetSocketAddress) clientSocket.getRemoteSocketAddress();
				System.out.println("[서버] 접속된 클라이언트 : " + clientAddress.getHostName());
				
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	// 주소를 연결하고 소멸되는 과정.
		
		
	}

}
