/**
 * @author huangyq
 * @date 2018-4-26  
 * @version 1.0.0 
 */
package com.baidu.ai.api;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * @author hyqin
 *
 */
public class TestPhotoRender {
	//����APPID/AK/SK
    public static final String APP_ID = "11159404";
    public static final String API_KEY = "7r6oHpaePiqi2ekU4bFohSBZ";
    public static final String SECRET_KEY = "PDKdF8gDlC11kMmsUzRjF1Ebm4gOCahM";
	
	
	public static void main(String[] args) {
		 // �����ѡ�������ýӿ�
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("language_type", "CHN_ENG");
	    options.put("detect_direction", "true");
	    options.put("detect_language", "true");
	    options.put("probability", "true");
		
		
		AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
		
		 // ����Ϊ����ͼƬ·��
	    String image = "g://1212.png";
	    JSONObject res = client.basicGeneral(image, options);
	    System.out.println(res.toString(2));
		
	 // ����Ϊ����ͼƬ����������
	 //   byte[] file = readImageFile(image);
	 //   res = client.basicGeneral(file, options);
	 //   System.out.println(res.toString(2));
	    
	    
	    // ͨ������ʶ��, ͼƬ����ΪԶ��urlͼƬ
	   // JSONObject res = client.basicGeneralUrl(url, options);
	   // System.out.println(res.toString(2));
	    
	    
	    JSONArray object = res.getJSONArray("words_result");
	    StringBuffer buffer = new StringBuffer();
	    for (int i = 0; i < object.length(); i++) {
	    	JSONObject jsonObject = object.getJSONObject(i);
			String words = jsonObject.getString("words");
			buffer.append(words+"\r\n");
		}
		System.out.println(buffer.toString());
	}
}
