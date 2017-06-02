package com.mybatis.dao;

import java.util.List;

import com.mybatis.pojo.StudentCard;

public interface StudentCardDao {
	
	/**
	 * 查询学生证表
	 * @param cid
	 * @return
	 */
	List<StudentCard> listStudentCard();
}
