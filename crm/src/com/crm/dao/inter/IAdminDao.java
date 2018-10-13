package com.crm.dao.inter;

import com.crm.entity.Admin;

public interface IAdminDao {
	public Admin findByNameAndPwd(String name,String pwd);
	public Admin findByName(String name);
	public Admin setAdmin(Admin admin);
}
