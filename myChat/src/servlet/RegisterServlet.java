package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.JDBC;
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected Connection conn = JDBC.getConn();
	public RegisterServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String name=request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String address=request.getParameter("address");
		String createTime = new SimpleDateFormat().format(new Date());
		System.out.println(account + "  " + password + "  " + address + "   " + gender);
		String nickName;
		String sql = "INSERT INTO users(name,password,gender,age,address,createTime,account) "
				+ "VALUES (?,?,?,?,?,?,?)";
		System.out.println(sql);
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, gender);
			ps.setInt(4, Integer.parseInt(age));
			ps.setString(5, address);
			ps.setString(6, createTime);
			ps.setString(7, account);
			int result=ps.executeUpdate();
			System.out.println(result);
			if (result==1) {
				request.setAttribute("userName", name);
				HttpSession session=request.getSession();
				session.setAttribute("userName", name);
				if (Integer.parseInt(age)<15) {
					if (gender.equals("男")) {
						nickName="小正太";
					}else if(gender.equals("女")){
						nickName="小萝莉";
					}else{
						nickName="同志";
					}
				}else{
					if (gender.equals("男")) {
						nickName="大叔";
					}else if(gender.equals("女")){
						nickName="大娘";
					}else{
						nickName="同志";
					}
				}
				session.setAttribute("nickName", nickName);
				response.sendRedirect("home.jsp");
//				RequestDispatcher dispatcher=request.getRequestDispatcher("home.jsp");
//				dispatcher.forward(request, response);
			} else {
				response.sendRedirect("register.jsp");
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}

	}

}
