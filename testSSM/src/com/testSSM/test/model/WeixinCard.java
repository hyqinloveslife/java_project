package com.testSSM.test.model;
/**
 * ΢�ſ�ȯ 
 * @author hyqin
 *
 */
public class WeixinCard {
	private String logo_url;//��ȯ���̻�logo����������Ϊ300*300��
	private String brand_name;//���ͣ� "CODE_TYPE_TEXT"�� �� �� "CODE_TYPE_BARCODE"һά�� "CODE_TYPE_QRCODE"��ά�� "CODE_TYPE_ONLY_QRCODE",��ά����code��ʾ�� "CODE_TYPE_ONLY_BARCODE",һά����code��ʾ��CODE_TYPE_NONE�� ����ʾcode������������
	private String code_type;//�̻�����,��������Ϊ12�����֡�
	private String title;//��ȯ������������Ϊ9������
	private String color;//ȯ��ɫ����ɫ�ʹ淶��ע��дColor010-Color100��
	private String notice;//��ȯʹ������
	private String description;//��ȯʹ��˵��
	private String sku;//��Ʒ��Ϣ
	private String quantity;//��ȯ��������������Ϊ100000000��
	private String date_info;//ʹ�����ڣ���Ч�ڵ���Ϣ��
	private String type;//ʹ��ʱ�������
	private String begin_timestamp;//typeΪDATE_TYPE_FIX_TIME_RANGEʱר�ã���ʾ����ʱ��
	private String end_timestamp;//��ʾ����ʱ�� �� ��������Ϊ��ֹ���ڵ�23:59:59���� 
	private String fixed_term;//typeΪDATE_TYPE_FIX_TERMʱר�ã���ʾ����ȡ�����������Ч����֧����д0
	private String fixed_begin_term;//typeΪDATE_TYPE_FIX_TERMʱר�ã���ʾ����ȡ������쿪ʼ��Ч����ȡ������Ч��д0��
	public String getLogo_url() {
		return logo_url;
	}
	public void setLogo_url(String logo_url) {
		this.logo_url = logo_url;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public String getCode_type() {
		return code_type;
	}
	public void setCode_type(String code_type) {
		this.code_type = code_type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getDate_info() {
		return date_info;
	}
	public void setDate_info(String date_info) {
		this.date_info = date_info;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBegin_timestamp() {
		return begin_timestamp;
	}
	public void setBegin_timestamp(String begin_timestamp) {
		this.begin_timestamp = begin_timestamp;
	}
	public String getEnd_timestamp() {
		return end_timestamp;
	}
	public void setEnd_timestamp(String end_timestamp) {
		this.end_timestamp = end_timestamp;
	}
	public String getFixed_term() {
		return fixed_term;
	}
	public void setFixed_term(String fixed_term) {
		this.fixed_term = fixed_term;
	}
	public String getFixed_begin_term() {
		return fixed_begin_term;
	}
	public void setFixed_begin_term(String fixed_begin_term) {
		this.fixed_begin_term = fixed_begin_term;
	}
	@Override
	public String toString() {
		return "base_info [logo_url=" + logo_url + ", brand_name=" + brand_name + ", code_type=" + code_type
				+ ", title=" + title + ", color=" + color + ", notice=" + notice + ", description=" + description
				+ ", sku=" + sku + ", quantity=" + quantity + ", date_info=" + date_info + ", type=" + type
				+ ", begin_timestamp=" + begin_timestamp + ", end_timestamp=" + end_timestamp + ", fixed_term="
				+ fixed_term + ", fixed_begin_term=" + fixed_begin_term + "]";
	}

	
	
}
