package com.ginwavelz.sms.bean.user;
/**
 * �Ա�
 * @author Administrator
 *
 */
public enum Gender {

	MAN{
			public String getName(){
				return "��";
	}
	},
	WOMEN{
			public String getName(){
				return "Ů";
			}
	};
	
	public  abstract  String getName();
	
}
