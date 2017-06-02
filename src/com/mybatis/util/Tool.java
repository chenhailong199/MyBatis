package com.mybatis.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Tool {
	private static SqlSessionFactory sqlSessionFactory;//用于生产sqlsesion的工厂
	private static SqlSession sqlSession;//用来执行和提交事物的
	static {
		try {
			System.out.println("开始执行获取sqlsession------------");
			//读取配置文件
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			//获取sqlsesionFactory工厂
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			//获取sqlsession
			sqlSession =sqlSessionFactory.openSession();	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public SqlSession getSession(){
		return sqlSession;
	}
	public void closeSession(){
		if (sqlSession != null){
			try {
				sqlSession.commit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				sqlSession.rollback();
			} finally {
				sqlSession.close();		
			}
		}		
	}
}
