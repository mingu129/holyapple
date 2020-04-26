package discords;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * kr.co.swh.lecture.database.java
 * MariaDBTransaction.java
 *
 * ���� :�����ͺ��̽� Ʈ����� ����
 * </pre>
 * 
 * @since : 2017. 10. 26.
 * @author : tobby48
 * @version : v1.0
 */
public class MariaDBTransaction {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://192.168.0.41/minkyu";

	static final String USERNAME = "root";
	static final String PASSWORD = "swhacademy!";

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		PreparedStatement preparedStatementInsert = null;
		PreparedStatement preparedStatementUpdate = null;
		SendJDA j = new SendJDA();
		List<SentimentalDic> s = j.initDatas();
		ArrayList<PreparedStatement> as = new ArrayList<PreparedStatement>();
		String insertTableSQL = "INSERT INTO sentimentaldic"
				+ "(word, word_root, polarity) VALUES"
				+ "(?,?,?)";

		for(int i = 0; i<s.size(); i++) {
			try{
				Class.forName(JDBC_DRIVER);
				connection = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
				System.out.println("MariaDB ����.");

				connection.setAutoCommit(false);

				preparedStatementInsert = connection.prepareStatement(insertTableSQL);
				preparedStatementInsert.setString(1, s.get(i).getWord());
				preparedStatementInsert.setString(2, s.get(i).getWord_root());
				preparedStatementInsert.setString(3, s.get(i).getPolarity());
				preparedStatementInsert.executeUpdate();

				
				/*	����ó��	*/
//				preparedStatementUpdate.setString(1, "�Ҹ�");
//				preparedStatementUpdate.setInt(2, 168);
				
				/*	����
				 * 	ù��° ������ ������� ����
				 * */
				
				
				connection.commit();
				System.out.println("Ʈ����� ����ó��");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				if (connection != null) connection.rollback();
			} finally {
				if (preparedStatementInsert != null) preparedStatementInsert.close();
				if (preparedStatementUpdate != null) preparedStatementUpdate.close();
				if (connection != null) connection.close();
			}
		}
		System.out.println("MariaDB ��������.");
	}

}