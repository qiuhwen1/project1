package com.woniuxy.entitys;

import java.util.Date;

public class Goods {
	private int gid;
	private int gnid;
	private String gname;
	private int cnid;
	private int pnid;
	private Date days;
	private double price;
	private int quality;
	private int model;
	private String info;
	private int inventory;	
	private String status;

	public Goods() {
		super();
	}

	public Goods(int gid, int gnid, String gname, int cnid, int pnid, Date days, double price, int quality, int model,
			String info, int inventory, String status) {
		super();
		this.gid = gid;
		this.gnid = gnid;
		this.gname = gname;
		this.cnid = cnid;
		this.pnid = pnid;
		this.days = days;
		this.price = price;
		this.quality = quality;
		this.model = model;
		this.info = info;
		this.inventory = inventory;
		this.status = status;
	}

	public Goods(int gnid, String gname, int pnid, double price, String info) {
		super();
		this.gnid = gnid;
		this.gname = gname;
		this.pnid = pnid;
		this.price = price;
		this.info = info;
	}

	public Goods(int gid, int gnid, String gname, int pnid, double price, String info) {
		super();
		this.gid = gid;
		this.gnid = gnid;
		this.gname = gname;
		this.pnid = pnid;
		this.price = price;
		this.info = info;
	}

	public Goods(int gnid, String gname, double price, String info) {
		super();
		this.gnid = gnid;
		this.gname = gname;
		this.price = price;
		this.info = info;
	}

	public Goods(int gid, int gnid, String gname, double price, String info) {
		super();
		this.gid = gid;
		this.gnid = gnid;
		this.gname = gname;
		this.price = price;
		this.info = info;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public int getGnid() {
		return gnid;
	}

	public void setGnid(int gnid) {
		this.gnid = gnid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public int getCnid() {
		return cnid;
	}

	public void setCnid(int cnid) {
		this.cnid = cnid;
	}

	public int getPnid() {
		return pnid;
	}

	public void setPnid(int pnid) {
		this.pnid = pnid;
	}

	public Date getDays() {
		return days;
	}

	public void setDays(Date days) {
		this.days = days;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public int getModel() {
		return model;
	}

	public void setModel(int model) {
		this.model = model;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", gnid=" + gnid + ", gname=" + gname + ", cnid=" + cnid + ", pnid=" + pnid
				+ ", days=" + days + ", price=" + price + ", quality=" + quality + ", model=" + model + ", info=" + info
				+ ", inventory=" + inventory + ", status=" + status + "]";
	}

	
	

}
