package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC {
	private static final String JDBC_URL="jdbc:mysql://localhost:3306/chatroomdb?useUnicode=true&characterEncoding=utf-8";
	private static final String DRIVERCLASS="com.mysql.jdbc.Driver";
	private static final String USER="root";
	private static final String PASSWORD="123456";
	
	public static Connection getConn(){
		Connection conn=null;
		try {
			Class.forName(DRIVERCLASS);
			conn=DriverManager.getConnection(JDBC_URL,USER,PASSWORD);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		
		
		return conn;
	}
}
