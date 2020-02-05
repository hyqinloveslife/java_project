package filter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 在线人数监听 <br/>
 * 当一个Web应用创建的Session很多时，为了避免Session占用太多的内存，我们可以选择手动将这些内存中的session销毁，那么此时也可以借助监听器技术来实现
 * @author 97025
 *
 */
public class OnLineCountListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		ServletContext context = se.getSession().getServletContext();
		
		Integer onlineCount = (Integer) context.getAttribute("online");
		if(null==onlineCount) {			
			context.setAttribute("online", 1);
		}else {
			onlineCount++;
			context.setAttribute("online", onlineCount);
		}
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		ServletContext context = se.getSession().getServletContext();
		
		Integer onlineCount = (Integer) context.getAttribute("online");
		if(null==onlineCount) {			
			context.setAttribute("online", 0);
		}else {
			onlineCount--;
			context.setAttribute("online", onlineCount);
		}
		
	}

}
