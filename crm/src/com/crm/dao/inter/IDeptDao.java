package com.crm.dao.inter;

import java.util.List;

import com.crm.entity.Dept;

public interface IDeptDao {
	public Dept findByName(String name);
	public List<Dept> findDepts(String sql);
	public List<Dept> findAllDept();
	public Dept setDept(Dept dept);
	public boolean deleteDeptById(String sql);
	public Dept findById(String sql);
	public boolean updateDept(String sql);
}
