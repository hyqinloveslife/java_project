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
		 * @Fields url : 菜单链接地址
		 */
		private String url;
	 	/** 
	    * @Fields id : 编号 
	    */  
	    private Long id;  
	    /** 
	    * @Fields text : 文字 
	    */  
	    private String text;  
	    /** 
	    * @Fields pid :父目录的id 
	    */  
	    private Long pid;  
	    /** 
	    * @Fields levels : 所在级别 
	    */  
	    private Long levels;  
	    /** 
	    * @Fields children : 子节点集合 
	    */
	    private List children = new ArrayList();
	    /**
	     * @serialField icon : 图标
	     */
	    private String icon;
	    
	    
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
				Long levels, List children, String icon) {
			this.url = url;
			this.id = id;
			this.text = text;
			this.pid = pid;
			this.levels = levels;
			this.children = children;
			this.icon = icon;
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
		public String getIcon() {
			return icon;
		}
		public void setIcon(String icon) {
			this.icon = icon;
		} 
	    
}
