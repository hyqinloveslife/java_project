package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;
import filter.MyServlet;
import jdbc.JDBC;

/**
 * Servlet implementation class ChatServlet
 */
@WebServlet("/ChatServlet")
public class ChatServlet extends MyServlet {
	private static final long serialVersionUID = 1L;
	protected Connection conn=JDBC.getConn();
    public ChatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		System.out.println(account);
		System.out.println(password);
		String sql="select * from users where account='"+account+"'";
		String nickName;
		HttpSession session=request.getSession();
		List<UserBean> userBeans=new ArrayList<>();
		try {
			Statement ps=conn.createStatement();
			//ps.setString(1, account);
			ResultSet set=ps.executeQuery(sql);
			UserBean userBean = null;
			while (set.next()) {
				userBean = new UserBean();
				userBean.setAccount(set.getString("account"));
				userBean.setId(set.getString("id"));
				userBean.setPassword(set.getString("psw"));
				userBean.setGender(set.getString("gender"));
				userBean.setName(set.getString("name"));
				userBean.setAge(set.getInt("age"));
				userBean.setAddress(set.getString("address"));
				userBeans.add(userBean);
			}
			System.out.println(userBean);
			if(null==userBean) {

				response.setHeader("Content-type", "text/html;charset=UTF-8");
				
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				out.print("<script>alert('登录失败!');window.location.href='index.jsp'</script>");
				return;
			}
			if (userBean.getAge()<15) {
				if (userBean.getGender().equals("男")) {
					nickName="小正太";
					session.setAttribute("nickName", nickName);
				}else{
					nickName="小萝莉";
					session.setAttribute("nickName", nickName);
				}
			}else{
				if (userBean.getGender().equals("女")) {
					nickName="大娘";
					session.setAttribute("nickName", nickName);
				}else{
					nickName="大叔";
					session.setAttribute("nickName", nickName);
				}
			}
			System.out.println(nickName);
			if (userBean.getPassword().equals(password)&&userBean.getAccount().equals(account)) {
				System.out.println("登录成功");
				
				session.setAttribute("userName", userBean.getName());
				session.setAttribute("password", userBean.getPassword());
				RequestDispatcher dispatcher=request.getRequestDispatcher("home.jsp");
				dispatcher.forward(request, response);
			}else{
				System.out.println("登录失败");
				sendMessage(request, response, "登录失败");
				response.sendRedirect("index.jsp?error=登录失败");
			}
		} catch (Exception e) {
			sendMessage(request, response, e.getMessage());	
		}
	}

}
