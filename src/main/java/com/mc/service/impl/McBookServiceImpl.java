package com.mc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mc.dao.McBookDao;
import com.mc.dao.impl.McBookDaoImpl;
import com.mc.entity.McBook;
import com.mc.service.McBookService;

@Service
public class McBookServiceImpl implements McBookService {
	@Autowired
	private McBookDao mcBookDao;

	public McBook load(String id) {
		return mcBookDao.load(id);
	}

	public McBook get(String id) {
		return mcBookDao.get(id);
	};

	public List<McBook> findAll() {
		return mcBookDao.findAll();
	}

	public void persist(McBook entity) {
		mcBookDao.persist(entity);
	}

	public String save(McBook entity) {
		return (String) mcBookDao.save(entity);
	}

	public void saveOrUpdate(McBook entity) {
		mcBookDao.saveOrUpdate(entity);
	}

	public void delete(String id) {
		mcBookDao.delete(id);
	}

	public void flush() {
		mcBookDao.flush();
	}

}
