package com.testSSM.test.controller;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.Blob;
import com.testSSM.test.common.ListObject;
import com.testSSM.test.common.Other;
import com.testSSM.test.model.DownloadRecord;
import com.testSSM.test.model.User;
import com.testSSM.test.pojo.UserPojo;
import com.testSSM.test.service.UserService;

/**
 * 用户的控制层
 * 
 * @author huangyeq
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	private static Logger logger = Logger.getLogger(UserController.class);
	private static final String SUCCESS = "1";
	private static final String ERROR = "0";
	@Resource
	private UserService userService;

	/**
	 * 用户注册
	 * 
	 * @param request
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("register.do")
	public ModelAndView register(HttpServletRequest request, UserPojo user) {
		ModelAndView view = new ModelAndView();
		if (user.getAccount() == null) {
			return view;
		}
		User userModel = new User();
		BeanUtils.copyProperties(user, userModel);
		int result = userService.save(userModel);
		if (result > 0) {
			view.addObject("flag", "注册成功");
		}
		view.setViewName("register");

		return view;
	}

	/**
	 * when the program log in , i wanan kept the session in jsp page, then,get
	 * the session in backend program.
	 * 
	 * @return
	 */
	@RequestMapping("userList.do")
	public ModelAndView userList(HttpSession session, HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		List<User> users = userService.query();
		view.addObject("users", users);
		// request.getSession().setAttribute("1", "1");
		session.setAttribute("1", "1");
		view.setViewName("user/userList");
		return view;
	}

	/**
	 * 登陆 返回modelandview
	 * 
	 * @return
	 */
	@RequestMapping("login.do")
	public ModelAndView login(HttpServletRequest request, @Validated UserPojo userPojo,BindingResult result) {
		ModelAndView view = new ModelAndView();
		
		//测试bindingResult的验证功能
		String accountString = userPojo.getAccount().trim();
		if (accountString==null|| accountString.equals("")) {
			result.addError(new ObjectError("account", "账号不能为空"));
		}
		
		// 
		userPojo.setAccount(userPojo.getAccount().trim());
		userPojo.setPassword(userPojo.getPassword().trim());
		User user = userService.queryAccount(userPojo.getAccount());
		if (user != null) {
			if (user.getPassword().equals(userPojo.getPassword())
					&& user.getAccount().equals(userPojo.getAccount())) {
				request.getSession().setAttribute("user", user.getName());
				view.setViewName("user/index");
				return view;
			}
		}
		
		result.addError(new ObjectError("account", "账号或密码错误"));
		view.addObject("flag", "登录失败");
		view.setViewName("redirect:login.jsp");
		

		return view;

	}

	/**
	 * 登陆 返回json
	 * 
	 * @author huangyq
	 * @date 2017-7-7
	 * @version 1.0.0
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/login2.do", method = RequestMethod.POST)
	public ListObject log_in(HttpServletRequest request, HttpSession session,
			String param) {
		ListObject object = new ListObject();
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		User user = userService.queryAccount(account);
		if (user != null) {
			if (user.getPassword().equals(password)
					&& user.getAccount().equals(account)) {
				object.setData(user);
				object.setOther(new Other(SUCCESS_STATUS_CODE));
			} else {
				object.setOther(new Other(ERROR_STATUS_CODE));
				object.setData("登陆失败");
			}
		} else {
			Other other = new Other(0);
			object.setOther(other);
			object.setData("登陆成功");
		}

		return object;
	}

	/**
	 * find the user by some conditions
	 * 
	 * @return
	 */
	@RequestMapping("queryUserList.do")
	public ModelAndView queryUserList(HttpServletRequest request,
			String username) {
		String param = request.getParameter("username");
		ModelAndView view = null;
		List<User> list = null;
		try {
			view = new ModelAndView("user/userList");
			if (!StringUtils.isEmpty(username)) {
				list = userService.queryUserList(username);
				if (list.size() > 0) {
					view.addObject("users", list);
				} else {
					throw new Exception("查询用户列表");
				}
			} else {
				view.addObject("users", userService.query());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return view;
	}

	/**
	 * 删除用户
	 * 
	 * @return
	 */
	@RequestMapping("delete.do")
	public ModelAndView deleteUser(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		ModelAndView view = new ModelAndView();
		System.out.println(id);
		try {
			int result = userService.remove(id);
			if (result > 0) {
				view.addObject("flag", "删除成功");
				response.getWriter().print("<script>alert('删除成功')</script>");
			} else {
				view.addObject("flag", "删除失败");
				response.getWriter().print("<script>alert('删除失败')</script>");
			}
		} catch (IOException e) {
			try {
				response.getWriter().print(
						"<script>alert('删除失败 : '+" + e.getMessage()
								+ ")</script>");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		view.addObject("users", userService.query());
		view.setViewName("user/userList");
		return view;
	}

	@ResponseBody
	@RequestMapping(value = "remove.do", method = RequestMethod.POST)
	public String deleteUser2(HttpServletRequest request) {
		try {
			String id = request.getParameter("id");
			int result = userService.remove(id);
			if (result > 0) {
				return SUCCESS;
			} else {
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
	 * 
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
	@RequestMapping(value = "/upload.do", method = RequestMethod.POST)
	public ListObject photoUpload(MultipartFile file,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws Exception {
		DownloadRecord record = new DownloadRecord();
		ListObject json = new ListObject();
		Other other = new Other();
		if (file != null) {
			String path = null;
			String type = null;
			String fileName = file.getOriginalFilename();
			logger.debug("解析出来的文件名:" + fileName);

			type = fileName.indexOf(".") != -1 ? fileName.substring(
					fileName.indexOf(".") + 1, fileName.length()) : null;
			if (type != null) {
				if ("GIF".equals(type.toUpperCase())
						|| "PNG".equals(type.toUpperCase())
						|| "JPG".equals(type.toUpperCase())) {

					String realPath = request.getSession().getServletContext()
							.getRealPath("/"); // +"upload/"
					String myPath = "upload";
					
					System.out.println("realPath : "+realPath+myPath);
					
					String trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;

					//path = FILE_PATH + System.getProperty("file.separator") + trueFileName;
					
					path = realPath+myPath+System.getProperty("file.separator")+trueFileName;
					logger.debug("解析出来的路径:" + path);

					file.transferTo(new File(path));

					record.setFileName(fileName);
					record.setFilePath(path);
					record.setLength(file.getSize());
					record.setType(file.getContentType());
					record.setStartTime(new Timestamp(System.currentTimeMillis()));
					int result = fileRecordService.insert(record);

					if (result > 0) {
						other.setCode(SUCCESS_STATUS_CODE);
						json.setData("上传成功");
						json.setOther(other);
					} else {
						json.setOther(new Other(ERROR_STATUS_CODE));
						json.setData("文件上传失败");
					}

				} else {
					other.setCode(ERROR_STATUS_CODE);
					json.setData("文件上传失败");
					json.setOther(other);
					return json;
				}
			}
		} else {
			other.setCode(ERROR_STATUS_CODE);
			json.setOther(other);
			json.setData("文件上传失败");
			return json;
		}
		return json;
	}
	
	/**
	 * 文件流上传
	 * @author huangyq
	 * @date 2018-4-8  
	 * @version 1.0.0 
	 * @param file
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/savefile.do" ,method=RequestMethod.POST)
	public ListObject saveFile(MultipartFile file,
			HttpServletRequest request, HttpServletResponse response){
		DownloadRecord paramRecord = new DownloadRecord();
		paramRecord.setId("14");
		FileInputStream fis = null;
		OutputStream os = null;
		try {
			fis = (FileInputStream) file.getInputStream();
			
			byte [] data = file.getBytes();
			Blob blob = null ;
			blob.getBinaryStream(0, data.length);
			paramRecord.setResource(blob);
			int result = fileRecordService.updateFile(paramRecord);
			if (result>0) {
				response.getWriter().print("<script>alert('上传成功')</scritp>");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}finally{
			if (fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (os!=null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}
	
	/**
	 * io流文件下载
	 * @author huangyq
	 * @date 2018-4-8  
	 * @version 1.0.0 
	 * @param request
	 * @param response
	 * 1.获取outputstream要用response.getOutputStream();
	 * 2.fileName要前面就设置好，不然下载的时候就报错，默认文件名为 download2.do
	 * 2.保存io流的数据 ，库里面要blob，bean里面用byte
	 */
	@RequestMapping(value="/download2.do",method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public String downloadFile(HttpServletRequest request,HttpServletResponse response){
		String fileName = "abc.jpg";
		DownloadRecord t = new DownloadRecord();
		t.setId("12");
		DownloadRecord record = fileRecordService.findById(t);
		byte [] arr = record.getQrcode();
		
		try {
			downloadFile("", "", arr, request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
			return "";
		}
		return null;
	}
	
	/**
	 * 文件下载的通用方法
	 * @author huangyq
	 * @date 2018-4-26  
	 * @version 1.0.0 
	 * @param fileName
	 * @param filePath
	 * @param resource
	 */
	@SuppressWarnings("unused")
	private void downloadFile(String fileName,String filePath, Object resource
			,HttpServletRequest request,HttpServletResponse response) throws Exception{
		if (StringUtils.isEmpty(fileName)) {
			throw new Exception("文件名不能为空");
			
		}
		//设置下载文件的格式
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
		
		OutputStream os = null;
		ByteArrayInputStream inputStream =null;
		
		byte [] arr = (byte[]) resource;
		
		try {
			inputStream = new ByteArrayInputStream(arr);
			os = response.getOutputStream();
			
			int len = 0;
			byte[] buf = new byte[1024];  
			while((len = inputStream.read(buf))!=-1){
				os.write(buf,0,len);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}finally{
			if (os!=null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (inputStream!=null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	/**
	 * 文件下载
	 * 
	 * @author huangyq
	 * @date 2017-7-9
	 * @version 1.0.0
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "/download.do",produces="application/json;charset=utf-8")
	public ListObject download(HttpServletRequest request,
			HttpServletResponse response, String fileName) throws IOException {
		ListObject object = new ListObject();
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;fileName="
				+ fileName);
		OutputStream os = null;
		InputStream inputStream =null;
		try {
			String realPath = request.getParameter("realPath");
			// String path =
			// Thread.currentThread().getContextClassLoader().getResource("").getPath()+"download";
			String path = request.getSession().getServletContext()
					.getRealPath("/download");

			//inputStream = new FileInputStream(new File(path+ File.separator + fileName));
			inputStream = new FileInputStream(new File(realPath));
			os = response.getOutputStream();
			byte[] b = new byte[2048];
			int length;
			while ((length = inputStream.read(b)) > 0) {
				os.write(b, 0, length);
			}
			object.setOther(new Other(SUCCESS_STATUS_CODE, "下载成功"));
			response.getWriter().print("<script>alert('下载成功')</scritp>");
		} catch (Exception e) {
			object.setOther(new Other(ERROR_STATUS_CODE, "下载失败"));
			response.getWriter().print("<script>alert('下载失败')</scritp>");
		}finally{
			if (os!=null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (inputStream!=null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return object;
	}

	/**
	 * 图片查看
	 * 
	 * @author huangyq
	 * @date 2017-7-11
	 * @version 1.0.0
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/imgs.do", method = RequestMethod.GET)
	public ListObject imgQuery(HttpServletRequest request,
			HttpServletResponse response) {
		ListObject object = new ListObject();
		Other other = new Other();
		List<DownloadRecord> list = fileRecordService.query();
		if (list != null) {
			JSONArray jsonArray = JSONArray.fromObject(list);
			object.setData(jsonArray.toString());
			other.setCode(SUCCESS_STATUS_CODE);
			object.setOther(other);
		} else {
			other.setCode(ERROR_STATUS_CODE);
			object.setData("查看图片失败");
		}
		return object;
	}

	/**
	 * 显示所有文件信息
	 * 
	 * @author huangyq
	 * @date 2017-7-18
	 * @version 1.0.0
	 * @return
	 */
	@RequestMapping(value = "fileList.do", method = RequestMethod.GET)
	public ModelAndView fileList() {
		ModelAndView view = new ModelAndView();
		view.setViewName("user/fileList");
		List<DownloadRecord> list = fileRecordService.query();
		view.addObject("files", list);
		return view;
	}

	@RequestMapping(value="files.do",method = RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public Map<String, Object> getFileList(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		List<DownloadRecord> list = fileRecordService.query();
		map.put("rows", list);
		return map; 
	}
	
	@RequestMapping(value="files2.do",method = RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String getFileLists(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		List<DownloadRecord> list = fileRecordService.query();
		JSONArray json = JSONArray.fromObject(list);
		return json.toString(); 
	}
	
	
	@RequestMapping(value="removeFile.do",method = RequestMethod.POST)
	@ResponseBody
	public ListObject removeFiles(HttpServletRequest request,HttpServletResponse response,String id){
		ListObject object = new ListObject();
		
		try {
			
			int result = fileRecordService.remove(id);
			
			if(result == 0){
				object.setOther(new Other(ERROR_STATUS_CODE, "没有写入数据库"));
			}else{
				object.setOther(new Other(SUCCESS_STATUS_CODE, "删除成功"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return object;
	}
	
	
	@RequestMapping(value="/previewPhoto.do")
	@ResponseBody
	public void previewPhoto(HttpServletRequest request,HttpServletResponse response,String filePath) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		response.setContentType("multipart/form-data");
		//String fullFileName = request.getSession().getServletContext().getRealPath(filePath);
		FileInputStream fis = new FileInputStream(filePath);
		OutputStream os = response.getOutputStream();
		
		try {
			int count = 0;
			byte [] buffer = new byte[1024*1024];
			while ((count=fis.read())!=-1) {
				os.write(buffer,0,count);
			}
			os.flush();
		} catch (Exception e) {
			e.getStackTrace();
		}finally {
			if (fis!=null) {
				fis.close();
			}
			if (os!=null) {
				os.close();
			}
		}
		
	}
	
	/**
	 * 初始化 “用户”列表 JSP页面,具有分页功能
	 * 
	 * @date 2017-7-29
	 * @version 1.0.0
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "showUsers.do", method = RequestMethod.GET)
	public String showMyUsers(HttpServletRequest request, Model model) {
		int loginUserId = 1;
		this.userService.showProductsByPage(request, model, loginUserId);

		return "user/userList";
	}

	/**
	 * 登出
	 * 
	 * @author huangyq
	 * @date 2017-7-7
	 * @version 1.0.0
	 * @return
	 */
	public ModelAndView logout() {
		ModelAndView view = new ModelAndView();
		return view;
	}
}
