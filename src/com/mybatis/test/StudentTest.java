package com.mybatis.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
	@Test
	public void getStudentByIf(){
		Student student = new Student();
		student.setStuId(3);
		student.setStuName("诸葛亮");
		Student stu = studentDao.getStudentByIf(student);
		System.out.println(stu);
	}
	@Test
	public void listStudentByChoose(){
		Student student = new Student();
		//student.setStuName("关");
		student.setStuAge(20);
		List<Student> list = studentDao.listStudentByChoose(student);
		for (Iterator<Student> iter = list.iterator(); iter.hasNext();){
			System.out.println(iter.next());
		}
	}
	@Test
	public void listStudentByWhere(){
		Student student = new Student();
		student.setStuName("关");
		student.setStuAge(20);
		List<Student> list = studentDao.listStudentByWhere(student);
		for (Iterator<Student> iter = list.iterator(); iter.hasNext();){
			System.out.println(iter.next());
		}
	}
	@Test
	public void listStudentByTrim(){
		Student student = new Student();
		student.setStuName("关");
		student.setStuAge(20);
		List<Student> list = studentDao.listStudentByTrim(student);
		for (Iterator<Student> iter = list.iterator(); iter.hasNext();){
			System.out.println(iter.next());
		}
	}
	@Test
	public void updateStudent(){
		Student student = new Student();
		student.setStuId(2);
		Student stu1 = studentDao.getStudentByIf(student);
		System.out.println(stu1);
		student.setStuCity("益州");
		student.setStuAge(99);
		studentDao.updateStudent(student);
		Student stu2 = studentDao.getStudentByIf(student);
		System.out.println(stu2);
	}
	@Test
	public void listStudentByEach(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(5);
		list.add(7);
		List<Student> studentList = studentDao.listStudentByEach(list);
		for (Iterator<Student> iter = studentList.iterator(); iter.hasNext();){
			System.out.println(iter.next());
		}
	}
}
