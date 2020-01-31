package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.jmx.snmp.Timestamp;

public class JDBCHelper {
	
	/**
	 * 封装jdbc，从数据库中查询格式为List<Map<String,Object>>的数据
	 * @param sql 需要传入的sql语句
	 * @return
	 * @throws SQLException
	 */
	public static List<Map<String,Object>> queryList(String sql) throws SQLException {
		Connection conn=JDBC.getConn();
		/* 返回的结果集 */
		List<Map<String,Object>> results = new ArrayList<>();
		
		/* 获取所有列名 */
		List<String> columnList = new ArrayList<String>();
		
		Statement st = conn.createStatement();
		
		ResultSet rs = st.executeQuery(sql);
		
		ResultSetMetaData rsmd = rs.getMetaData();
		
		int columnCount = rsmd.getColumnCount();
		
		for (int i = 1; i <= columnCount; i++) {

			columnList.add(lookupColumnName(rsmd, i));
		}
		
		Map<String,Object> map;
		for(;rs.next();results.add(map)) {
			map = new HashMap<String, Object>();
			for (int i = 0; i < columnCount; i++) {
				map.put(columnList.get(i), rs.getObject(i+1));
			}
		}
		
		return results;
	}
	
	/**
	 * 查询
	 * @param sql 传入的sql语句 
	 * @param param 需要传入的 参数
	 * @return
	 * @throws SQLException 返回sql异常，比如sql语法错误 
	 */
	public static List<Map<String,Object>> queryList(String sql,Object[] params) throws SQLException{
		Connection conn=JDBC.getConn();
		/* 返回的结果集 */
		List<Map<String,Object>> results = new ArrayList<>();
		
		PreparedStatement st = conn.prepareStatement(sql);
		
		ResultSet rs = executeQuery(conn,st,sql,params);
		
		results = toList(rs);
		
		return results;
	}
	
	/**
	 * 将resultset中的数取出来封装成List<Map<String,Object>>类型的
	 * @param rs
	 * @return
	 * @throws SQLException 
	 */
	private static List<Map<String, Object>> toList(ResultSet rs) throws SQLException {
		/* 返回的结果集 */
		List<Map<String,Object>> results = new ArrayList<>();
		
		ResultSetMetaData rsmd = rs.getMetaData();
		
		int columnCount = rsmd.getColumnCount();
		
		/* 获取所有列名 */
		List<String> columnList = new ArrayList<String>();
		
		for (int i = 1; i <= columnCount; i++) {

			columnList.add(lookupColumnName(rsmd, i));
		}
		
		Map<String,Object> map;
		for(;rs.next();results.add(map)) {
			map = new HashMap<String, Object>();
			for (int i = 0; i < columnCount; i++) {
				map.put(columnList.get(i), rs.getObject(i+1));
			}
		}
		return results;
	}

	/**
	 * 封装获取resultSet的方法
	 * @param conn
	 * @param st
	 * @param sql
	 * @param param 数组中的参数与sql中的参数需要对应
	 * @return
	 * @throws SQLException 
	 */
	private static ResultSet executeQuery(Connection conn, PreparedStatement ps, String sql, Object[] params) throws SQLException {
		ResultSet rs = null;
		
		//设置预处理的参数
		setObjects(ps,params);
		
		rs = ps.executeQuery();
		
		return rs;
	}

	/**
	 * 设置预处理sql的参数
	 * @param ps
	 * @param params
	 * @throws SQLException 处理sql异常
	 */
	private static void setObjects(PreparedStatement ps, Object[] params) throws SQLException {
		if(params == null || params.length == 0) {
			return;
		}
		
		int colIndex = 1;//设置参数，从第一个开始
		
		for (int i = 0; i < params.length; i++) {
			Object value = params[i];
			//对于时间类型的需要特殊处理
			if(value instanceof Date) {
				ps.setObject(colIndex++, new Timestamp(((Date) value).getTime()));
			}else {
				ps.setObject(colIndex++, value);
			}
		}
		
	}

	/**
	 * 将元数据的值转出来
	 * @param rsmd
	 * @param colIndex
	 * @return
	 * @throws SQLException
	 */
	private static String lookupColumnName(ResultSetMetaData rsmd,int colIndex) throws SQLException {
		String name = rsmd.getColumnLabel(colIndex);
		if(null==name||name.length()<1) {
			name = rsmd.getColumnName(colIndex);
		}
		return name;
		
	}
}
