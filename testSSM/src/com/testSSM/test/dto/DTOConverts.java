package com.testSSM.test.dto;

/**
 * ����ӿڶ���
 * @author hyqin
 *
 * @param <S>
 * @param <T>
 */
public interface DTOConverts <S,T>{
	T converts(S s);
	
	S doBackward(T t);
}
