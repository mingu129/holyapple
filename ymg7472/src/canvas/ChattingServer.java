package canvas; 

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * <pre>
 * kr.co.swh.lecture.network.chat 
 * ChattingServer.java
 *
 * ���� :ä�� ���� ���α׷�, ������ ����
 * </pre>
 * 
 * @since : 2018. 12. 28.
 * @author : tobby48
 * @version : v1.0
 */
public class ChattingServer extends Thread{
    Set<ServerThread> sockets = new HashSet<>();
    
    public void run(){
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(1234);
            System.out.println("Ŭ���̾�Ʈ ������ ��ٸ��ϴ�.");
            while(true){
                Socket s = serverSocket.accept();
                ServerThread t = new ServerThread(this, s);
                t.start();
                sockets.add(t);
            }
        }catch(IOException e){
            System.err.println("���� ����");
            e.printStackTrace();
        }finally{
            try{ serverSocket.close(); } catch(Exception e) {}
        }
    }
    
    public void broadcast(String message){
        Iterator<ServerThread> it = sockets.iterator();
        while(it.hasNext()){
            ServerThread peer = it.next();
            peer.sendMessage(message);
        }
    }
    
    public static void main(String[] args) {
    	ChattingServer server = new ChattingServer();
    	server.start();
    }
}
