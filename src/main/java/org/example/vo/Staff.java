package org.example.vo;

public class Staff extends Person {
	private int seq_sta;
	private String dept;	// 부서정보

	public Staff() {}

	public Staff(String name, String ssn, int age, String type, String dept) {
		super(name, ssn, age, type);
		this.dept = dept;
	}
		
	public int getSeq_sta() {
		return seq_sta;
	}

	public void setSeq_sta(int seq_sta) {
		this.seq_sta = seq_sta;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return super.toString() + ", dept: " + dept;
	}
	
}
