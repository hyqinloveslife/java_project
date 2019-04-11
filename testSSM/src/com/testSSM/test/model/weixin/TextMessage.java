package com.testSSM.test.model.weixin;
/**
 * 文本消息
 * @author hyqin
 *
 */
public class TextMessage extends BaseWechatMessage{
	/**

	 * 文本消息内容

	 */

	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}
