package com.mc.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InformationOfBook implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private String no;
	private String registrationNumber;
	private String title;
	private String author;
	private String publishingCompany;
	private String category;
	private String publishingDate;

	private String userName;
	private String backTime;

	/**
	 * 
	 */

	public InformationOfBook() {
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublishingCompany() {
		return publishingCompany;
	}

	public void setPublishingCompany(String publishingCompany) {
		this.publishingCompany = publishingCompany;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPublishingDate() {
		return publishingDate;
	}

	public void setPublishingDate(long publishingDate) {
		SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy HH:mm");  
		//前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型  
		java.util.Date dt = new Date(publishingDate);    
		String sDateTime = sdf.format(dt);  //得到精确到秒的表示：08/31/2006 21:08:00  
		System.out.println(sDateTime);
		this.publishingDate = sDateTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBackTime() {
		return backTime;
	}

	public void setBackTime(long backTime) {
		SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy HH:mm");  
		//前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型  
		java.util.Date dt = new Date(backTime);    
		String sDateTime = sdf.format(dt);  //得到精确到秒的表示：08/31/2006 21:08:00  
		System.out.println(sDateTime);
		this.backTime = sDateTime;
	}
	public void setBackTime(String backTime){
		this.backTime = backTime;
	}

}