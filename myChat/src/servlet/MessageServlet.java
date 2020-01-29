package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import filter.MyServlet;

@WebServlet("/messageServlet")
public class MessageServlet extends MyServlet{
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 5988160315352698901L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String returnValue = "返回成功";
		
		sendMessage(req, resp, returnValue);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
