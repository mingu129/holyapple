package tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.google.gson.Gson;

import naver_news_spark.HibernateUtil;
import naver_news_spark.models.C_news;


public class TcpServer {	
	public static void main(String[] args){
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			ServerSocket ss = null;		// �������� ����
			Socket sock = null;		// ������ Ŭ���̾�Ʈ ���Ϻ���
			try {
				ss = new ServerSocket(9999);	// �������ϻ���
				System.out.println("���� ����� ");
				while (true) {
					// Ŭ���̾�Ʈ�� ���� �Ҷ����� ����ϴٰ� �����ϸ� socket����
					sock = ss.accept();
					// Ŭ���̾�Ʈ���� ���� ������ �޽����� ���
					BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
					String msg = in.readLine();
//					System.out.println(msg);
					C_news jnews = new Gson().fromJson(msg, C_news.class);
//					System.out.println(jnews.toString());
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					session.save(jnews);
//					System.out.println(jnews.toString());
					session.getTransaction().commit();
					//Ŭ���̾�Ʈ���� ���� ����
					in.close();
					sock.close();
				}
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
		}
	}
