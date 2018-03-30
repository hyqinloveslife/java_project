package com.testSSM.test.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import com.testSSM.test.model.User;
import com.testSSM.test.pojo.UserPojo;
import com.testSSM.test.service.TestService;

@Controller
@RequestMapping("/test")
public class TestController {
	private static Logger logger=Logger.getLogger(TestController.class);
	
	@Resource
	private TestService testService;


	@RequestMapping("test.do")
	public String test(HttpServletRequest request, Model model){
		User user = testService.queryTest();
		System.out.println(user);
		model.addAttribute("user", user);
		return "showUser";
	}
	
	@ResponseBody
	@RequestMapping("validate.do")
	public String validate(HttpServletRequest request){
		String account=request.getParameter("account");
		User user=testService.queryAccount(account);
		if (user==null) {
			return "0";
		}else {
			return "1";
		}
	}
	
	@ResponseBody
	@RequestMapping("register.do")
	public ModelAndView register(HttpServletRequest request,@Validated UserPojo user,BindingResult result){
		ModelAndView view=new ModelAndView();
		view.addObject("", "");
		view.setViewName("register");
		result.rejectValue("value", "error" );
		return view;
	}
	
}
