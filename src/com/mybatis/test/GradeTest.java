package com.mybatis.test;

import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.dao.GradeDao;
import com.mybatis.pojo.Grade;
import com.mybatis.util.Tool;

public class GradeTest {
	private SqlSession sqlSession;
	private Tool tool;
	private GradeDao gradeDao;
	@Before
	public void before(){
		tool = new Tool();
		sqlSession = tool.getSession();
		gradeDao = sqlSession.getMapper(GradeDao.class);
	}
	@After
	public void after(){
		tool.closeSession();
	}
	@Test
	public void listGrade(){
		List<Grade> list = gradeDao.listGrade();
		for (Iterator<Grade> iter = list.iterator(); iter.hasNext();){
			System.out.println(iter.next());
		}
	}
	@Test
	public void saveGrade(){
		Grade grade = new Grade(1705, "研一");
		gradeDao.saveGrade(grade);
		listGrade();
	}
	@Test
	public void listStudentByGradeId(){
		List<Grade> list = gradeDao.listStudentByGradeId(1702);
		for (Iterator<Grade> iter = list.iterator(); iter.hasNext();){
			System.out.println(iter.next());
		}
	}
}
