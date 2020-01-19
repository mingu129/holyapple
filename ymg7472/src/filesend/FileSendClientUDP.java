package filesend;

import java.io.File;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * <pre>
 * kr.co.swh.lecture.network.filetrans 
 * FileSendClientUDP.java
 *
 * ���� :���� ���� Ŭ���̾�Ʈ
 * </pre>
 * 
 * @since : 2018. 12. 28.
 * @author : tobby48
 * @version : v1.0
 */
public class FileSendClientUDP {
	public static final int DEFAULT_BUFFER_SIZE = 10000;
	public static void main(String[] args) {
		String serverIP = "127.0.0.1";
		int port = 9999;
		String FileName = "C:\\Users\\ymg74\\asd.txt";

		File file = new File(FileName);
		DatagramSocket ds = null;
		if (!file.exists()) {
			System.out.println("File not Exist");
			System.exit(0);
		}
		long fileSize = file.length();
		long totalReadBytes = 0;

		double startTime = 0;  
		try {
			ds = new DatagramSocket();
			InetAddress serverAdd = InetAddress.getByName(serverIP);
			startTime = System.currentTimeMillis();
			
			//	start ��ȣ ������ ��Ʈ
			String str = "start";
			DatagramPacket dp = new DatagramPacket(str.getBytes(), str.getBytes().length, serverAdd, port);
			ds.send(dp);	//	start ��ȣ ����

			//	������ ũ�� ������ ��Ʈ
			str = String.valueOf(fileSize);
			dp = new DatagramPacket(str.getBytes(), str.getBytes().length, serverAdd, port);
			ds.send(dp);	//	������ ũ�� ����

			//	������ ������ �о� ������ �����ϴ� ��Ʈ
			FileInputStream fis = new FileInputStream(file);
			byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
			while (true) {
				Thread.sleep(10);
				//	���� ���� �о����
				int readBytes = fis.read(buffer, 0, buffer.length);
				if (readBytes == -1)
					break;
				//	������ ������ ������ ����
				dp = new DatagramPacket(buffer, readBytes, serverAdd, port); // *
				ds.send(dp);
				
				//	����� ���
				totalReadBytes += readBytes;
				System.out.println("In progress: " + totalReadBytes + "/"
						+ fileSize + " Byte(s) ("
						+ (totalReadBytes * 100 / fileSize) + " %)");

			}
			double endTime = System.currentTimeMillis();
			double diffTime = (endTime - startTime)/ 1000;;
			double transferSpeed = (fileSize / 1000)/ diffTime;

			System.out.println("time: " + diffTime+ " second(s)");
			System.out.println("Average transfer speed: " + transferSpeed + " KB/s");

			str = "end";
			dp = new DatagramPacket(str.getBytes(), str.getBytes().length, serverAdd, port);
			ds.send(dp);
			Thread.sleep(5000);
			System.out.println("Process Close");
			fis.close();
			ds.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}