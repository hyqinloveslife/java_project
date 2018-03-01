/**
 * @author huangyq
 * @date 2017-9-15  
 * @version 1.0.0 
 */
package com.testSSM.test.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import com.testSSM.test.common.ListObject;
import com.testSSM.test.common.Other;
import com.testSSM.test.service.IVoteTreeService;

/**
 * Éú³É²Ëµ¥Ê÷
 * @author hyqin
 * @date 
 */
@Controller
@RequestMapping(value="/menu")
public class VoteTreeController extends BaseController {
	@Resource
	private IVoteTreeService voteTreeService;
	
	@RequestMapping(value="/tree.do",method=RequestMethod.GET)
	@ResponseBody
	public ListObject getVoteTree(HttpServletRequest request,HttpServletResponse response){
		ListObject listObject = new ListObject();
		JSONArray json = voteTreeService.getTreeJson();
		listObject.setData(json);
		listObject.setOther(new Other(SUCCESS_STATUS_CODE));
		return listObject;
	}
	
}	
