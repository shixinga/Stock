package com.model;

//SingleTon
public class Record {
	private String aMIN;
	private String aMAX;
	private String bMIN;
	private String bMAX;
	private String cMIN;
	private String cMAX;
	private String dMIN;
	private String dMAX;
	private String eMIN;
	private String eMAX;

	private static Record record = new Record();
	private Record() {
		this.aMIN = new String();
		this.aMAX = new String();
		this.bMIN = new String();
		this.bMAX = new String();
		this.cMIN = new String();
		this.cMAX = new String();
		this.dMIN = new String();
		this.dMAX = new String();
		this.eMIN = new String();
		this.eMAX = new String();
	}
	public static Record getRecode() {
		return Record.record;
	}

	public String getaMIN() {
		return aMIN;
	}

	public void setaMIN(String aMIN) {
		this.aMIN = aMIN;
	}

	public String getaMAX() {
		return aMAX;
	}

	public void setaMAX(String aMAX) {
		this.aMAX = aMAX;
	}

	public String getbMIN() {
		return bMIN;
	}

	public void setbMIN(String bMIN) {
		this.bMIN = bMIN;
	}

	public String getbMAX() {
		return bMAX;
	}

	public void setbMAX(String bMAX) {
		this.bMAX = bMAX;
	}

	public String getcMIN() {
		return cMIN;
	}

	public void setcMIN(String cMIN) {
		this.cMIN = cMIN;
	}

	public String getcMAX() {
		return cMAX;
	}

	public void setcMAX(String cMAX) {
		this.cMAX = cMAX;
	}

	public String getdMIN() {
		return dMIN;
	}

	public void setdMIN(String dMIN) {
		this.dMIN = dMIN;
	}

	public String getdMAX() {
		return dMAX;
	}

	public void setdMAX(String dMAX) {
		this.dMAX = dMAX;
	}

	public String geteMIN() {
		return eMIN;
	}

	public void seteMIN(String eMIN) {
		this.eMIN = eMIN;
	}

	public String geteMAX() {
		return eMAX;
	}

	public void seteMAX(String eMAX) {
		this.eMAX = eMAX;
	}
}