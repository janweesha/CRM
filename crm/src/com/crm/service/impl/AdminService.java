package com.crm.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;

import com.crm.dao.inter.IAdminDao;
import com.crm.entity.Admin;
import com.crm.service.inter.IAdminService;

@Component("adminService")
public class AdminService implements IAdminService{
	@Resource(name="adminDao")
	private IAdminDao adminDao;
	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}
	public boolean login(Admin admin)
	{
		if(adminDao.findByNameAndPwd(admin.getName(),admin.getPwd())!=null)
		{
			return true;
		}
		else
		{
			return false;
		}	
	}
	
	public boolean register(Admin admin)
	{
		//数据库中是否有名字相同的记录
		if(adminDao.findByName(admin.getName())!=null)
		{
			return false;
		}
		else
		{
			adminDao.setAdmin(admin);
			return true;
		}	
	}
}
