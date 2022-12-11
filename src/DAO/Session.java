package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Session {

	private final String CONN_URL = "jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag";
	private final String USER = "bastamar";
	private final String PASSWD = "b6f5bf59c6";

	private static Connection connect;

	private static int sessionCount = 0;
	private int sessionId = -1;

	public void open(){
		try {
		sessionId = ++sessionCount;

		// Etablissement de la connection
		System.out.print("Connecting to the database with session S" + sessionCount + "... "); 
		connect = DriverManager.getConnection(CONN_URL,USER,PASSWD);
		System.out.println("connected");

		connect.setAutoCommit(false);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getSession() {
		return connect;
	}

	public void commit(){
		try {
			connect.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void rollback(){
		try {
			connect.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close(){
		System.out.println("Closing session S" + sessionId + "...");
		try {
			sessionCount--;
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void setTransactionIsolation(int level) throws SQLException {
		connect.setTransactionIsolation(level);
	}
}
