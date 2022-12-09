package org.example.vo;

public class Teacher extends Person {
	private int seq_tea;
	private String major;	// 전공과목

	public Teacher() {}

	public Teacher(String name, String ssn, int age, String type, String major) {
		super(name, ssn, age, type);
		this.major = major;
	}
		
	public int getSeq_tea() {
		return seq_tea;
	}

	public void setSeq_tea(int seq_tea) {
		this.seq_tea = seq_tea;
	}


	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return super.toString() + ", major: " + major;
	}
}
