package dao;

import java.util.List;
import java.util.Map;

public interface ArticleDAO {
	List<Map<String,Object>> queryArticles();
	
	List<Map<String,Object>> getPraises(String id);
}
