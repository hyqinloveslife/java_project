/**
 * @author huangyq
 * @date 2017-9-15  
 * @version 1.0.0 
 */
package com.testSSM.test.model.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 *
 */
public class VoteTree {
		/**
		 * @Fields url : �˵����ӵ�ַ
		 */
		private String url;
	 	/** 
	    * @Fields id : ��� 
	    */  
	    private Long id;  
	    /** 
	    * @Fields text : ���� 
	    */  
	    private String text;  
	    /** 
	    * @Fields pid :��Ŀ¼��id 
	    */  
	    private Long pid;  
	    /** 
	    * @Fields levels : ���ڼ��� 
	    */  
	    private Long levels;  
	    /** 
	    * @Fields children : �ӽڵ㼯�� 
	    */  
	    private List children = new ArrayList();
	    
	    private List li_attr = new ArrayList();
	    
		public VoteTree(Long id, String text) {
			super();
			this.id = id;
			this.text = text;
		}
		public VoteTree(Long id, String text, Long pid) {
			super();
			this.id = id;
			this.text = text;
			this.pid = pid;
		}
		public VoteTree() {
			
		}
		
		public VoteTree(String url, Long id, String text, Long pid,
				Long levels, List children, List li_attr) {
			super();
			this.url = url;
			this.id = id;
			this.text = text;
			this.pid = pid;
			this.levels = levels;
			this.children = children;
			this.li_attr = li_attr;
		}
		public VoteTree(Long id, String text, Long pid, Long levels,
				List children) {
			super();
			this.id = id;
			this.text = text;
			this.pid = pid;
			this.levels = levels;
			this.children = children;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		public Long getPid() {
			return pid;
		}
		public void setPid(Long pid) {
			this.pid = pid;
		}
		public Long getLevels() {
			return levels;
		}
		public void setLevels(Long levels) {
			this.levels = levels;
		}
		public List getChildren() {
			return children;
		}
		public void setChildren(List children) {
			this.children = children;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public List getLi_attr() {
			return li_attr;
		}
		public void setLi_attr(List li_attr) {
			this.li_attr = li_attr;
			li_attr.add(this.url);
		} 
	    
}
