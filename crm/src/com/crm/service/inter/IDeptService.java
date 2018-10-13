package com.crm.service.inter;

import java.util.List;

import com.crm.entity.Dept;

public interface IDeptService {
	public boolean add(Dept dept);
	public boolean delete(String[] ids);
	public List<Dept> searchDept(String name);
	public List<Dept> findAll();
	public Dept findById(String id);
	public boolean updateDept(Dept dept);
}
