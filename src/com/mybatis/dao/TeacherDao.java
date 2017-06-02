package com.mybatis.dao;

import java.util.List;

import com.mybatis.pojo.Teacher;

public interface TeacherDao {
	/**
	 * 新增老师
	 */
	void saveTeacher();
	
	/**
	 * 查询老师列表
	 * @return
	 */
	List<Teacher> listTeacher();
}
