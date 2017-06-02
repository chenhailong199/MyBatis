package com.mybatis.dao;

import java.util.List;
import java.util.Map;

import com.mybatis.pojo.Student;

public interface StudentDao {
	/**
	 * 统计总记录数
	 * @return
	 */
	int countStudent();
	
	/**
	 * 查询所有学生
	 * @return
	 */
	List<Student> listStudent();
	
	/**
	 * 新增学生
	 * @param student
	 */
	void saveStudent(Student student);
	
	/**
	 * 分页查询
	 * @param map
	 * @return
	 */
	List<Student> listStudentByPage(Map<String, Integer> map);
}
