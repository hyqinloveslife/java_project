package com.testSSM.test.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.testSSM.test.common.DataJson;
import com.testSSM.test.common.ListObject;
import com.testSSM.test.common.Other;
import com.testSSM.test.model.DownloadRecord;
import com.testSSM.test.model.ResultData;
import com.testSSM.test.model.User;
import com.testSSM.test.pojo.UserPojo;
import com.testSSM.test.service.FileRecordService;
import com.testSSM.test.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	private static Logger logger=Logger.getLogger(UserController.class);
	private static final String SUCCESS="1";
	private static final String ERROR="0";
	@Resource
	private UserService userService;
	
	/**
	 * 注册
	 * @param request
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("register.do")
	public ModelAndView register(HttpServletRequest request,UserPojo user){
		ModelAndView view=new ModelAndView();
		if (user.getAccount()==null) {
			return view;
		}
		User userModel=new User();
		BeanUtils.copyProperties(user, userModel);
		int result = userService.save(userModel);
		if (result>0) {			
			view.addObject("flag", "成功");
		}
		view.setViewName("register");
		
		return view;
	}
	
	/**
	 * 用户列表
	 * @return
	 */
	@RequestMapping("userList.do")
	public ModelAndView userList(){
		ModelAndView view=new ModelAndView();
		List<User> users=userService.query();
		view.addObject("users", users);
		//setviewname会定位到web-inf目录下
		view.setViewName("user/userList");
		return view;
	}
	
	/**
	 * 登录
	 * @return
	 */
	@RequestMapping("login.do")
	public ModelAndView login(HttpServletRequest request,UserPojo userPojo){
		ModelAndView view=new ModelAndView();
		//清除空格
		userPojo.setAccount(userPojo.getAccount().trim());
		userPojo.setPassword(userPojo.getPassword().trim());
		User user=userService.queryAccount(userPojo.getAccount());
		if (user!=null) {
			if (user.getPassword().equals(userPojo.getPassword())
					&&user.getAccount().equals(userPojo.getAccount())) {
				request.getSession().setAttribute("user", user.getName());
				view.setViewName("user/index");
				return view;
			}
		}
		view.addObject("flag", "账号或密码错误");
		view.setViewName("redirect:login.jsp");
		
		return view;
				
	}
	
	/**
	 * 前端登录
	 * @author huangyq
	 * @date 2017-7-7  
	 * @version 1.0.0 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/login2.do",method=RequestMethod.POST)
	public ListObject log_in(HttpServletRequest request,HttpSession session,String param) {
		ListObject object = new ListObject();
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		User user =userService.queryAccount(account);
		if (user!=null) {
			if (user.getPassword().equals(password)
					&&user.getAccount().equals(account)) {
				object.setData(user);
				object.setOther(new Other(1));
			}else {
				object.setOther(new Other(0));
				object.setData("密码错误");
			}
		}else {			
			Other other=new Other(0);
			object.setOther(other);
			object.setData("账号不存在");
		}
		
		return object;
	}
	
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("queryUserList.do")
	public ModelAndView queryUserList(HttpServletRequest request,String username){
		String param=request.getParameter("username");
		ModelAndView view = null;
		List<User> list=null;
		try {
			view = new ModelAndView("user/userList");
			if (!StringUtils.isEmpty(username)) {
				list=userService.queryUserList(username);
				if (list.size()>0) {
					view.addObject("users", list);
				}else {
					throw new  Exception("没有数据");
				}
			}else {
				view.addObject("users",userService.query());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return view;
	}
	
	/**
	 * 删除
	 * 该功能做成ajax异步提交可能会更好
	 * @return
	 */
	@RequestMapping("delete.do")
	public ModelAndView deleteUser(HttpServletRequest request) {
		String id = request.getParameter("id");
		ModelAndView view =new ModelAndView();
		System.out.println(id);
		int result = userService.remove(id);
		if (result>0) {
			view.addObject("flag", "成功");
		}else {
			view.addObject("flag", "失败");
		}
		view.addObject("users",userService.query());
		view.setViewName("user/userList");
		return view;
	}
	
	@ResponseBody
	@RequestMapping(value="remove.do",method=RequestMethod.POST)
	public String deleteUser2(HttpServletRequest request) {
		try {
			String id = request.getParameter("id");
			int result = userService.remove(id);
			if (result>0) {
				return SUCCESS;
			}else {
				return ERROR;
			}
		} catch (Exception e) {
			try {
				throw new Exception(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return "-1";
	}
	
	/**
	 * 文件上传
	 * @author huangyq
	 * @date 2017-7-7  
	 * @version 1.0.0 
	 * @param file
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/upload.do",method = RequestMethod.POST)
	public ListObject photoUpload(MultipartFile file,HttpServletRequest request,HttpServletResponse response
			,HttpSession session) throws Exception{
		DownloadRecord record = new DownloadRecord();
		ListObject json=new ListObject();
		Other other = new Other();
		if (file!=null) {
			String path=null;
			String type=null;
			String fileName=file.getOriginalFilename();
			logger.debug("上传的文件原名称:"+fileName);
			
			type=fileName.indexOf(".")!=-1?fileName.substring(fileName.indexOf(".")+1,fileName.length()):null;
			if (type!=null) {
				if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())){
					
					String realPath=request.getSession().getServletContext().getRealPath("/");   //+"upload/"
					String myPath="fileUpload";
					
					String trueFileName=String.valueOf(System.currentTimeMillis())+fileName;
					
					//path=realPath+myPath+System.getProperty("file.separator")+trueFileName;
					path = FILE_PATH+System.getProperty("file.separator")+trueFileName;
					logger.debug("存放图片文件的路径:"+path); 
					
					file.transferTo(new File(path));
					
					//不管什么文件，都要存在数据库里面
					record.setFileName(fileName);
					record.setFilePath(path);
					record.setLength(file.getSize());
					record.setType(file.getContentType());
					record.setStartTime(new Timestamp(System.currentTimeMillis()));
					int result = fileRecordService.insert(record);
					
					if (result>0) {
						other.setCode(SUCCESS_STATUS_CODE);
						json.setData("上传成功");
						json.setOther(other);
						System.out.println("文件成功上传到指定目录下");
					}else {
						json.setOther(new Other(ERROR_STATUS_CODE));
						json.setData("上传失败");
					}
					
				}else {
					other.setCode(ERROR_STATUS_CODE);
					json.setData("上传文件失败");
					json.setOther(other);
					System.out.println("不是我们想要的文件类型,请按要求重新上传");
					return json;
				}
			}
		}else {
			other.setCode(ERROR_STATUS_CODE);
			json.setOther(other);
			json.setData("没有找到相对应的文件");
			System.out.println("没有找到相对应的文件");
			return json;
		}
		return json;
	}
	
	/**
	 * 文件下载
	 * @author huangyq
	 * @date 2017-7-9  
	 * @version 1.0.0 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/download.do")
	public String download(HttpServletRequest request,HttpServletResponse response,String fileName) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;fileName="+fileName);
		try {
			//String path = Thread.currentThread().getContextClassLoader().getResource("").getPath()+"download";
			String path = request.getSession().getServletContext().getRealPath("/download");
			
			InputStream inputStream = new FileInputStream(new File(path+File.separator+fileName));
			OutputStream os = response.getOutputStream();
			byte [] b=new byte[2048];
			int length;
			while ((length=inputStream.read(b))>0) {
				os.write(b,0,length);
			}
			os.close();
			inputStream.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 所有图片查看
	 * @author huangyq
	 * @date 2017-7-11  
	 * @version 1.0.0 
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/imgs.do",method=RequestMethod.GET)
	public ListObject imgQuery(HttpServletRequest request,HttpServletResponse response){
		ListObject object = new ListObject();
		Other other = new Other();
		List<DownloadRecord> list = fileRecordService.query();
		if (list!=null) {
			JSONArray jsonArray = JSONArray.fromObject(list);
			object.setData(jsonArray.toString());
			other.setCode(SUCCESS_STATUS_CODE);
			object.setOther(other);
		}else {
			other.setCode(ERROR_STATUS_CODE);
			object.setData("查询无数据");
		}
		return object;
	}
	
	/**
	 * 登出
	 * @author huangyq
	 * @date 2017-7-7  
	 * @version 1.0.0 
	 * @return
	 */
	public ModelAndView logout(){
		ModelAndView view=new ModelAndView();
		return view;
	}
}
