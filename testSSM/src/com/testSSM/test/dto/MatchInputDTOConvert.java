package com.testSSM.test.dto;

import org.springframework.beans.BeanUtils;

import com.testSSM.test.model.fifa.Match;
/**
 * 
 * @author hyqin
 *
 */
public class MatchInputDTOConvert implements DTOConverts<MatchInputDTO, Match>{

	@Override
	public Match converts(MatchInputDTO s) {
		Match match = new Match();
		BeanUtils.copyProperties(s, match);
		return match;
	}

	@Override
	public MatchInputDTO doBackward(Match t) {
		// TODO Auto-generated method stub
		return null;
	}

}
