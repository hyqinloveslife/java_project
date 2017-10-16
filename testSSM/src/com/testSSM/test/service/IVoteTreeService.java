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
	 
}
