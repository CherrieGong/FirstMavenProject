package com.mc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mc.entity.Borrow;

public interface BorrowService {
	Borrow load(String id);

	Borrow get(String id);

	List<Borrow> findAll();

	void persist(Borrow entity);

	String save(Borrow entity);

	void saveOrUpdate(Borrow entity);

	void delete(String id);

	void flush();
}
