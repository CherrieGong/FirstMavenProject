package com.mc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * McUser generated by hbm2java
 */
@Entity(name = "mc_user")
@Table(name = "mc_user", catalog = "mc")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class McUser implements java.io.Serializable {
	/**
	 * serialVersionUID作用： 序列化时为了保持版本的兼容性，即在版本升级时反序列化仍保持对象的唯一性。 有两种生成方式：
	 * 一个是默认的1L，比如：private static final long serialVersionUID = 1L;
	 * 一个是根据类名、接口名、成员方法及属性等来生成一个64位的哈希字段，比如： private static final long
	 * serialVersionUID = xxxxL;
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String userName;
	private String passWord;
	private Date registerTime;
	private String telephone;
	private String email;

	/**
	 * 
	 */
	public McUser() {

	}

	public McUser(String id, String userName, String passWord,
			Date registerTime, String telephone, String email) {
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.registerTime = registerTime;
		this.telephone = telephone;
		this.email = email;

	}

	/**
	 * unique=true是指这个字段的值在这张表里不能重复，所有记录值都要唯一，就像主键那样
	 * nullable=false是这个字段在保存时必需有值，不能还是null值就调用save去保存入库
	 * 
	 * @return
	 */

	@Id
	@Column(name = "id", unique = true, nullable = false, length = 36)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "username", unique = true)
	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password")
	public String getpassWord() {
		return passWord;
	}

	public void setpassWord(String passWord) {
		this.passWord = passWord;
	}

	@Column(name = "registertime")
	public Date getregisterTime() {
		return registerTime;
	}

	public void setregisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	@Column(name = "telephone")
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}