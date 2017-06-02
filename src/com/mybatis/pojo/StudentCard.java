package com.mybatis.pojo;

public class StudentCard {
	private Integer cid;
	private String cname;
	private Integer sid;
	private Student student;
	public StudentCard() {
		super();
	}
	public StudentCard(String cname, Integer sid) {
		super();
		this.cname = cname;
		this.sid = sid;
	}
	
	
	@Override
	public String toString() {
		return "StudentCard [cid=" + cid + ", cname=" + cname + ", sid=" + sid + ", student=" + student + "]";
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
}
