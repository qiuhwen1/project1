package com.woniuxy.entitys;

public class City {
	private int cid;
	private int cnum;
	private String cname;
	private int pid;
	
	public City() {
		super();
	}

	public City(int cid, int cnum, String cname, int pid) {
		super();
		this.cid = cid;
		this.cnum = cnum;
		this.cname = cname;
		this.pid = pid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getCnum() {
		return cnum;
	}

	public void setCnum(int cnum) {
		this.cnum = cnum;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "City [cid=" + cid + ", cnum=" + cnum + ", cname=" + cname + ", pid=" + pid + "]";
	}
	
	

}
