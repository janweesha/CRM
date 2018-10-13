package com.crm.service.inter;

import com.crm.entity.Admin;

public interface IAdminService {
	public boolean login(Admin admin);
	public boolean register(Admin admin);
}
