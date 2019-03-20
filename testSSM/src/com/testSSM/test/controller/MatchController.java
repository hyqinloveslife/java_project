package com.testSSM.test.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.MapUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.testSSM.test.common.ListObject;
import com.testSSM.test.common.Other;
import com.testSSM.test.dto.MatchInputDTO;
import com.testSSM.test.dto.MatchInputDTOConvert;
import com.testSSM.test.model.fifa.Match;
import com.testSSM.test.service.MatchService;
import com.testSSM.test.utils.PropertiesUtils;
import com.weixin.api.AccessTokenTool;

import net.sf.json.JSONArray;

/**
 * ������controller
 * @author hyqin
 *
 */
@Controller
@RequestMapping("/match")
public class MatchController extends BaseController{
	private static Logger logger = Logger.getLogger(MatchController.class);
	
	@Resource
	private MatchService matchService;
	
	/**
	 * ����������Ϣ
	 * @return
	 */
	
	@ResponseBody
	@RequestMapping(value="/save.do",method=RequestMethod.POST)
	public ListObject saveMatchInfo(HttpServletRequest request,HttpServletResponse response){
		Map<?,?> paramMap = getParameterMap(request);
		ListObject object = new ListObject();
		logger.info("�Ѿ�����save����"+paramMap);
		String ss = (String) paramMap.get("SupplierID");
		String str1 = MapUtils.getString(paramMap, "SupplierID");
		logger.info("��map�н����������ַ���   :   "+str1+"  ----"+ss);
		
		int result = matchService.addMatch(paramMap);
		if(result==0){
			object.setOther(new Other(ERROR_STATUS_CODE, "error"));
		}else{
			object.setOther(new Other(SUCCESS_STATUS_CODE, "success"));
		}
			
		return object;
	}
	
	/**
	 * ��ȡ������Ϣ
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value="/team.do")
	public List findTeam(HttpServletRequest request,HttpServletResponse response){
		List footballTeams = matchService.getFootBallTeam();
		
		return footballTeams;
	}

	/**
	 * ���������Ϣ
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/saveTeam.do",method=RequestMethod.POST)
	public ListObject saveTeamInfo(HttpServletRequest request,HttpServletResponse response){
		Map<?,?> paramMap = getParameterMap(request);
		ListObject object = new ListObject();
		logger.info("�Ѿ�����save����"+paramMap);
		String ss = (String) paramMap.get("homefield");
		String str1 = MapUtils.getString(paramMap, "ageLimit");
		
		try {
			int result = matchService.addFootballTeam(paramMap);
			if(result>0){
				object.setOther(new Other(SUCCESS_STATUS_CODE, "�ɹ�"));
			}else{
				object.setOther(new Other(SUCCESS_STATUS_CODE, "��Ϣδ����"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			object.setData("");
			object.setOther(new Other(ERROR_STATUS_CODE, "����ʧ��:"+e.getMessage()));
			e.printStackTrace();
		}
		
		return object;
	}
	
	/**
	 * ����������Ϣ
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value="/getTeamInfo.do",method=RequestMethod.POST)
	public JSONArray getTeamInfo(HttpServletRequest request,HttpServletResponse response){
		ListObject object = new ListObject();
		logger.info("--------------->�Ѿ�����getTeamInfo����");
		JSONArray json = null;
		try {
			List teams = matchService.getFootballTeam();
			if(teams.size() >0){
				json = JSONArray.fromObject(teams);
				logger.info("json==========================>"+json);
				object.setData(json);
				object.setOther(new Other(SUCCESS_STATUS_CODE, "�ɹ�"));
			}else{
				object.setOther(new Other(SUCCESS_STATUS_CODE, "��Ϣδ����"));
			}
		} catch (Exception e) {
			object.setOther(new Other(ERROR_STATUS_CODE, "����ʧ��:"+e.getMessage()));
			e.printStackTrace();
		}
		
		return json;
	}
	
	/**
	 * ��ȡ������Ϣ
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value="/nation.do")
	public List getNation(HttpServletRequest request,HttpServletResponse response){
		List nations = matchService.getNation();
		logger.info(nations);
		return nations;
	}
	
	/**
	 * ��ȡ������Ϣ
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value="/education.do")
	public List getEducation(HttpServletRequest request,HttpServletResponse response){
		List educations = matchService.getEducation();
		logger.info(educations);
		return educations;
	}
	
	/**
	 * �򵥵Ĳ���һ��ת����
	 * @param matchInputDTO
	 * @return
	 */
	public Match addMatch(MatchInputDTO matchInputDTO){
		
		Match match = new MatchInputDTOConvert().converts(matchInputDTO);
		
		Match m2 = matchInputDTO.convertToMatch();//����Ч��һ������
		
		return match;
	}
	
	
	
}
