package com.crm.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crm.entity.Admin;
import com.crm.service.impl.AdminService;
import com.crm.service.inter.IAdminService;

public class AdminServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//通用对象
	private ApplicationContext ac;//spring容器
	private IAdminService adminService;
	private String name;
	private String pwd;
	private String checkNum;
	private Admin admin;
	private String text;
	
	//接收GET请求
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		this.doPost(request, response);
    }
	
	//接收POST请求
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		//设置请求数据的编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=gb2312");
		String method=request.getParameter("method");
		if(method.equals("login"))
		{
			this.login(request, response);//调用login()方法
		}
		else if(method.equals("register"))
		{
			this.register(request, response);
		}
		else if (method.equals("exit"))
		{
			this.exit(request, response);
		}
    }
	
	//login()方法处理用户登录
	private void login(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
		{
		//给通用对象赋值
		setObjects(request,response);
		//验证码相同
		if(text.equals(checkNum))
		{
			//账户名密码匹配
			if(adminService.login(admin))
			{
				// 将用户信息保存到session中
	            request.getSession().setAttribute("name", name);
	            // 使用cookie实现回写用户名
	            //Cookie cookie = new Cookie("name", name);
	            //cookie.setMaxAge(60 * 60);
	            // 通过响应头发送cookie
	            //response.addCookie(cookie);
	            // 重定向登录成功界面
	            response.sendRedirect(request.getContextPath() + "/main.jsp");
			}
			//账户名密码不匹配
			else
			{
				request.setAttribute("errorMsg", "账户名或密码错误！");
				request.setAttribute("name",name);
				//重新转发到登录页面
				request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
			}
		}
		//验证码不匹配
		else
		{
			request.setAttribute("imageMess", "验证码错误！");
			request.setAttribute("name",name);
			//重新转发到登录页面
			request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
		}
    }
	
	private void register(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
		{
			//给通用对象赋值
			setObjects(request, response);
			String checkPwd=request.getParameter("checkPwd");
			if(text.equals(checkNum))//验证码匹配
			{
				if(adminService.register(admin))//数据库无相同账号
				{
					if(pwd.equals(checkPwd))//两次密码相等
					{
						// 将用户信息保存到session中
						request.setAttribute("successMsg", "注册成功，请登录！");
			            request.setAttribute("name", name);
			            // 重定向至登录界面
			            //response.sendRedirect
			            request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
					}
					else//两次密码不匹配
					{
						request.setAttribute("errorMsg", "两次密码不一致！");
						request.setAttribute("name",name);
						//重新转发到注册页面
						request.getRequestDispatcher("/admin/register.jsp").forward(request, response);
					}
				}
				else//数据库中已存在账号
				{
					request.setAttribute("errorMsg", "用户名已存在，请直接登录！");
					request.setAttribute("name",name);
					//重新转发到登录页面
					request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
				}
			}
			else//验证码错误
			{
				request.setAttribute("imageMess", "验证码错误！");
				request.setAttribute("name",name);
				//重新转发到登录页面
				request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
			}
		}
	
	//给通用对象赋值的方法，避免重复代码
	private void setObjects(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		//加载bean容器
		ac=new ClassPathXmlApplicationContext("/spring.xml");
		//AdminService放在方法下多例调用
		adminService=(AdminService)ac.getBean("adminService");
				
		//从客户端表单获取用户名、密码、验证码数据
		name=request.getParameter("name");
		pwd=request.getParameter("pwd");
		checkNum=request.getParameter("checkNum");
				
		//将用户名、密码封装到admin对象
		admin=new Admin(name,pwd);
				
		//text接收服务器端验证码
		text=(String)request.getSession().getAttribute("text");
	}
	
	//注销方法
	private void exit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
			{
				//获取session
				HttpSession session=request.getSession();
				//销毁session
				session.invalidate();
				//重定向到login.jsp
				response.sendRedirect(request.getContextPath()+"/admin/login.jsp");
			}
}
