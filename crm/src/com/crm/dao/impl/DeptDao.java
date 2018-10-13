package com.crm.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.crm.dao.inter.IDeptDao;
import com.crm.entity.Dept;

@Component("deptDao")
public class DeptDao implements IDeptDao{
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	//根据name查询
	public Dept findByName(String name)
	{
		try//没有异常返回Dept对象
		{
			String sql="select * from dept where d_name=?";
			Map<String, Object> map=jdbcTemplate.queryForMap(sql,name);
			Dept dept =new Dept((String)map.get("name"),(String)map.get("manager"),(String)map.get("work"),(String)map.get("remark"));
			return dept;
		}catch(Exception e)//出现异常时返回null
		{
			e.printStackTrace();
			return null;
		}
	}
	

	//添加Dept，返回添加的Dept
	public Dept setDept(Dept dept)
	{
		try
		{
			String sql="insert into dept(d_name,d_manager,d_work,d_remark) values(?,?,?,?)";
			jdbcTemplate.update(sql,
					dept.getName(),
					dept.getManager(),
					dept.getWork(),
					dept.getRemark()
					);
			return dept;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	//通过d_id字段删除Dept
	public boolean deleteDeptById(String sql)
	{
		try
		{
			jdbcTemplate.update(sql);
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	//查询所有Dept，返回List<Dept>
	public List<Dept> findAllDept()
	{
		try
		{
		String sql="select d_id,d_name,d_manager,d_work,d_remark from dept";
		//List<Dept> list=jdbcTemplate.query(sql, new BeanPropertyRowMapper<Dept>(Dept.class));
		List<Map<String, Object>> mapList=jdbcTemplate.queryForList(sql);
		List<Dept> list=new ArrayList<Dept>();
		for(Map<String, Object> map:mapList)
		{
			 Dept dept=new Dept((Integer)map.get("d_id"),
					 (String)map.get("d_name"),
					 (String)map.get("d_manager"),
					 (String)map.get("d_work"),
					 (String)map.get("d_remark"));
			 list.add(dept);
		}
		return list;
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	//模糊查询,可变参数个数查询，参数由service层产生
	public List<Dept> findDepts(String sql)
	{
		try
		{
			List<Map<String, Object>> mapList=jdbcTemplate.queryForList(sql);
			List<Dept> list=new ArrayList<Dept>();
			for(Map<String, Object> map:mapList)
			{
				 Dept dept=new Dept((Integer)map.get("d_id"),
						 (String)map.get("d_name"),
						 (String)map.get("d_manager"),
						 (String)map.get("d_work"),
						 (String)map.get("d_remark"));
				 list.add(dept);
			}
			return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	//通过d_id查询部门
	public Dept findById(String sql)
	{
		try
		{
		Map<String, Object> map=jdbcTemplate.queryForMap(sql);
		Dept dept=new Dept((Integer)map.get("d_id"),
				 (String)map.get("d_name"),
				 (String)map.get("d_manager"),
				 (String)map.get("d_work"),
				 (String)map.get("d_remark"));
		return dept;
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	//根据Id更新部门
	public boolean updateDept(String sql)
	{
		try {
			if(jdbcTemplate.update(sql)>=0)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (DataAccessException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	@Test
	public void test()
	{
		ApplicationContext ac=new ClassPathXmlApplicationContext("/spring.xml");
		IDeptDao deptDao = (DeptDao)ac.getBean("deptDao");
		Dept dept=deptDao.findById("select d_id,d_name,d_manager,d_work,d_remark from dept where d_id=1");
		/*for(Dept dept:list)
		{
			System.out.println(dept);
		}*/
		System.out.println(dept);
	}
}
