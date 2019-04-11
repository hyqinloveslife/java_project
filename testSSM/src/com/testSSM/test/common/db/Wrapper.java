package com.testSSM.test.common.db;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

import org.springframework.jdbc.core.RowMapper;

public class Wrapper<T> implements RowMapper<T>{
	private Class<?> targetClazz;
	private HashMap<String, Field> fieldMap;
	
	
	public Wrapper(Class<?> clazz){
		this.targetClazz = clazz;
		this.fieldMap = new HashMap();
		Field [] fields = targetClazz.getDeclaredFields();
		for (Field field : fields) {
			//为了保证取出来的字段能匹配，所以将取出来的字段都变成小写，方便匹配
			fieldMap.put(field.getName().toLowerCase(), field);
			// fieldMap.put(getFieldNameUpper(field.getName()), field);  
		}
	}
	

	@Override
	public T mapRow(ResultSet rs, int rownum) throws SQLException {
		T t = null;
		try {
			t = (T) targetClazz.newInstance();
			final ResultSetMetaData metaData = rs.getMetaData();
			int columnLength = metaData.getColumnCount();
			String columnName = null;
			for (int i = 1; i <= columnLength; i++) {
				columnName = metaData.getColumnName(i).toLowerCase();
				Class fieldClazz = fieldMap.get(columnName).getType();
				Field field = fieldMap.get(columnName);
				field.setAccessible(true);
				
				if(fieldClazz==int.class||fieldClazz==Integer.class) {
					field.set(t, rs.getInt(columnName));
				}else if(fieldClazz==boolean.class||fieldClazz==Boolean.class) {
					field.set(t, rs.getBoolean(columnName));
				}else if(fieldClazz==String.class||fieldClazz==String.class) {
					field.set(t, rs.getString(columnName));
				}else if(fieldClazz==float.class||fieldClazz==Float.class) {
					field.set(t, rs.getString(columnName));
				}else if(fieldClazz==double.class||fieldClazz==Double.class) {
					field.set(t, rs.getDouble(columnName));
				}else if(fieldClazz==BigDecimal.class) {
					field.set(t, rs.getBigDecimal(columnName));
				}else if(fieldClazz==short.class||fieldClazz==Short.class) {
					field.set(t, rs.getShort(columnName));
				}else if(fieldClazz==Date.class) {
					field.set(t, rs.getDate(columnName));
				}else if(fieldClazz==long.class||fieldClazz==Long.class) {
					field.set(t, rs.getLong(columnName));
				}else if(fieldClazz==Timestamp.class) {
					field.set(t, rs.getTimestamp(columnName));
				}
				field.setAccessible(true);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

	
	 /** 
     * 方法首字母大写. 
     *  
     * @param fieldName 
     *            字段名. 
     * @return 字段名首字母大写. 
     */  
    private String getFieldNameUpper(String fieldName) {  
        char[] cs = fieldName.toCharArray();  
        cs[0] -= 32; // 方法首字母大写  
        return String.valueOf(cs);  
    }  
}
