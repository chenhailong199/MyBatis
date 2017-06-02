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
	
	/**
	 * 根据条件查询学生
	 * @return
	 */
	Student getStudentByIf(Student student);
	
	/**
	 * choose元素
	 * @param student
	 * @return
	 */
	List<Student> listStudentByChoose(Student student);
	
	/**
	 * where元素
	 * @param student
	 * @return
	 */
	List<Student> listStudentByWhere(Student student);
	
	/**
	 * trim元素
	 * @param student
	 * @return
	 */
	List<Student> listStudentByTrim(Student student);
	
	/**
	 * set元素
	 * @param student
	 */
	void updateStudent(Student student);
	
	/**
	 * foreach元素
	 * @param student
	 * @return
	 */
	List<Student> listStudentByEach(List<Integer> list);
}
