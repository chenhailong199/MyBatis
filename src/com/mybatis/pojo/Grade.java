package com.mybatis.pojo;

import java.util.Set;

public class Grade {
	private Integer id;
	private Integer gradeId;
	private String gradeName;
	private Set<Student> students;
	public Grade() {
		super();
	}
	public Grade(Integer gradeId, String gradeName) {
		super();
		this.gradeId = gradeId;
		this.gradeName = gradeName;
	}
	
	@Override
	public String toString() {
		return "Grade [id=" + id + ", gradeId=" + gradeId + ", gradeName=" + gradeName + ", students=" + students + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getGradeId() {
		return gradeId;
	}
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
}
