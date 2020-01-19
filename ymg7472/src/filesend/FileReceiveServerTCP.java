package filesend;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <pre>
 * kr.co.swh.lecture.network.filetrans 
 * FileReceiveServer.java
 *
 * ���� :���� ���� ����
 * </pre>
 * 
 * @since : 2018. 12. 28.
 * @author : tobby48
 * @version : v1.0
 */
public class FileReceiveServerTCP {

	public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        String filename = "C:\\Users\\ymg74\\receive-data.txt";
        try {
            // ������ ���� ���� �� ���
            serverSocket = new ServerSocket(8081); // socket(),bind();
  
            // ����Ǹ� ��ſ� ���� ����           
            socket = serverSocket.accept(); // listen(),accept();
            long start = System.currentTimeMillis();
            // ���� ���� �۾� ����
            FileReceiver fr = new FileReceiver(socket,filename,start);
            fr.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
  
    }
}
  
class FileReceiver extends Thread {
    Socket socket;
    DataInputStream dis;
    FileOutputStream fos;
    BufferedOutputStream bos;
    String filename;
    long start;
    int control = 0;
    public FileReceiver(Socket socket,String filestr,long starttime) {
        this.socket = socket;
        this.filename = filestr;
        this.start = starttime;
    }
  
    @Override
    public void run() {
        try {
            dis = new DataInputStream(socket.getInputStream());
 
            String fName = filename;
  
            // ������ �����ϰ� ���Ͽ� ���� ��� ��Ʈ�� ����
            File f = new File(fName);
            fos = new FileOutputStream(f);
            bos = new BufferedOutputStream(fos);
            
  
            // ����Ʈ �����͸� ���۹����鼭 ���
            int len;
            int size = 4096;
            byte[] data = new byte[size];
            while ((len = dis.read(data)) != -1) {
                control++;
                if(control % 10000 == 0)
                {
                    System.out.println("������..." + control/10000);      
                }
                bos.write(data, 0, len);
            }
            long end = System.currentTimeMillis();
            System.out.println( "Elapsed Time (seconds) : " + ( end - start )/1000.0 );
            bos.flush();
            bos.close();
            fos.close();
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}