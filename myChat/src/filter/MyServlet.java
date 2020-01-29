package filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet{
	
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -1326376846620015162L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service处理。。。。。。");
		response.setContentType("text/html:charset=utf-8");
		
		String methodName = request.getParameter("method");
		
		if(null==methodName||methodName.trim().isEmpty()) {
			throw new RuntimeException("您没有传递method参数，无法调用方法");
		}
		Method method = null;
		try {
			method = getClass().getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class );
			String result = (String) method.invoke(this, request,response);
			
			System.out.println("result : "+result);
			
			if(null==result||result.trim().isEmpty()) {
				return;
			}
			
			if(result.contains(":")) {
				int index = result.indexOf(":");
				String operate = result.substring(0,index);
				String path = result.substring(index+1);
				
				if(operate.equalsIgnoreCase("r")) {
					response.sendRedirect(request.getContextPath()+path);
				}else if(operate.equalsIgnoreCase("f")) {
					request.getRequestDispatcher(path).forward(request, response);
				}else {
					throw new RuntimeException("您指定的操作"+operate+"不支持，请正确填写 r和f");
				}
			}else {
				request.getRequestDispatcher(result).forward(request, response);
			}
		}  catch (Exception e) {
			System.out.println("您要调用的方法"+methodName+",它内部抛出了异常");
			throw new RuntimeException(e.getMessage());
		}
	}
	

	/*
	 * 一般，根据返回结果的类型不同，我们要设置不同的值，常见的有以下几种：
    1、 返回普通文本：Content-Type="text/plain"
    2 、返回一段HTML代码 ：Content-Type="text/html"
    3 、返回一段XML代码：Content-Type="text/xml"（注意，是代码！没有返回一个XML文件这种说法，服务器与浏览器通过IO流来传输，所以只能是某种格式的字符串而不是一个文件）
    4 、返回一段javascript代码：Content-Type= "text/javascript"
    5 、返回一段json代码：Content-Type="application/json"  
	 * 
	 */
	
	/**
	 * 在执行了操作后返回消息到前台
	 * @param request
	 * @param response
	 * @param returnValue
	 * @throws IOException
	 */
	protected void sendMessage(HttpServletRequest request,HttpServletResponse response,String returnValue) throws IOException {
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/javascript");
		PrintWriter pw = response.getWriter();
		StringBuilder res = new StringBuilder();
		res.append("<script type='text/javascript'>");
		res.append("alert('");
		res.append(returnValue);
		res.append("')");
		res.append("</script>");
		
		pw.print(res);
		pw.flush();
		pw.close();
	}
	
}
