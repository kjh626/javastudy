package ex02_socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
				
				// ※ InputStream, OutputStream는 한글 처리 불가 (=> 둘 중 하나는 쓸 줄 알아야한다.)
				// 1. InputStreamReader, OutputStreamWriter로 변환해서 한글 처리하기 가능 <추천 방법, 보편적인 방법>
				// 2. DataOutputStream, DataInputStream 만 한글 처리 가능하다(writeUTF(), readUTF() 를 사용해서). 나머지는 불가
				
				// 클라이언트에게 welcome 메시지 보내기
				DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());    // 접속한 클라이언트로 데이터를 보내는 출력 스트림.
				out.writeUTF("어서오세요 환영합니다!");   // writeUTF 메소드를 이용하면 바이트 스트림으로도 한글 깨짐없이 데이터를 보낼 수 있다.
				
				// 클라이언트가 보낸 메시지 확인하기
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));	// '바이트스트림'을 '문자스트림'으로 바꾸고 '버퍼'까지 넣었다
				String line = null;		// 한 줄만 읽는 게 아니라, 여러 문장을 읽어오기 위해서 이렇게 해줌
				StringBuilder sb = new StringBuilder();
				
				while((line = in.readLine()) != null) {
					sb.append(line + "\n");
				}
				System.out.println("[서버] " + sb.toString());
				
				// 스트림 종료
				out.close();
				in.close();
				
				// 클라이언트 접속 종료 (생략 가능. 클라이언트메인에서 소켓클로즈 해줌.)
				clientSocket.close();
				
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
