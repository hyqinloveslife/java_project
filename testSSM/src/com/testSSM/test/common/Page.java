/**
 * @author huangyq
 * @date 2017-7-26  
 * @version 1.0.0 
 */
package com.testSSM.test.common;

import java.util.List;

import org.apache.commons.lang.StringUtils;

public class Page {
	private int pageSize = 10; // ÿҳ��ʾ��¼��
	private int totalPage; // ��ҳ��
	private int totalResult; // �ܼ�¼��
	private int currentPage; // ��ǰҳ
	private int currentResult; // ��ǰ��¼��ʼ����
	private boolean entityOrField; // true:��Ҫ��ҳ�ĵط�������Ĳ�������Pageʵ�壻false:��Ҫ��ҳ�ĵط�������Ĳ����������ʵ��ӵ��Page����
	private String pageStr; // ����ҳ����ʾ�ĵײ���ҳ��������ϸ����getPageStr();
	private List<?> result;// ��Ų�ѯ�Ľ����
	private String formName = ""; // ��ѯ������ҳ����е�λ��

	public Page() {
	}

	public Page(int pageSize) {
		this.pageSize = pageSize;
	}

	public Page(int pageSize, String formName) {
		this.pageSize = pageSize;
		this.formName = formName;
	}

	public Page(String formName) {
		this.formName = formName;
	}

	public int getTotalPage() {
		if (totalResult % pageSize == 0)
			totalPage = totalResult / pageSize;
		else
			totalPage = totalResult / pageSize + 1;
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalResult() {
		return totalResult;
	}

	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}

