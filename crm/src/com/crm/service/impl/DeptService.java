package com.crm.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.crm.dao.inter.IDeptDao;
import com.crm.entity.Dept;
import com.crm.service.inter.IDeptService;

@Component("deptService")
public class DeptService implements IDeptService{
	@Resource(name="deptDao")
	private IDeptDao deptDao;
	public void setDeptDao(IDeptDao deptDao) {
		this.deptDao = deptDao;
	}
	
	//增加部门
	public boolean add(Dept dept)
	{
		try {
			if(deptDao.findByName(dept.getName())!=null)
			{
				return false;
			}
			else
			{
				deptDao.setDept(dept);
				return true;
			}
		} catch (Exception e)
		{
			return false;
		}
	}
	
	//删除部门
	public boolean delete(String[] ids)
	{
		try
		{
			String sql;
			for(String id:ids)
			{
				sql="delete from dept where d_id="+id;
				deptDao.deleteDeptById(sql);
			}
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	//查询所有部门
	public List<Dept> findAll()
	{
		try
		{
			return deptDao.findAllDept();
		} catch (Exception e)
		{
			return null;
		}
	}
	
	//按名字搜索部门
	public List<Dept> searchDept(String name)
	{
		try
		{
			String sql="select d_id,d_name,d_manager,d_work,d_remark from dept where d_name like '%"+name+"%'";
			return deptDao.findDepts(sql);
		}
		catch(Exception e)
		{
			throw null;
		}
		
	}
	
	public Dept findById(String id)
	{
		try {
			String sql="select d_id,d_name,d_manager,d_work,d_remark from dept where d_id="+id;
			return deptDao.findById(sql);
		} catch (Exception e)
		{
			return null;
		}
	}
	
	public boolean updateDept(Dept dept)
	{
		try {
			String sql="update dept set d_name='"
					+dept.getName()+"',d_manager='"
					+dept.getManager()+"',d_work='"
					+dept.getWork()+"',d_remark='"
					+dept.getRemark()+"' where d_id="
					+dept.getId();
			return deptDao.updateDept(sql);
		} catch (Exception e)
		{
			return false;
		}
	}
}
