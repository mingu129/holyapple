package ssa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.PreparedStatement;
import lombok.Data;

/**
 * <pre>
 * kr.co.swh.lecture.database.java
 * MariaDBSelect.java
 *
 * ���� :�����ͺ��̽� �˻� ����
 * </pre>
 * 
 * String insertTableSQL = "INSERT INTO student"
				+ "(id, name) VALUES"
				+ "(?,?)";
 *
 * @since : 2017. 10. 26.
 *
 * @author : tobby48
 * @version : v1.0
 */
public class MariaDBSelect {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://192.168.0.41:3306/minkyu";

	static final String USERNAME = "root";
	static final String PASSWORD = "swhacademy!";
	static void menu(){
		System.out.println("###############");
		System.out.println("1.����� �߰�");
		System.out.println("2.����");
		System.out.println("3.������");
		System.out.println("###############");
	}
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		try{
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			System.out.println("MariaDB ����.");
			statement = connection.createStatement();

			
			//	insert.int result = statement.executeUpdate("insert into employees( name, hourly_pay, position, employee_contact) values('"+"�α�', 9.00,'manager',12777723);");
			while(true) {
				menu();
				Scanner s = new Scanner(System.in);
				int a = s.nextInt();
				
				if(a==1) {
					Scanner s1 = new Scanner(System.in);
					User1 u = new User1();
					System.out.println("name:");
					u.setName(s.next());
					System.out.println("age:");
					u.setAge(s.nextInt());
					statement.execute("INSERT INTO users (NAME, age) values("+ u.getName() +", "+ u.getAge());
				}
				if(a==2) {
					ResultSet rs = statement.executeQuery("SELECT * FROM users;");	
					while(rs.next()){
						int user_id = rs.getInt("user_id");
						String name = rs.getString("name");
						int age = rs.getInt("age");
						System.out.println("user_id : " + user_id);
						System.out.println("name: " + name);
						System.out.println("age: " + age);
						System.out.println(rs.getInt(1)+"\n");
					}
					rs.close();
				}
				if(a==3) {
					System.out.println("exit");
					break;
				}
			}
			//	update
//			int result1 = statement.executeUpdate("update a set c1 = v1;");		//	result = �������͵� ���� ����
//			if(result1 > 0) System.out.println("����ó��");
//			else System.out.println("������ó��");
				
			//	select
		}catch(SQLException se1){
			se1.printStackTrace();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(statement!=null) statement.close();
				if(connection!=null) connection.close();
			}catch(SQLException se2){
			}
		}
		System.out.println("MariaDB ��������.");
	}

}