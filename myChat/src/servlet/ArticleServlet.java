package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 */
	private void listArticle(HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println("执行查询所有文章的方法");
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
