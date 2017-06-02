package com.mybatis.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.dao.StudentDao;
import com.mybatis.pojo.Student;
import com.mybatis.util.Tool;

public class StudentTest {
	
	private SqlSession sqlSession;
	private StudentDao studentDao;
	private Tool tool;
	@Before
	public void before(){
		tool = new Tool();
		sqlSession = tool.getSession();
		studentDao = sqlSession.getMapper(StudentDao.class);
		PropertyConfigurator.configure("resources/log4j.properties");
	}
	@After
	public void after(){
		tool.closeSession();
	}
	
	@Test
	public void countStudent(){
		int count = studentDao.countStudent();
		System.out.println("学生总人数:"+count);
		
	}
	@Test
	public void listStudent(){
		List<Student> list = studentDao.listStudent();
		for (Student stu:list){
			System.out.println(stu);
		}
	}
	@Test
	public void saveStudent(){
		Student student = new Student();
		student.setStuName("朱紫薇");
		student.setStuCity("青岛");
		student.setStuAge(25);
		student.setGradeId(1704);
		studentDao.saveStudent(student);
		listStudent();
	}
	@Test
	public void listStudentByPage(){
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("请输入显示第几页数据:");
		int page = input.nextInt();
		System.out.print("请输入每页显示多少条数据:");
		int pageSize = input.nextInt();
		int pageNo = (page-1)*pageSize;
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("pageNo", pageNo);
		map.put("pageSize", pageSize);
		List<Student> list = studentDao.listStudentByPage(map);
		for (Student stu:list){
			System.out.println(stu);
		}
	}
	
	
	
}
