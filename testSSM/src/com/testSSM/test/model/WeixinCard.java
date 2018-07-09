package com.testSSM.test.model;
/**
 * 微信卡券 
 * @author hyqin
 *
 */
public class WeixinCard {
	private String logo_url;//卡券的商户logo，建议像素为300*300。
	private String brand_name;//码型： "CODE_TYPE_TEXT"文 本 ； "CODE_TYPE_BARCODE"一维码 "CODE_TYPE_QRCODE"二维码 "CODE_TYPE_ONLY_QRCODE",二维码无code显示； "CODE_TYPE_ONLY_BARCODE",一维码无code显示；CODE_TYPE_NONE， 不显示code和条形码类型
	private String code_type;//商户名字,字数上限为12个汉字。
	private String title;//卡券名，字数上限为9个汉字
	private String color;//券颜色。按色彩规范标注填写Color010-Color100。
	private String notice;//卡券使用提醒
	private String description;//卡券使用说明
	private String sku;//商品信息
	private String quantity;//卡券库存的数量，上限为100000000。
	private String date_info;//使用日期，有效期的信息。
	private String type;//使用时间的类型
	private String begin_timestamp;//type为DATE_TYPE_FIX_TIME_RANGE时专用，表示起用时间
	private String end_timestamp;//表示结束时间 ， 建议设置为截止日期的23:59:59过期 
	private String fixed_term;//type为DATE_TYPE_FIX_TERM时专用，表示自领取后多少天内有效，不支持填写0
	private String fixed_begin_term;//type为DATE_TYPE_FIX_TERM时专用，表示自领取后多少天开始生效，领取后当天生效填写0。
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
