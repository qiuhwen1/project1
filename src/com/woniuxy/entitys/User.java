package com.woniuxy.entitys;

public class User {
	private int uid;
	private String uname;
	private String upsw;
	
	public User() {
		super();
	}

	public User(int uid, String uname, String upsw) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upsw = upsw;
	}

	public User(String uname, String upsw) {
		super();
		this.uname = uname;
		this.upsw = upsw;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpsw() {
		return upsw;
	}

	public void setUpsw(String upsw) {
		this.upsw = upsw;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upsw=" + upsw + "]";
	}
	
	

}
