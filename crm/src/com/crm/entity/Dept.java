package com.crm.entity;

public class Dept {
	private Integer id;
	private String name;
	private String manager;
	private String work;
	private String remark;
	
	
	public Dept()
	{
	}

	public Dept(String name, String manager, String work)
	{
		this.name = name;
		this.manager = manager;
		this.work = work;
	}
	
	
	public Dept(String name, String manager, String work, String remark) {
		super();
		this.name = name;
		this.manager = manager;
		this.work = work;
		this.remark = remark;
	}
	
	public Dept(Integer id, String name, String manager, String work,
			String remark) {
		super();
		this.id = id;
		this.name = name;
		this.manager = manager;
		this.work = work;
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
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}


	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + ", manager=" + manager
				+ ", work=" + work + ", remark=" + remark + "]";
	}
	
}
