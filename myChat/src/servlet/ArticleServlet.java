package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Articles;
import jdbc.JDBCHelper;

@WebServlet("/queryArticle")
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 650707582634909101L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@SuppressWarnings("unused")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取请求的uri地址
		String url = req.getRequestURI();
		String methodName = req.getParameter("method");
		//截取其中的方法名  方法名是restful格式的   http://localhost:8080/mychat/article/listArticles
		//String methodName = url.substring(url.lastIndexOf("/")+1);
		
		Method method = null;
		try {
			method = getClass().getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class );
			method.invoke(this, req,resp);
		}  catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	/**
	 * 获取所有的文章信息
	 * @param request
	 * @param response
	 * @throws ServletException 
	 */
	private void listArticle(HttpServletRequest request,HttpServletResponse response) throws IOException{
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT  ");
        sql.append("     articles.id, ");
        sql.append("     articles.author, ");
        sql.append("     articles.content, ");
        sql.append("     articles.oppose, ");
        sql.append("     articles.praise, ");
        sql.append("     articles.title, ");
        sql.append("     date_format(articles.editTime,'%H:%i' ) editTime ");
        sql.append(" FROM ");
        sql.append("     articles, ");
        sql.append("     users a ");
        sql.append(" WHERE ");
        sql.append("     articles.users_id = a.id; ");

		List<Map<String, Object>> maps = null;
		try {
			maps = JDBCHelper.queryList(sql.toString());
		} catch (SQLException e1) {
			throw new RuntimeException("查询数据库失败");
		}
		
		/**
		 * 在这里，最开始用request传值总是无效，但是用session就可以。
		 * 在网上查了，说request只针对于本次传值，session是持续有效的，只要没有退出就一直可以使用。
		 * 用重定向的方式jsp是无法获取到值的。
		 */
		HttpSession session=request.getSession();
		session.setAttribute("articles", maps);
//		request.setAttribute("articles", maps);
//        response.sendRedirect("front/queryArticles.jsp");  //重定向
        
		/* 转发,一般是将servlet1处理的内容，转给servlet2来处理，地址栏不变 */
        try {
			request.getRequestDispatcher("front/queryArticles.jsp").forward(request, response);
		} catch (ServletException e) {
			throw new RuntimeException(e.getMessage());
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
        
        
	}
	
	/**
	 * 获取所有的文章信息
	 * @param request
	 * @param response
	 */
	private void findArticle(HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println("执行查询单个文章的方法");
		response.setContentType("text/html;charset=utf8");
        PrintWriter pw = response.getWriter();
        pw.println("<h1>查询员工的方法</h1>");
        pw.flush();
        pw.close();
	}
	
	/**
	 * 获取所有的文章信息
	 * @param request
	 * @param response
	 */
	private void addArticle(HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println("执行增加文章的方法");
		response.setContentType("text/html;charset=utf8");
        PrintWriter pw = response.getWriter();
        pw.println("<h1>查询员工的方法</h1>");
        pw.flush();
        pw.close();
	}
	
	/**
	 * 获取所有的文章信息
	 * @param request
	 * @param response
	 */
	private void updateArticle(HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println("执行修改文章的方法");
		response.setContentType("text/html;charset=utf8");
        PrintWriter pw = response.getWriter();
        pw.println("<h1>查询员工的方法</h1>");
        pw.flush();
        pw.close();
	}
	
	/**
	 * 获取所有的文章信息
	 * @param request
	 * @param response
	 */
	private void deleteArticle(HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println("执行删除文章的方法");
		response.setContentType("text/html;charset=utf8");
        PrintWriter pw = response.getWriter();
        pw.println("<h1>查询员工的方法</h1>");
        pw.flush();
        pw.close();
	}
}