	public int getCurrentPage() {
		if (currentPage <= 0)
			currentPage = 1;
		if (currentPage > getTotalPage())
			currentPage = getTotalPage();
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getPageStr() {
		StringBuffer sb = new StringBuffer();
		if (totalResult > 0) {
			sb.append("<div class='pages_bar'>\n");
			if (currentPage == 1) {
				sb.append("	<a href='javascript:void(0);'>��ҳ</a>\n");
				sb.append("	<a href='javascript:void(0);'>��ҳ</a>\n");
			} else {
				sb.append("	<a onclick=\"nextPage(1);return false;\" href=\"javascript:void(0);\">��ҳ</a>\n");
				sb.append("	<a onclick=\"nextPage("
						+ (currentPage - 1)
						+ ");return false;\" href=\"javascript:void(0);\">��ҳ</a>\n");
			}
			int showTag = 5; // ��ҳ��ǩ��ʾ����
			int startTag = 1;
			if (currentPage > showTag) {
				startTag = currentPage - 1;
			}
			int endTag = startTag + showTag - 1;
			for (int i = startTag; i <= totalPage && i <= endTag; i++) {
				if (currentPage == i)
					sb.append("<a href='javascript:void(0);' class='current_page'>"
							+ i + "</a>\n");
				else
					sb.append("	<a onclick=\"nextPage(" + i
							+ ");return false;\" href=\"javascript:void(0);\">"
							+ i + "</a>\n");
			}
			if (currentPage == totalPage) {
				sb.append("	<a href='javascript:void(0);'>��ҳ</a>\n");
				sb.append("	<a href='javascript:void(0);'>βҳ</a>\n");
			} else {
				sb.append("	<a onclick=\"nextPage("
						+ (currentPage + 1)
						+ ");return false;\" href=\"javascript:void(0);\">��ҳ</a>\n");
				sb.append("	<a onclick=\"nextPage("
						+ totalPage
						+ ");return false;\" href=\"javascript:void(0);\">βҳ</a>\n");
			}
			sb.append("	<span style='border:0px;padding:0px;'>����<input id='txtPage' type='text' size='3'/>ҳ</span>\n");
			sb.append("	<label class='btn_gray_s' style='margin:0px;margin-bottom:4px;'><input type='button' value='GO' onclick='nextPage(0);return false;'/></label>\n");
			sb.append("	<span>��" + currentPage + "ҳ</span>\n");
			sb.append("	<span>��" + totalPage + "ҳ</span>\n");
			sb.append("	<span>ÿҳ" + pageSize + "����¼,��" + totalResult
					+ "��</span>\n");
			sb.append("</div>\n");

			sb.append("<script type=\"text/javascript\">\n");
			sb.append("function nextPage(page){\n");
			if (StringUtils.isNotBlank(formName)) {// ����form��
				// �������ҳ����ת��������֤
				sb.append("	if(page == 0){\n");
				sb.append("		page = jQuery.trim(document.getElementById('txtPage').value);\n");
				sb.append("		if (page > 0 && page <= " + totalPage
						+ " && page.indexOf('.') < 0) {\n");
				sb.append("		} else {\n");
				sb.append("			realAlert('��������ȷ��ҳ��');\n");
				sb.append("			return false;\n");
				sb.append("		}\n");
				sb.append("		if (page == " + currentPage
						+ " || page == '') {\n");
				sb.append("			realAlert('��������ȷ��ҳ��');\n");
				sb.append("			return false;\n");
				sb.append("		}\n");
				sb.append("	}\n");
				sb.append("	if(true && document.forms['").append(formName)
						.append("']){\n");
				sb.append("		var url = document.forms['").append(formName)
						.append("'].getAttribute(\"action\");\n");
				sb.append("		if(url.indexOf('?')>-1){url += \"&"
						+ (entityOrField ? "currentPage" : "page.currentPage")
						+ "=\";}\n");
				sb.append("		else{url += \"?"
						+ (entityOrField ? "currentPage" : "page.currentPage")
						+ "=\";}\n");
				sb.append("		document.forms['")
						.append(formName)
						.append("'].action = url+page+\"&pageChangeFlag=1\";\n");
				sb.append("		document.forms['").append(formName)
						.append("'].submit();\n");
				sb.append("	}else{\n");
				sb.append("		var url = document.location+'';\n");
				sb.append("		if(url.indexOf('?')>-1){\n");
				sb.append("			if(url.indexOf('currentPage')>-1){\n");
				sb.append("				var reg = /currentPage=\\d*/g;\n");
				sb.append("				url = url.replace(reg,'currentPage=');\n");
				sb.append("			}else{\n");
				sb.append("				url += \"&"
						+ (entityOrField ? "currentPage" : "page.currentPage")
						+ "=\";\n");
				sb.append("			}\n");
				sb.append("		}else{url += \"?"
						+ (entityOrField ? "currentPage" : "page.currentPage")
						+ "=\";}\n");
				sb.append("		document.location = url + page + \"&pageChangeFlag=1\";\n");
				sb.append("	}\n");
			} else {
				sb.append("		if(page == 0){\n");
				sb.append("			page = trim(document.getElementById('txtPage').value);\n");
				sb.append("			if (page > 0 && page <= " + totalPage
						+ " && page.indexOf('.') < 0) {\n");
				sb.append("			} else {\n");
				sb.append("				realAlert('��������ȷ��ҳ��');\n");
				sb.append("				return false;\n");
				sb.append("			}\n");
				sb.append("			if (page == " + currentPage
						+ " || page == '') {\n");
				sb.append("				realAlert('��������ȷ��ҳ��');\n");
				sb.append("				return false;\n");
				sb.append("			}\n");
				sb.append("		}\n");

				sb.append("		var url = document.location+'';\n");
				sb.append("		if(url.indexOf('?')>-1){\n");
				sb.append("			if(url.indexOf('currentPage')>-1){\n");
				sb.append("				var reg = /currentPage=\\d*/g;\n");
				sb.append("				url = url.replace(reg,'currentPage=');\n");
				sb.append("			}else{\n");
				sb.append("				url += \"&"
						+ (entityOrField ? "currentPage" : "page.currentPage")
						+ "=\";\n");
				sb.append("			}\n");
				sb.append("		}else{url += \"?"
						+ (entityOrField ? "currentPage" : "page.currentPage")
						+ "=\";}\n");
				sb.append("		document.location = url + page;\n");
			}
			sb.append("}\n");
			sb.append("</script>\n");
		}
		pageStr = sb.toString();
		return pageStr;
	}

	/**
	 * ��ȡ�򵥰�ķ�ҳ�������form����url�ύ�� ���� ��ҳ ��ҳ 5 ��ҳ βҳ ��15ҳ ÿҳ....
	 */
	public String getSimplePageStr(String nextPageMethod) {
		StringBuffer sb = new StringBuffer();
		if (totalResult > 0) {
			sb.append("<div class='simple_pages_bar'>\n");
			if (currentPage == 1) {
				sb.append("	<a href='javascript:void(0);'>��һҳ</a>\n");
			} else {
				sb.append("	<a onclick=\""
						+ nextPageMethod
						+ "("
						+ (currentPage - 1)
						+ ");return false;\" href=\"javascript:void(0);\">��һҳ</a>\n");
			}
			int startTag = currentPage;
			// int showTag = 5; //��ҳ��ǩ��ʾ����
			// int startTag = 1;
			// if(currentPage>showTag){
			// startTag = currentPage-1;
			// }
			// int endTag = startTag+showTag-1;
			sb.append("<span>��" + currentPage + "ҳ</span>\n");
			sb.append("<span>��" + totalPage + "ҳ</span>\n");
			if (currentPage == totalPage) {
				sb.append("	<a href='javascript:void(0);'>��һҳ</a>\n");
			} else {
				sb.append("	<a onclick=\""
						+ nextPageMethod
						+ "("
						+ (currentPage + 1)
						+ ");return false;\" href=\"javascript:void(0);\">��һҳ</a>\n");
			}
			sb.append("<input type=\"hidden\" id=\"page_total_page_size\" value=\""
					+ totalPage + "\">");
			sb.append("<input type=\"hidden\" id=\"page_current_page_size\" value=\""
					+ currentPage + "\">");
			// sb.append("	<span style='border:0px;padding:0px;'>����<input id='txtPage' type='text' size='3'/>ҳ</span>\n");
			// sb.append("	<label class='btn_gray_s' style='margin:0px;margin-bottom:4px;'><input type='button' value='GO' onclick='nextPage(0);return false;'/></label>\n");
			// sb.append("	<span>��"+currentPage+"ҳ</span>\n");
			sb.append("</div>\n");

		}
		pageStr = sb.toString();
		return pageStr;
	}

	/**
	 * ��ȡ�򵥰�ķ�ҳ�������form����url�ύ�� ���� ��ҳ ��ҳ 5 ��ҳ βҳ ��15ҳ ÿҳ.... type �ж��Ƿ���ʾ ��ҳ��ǩ
	 */
	public String getAjaxPageStr(String nextPageMethod, String type) {
		StringBuffer sb = new StringBuffer();
		if (totalResult > 0) {
			sb.append("<div class='pages_bar'>\n");
			if (currentPage == 1) {
				sb.append("	<a href='javascript:void(0);'>��ҳ</a>\n");
				sb.append("	<a href='javascript:void(0);'>��ҳ</a>\n");
			} else {
				if ("depotSearch".equals(type)) {
					sb.append("	<a onclick=\""
							+ nextPageMethod
							+ ",1);return false;\" href=\"javascript:void(0);\">��ҳ</a>\n");
					sb.append("	<a onclick=\""
							+ nextPageMethod
							+ ","
							+ (currentPage - 1)
							+ ");return false;\" href=\"javascript:void(0);\">��ҳ</a>\n");
				} else {
					sb.append("	<a onclick=\""
							+ nextPageMethod
							+ "(1);return false;\" href=\"javascript:void(0);\">��ҳ</a>\n");
					sb.append("	<a onclick=\""
							+ nextPageMethod
							+ "("
							+ (currentPage - 1)
							+ ");return false;\" href=\"javascript:void(0);\">��ҳ</a>\n");
				}
			}
			if ("have".equals(type)) {
				int showTag = 5; // ��ҳ��ǩ��ʾ����
				int startTag = 1;
				if (currentPage > showTag) {
					startTag = currentPage - 1;
				}
				int endTag = startTag + showTag - 1;
				for (int i = startTag; i <= totalPage && i <= endTag; i++) {
					if (currentPage == i)
						sb.append("<a href='javascript:void(0);' class='current_page'>"
								+ i + "</a>\n");
					else
						sb.append("	<a onclick=\""
								+ nextPageMethod
								+ "("
								+ i
								+ ");return false;\" href=\"javascript:void(0);\">"
								+ i + "</a>\n");
				}
			}
			if (currentPage == totalPage) {
				sb.append("	<a href='javascript:void(0);'>��ҳ</a>\n");
				sb.append("	<a href='javascript:void(0);'>βҳ</a>\n");
			} else {
				if ("depotSearch".equals(type)) {
					sb.append("	<a onclick=\""
							+ nextPageMethod
							+ ","
							+ (currentPage + 1)
							+ ");return false;\" href=\"javascript:void(0);\">��ҳ</a>\n");
					sb.append("	<a onclick=\""
							+ nextPageMethod
							+ ","
							+ totalPage
							+ ");return false;\" href=\"javascript:void(0);\">βҳ</a>\n");
					sb.append("	<span style='border:0px;padding:0px;'>����<input id='txtPagesearchDepotId' type='text' size='3'/>ҳ</span>\n");
					sb.append("	<label class='btn_gray_s' id = 'gotoNum' style='margin:0px;margin-bottom:4px;'><input type='button' value='GO' onclick='"
							+ nextPageMethod
							+ ",this.value);return false;'/></label>\n");
				} else {
					sb.append("	<a onclick=\""
							+ nextPageMethod
							+ "("
							+ (currentPage + 1)
							+ ");return false;\" href=\"javascript:void(0);\">��ҳ</a>\n");
					sb.append("	<a onclick=\""
							+ nextPageMethod
							+ "("
							+ totalPage
							+ ");return false;\" href=\"javascript:void(0);\">βҳ</a>\n");
					sb.append("	<span style='border:0px;padding:0px;'>����<input id='txtPage"
							+ nextPageMethod
							+ "' type='text' size='3'/>ҳ</span>\n");
					sb.append("	<label class='btn_gray_s' id = 'gotoNum' style='margin:0px;margin-bottom:4px;'><input type='button' value='GO' onclick='"
							+ nextPageMethod
							+ "(this.value);return false;'/></label>\n");
				}
			}
			sb.append("	<span>��" + currentPage + "ҳ</span>\n");
			sb.append("	<span>��" + totalPage + "ҳ</span>\n");
			if ("have".equals(type)) {
				sb.append("	<span>ÿҳ" + pageSize + "����¼,��" + totalResult
						+ "��</span>\n");
			}
			sb.append("</div>\n");

		}
		pageStr = sb.toString();
		return pageStr;
	}

	public void setPageStr(String pageStr) {
		this.pageStr = pageStr;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentResult() {
		currentResult = (getCurrentPage() - 1) * getPageSize();
		if (currentResult < 0)
			currentResult = 0;
		return currentResult;
	}

	public void setCurrentResult(int currentResult) {
		this.currentResult = currentResult;
	}

	public boolean isEntityOrField() {
		return entityOrField;
	}

	public void setEntityOrField(boolean entityOrField) {
		this.entityOrField = entityOrField;
	}

	public List<?> getResult() {
		return result;
	}

	public void setResult(List<?> result) {
		this.result = result;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

}
