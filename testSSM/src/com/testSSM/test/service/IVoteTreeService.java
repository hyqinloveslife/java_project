/**
 * @author huangyq
 * @date 2017-9-15  
 * @version 1.0.0 
 */
package com.testSSM.test.service;

import java.util.List;

import net.sf.json.JSONArray;

import com.testSSM.test.model.entity.VoteTree;

/**
 * @author Administrator
 *
 */
public interface IVoteTreeService {
	 public JSONArray getTreeJson();  
	 
	 List<VoteTree> getDeeptLevel(VoteTree voteTree);
	 
	 public List<VoteTree> getNextSubSet(VoteTree voteTree);
	 
	 public List<VoteTree> queryTrees(int startPos,  int pageSize );

	/**
	 * Ìí¼Ó²Ëµ¥
	 * @author huangyq
	 * @date 2018-3-7  
	 * @version 1.0.0 
	 * @param tree
	 * @return
	 */
	public int addMenu(VoteTree tree);

	/**
	 * É¾³ý²Ëµ¥
	 * @param idStr
	 * @return
	 */
	public int removeMenu(String idStr);

	public int updateMenu(VoteTree tree) throws Exception;

	public List getParentId();
}
