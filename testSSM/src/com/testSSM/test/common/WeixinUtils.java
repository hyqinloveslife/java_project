package com.testSSM.test.common;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import com.testSSM.test.model.weixin.TextMessage;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ΢�ſ����Ĺ�����
 * @author hyqin
 *
 */
public class WeixinUtils {
	// ������Ϣ����,����ɨ����ά���¼�

    /**

     * �ı���Ϣ

     */

    public static final String MESSAGE_TEXT = "text";

    /**

     * ͼƬ��Ϣ

     */

    public static final String MESSAtGE_IMAGE = "image";

    /**

     * ͼ����Ϣ

     */

    public static final String MESSAGE_NEWS = "news";

    /**

     * ������Ϣ

     */

    public static final String MESSAGE_VOICE = "voice";

    /**

     * ��Ƶ��Ϣ

     */

    public static final String MESSAGE_VIDEO = "video";

    /**

     * С��Ƶ��Ϣ

     */

    public static final String MESSAGE_SHORTVIDEO = "shortvideo";

    /**

     * ����λ����Ϣ

     */

    public static final String MESSAGE_LOCATION = "location";

    /**

     * ������Ϣ

     */

    public static final String MESSAGE_LINK = "link";

    /**

     * �¼�������Ϣ

     */

    public static final String MESSAGE_EVENT = "event";

    /**

     * �¼�������Ϣ��,�¼����ͣ�subscribe(����)

     */

    public static final String MESSAGE_EVENT_SUBSCRIBE = "subscribe";

    /**

     * �¼�������Ϣ��,�¼����ͣ�unsubscribe(ȡ������)

     */

    public static final String MESSAGE_EVENT_UNSUBSCRIBE = "unsubscribe";

    /**

     * �¼�������Ϣ��,�ϱ�����λ���¼�

     */

    public static final String MESSAGE_EVENT_LOCATION_UP = "LOCATION";

    /**

     * �¼�������Ϣ��,�Զ���˵��¼�,����˵���ȡ��Ϣʱ���¼�����

     */

    public static final String MESSAGE_EVENT_CLICK = "CLICK";

    /**

     * �¼�������Ϣ��,�Զ���˵��¼�,����˵���ת����ʱ���¼�����

     */

    public static final String MESSAGE_EVENT_VIEW = "VIEW";
	/**
	 * ��xmlת��map
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> xmlToMap(HttpServletRequest request){
		Map<String, String> map = new HashMap<String, String>();
		SAXReader reader = new SAXReader();
		InputStream is = null;
		try {
			is = request.getInputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Document doc = null;
		try {
			doc = reader.read(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Element root = doc.getRootElement();
		List<Element> list = root.elements();
		for (Element e : list) {
			map.put(e.getName(), e.getText());
		}
		try {
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * �ı���Ϣת��xml
	 * @param message
	 * @return
	 */
	public static String textMessageToXml(TextMessage message){
		XStream stream = new XStream();
		stream.alias("xml", message.getClass());
		return stream.toXML(message);
	}
	
}
