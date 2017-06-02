package com.mybatis.test;

import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.dao.StudentCardDao;
import com.mybatis.pojo.StudentCard;
import com.mybatis.util.Tool;

public class StudentCardTest {
	private SqlSession sqlSession;
	private Tool tool;
	private StudentCardDao studentCardDao;
	@Before
	public void before(){
		tool = new Tool();
		sqlSession = tool.getSession();
		studentCardDao = sqlSession.getMapper(StudentCardDao.class);
	}
	@After
	public void after(){
		tool.closeSession();
	}
	@Test
	public void listStudentCard(){
		List<StudentCard> list = studentCardDao.listStudentCard();
		for (Iterator<StudentCard> iter = list.iterator(); iter.hasNext();) {
			System.out.println(iter.next());
		}
	}
}
