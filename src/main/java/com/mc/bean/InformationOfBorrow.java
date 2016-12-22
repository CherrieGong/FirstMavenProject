package com.mc.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class InformationOfBorrow implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String registrationNumber;
	private String bookName;
	private String userName;
	private String time;
	private String backTime;
	private String tag;

	/**
	 * 
	 */
	public InformationOfBorrow() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getTime() {
		return time;
	}

	public void setTime(long time) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		// 前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
		java.util.Date dt = new Date(time);
		String sDateTime = sdf.format(dt); // 得到精确到秒的表示：08/31/2006 21:08:00
		System.out.println(sDateTime);
		this.time = sDateTime;
	}

	public String getBackTime() {
		return backTime;
	}

	public void setBackTime(long backTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		// 前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
		java.util.Date dt = new Date(backTime);
		String sDateTime = sdf.format(dt); // 得到精确到秒的表示：08/31/2006 21:08:00
		System.out.println(sDateTime);
		this.backTime = sDateTime;
	}
	public void setBackTime(String backTime){
		this.backTime = backTime;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}
