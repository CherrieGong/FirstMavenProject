package com.mc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mc.dao.McRegisterDao;
import com.mc.entity.McUser;

@Repository("mcRegisterDao")
public class McRegisterDaoImpl implements McRegisterDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public McUser load(String id) {
		// TODO Auto-generated method stub
		return (McUser) this.getCurrentSession().load(McUser.class, id);
	}

	public McUser get(String id) {
		// TODO Auto-generated method stub
		return (McUser) this.getCurrentSession().get(McUser.class, id);
	}

	@SuppressWarnings("unchecked")
	// 该批注的作用是给编译器一条指令，告诉它对被批注的代码元素内部的某些警告保持静默
	public List<McUser> findAll() {
		// TODO Auto-generated method stub
		List<McUser> mcRegisters = this.getCurrentSession()
				.createQuery("from McRegister").setCacheable(true).list();
		return mcRegisters;
	}

	public void persist(McUser entity) {
		// TODO Auto-generated method stub
		this.getCurrentSession().persist(entity);
	}

	// 返回插入数据的主键
	public String save(McUser entity) {
		// TODO Auto-generated method stub
		return (String) this.getCurrentSession().save(entity);
	}

	public void saveOrUpdate(McUser entity) {
		// TODO Auto-generated method stub
		this.getCurrentSession().saveOrUpdate(entity);
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
this.getCurrentSession().delete(id);
	}

	public void flush() {
		// TODO Auto-generated method stub

	}
}
