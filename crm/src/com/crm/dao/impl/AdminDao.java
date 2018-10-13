package com.crm.dao.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.crm.dao.inter.IAdminDao;
import com.crm.entity.Admin;

@Component("adminDao")
public class AdminDao implements IAdminDao{
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public Admin findByNameAndPwd(String name,String pwd)
	{
		try
		{
			String sql="select a_id,a_name,a_pwd from admin where a_name=? and a_pwd=?";
			Map<String, Object> map=jdbcTemplate.queryForMap(sql,name,pwd);
			Admin admin =new Admin((String)map.get("a_name"),(String)map.get("pwd"));
			return admin;
		}catch(EmptyResultDataAccessException e)
		{
			return null;
		}
		
	}

	public Admin setAdmin(Admin admin) {
		try
		{
			String sql="insert into admin(a_name,a_pwd) values(?,?)";
			jdbcTemplate.update(sql,admin.getName(),admin.getPwd());
			return admin;
		}
		catch (Exception e)
		{
			return null;
		}
		
	}

	//只查找数据库中是否有a_name字段相同的行
	public Admin findByName(String name)
	{
		try
		{
			String sql="select a_id,a_name,a_pwd from admin where a_name=?";
			Map<String, Object> map=jdbcTemplate.queryForMap(sql,name);
			Admin admin =new Admin((String)map.get("name"),(String)map.get("pwd"));
			return admin;
		}catch(EmptyResultDataAccessException e)
		{
			return null;
		}
	}
}
