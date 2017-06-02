package com.mybatis.dao;

import java.util.List;

import com.mybatis.pojo.Grade;


public interface GradeDao {
	/**
	 * 新增grade
	 * @param grade
	 */
	void saveGrade(Grade grade);
	/**
	 * 查询grade列表
	 * @return
	 */
	List<Grade> listGrade();
	
	/**
	 * 查询gradeId下的学生
	 * @param gradeId
	 * @return
	 */
	List<Grade> listStudentByGradeId(int gradeId);
}
