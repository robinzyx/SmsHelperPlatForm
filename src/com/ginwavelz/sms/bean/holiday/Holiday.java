package com.ginwavelz.sms.bean.holiday;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


/**
 * 节日实体
 * @author robin
 *
 */
@Entity(name="Holiday")
public class Holiday implements Serializable {
	private static final long serialVersionUID = -1022406732041019291L;
	
	/*编号*/
	private Integer h_id;
    /*名称*/
    private String h_name;
	/*图标*/
	private String icon;
	/*日期*/
	private String month;
	/*类型*/
	private String type;
	/*介绍*/
	private String itemOneTitle;
	private String itemOneCont;
	/*由来*/
	private String itemTwoTitle;
	private String itemTwoCont;
	/*习俗*/
	private String itemThreeTitle;
	private String itemThreeCont;
	/*资料*/
	private String itemFourTitle;
	private String itemFourCont;

	/*创建时间*/
	private Date create_time=new Date();
	/*修改时间*/
	private Date modify_time=new Date();
	/*是否更新*/
	private Boolean is_up=false;
	/*短信*/
	private List<Sms> smslist= new ArrayList<Sms>();
	/*彩信*/
	private List<Mms> mmslist=new ArrayList<Mms>();
	
	
	@Id
	@Column(length=4)@GeneratedValue
	public Integer getH_id() {
		return h_id;
	}
	public void setH_id(Integer h_id) {
		this.h_id = h_id;
	}
	
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	
	@Column(length=20)
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	@Temporal(TemporalType.DATE)@Column(nullable=false)
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	@Temporal(TemporalType.DATE)@Column(nullable=false)
	public Date getModify_time() {
		return modify_time;
	}
	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}
	@Column(length=2)
	public Boolean getIs_up() {
		return is_up;
	}
	
	public void setIs_up(Boolean is_up) {
		this.is_up = is_up;
	}
	
	@Column(length=20)
	public String getItemOneTitle() {
		return itemOneTitle;
	}
	public void setItemOneTitle(String itemOneTitle) {
		this.itemOneTitle = itemOneTitle;
	}
	
	@Column(length=3000)
	public String getItemOneCont() {
		return itemOneCont;
	}
	public void setItemOneCont(String itemOneCont) {
		this.itemOneCont = itemOneCont;
	}
	
	@Column(length=20)
	public String getItemTwoTitle() {
		return itemTwoTitle;
	}
	public void setItemTwoTitle(String itemTwoTitle) {
		this.itemTwoTitle = itemTwoTitle;
	}
	
	@Column(length=3000)
	public String getItemTwoCont() {
		return itemTwoCont;
	}
	public void setItemTwoCont(String itemTwoCont) {
		this.itemTwoCont = itemTwoCont;
	}
	
	@Column(length=20)
	public String getItemThreeTitle() {
		return itemThreeTitle;
	}
	public void setItemThreeTitle(String itemThreeTitle) {
		this.itemThreeTitle = itemThreeTitle;
	}
	
	@Column(length=3000)
	public String getItemThreeCont() {
		return itemThreeCont;
	}
	public void setItemThreeCont(String itemThreeCont) {
		this.itemThreeCont = itemThreeCont;
	}
	
	@Column(length=20)
	public String getItemFourTitle() {
		return itemFourTitle;
	}
	public void setItemFourTitle(String itemFourTitle) {
		this.itemFourTitle = itemFourTitle;
	}
	
	@Column(length=3000)
	public String getItemFourCont() {
		return itemFourCont;
	}
	
	public void setItemFourCont(String itemFourCont) {
		this.itemFourCont = itemFourCont;
	}
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="holiday",fetch=FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	public List<Sms> getSmslist() {
		return smslist;
	}
	
	public void setSmslist(List<Sms> smslist) {
		this.smslist = smslist;
	}
	 @OneToMany(cascade=CascadeType.ALL,mappedBy="holiday",fetch=FetchType.EAGER)
	 @Fetch(FetchMode.SUBSELECT)
	public List<Mms> getMmslist() {
		return mmslist;
	}
	public void setMmslist(List<Mms> mmslist) {
		this.mmslist = mmslist;
	}
	@Column(length=18)	
	public String getH_name() {
		return h_name;
	}
	public void setH_name(String h_name) {
		this.h_name = h_name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((h_id == null) ? 0 : h_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Holiday other = (Holiday) obj;
		if (h_id == null) {
			if (other.h_id != null)
				return false;
		} else if (!h_id.equals(other.h_id))
			return false;
		return true;
	}
	
	public Holiday() {
		super();
	}
	public Holiday(String h_name, String month, String type,
			Date create_time) {
		super();
		this.h_name = h_name;
		this.month = month;
		this.type = type;
		this.create_time = create_time;
	}
	

}
