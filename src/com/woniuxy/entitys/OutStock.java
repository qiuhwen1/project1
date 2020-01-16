package com.woniuxy.entitys;

import java.util.Date;

public class OutStock {
	private int osid;
	private int osnum;
	private int oscount;
	private int gid;
	private Date osdays;
	private String osstatus;
	private int uid;
	private String osinfo;
	
	public OutStock() {
		super();
	}

	public OutStock(int osid, int osnum, int oscount, int gid, Date osdays, String osstatus, int uid, String osinfo) {
		super();
		this.osid = osid;
		this.osnum = osnum;
		this.oscount = oscount;
		this.gid = gid;
		this.osdays = osdays;
		this.osstatus = osstatus;
		this.uid = uid;
		this.osinfo = osinfo;
	}	
	
	public OutStock(int osnum, int oscount, int gid, Date osdays, String osstatus, int uid, String osinfo) {
		super();
		this.osnum = osnum;
		this.oscount = oscount;
		this.gid = gid;
		this.osdays = osdays;
		this.osstatus = osstatus;
		this.uid = uid;
		this.osinfo = osinfo;
	}

//	public OutStock(int osnum, int oscount, int gid, int uid, String osinfo) {
//		super();
//		this.osnum = osnum;
//		this.oscount = oscount;
//		this.gid = gid;
//		this.uid = uid;
//		this.osinfo = osinfo;
//	}

	public OutStock(int osnum, int oscount, int gid, String osstatus, int uid, String osinfo) {
		super();
		this.osnum = osnum;
		this.oscount = oscount;
		this.gid = gid;
		this.osstatus = osstatus;
		this.uid = uid;
		this.osinfo = osinfo;
	}
	
	public OutStock(int osid, int oscount, int gid) {
		super();
		this.osid = osid;
		this.oscount = oscount;
		this.gid = gid;
	}
	
	public OutStock(int osid, int osnum, int oscount, int gid, String osinfo) {
		super();
		this.osid = osid;
		this.osnum = osnum;
		this.oscount = oscount;
		this.gid = gid;
		this.osinfo = osinfo;
	}

	public int getOsid() {
		return osid;
	}

	public void setOsid(int osid) {
		this.osid = osid;
	}

	public int getOsnum() {
		return osnum;
	}

	public void setOsnum(int osnum) {
		this.osnum = osnum;
	}

	public int getOscount() {
		return oscount;
	}

	public void setOscount(int oscount) {
		this.oscount = oscount;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public Date getOsdays() {
		return osdays;
	}

	public void setOsdays(Date osdays) {
		this.osdays = osdays;
	}

	public String getOsstatus() {
		return osstatus;
	}

	public void setOsstatus(String osstatus) {
		this.osstatus = osstatus;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getOsinfo() {
		return osinfo;
	}

	public void setOsinfo(String osinfo) {
		this.osinfo = osinfo;
	}

	@Override
	public String toString() {
		return "OutStock [osid=" + osid + ", osnum=" + osnum + ", oscount=" + oscount + ", gid=" + gid + ", osdays="
				+ osdays + ", osstatus=" + osstatus + ", uid=" + uid + ", osinfo=" + osinfo + "]";
	}
	
	

}
