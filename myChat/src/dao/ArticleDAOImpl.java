package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import jdbc.JDBCHelper;

public class ArticleDAOImpl implements ArticleDAO {

	@Override
	public List<Map<String, Object>> getPraises(String articleId) {
		StringBuilder sql = new StringBuilder();
		sql.append(" select a.name,a.id ");
		sql.append(" from users a,praise ");
		sql.append(" where a.id =  praise.user_id ");
		sql.append(" and praise.article_id = ?  ");
		List<Map<String, Object>> maps = null;
		try {
			maps = JDBCHelper.queryList(sql.toString(),new Object[] {articleId});
		} catch (SQLException e) {
			throw new RuntimeException("查询数据库失败");
		}
		return maps;
	}

	@Override
	public List<Map<String, Object>> queryArticles() {
		StringBuilder sql = new StringBuilder();
        sql.append(" SELECT  ");
        sql.append("     articles.id, ");
        sql.append("     articles.author, ");
        sql.append("     articles.content, ");
        sql.append("     articles.oppose, ");
        sql.append("     articles.praise, ");
        sql.append("     articles.title, ");
        sql.append("     date_format(articles.editTime,'%H:%i' ) editTime ");
        sql.append(" FROM ");
        sql.append("     articles, ");
        sql.append("     users a ");
        sql.append(" WHERE ");
        sql.append("     articles.users_id = a.id; ");

		List<Map<String, Object>> results = null;
		try {
			results = JDBCHelper.queryList(sql.toString());
		} catch (SQLException e1) {
			throw new RuntimeException("查询数据库失败");
		}
		return results;
	}

}
