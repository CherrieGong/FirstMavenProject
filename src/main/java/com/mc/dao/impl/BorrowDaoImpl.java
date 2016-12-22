package com.mc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mc.dao.BorrowDao;
import com.mc.entity.Borrow;

@Repository("borrowDao")
public class BorrowDaoImpl implements BorrowDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public Borrow load(String id) {
		// TODO Auto-generated method stub
		return (Borrow) this.getCurrentSession().load(Borrow.class, id);
	}

	public Borrow get(String id) {
		// TODO Auto-generated method stub
		return (Borrow) this.getCurrentSession().get(Borrow.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Borrow> findAll() {
		// TODO Auto-generated method stub
		List<Borrow> mcBooks = this.getCurrentSession()
				.createQuery("from McBook").setCacheable(true).list();
		return mcBooks;
	}

	public void persist(Borrow entity) {
		// TODO Auto-generated method stub
		this.getCurrentSession().persist(entity);
	}

	public String save(Borrow entity) {
		// TODO Auto-generated method stub
		return (String) this.getCurrentSession().save(entity);
	}

	public void saveOrUpdate(Borrow entity) {
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
