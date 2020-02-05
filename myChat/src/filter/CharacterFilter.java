package filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CharacterFilter implements Filter{
	private FilterConfig config;
	
	@Override
	public void destroy() {
		System.out.println("fileter銷毀");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
			throws IOException, ServletException {
		/* 在这里可以获取request里面所有的参数 */
		ServletContext application = config.getServletContext();
		
		Map<String,Integer> ipCount = (Map<String, Integer>) application.getAttribute("ipcount");
		String ip = req.getRemoteAddr();
		Integer count = ipCount.get("ip");
		if(null!=count) {
			count += count;
		}else {
			count=1;
		}
		ipCount.put("ip", count);
		application.setAttribute("ipcount", ipCount);
		
		//在实现接口方法之后，我们要转换request和response类型至HttpServlet，否则接下去的操作可能会报错。
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("调用service之前执行一段代码");
		filterChain.doFilter(request, response);
		System.out.println("调用service之后执行一段代码");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("初始化字符过滤器");
		this.config = config;
		
		/* 初始化参数，用ipcount来存放ip及访问次数 */
		ServletContext application = config.getServletContext();
		
		Map<String,Integer> ipCount = new HashMap<String, Integer>();
		
		application.setAttribute("ipcount", ipCount);
		
	}

}
