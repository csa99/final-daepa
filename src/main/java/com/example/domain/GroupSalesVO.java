package com.example.domain;

public class GroupSalesVO extends MeterialAndProductVO{
	public String sales_id;
	public String user_id;
	public int sales_price;
	public int sales_qtt; //�Ǹż���
	public String sales_end; //�ǸŸ�����
	public int sales_people; //���� �ʿ� �ο�
	public String sales_name; //���� �̸�
	public String sales_contents; //���� ����
	public String sales_image; //���� ��ǥ�̹���
	public int sales_drop; // ���� ����
	public int sales_whole_qtt; //1���� ���� ������ �ִ����
	
	public String getSales_id() {
		return sales_id;
	}
	public void setSales_id(String sales_id) {
		this.sales_id = sales_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getSales_price() {
		return sales_price;
	}
	public void setSales_price(int sales_price) {
		this.sales_price = sales_price;
	}
	public int getSales_qtt() {
		return sales_qtt;
	}
	public void setSales_qtt(int sales_qtt) {
		this.sales_qtt = sales_qtt;
	}
	public String getSales_end() {
		return sales_end;
	}
	public void setSales_end(String sales_end) {
		this.sales_end = sales_end;
	}
	public int getSales_people() {
		return sales_people;
	}
	public void setSales_people(int sales_people) {
		this.sales_people = sales_people;
	}
	public String getSales_name() {
		return sales_name;
	}
	public void setSales_name(String sales_name) {
		this.sales_name = sales_name;
	}
	public String getSales_contents() {
		return sales_contents;
	}
	public void setSales_contents(String sales_contents) {
		this.sales_contents = sales_contents;
	}
	public String getSales_image() {
		return sales_image;
	}
	public void setSales_image(String sales_image) {
		this.sales_image = sales_image;
	}
	public int getSales_drop() {
		return sales_drop;
	}
	public void setSales_drop(int sales_drop) {
		this.sales_drop = sales_drop;
	}
	public int getSales_whole_qtt() {
		return sales_whole_qtt;
	}
	public void setSales_whole_qtt(int sales_whole_qtt) {
		this.sales_whole_qtt = sales_whole_qtt;
	}
	@Override
	public String toString() {
		return "GroupSalesVO [sales_id=" + sales_id + ", user_id=" + user_id + ", sales_price=" + sales_price
				+ ", sales_qtt=" + sales_qtt + ", sales_end=" + sales_end + ", sales_people=" + sales_people
				+ ", sales_name=" + sales_name + ", sales_contents=" + sales_contents + ", sales_image=" + sales_image
				+ ", sales_drop=" + sales_drop + ", sales_whole_qtt=" + sales_whole_qtt + "]";
	}
}
