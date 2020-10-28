package network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * <pre>
 * kr.co.swh.lecture.network.udp
 * UdpClient.java
 *
 * ���� :UDP Ŭ���̾�Ʈ
 * </pre>
 * 
 * @since : 2018. 6. 23.
 * @author : tobby48
 * @version : v1.0
 */
public class UdpClient {
	public static void main(String[] args) {
		try{
			// ������ �� �ִ� UDP ���� ����
			DatagramSocket ds = new DatagramSocket();

			// ���� ���� �ּ� ����
			InetAddress ia = InetAddress.getByName("127.0.0.1");

			// ������ ������ ����
			for(int i = 0; i<10; i++) {
				String t = String.valueOf(i);
				DatagramPacket dp = new DatagramPacket(t.getBytes(),t.getBytes().length,ia, 7777);
				ds.send(dp);
			}
			ds.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}