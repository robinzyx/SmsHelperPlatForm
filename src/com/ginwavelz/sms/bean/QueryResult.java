package com.ginwavelz.sms.bean;

import java.util.List;

public class QueryResult<T> {
	/*��¼��*/
	private List<T> resultlist;
	/*��¼����*/
	private long recordtotal;
	public List<T> getResultlist() {
		return resultlist;
	}
	public void setResultlist(List<T> resultlist) {
		this.resultlist = resultlist;
	}
	public long getRecordtotal() {
		return recordtotal;
	}
	public void setRecordtotal(long recordtotal) {
		this.recordtotal = recordtotal;
	}

}
