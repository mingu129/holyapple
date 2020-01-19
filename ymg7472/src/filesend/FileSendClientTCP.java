package filesend;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * <pre>
 * kr.co.swh.lecture.network.filetrans 
 * FileSendClient.java
 *
 * ���� :���� ���� Ŭ���̾�Ʈ
 * </pre>
 * 
 * @since : 2018. 12. 28.
 * @author : tobby48
 * @version : v1.0
 */
public class FileSendClientTCP {
	public static void main(String[] args) {
        Socket socket = null;       
        String serverIp = "192.168.0.13";
        int serverPort = 8081;
        String filename = "C:\\Users\\ymg74\\asd.txt";
         
        try {
            // ���� ����
            socket = new Socket(serverIp, serverPort); // socket(),connect();
            System.out.println("������ ����Ǿ����ϴ�.");
  
            FileSender fs = new FileSender(socket,filename);
            fs.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
 
class FileSender extends Thread {
    Socket socket;
    DataOutputStream dos;
    FileInputStream fis;
    BufferedInputStream bis;
    String filename;
    int control = 0;
    public FileSender(Socket socket,String filestr) {
        this.socket = socket;
        this.filename = filestr;
        try {
            // ������ ���ۿ� ��Ʈ�� ����
            dos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  
    @Override
    public void run() {
        try {
            // ���� ������ �����鼭 ����
            File f = new File(filename);
            fis = new FileInputStream(f);
            bis = new BufferedInputStream(fis);
  
            int len;
            int size = 4096;
            byte[] data = new byte[size];
            while ((len = bis.read(data)) != -1) {
                control++;
                if(control % 10000 == 0)
                {
                    System.out.println("������..." + control/10000);      
                }
                dos.write(data, 0, len);
            }
  
            dos.flush();
            dos.close();
            bis.close();
            fis.close();
            System.out.println("�Ϸ�");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}