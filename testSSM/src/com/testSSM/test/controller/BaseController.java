/**
 * @author wws
 * @date 2017-7-6  
 * @version 1.0.0 
 */
package com.testSSM.test.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.testSSM.test.service.FileRecordService;

/**
 * @author Administrator
 *
 */
public class BaseController {
	public static final int SUCCESS_STATUS_CODE = 1;
	public static final int ERROR_STATUS_CODE = 0;
	public static final String FILE_PATH = "D:\\ssm_img";

	public static final String USER = "user";

	private HttpServletResponse response;


	@ModelAttribute
	public void setReqAndRes(HttpServletResponse response) {
		this.response = response;
	}

	// HttpServletResponse response =
	// ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();

	@Resource
	public FileRecordService fileRecordService;

	/**
	 * ��ȡ��ǰ�û���Ϣ
	 * 
	 * @author huangyq
	 * @date 2017-11-13
	 * @version 1.0.0
	 * @return
	 */
	public String getCommonUser(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute(USER);
		if (StringUtils.isEmpty(username)) {
			return "0";
		}
		return username;
	}

	public void setJSONReturn(String message) {
		try {
			response.getWriter().print(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * ��request�л�ò���Map�������ؿɶ���Map
	 * 
	 * �Լ�������copy��һ���������ر���Ч
	 * 
	 * @param request
	 * 
	 * @return
	 * 
	 */

	@SuppressWarnings("unchecked")

	public static Map getParameterMap(HttpServletRequest request) {

		// ����Map

		Map properties = request.getParameterMap();

		// ����ֵMap

		Map returnMap = new HashMap();

		Iterator entries = properties.entrySet().iterator();

		Map.Entry entry;

		String name = "";

		String value = "";

		while (entries.hasNext()) {

			entry = (Map.Entry) entries.next();

			name = (String) entry.getKey();

			Object valueObj = entry.getValue();

			if (null == valueObj) {

				value = "";

			} else if (valueObj instanceof String[]) {

				String[] values = (String[]) valueObj;

				for (int i = 0; i < values.length; i++) {

					value = values[i] + ",";

				}

				value = value.substring(0, value.length() - 1);

			} else {

				value = valueObj.toString();

			}

			returnMap.put(name, value);

		}

		return returnMap;

	}
	
	
}
