package org.example.vo;

public class Student extends Person {
	private int seq_stu;
	private String stdNo;	// 학번

	public Student() {}

	public Student(String name, String ssn, int age, String type, String stdNo) {
		super(name, ssn, age, type);
		this.stdNo = stdNo;
	}
	
	public int getSeq_stu() {
		return seq_stu;
	}

	public void setSeq_stu(int seq_stu) {
		this.seq_stu = seq_stu;
	}


	public String getStdNo() {
		return stdNo;
	}

	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", stdNo: " + stdNo;
	}
}







