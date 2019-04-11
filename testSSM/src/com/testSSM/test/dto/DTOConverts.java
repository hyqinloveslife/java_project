package com.testSSM.test.dto;

/**
 * 抽象接口定义
 * @author hyqin
 *
 * @param <S>
 * @param <T>
 */
public interface DTOConverts <S,T>{
	T converts(S s);
	
	S doBackward(T t);
}
