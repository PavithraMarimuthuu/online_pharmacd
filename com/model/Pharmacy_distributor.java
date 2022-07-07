package com.model;

public class Pharmacy_distributor {
	private int D_id;
	private String D_name;
	private int ph_no;
	private int Item_no;
	public int getD_id() {
		return D_id;
	}
	public void setD_id(int d_id) {
		D_id = d_id;
	}
	public String getD_name() {
		return D_name;
	}
	public void setD_name(String d_name) {
		D_name = d_name;
	}
	public int getPh_no() {
		return ph_no;
	}
	public void setPh_no(int ph_no) {
		this.ph_no = ph_no;
	}
	public int getItem_no() {
		return Item_no;
	}
	public void setItem_no(int item_no) {
		Item_no = item_no;
	}
	public Pharmacy_distributor(int d_id, String d_name, int ph_no, int item_no) {
		super();
		D_id = d_id;
		D_name = d_name;
		this.ph_no = ph_no;
		Item_no = item_no;
	}
	

}
