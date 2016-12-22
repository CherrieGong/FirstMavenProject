package com.mc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mc.entity.McBook;

public interface McBookService {
	McBook load(String id);

	McBook get(String id);

	List<McBook> findAll();

	void persist(McBook entity);

	String save(McBook entity);

	void saveOrUpdate(McBook entity);

	void delete(String id);

	void flush();
}
