package canvas; 

import org.apache.log4j.Logger;

/**
 * <pre>
 * chat 
 * zcx.java
 *
 * ���� :
 * </pre>
 * 
 * @since : 2020. 10. 28.
 * @author : ymg74
 * @version : v1.0
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 * <pre>
 * kr.co.swh.lecture.network.chat 
 * ServerThread.java
 *
 * ���� :ä�� ���� �޼��� ���� ������
 * </pre>
 * 
 * @since : 2018. 12. 28.
 * @author : tobby48
 * @version : v1.0
 */
public class ServerThread extends Thread{
    private Socket socket;
    private ChattingServer server;
    private OutputStream os;
    public ServerThread(ChattingServer server, Socket s){
        this.server = server;
        this.socket = s;
        System.out.println("Ŭ���̾�Ʈ ���� : " + s.getInetAddress().getHostAddress());
    }
    ArrayList<String> us = new ArrayList<String>();
    public void run(){
        InputStream is = null;
        DataInputStream dis = null;
        
        try{
            is = socket.getInputStream();
            dis = new DataInputStream(is);
            String line;
            while(true){
                line = dis.readUTF();
                if(!line.contains(":")) {
                	us.add(line);
                	server.announce(us);
                }
                else {
                	server.broadcast(line);
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{

            
        }
    }
    
    public void sendMessage(String message){
        try {
            os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeUTF(message);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
