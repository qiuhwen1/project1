package com.woniuxy.entitys;

public class Area {
	
	private int aid;
	private int anum;
	private String aname;
	private int cid;
	
	public Area() {
		super();
	}

	public Area(int aid, int anum, String aname, int cid) {
		super();
		this.aid = aid;
		this.anum = anum;
		this.aname = aname;
		this.cid = cid;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getAnum() {
		return anum;
	}

	public void setAnum(int anum) {
		this.anum = anum;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Area [aid=" + aid + ", anum=" + anum + ", aname=" + aname + ", cid=" + cid + "]";
	}
	
	
}
