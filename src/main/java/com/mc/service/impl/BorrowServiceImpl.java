package com.mc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mc.dao.BorrowDao;
import com.mc.dao.impl.BorrowDaoImpl;
import com.mc.entity.Borrow;
import com.mc.service.BorrowService;

@Service
public class BorrowServiceImpl implements BorrowService {
	@Autowired
	private BorrowDao borrowDao;

	public Borrow load(String id) {
		return borrowDao.load(id);
	}

	public Borrow get(String id) {
		return borrowDao.get(id);
	};

	public List<Borrow> findAll() {
		return borrowDao.findAll();
	}

	public void persist(Borrow entity) {
		borrowDao.persist(entity);
	}

	public String save(Borrow entity) {
		return (String) borrowDao.save(entity);
	}

	public void saveOrUpdate(Borrow entity) {
		borrowDao.saveOrUpdate(entity);
	}

	public void delete(String id) {
		borrowDao.delete(id);
	}

	public void flush() {
		borrowDao.flush();
	}

}
