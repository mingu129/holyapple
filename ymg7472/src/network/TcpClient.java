package network;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
/**
 * <pre>
 * kr.co.swh.lecture.network.tcp
 * TcpClient.java
 *
 * ���� :TCP Ŭ���̾�Ʈ
 * </pre>
 * 
 * @since : 2018. 6. 23.
 * @author : tobby48
 * @version : v1.0
 */
public class TcpClient {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		InetAddress ia = null;		// ������ ������ �ּҸ� ������ ����
		Socket sock = null;		// ������ ������ ���� ����
		PrintWriter out = null;		// �����͸� ������  Write ����
		try{
			// ���� �ּһ���
			ia = InetAddress.getByName("127.0.0.1");
			// ���� ����
			sock = new Socket(ia, 9999);
			// ������ �޼��� ����
			out = new PrintWriter(sock.getOutputStream());
			System.out.println("���� �޽��� �Է�");
			String msg = s.nextLine();
			out.println(msg+"\n");
			out.flush();
			// ���� ����
			sock.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

	}
}
