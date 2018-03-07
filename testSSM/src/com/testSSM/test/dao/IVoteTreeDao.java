/**
 * @author huangyq
 * @date 2017-9-15  
 * @version 1.0.0 
 */
package com.testSSM.test.dao;

import java.util.List;

import com.testSSM.test.model.entity.VoteTree;

/**
 * �˵���
 * @author Administrator
 *
 */
public interface IVoteTreeDao {
	 //��ѯ��С��level  
    Long minId();  
      
    //������С�Ĳ�ѯ����һ���˵�  
    List<VoteTree> getFirstLevel(Long minLevel);  
      
    //����pid��ѯ�������Ӧ���Ӽ�  
    List<VoteTree> getNextSubSet(VoteTree tvote);  
      
    //�ݹ��ѯ  
    List<VoteTree> getDeeptLevel(VoteTree tvote);

	/**
	 * ��ѯ�˵��б�
	 * @author huangyq
	 * @date 2018-3-7  
	 * @version 1.0.0 
	 * @param pageSize 
	 * @param startPos 
	 * @return
	 */
	List<VoteTree> queryTrees(int startPos, int pageSize);

	/**
	 * �����˵�
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
