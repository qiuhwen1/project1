package com.woniuxy.entitys;

public class Province {
	
	private int pid;
	private int pnum;
	private String pname;
	
	public Province() {
		super();
	}

	public Province(int pid, int pnum, String pname) {
		super();
		this.pid = pid;
		this.pnum = pnum;
		this.pname = pname;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	@Override
	public String toString() {
		return "Province [pid=" + pid + ", pnum=" + pnum + ", pname=" + pname + "]";
	}
		
}
