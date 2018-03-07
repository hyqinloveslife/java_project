/**
 * @author huangyq
 * @date 2017-9-15  
 * @version 1.0.0 
 */
package com.testSSM.test.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.testSSM.test.model.entity.VoteTree;
import com.testSSM.test.service.IVoteTreeService;

/**
 * 生成菜单树
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
	
	@RequestMapping(value="/query.do",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public Map<String, Object> queryMenu(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		List<VoteTree> trees = voteTreeService.queryTrees(1, 20);
		map.put("rows", trees);
		return map;
	}
	
	@RequestMapping(value="/addMenu.do",method = RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public ListObject addMenu(HttpServletRequest request,HttpServletResponse response,VoteTree tree){
		ListObject object = new ListObject();
		try {
			int result = voteTreeService.addMenu(tree);
			if(result==0){
				object.setOther(new Other(ERROR_STATUS_CODE, "没有写入数据库"));
				throw new Exception("没有写入数据库");
			}else {
				object.setOther(new Other(SUCCESS_STATUS_CODE, "添加成功"));
				setJSONReturn("添加成功");
			}
		} catch (Exception e) {
			try {
				object.setOther(new Other(ERROR_STATUS_CODE, e.getMessage()));
				setJSONReturn("添加失败:"+e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return object;
	}
}	
