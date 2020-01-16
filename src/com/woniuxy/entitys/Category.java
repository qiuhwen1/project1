package com.woniuxy.entitys;

public class Category {
	private int cid;
	private int cnid;
	private String cname;
	private String cstatus;
	
	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(int cid, int cnid, String cname, String cstatus) {
		super();
		this.cid = cid;
		this.cnid = cnid;
		this.cname = cname;
		this.cstatus = cstatus;
	}

	
	
	public Category(int cid, int cnid, String cname) {
		super();
		this.cid = cid;
		this.cnid = cnid;
		this.cname = cname;
	}

	public Category(int cnid, String cname) {
		super();
		this.cnid = cnid;
		this.cname = cname;
	}

	public Category(int cnid, String cname, String cstatus) {
		super();
		this.cnid = cnid;
		this.cname = cname;
		this.cstatus = cstatus;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getCnid() {
		return cnid;
	}

	public void setCnid(int cnid) {
		this.cnid = cnid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCstatus() {
		return cstatus;
	}

	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}

	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cnid=" + cnid + ", cname=" + cname + ", cstatus=" + cstatus + "]";
	}
	
	

}
