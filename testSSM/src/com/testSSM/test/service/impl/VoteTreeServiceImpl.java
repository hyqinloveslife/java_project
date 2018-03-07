/**
 * @author huangyq
 * @date 2017-9-15  
 * @version 1.0.0 
 */
package com.testSSM.test.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testSSM.test.dao.IVoteTreeDao;
import com.testSSM.test.model.entity.VoteTree;
import com.testSSM.test.service.IVoteTreeService;

/**
 * @author huangyeqin
 *
 */
@Transactional
@Service
public class VoteTreeServiceImpl implements IVoteTreeService {
	@Resource
	private IVoteTreeDao voteTreeDao;

	@Override
	public JSONArray getTreeJson() {
		Map<String, Object> treeMap = new HashMap<String, Object>();  
        Map<String, Object> treejsonMap = new HashMap<String, Object>();  
        treeMap.put("menuid",1);  
        treeMap.put("menuname", "���ܲ˵�");  
        treeMap.put("menus", treeList());  
        JSONArray jsonObject = JSONArray.fromObject(treeMap);  
		return jsonObject;
	}

	
	private List<VoteTree> treeList() {
		List<VoteTree> nextSubSet = new ArrayList<VoteTree>();  
        //��С��level  
        Long minLevel =voteTreeDao.minId();    
        //һ��Ŀ¼  
        List<VoteTree> friList = voteTreeDao.getFirstLevel(minLevel);  
        for (VoteTree voteTree : friList) {  
            //����һ��Ŀ¼�������е��Ӽ�  
        	voteTree.setChildren(nextSubSet);
        	
        	nextSubSet =this.getNextSubSet(voteTree);  
        }  
        return nextSubSet; 
	}
	
	/**
	 * �ݹ��ѯ
	 * @author huangyq
	 * @date 2017-9-19  
	 * @version 1.0.0 
	 * @param voteTree
	 * @return
	 */
	@Override
	public List<VoteTree> getDeeptLevel(VoteTree voteTree){
		List<VoteTree> list=voteTreeDao.getDeeptLevel(voteTree);
		if (list.size()>0) {
			for (int i = 0; i < list.size(); i++) {
				getDeeptLevel(list.get(i));
			}
		}
		return list;
	}


	/**
	 * 	����һ��id��ѯ���е��Ӽ�
	 */
	@Override
	public List<VoteTree> getNextSubSet(VoteTree voteTree) {
		List<VoteTree> trees = voteTreeDao.getNextSubSet(voteTree);
		//��������Ŀ¼����
		for (VoteTree tree : trees) {
			List<VoteTree> ls =getDeeptLevel(tree);
			tree.setChildren(ls);
		}
		
		return trees;
	}


	/* (non-Javadoc)
	 * @see com.testSSM.test.service.IVoteTreeService#queryTrees()
	 */
	@Override
	public List<VoteTree> queryTrees(int startPos,  int pageSize) {
		List<VoteTree> trees = voteTreeDao.queryTrees(startPos,pageSize);
		return trees;
	}


	/* (non-Javadoc)
	 * @see com.testSSM.test.service.IVoteTreeService#addMenu(com.testSSM.test.model.entity.VoteTree)
	 */
	@Override
	public int addMenu(VoteTree tree) {
		
		return voteTreeDao.addMenu(tree);
	}


	@Override
	public int removeMenu(String idStr) {
		
		return voteTreeDao.removeMenu(idStr);
	}


	@Override
	public int updateMenu(VoteTree tree) throws Exception {
		try {
			if(tree.getPid()==null||tree.getPid().equals("")){
				throw new Exception("pidΪ��");
			}
			if(tree.getLevels()==null||tree.getLevels().equals("")){
				throw new Exception("levelΪ��");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return voteTreeDao.updateMenu(tree);
	}


	@Override
	public List getParentId() {
		// TODO Auto-generated method stub
		return voteTreeDao.getParentId();
	}

}
