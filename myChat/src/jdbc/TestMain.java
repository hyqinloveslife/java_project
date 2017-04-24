package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.ResultSet;

import bean.UserBean;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection= (Connection) JDBC.getConn();
		System.out.println(connection);
		String sql="select * from users";
		List<UserBean> userBeans=new ArrayList<>();
		try {
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rSet=(ResultSet) ps.executeQuery();
			while (rSet.next()) {
				UserBean userBean=new UserBean();
				userBean.setId(rSet.getString("id"));
				userBean.setName(rSet.getString("name"));
				userBean.setAge(rSet.getInt("age"));
				userBean.setPassword(rSet.getString("password"));
				userBean.setGender(rSet.getString("gender"));
//				userBean.setCreateTime(rSet.getDate("createTime"));
				userBean.setAddress(rSet.getString("address"));
				userBeans.add(userBean);
			}
			System.out.println(userBeans);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
