package com.mc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mc.entity.McUser;

public interface McRegisterService {
	McUser load(String id);

	McUser get(String id);

	List<McUser> findAll();

	void persist(McUser entity);

	String save(McUser entity);

	void saveOrUpdate(McUser entity);

	void delete(String id);

	void flush();
}
