package com.mc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mc.dao.McBookDao;
import com.mc.entity.McBook;

@Repository("mcBookDao")
public class McBookDaoImpl implements McBookDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public McBook load(String id) {
		// TODO Auto-generated method stub
		return (McBook) this.getCurrentSession().load(McBook.class, id);
	}

	public McBook get(String id) {
		// TODO Auto-generated method stub
		return (McBook) this.getCurrentSession().get(McBook.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<McBook> findAll() {
		// TODO Auto-generated method stub
		List<McBook> mcBooks = this.getCurrentSession()
				.createQuery("from McBook").setCacheable(true).list();
		return mcBooks;
	}

	public void persist(McBook entity) {
		// TODO Auto-generated method stub
		this.getCurrentSession().persist(entity);
	}

	public String save(McBook entity) {
		// TODO Auto-generated method stub
		return (String) this.getCurrentSession().save(entity);
	}

	public void saveOrUpdate(McBook entity) {
		// TODO Auto-generated method stub
		this.getCurrentSession().saveOrUpdate(entity);
	}

	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	public void flush() {
		// TODO Auto-generated method stub

	}
}
