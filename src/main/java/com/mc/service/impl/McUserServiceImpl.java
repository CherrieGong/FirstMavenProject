package com.mc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mc.dao.McRegisterDao;
import com.mc.dao.impl.McRegisterDaoImpl;
import com.mc.entity.McUser;
import com.mc.service.McRegisterService;

@Service
public class McUserServiceImpl implements McRegisterService {
	@Autowired
	private McRegisterDao mcRegisterDao;

	public McUser load(String id) {
		return mcRegisterDao.load(id);
	}

	public McUser get(String id) {
		return mcRegisterDao.get(id);
	};

	public List<McUser> findAll() {
		return mcRegisterDao.findAll();
	}

	public void persist(McUser entity) {
		mcRegisterDao.persist(entity);
	}

	public String save(McUser entity) {
		return (String) mcRegisterDao.save(entity);
	}

	public void saveOrUpdate(McUser entity) {
		mcRegisterDao.saveOrUpdate(entity);
	}

	public void delete(String id) {
		mcRegisterDao.delete(id);
	}

	public void flush() {
		mcRegisterDao.flush();
	}

}
