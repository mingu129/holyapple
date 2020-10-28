package network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * <pre>
 * kr.co.swh.lecture.network.udp
 * UdpServer.java
 *
 * ���� :UDP ����
 * </pre>
 * 
 * @since : 2018. 6. 23.
 * @author : tobby48
 * @version : v1.0
 */
public class UdpServer {
	public static void main(String[] args) {
		DatagramSocket ds = null;
		try{
			ds = new DatagramSocket(7777);	// ������ �����Ҽ� �ֵ��� UDP ���� ����
			byte [] date = new byte[66536];		// ���۹��� �����͸� ������ ����Ʈ �迭����

			// UDP ������� ������ ���� packet ��ü����
			DatagramPacket dp = new DatagramPacket(date, date.length);
			System.out.println("������ ���� �غ� �Ϸ�....");
			while(true){
				// ������ ���� �ޱ�
				ds.receive(dp);
				System.out.println(new String(dp.getData(),"UTF-8"));
			}
		} catch(Exception e){
			System.out.println(e.getMessage());
		} finally {
			ds.close();
		}
	}
}