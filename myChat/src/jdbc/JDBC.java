package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 获取jdbc要设置为单例模式
 * @author 97025
 *
 */
public class JDBC {
	private static final String JDBC_URL="jdbc:mysql://localhost:3306/chatroomdb?useUnicode=true&characterEncoding=utf-8";
	private static final String DRIVERCLASS="com.mysql.jdbc.Driver";
	private static final String USER="root";
	private static final String PASSWORD="123456";
	
	/* 私有化构造方法 */
	private JDBC() {}
	private static Connection conn=null;
	static {
		System.out.println(" jdbc: "+conn);
	}
	/**
	 * 线程安全
	 * @return
	 */
	public static Connection getConn(){
		if(null==conn) {
			synchronized (JDBC.class) {
				if(null==conn) {
					try {
						Class.forName(DRIVERCLASS);
						conn=DriverManager.getConnection(JDBC_URL,USER,PASSWORD);
						
					} catch (Exception e) {
						e.getStackTrace();
					}
				}
			}
		}
		return conn;
	}
}
