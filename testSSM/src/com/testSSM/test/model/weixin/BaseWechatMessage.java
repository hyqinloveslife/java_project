package com.testSSM.test.model.weixin;
/**
 * ΢����Ϣ����
 * @author hyqin
 *
 */
public class BaseWechatMessage {
	/**

	 * ������΢�ź�

	 */

	private String ToUserName;

	/**

	 * ���ͷ��ʺţ�һ��OpenID��

	 */

	private String FromUserName;

	/**

	 * ��Ϣ����ʱ�� �����ͣ�

	 */

	private long CreateTime;

	/**

	 * ��Ϣ����

	 */

	private String MsgType;

	/**

	 * ��Ϣid��64λ����

	 */

	private String MsgId;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public String getMsgId() {
		return MsgId;
	}

	public void setMsgId(String msgId) {
		MsgId = msgId;
	}
}
