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

/**
 * Servlet implementation class NewsHandlerServlet
 */
@WebServlet("/newsHandler")
public class NewsHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected Connection conn=JDBC.getConn();
    public NewsHandlerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		System.out.println("newsHandler");
		HttpSession session=request.getSession();
		String content=request.getParameter("content");
		String userName=(String) session.getAttribute("userName");
		System.out.println(content);
		String sql="insert into news(fromperson,toperson,content,createTime) values(?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, "all");
			ps.setString(3, content);
			ps.setDate(4, new java.sql.Date(System.currentTimeMillis()));
			int result=ps.executeUpdate();
			System.out.println(result);
			RequestDispatcher dispatcher=request.getRequestDispatcher("NewsDisplay");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
