/**
 * @author huangyq
 * @date 2018-4-26  
 * @version 1.0.0 
 */
package com.baidu.ai.api;

import java.util.HashMap;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 * @author hyqin
 *
 */
public class PhotoRenderUtils {
	//设置APPID/AK/SK
    public static final String APP_ID = "11159404";
    public static final String API_KEY = "7r6oHpaePiqi2ekU4bFohSBZ";
    public static final String SECRET_KEY = "PDKdF8gDlC11kMmsUzRjF1Ebm4gOCahM";
	
    private static final String PHOTO_TYPE_LOCAL = "1";
    private static final String PHOTO_TYPE_WEB = "2";
    private static final String PHOTO_TYPE_IOSTREAM = "3";
	
	public static String getFormulaByPhoto(String fileName,String photoType) {
		 // 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("language_type", "CHN_ENG");
	    options.put("detect_direction", "true");
	    options.put("detect_language", "true");
	    options.put("probability", "true");
		
		
		AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
		JSONObject res = null;
		if(PHOTO_TYPE_LOCAL.equals(photoType)){
			// 参数为本地图片路径
		    String image = fileName;
		    res = client.basicGeneral(image, options);
		    System.out.println(res.toString(2));
		}else if (PHOTO_TYPE_IOSTREAM.equals(photoType)) {
			 // 参数为本地图片二进制数组
			 //   byte[] file = readImageFile(image);
			 //   res = client.basicGeneral(file, options);
			 //   System.out.println(res.toString(2));
		}else if (PHOTO_TYPE_WEB.equals(photoType)) {
			  
		    // 通用文字识别, 图片参数为远程url图片
		   // JSONObject res = client.basicGeneralUrl(url, options);
		   // System.out.println(res.toString(2));
		}else {
			
		}
		
	    JSONArray object = res.getJSONArray("words_result");
	    StringBuffer buffer = new StringBuffer();
	    for (int i = 0; i < object.length(); i++) {
	    	JSONObject jsonObject = object.getJSONObject(i);
			String words = jsonObject.getString("words");
			buffer.append(words+"\r\n");
		}
		System.out.println(buffer.toString());
		
		return buffer.toString();
	}
}
