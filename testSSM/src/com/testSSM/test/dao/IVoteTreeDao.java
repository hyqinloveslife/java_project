/**
 * @author huangyq
 * @date 2017-9-15  
 * @version 1.0.0 
 */
package com.testSSM.test.dao;

import java.util.List;

import com.testSSM.test.model.entity.VoteTree;

/**
 * 菜单树
 * @author Administrator
 *
 */
public interface IVoteTreeDao {
	 //查询最小的level  
    Long minId();  
      
    //根据最小的查询所有一级菜单  
    List<VoteTree> getFirstLevel(Long minLevel);  
      
    //根据pid查询所有相对应的子集  
    List<VoteTree> getNextSubSet(VoteTree tvote);  
      
    //递归查询  
    List<VoteTree> getDeeptLevel(VoteTree tvote);

	/**
	 * 查询菜单列表
	 * @author huangyq
	 * @date 2018-3-7  
	 * @version 1.0.0 
	 * @param pageSize 
	 * @param startPos 
	 * @return
	 */
	List<VoteTree> queryTrees(int startPos, int pageSize);

	/**
	 * 新增菜单
	 * @author huangyq
	 * @date 2018-3-7  
	 * @version 1.0.0 
	 * @param tree
	 * @return
	 */
	int addMenu(VoteTree tree);

	int removeMenu(String idStr);

	int updateMenu(VoteTree tree);

	List getParentId();  
}
