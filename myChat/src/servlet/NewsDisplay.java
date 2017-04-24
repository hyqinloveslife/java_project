package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.News;
import jdbc.JDBC;

/**
 * Servlet implementation class NewsDisplay
 */
@WebServlet("/NewsDisplay")
public class NewsDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected Connection conn=JDBC.getConn();
    public NewsDisplay() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		Map<String, String> map=new HashMap<>();
		String sql="select * from news";
		List<News> newses=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet set=ps.executeQuery();
			while (set.next()) {
				News news=new News();
				news.setFromPerson(set.getString("fromperson"));
				news.setToPerson(set.getString("toperson"));
				news.setContent(set.getString("content"));
				news.setSendTime(set.getString("createTime"));
				newses.add(news);
			}
			System.out.println(newses);
			session.setAttribute("news", newses);
			request.setAttribute("newses", newses);
			RequestDispatcher dispatcher=request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
