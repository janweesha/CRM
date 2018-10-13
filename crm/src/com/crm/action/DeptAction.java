package com.crm.action;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.crm.entity.Dept;
import com.crm.service.inter.IDeptService;

@Controller
@RequestMapping("/deptAction")
public class DeptAction {
	
	@SuppressWarnings("unused")
	@RequestMapping("/addDept")
	private String addDept(Dept dept,Model model) throws Exception
	{
		
		try {
			//实例化ClassPathXMLApplicationContext和deptService
			ApplicationContext ac=new ClassPathXmlApplicationContext("/spring.xml");
			IDeptService deptService=(IDeptService)ac.getBean("deptService");
			if(dept.getName()!=null)
			{
				if(dept.getManager()!=null)
				{
					if(dept.getWork()!=null)
					{
						if(deptService.add(dept))
						{
							model.addAttribute("successMsg", "添加部门成功！");
							//转发到showDept.action处理请求
							return "/deptAction/showDept.action";
						}else
						{
							model.addAttribute("falseAddMsg", "部门名称重复！");
							return "/dept/addDept.jsp";
						}
					}
					else
					{
						model.addAttribute("nullWorkMsg", "部门职能为必填项！");
						return "/dept/addDept.jsp";
					}
				}
				else
				{
					model.addAttribute("nullManagerMsg", "部门主管为必填项！");
					return "/dept/addDept.jsp";
				}
			}
			else
			{
				model.addAttribute("nullNameMsg", "部门名称为必填项！");
				return "/dept/addDept.jsp";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "/dept/addDept.jsp";
		}
	}
	
	//返回dept的List
	@SuppressWarnings("unused")
	@RequestMapping("/showDept")
	private String showDept(Model model) throws Exception
	{
		try {
			ApplicationContext ac=new ClassPathXmlApplicationContext("/spring.xml");
			IDeptService deptService=(IDeptService)ac.getBean("deptService");
			List<Dept> deptList=deptService.findAll();
			model.addAttribute("DEPTLIST", deptList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//转发到list
		return "/dept/list.jsp";
	}
	
	@SuppressWarnings("unused")
	@RequestMapping("/deleteDept")
	private String deleteDept(String[] ids,Model model) throws Exception//使用String[] ids接收需要删除的部门编号
	{
		try {
			ApplicationContext ac=new ClassPathXmlApplicationContext("/spring.xml");
			IDeptService deptService=(IDeptService)ac.getBean("deptService");
			System.out.println("deleteDept.action");
			if(deptService.delete(ids)==true)
			{
				model.addAttribute("successMsg", "删除部门成功");
				System.out.println("删除部门成功");
			}else
			{
				model.addAttribute("errorMsg", "删除部门失败");
				System.out.println("删除部门失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/deptAction/showDept.action";
	}
	
	@SuppressWarnings("unused")
	@RequestMapping("/findDept")
	private String findDept(Model model,String[] ids) throws Exception
	{
		try {
			ApplicationContext ac=new ClassPathXmlApplicationContext("/spring.xml");
			IDeptService deptService=(IDeptService)ac.getBean("deptService");
			if(ids!=null)
			{
				Dept dept=deptService.findById(ids[0]);
				model.addAttribute("DEPT", dept);
				return "/dept/editDept.jsp";
			}
			else
			{
				return "/deptAction/showDept.action";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "/deptAction/showDept.action";
		}
		
	}
	
	@SuppressWarnings("unused")
	@RequestMapping("/editDept")
	private String editDept(Model model,Dept dept) throws Exception
	{
		try {
			ApplicationContext ac=new ClassPathXmlApplicationContext("/spring.xml");
			IDeptService deptService=(IDeptService)ac.getBean("deptService");
			//更新数据
			if(deptService.updateDept(dept))
			{
				model.addAttribute("successMsg", "修改成功");
			}
			else
			{
				model.addAttribute("errorMsg","修改失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/deptAction/showDept.action";
		
	}
	
	@SuppressWarnings("unused")
	@RequestMapping("/searchDept")
	private String searchDept(Model model,String searchText) throws Exception
	{
		try
		{
		ApplicationContext ac=new ClassPathXmlApplicationContext("/spring.xml");
		IDeptService deptService=(IDeptService)ac.getBean("deptService");
		List<Dept> deptList =deptService.searchDept(searchText);
		System.out.println(deptList.isEmpty());
		if(!deptList.isEmpty())
		{
			model.addAttribute("DEPTLIST", deptList);
			model.addAttribute("searchText", searchText);
			return "/dept/list.jsp";
		}
		else
		{
			return "/deptAction/showDept.action";
		}
		}catch(Exception e)
		{
			e.printStackTrace();
			return "/deptAction/showDept.action";
		}
	}
	
	@Test
	public void test()
	{
		ApplicationContext ac=new ClassPathXmlApplicationContext("/spring.xml");
		IDeptService deptService=(IDeptService)ac.getBean("deptService");
		List<Dept> deptList =deptService.searchDept("管");
		for(Dept dept:deptList)
		{
			System.out.println(dept.toString());
		}
	}
}
