package com.ginwavelz.sms.web.formbean.holiday;

import java.sql.Date;
import java.util.List;

import org.apache.struts.upload.FormFile;

import com.ginwavelz.sms.bean.holiday.Sms;
import com.ginwavelz.sms.web.formbean.BaseForm;

/**
 * ���ձ?
 * 
 * @author robin
 * 
 */
public class HolidayForm extends BaseForm {
	/*节日id*/
	private Integer h_id;
	/* 节日名称 */
	private String h_name;
	/* 日期 */
	private String month;
	/* 图标 */
	private FormFile icon;
	/* 类型 */
	private String type;
	/* 创建 */
	// private Date create_time;
	/* 介绍 */
	private String itemOneTitle;
	private String itemOneCont;
	/* 由来 */
	private String itemTwoTitle;
	private String itemTwoCont;
	/* 习俗 */
	private String itemThreeTitle;
	private String itemThreeCont;
	/* 诗歌资料 */
	private String itemFourTitle;
	private String itemFourCont;
	
	private List<Sms> smslist;
	
	


	public List<Sms> getSmslist() {
		return smslist;
	}

	public void setSmslist(List<Sms> smslist) {
		this.smslist = smslist;
	}

	public Integer getH_id() {
		return h_id;
	}

	public void setH_id(Integer h_id) {
		this.h_id = h_id;
	}

	public String getH_name() {
		return h_name;
	}

	public void setH_name(String h_name) {
		this.h_name = h_name;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public FormFile getIcon() {
		return icon;
	}

	public void setIcon(FormFile icon) {
		this.icon = icon;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getItemOneTitle() {
		return itemOneTitle;
	}

	public void setItemOneTitle(String itemOneTitle) {
		this.itemOneTitle = itemOneTitle;
	}

	public String getItemOneCont() {
		return itemOneCont;
	}

	public void setItemOneCont(String itemOneCont) {
		this.itemOneCont = itemOneCont;
	}

	public String getItemTwoTitle() {
		return itemTwoTitle;
	}

	public void setItemTwoTitle(String itemTwoTitle) {
		this.itemTwoTitle = itemTwoTitle;
	}

	public String getItemTwoCont() {
		return itemTwoCont;
	}

	public void setItemTwoCont(String itemTwoCont) {
		this.itemTwoCont = itemTwoCont;
	}

	public String getItemThreeTitle() {
		return itemThreeTitle;
	}

	public void setItemThreeTitle(String itemThreeTitle) {
		this.itemThreeTitle = itemThreeTitle;
	}

	public String getItemThreeCont() {
		return itemThreeCont;
	}

	public void setItemThreeCont(String itemThreeCont) {
		this.itemThreeCont = itemThreeCont;
	}

	public String getItemFourTitle() {
		return itemFourTitle;
	}

	public void setItemFourTitle(String itemFourTitle) {
		this.itemFourTitle = itemFourTitle;
	}

	public String getItemFourCont() {
		return itemFourCont;
	}

	public void setItemFourCont(String itemFourCont) {
		this.itemFourCont = itemFourCont;
	}


	

}
