package com.ezen.mybatis.prj;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MainClass {
	public static void main(String[] args) {
		
		try {
			String resource = "com/ezen/mybatis/prj/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			SqlSession session = sqlSessionFactory.openSession(true);
			System.out.println("session >> " + session);
			
			mapperInterface mapper = session.getMapper(mapperInterface.class);
			
			MemberVO mVo = mapper.selectOne(00002);
			System.out.println(mVo);
			
			/*
			 * mVo.setId(00004); mVo.setName("장비"); mVo.setPhone("111-2222-3333");
			 * mVo.setAddress("서울시 강서구"); int result = mapper.insertMember(mVo);
			 * System.out.println("결과 : " + result);
			 */
				
			int result = mapper.deleteMember(00004);
			System.out.println("결과 : " + result);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
