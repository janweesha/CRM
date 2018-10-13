package com.crm.entity;

import java.sql.Date;

public class Emp {
	private Integer id;//职员Id
	private String name;//职员姓名
	private String pwd;//密码
	private Integer deptId;//所属部门
	private Integer courseId;//参加的公司培训课程
	private Boolean gender;//性别
	private String tell;//电话号码
	private Date birth;//出生日期
	private Date empDate;//入职日期
	private Boolean status;//是否可分配任务
	private String work;//职称
	private Double salary;//月薪
	private String remark;//备注信息
	public Emp() {
		super();
	}
	public Emp(String name,String pwd, Integer deptId, Boolean status, String work,
			Double salary) {
		super();
		this.pwd=pwd;
		this.name = name;
		this.deptId = deptId;
		this.status = status;
		this.work = work;
		this.salary = salary;
	}
	public Emp(Integer id, String pwd,String name, Integer deptId, Boolean gender,
			String tell, Date birth, Date empDate, Boolean status, String work,
			Double salary, String remark) {
		super();
		this.pwd=pwd;
		this.id = id;
		this.name = name;
		this.deptId = deptId;
		this.gender = gender;
		this.tell = tell;
		this.birth = birth;
		this.empDate = empDate;
		this.status = status;
		this.work = work;
		this.salary = salary;
		this.remark = remark;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Boolean getGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	public String getTell() {
		return tell;
	}
	public void setTell(String tell) {
		this.tell = tell;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Date getEmpDate() {
		return empDate;
	}
	public void setEmpDate(Date empDate) {
		this.empDate = empDate;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	
	
}
