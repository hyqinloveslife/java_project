package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCHelper {
	
	/**
	 * 封装jdbc，从数据库中查询格式为List<Map<String,Object>>的数据
	 * @param sql
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
