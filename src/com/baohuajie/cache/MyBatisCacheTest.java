package com.baohuajie.cache;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class MyBatisCacheTest {
	
	private static Logger logger=Logger.getLogger(MyBatisCacheTest.class);
	
	public static void main(String[] args) {
		String resource="com/baohuajie/cache/mybatis-config.xml";
		InputStream resourceAsStream;
		SqlSessionFactory sessionFactory;
		SqlSession session;
		SqlSession session1;
		SqlSession session2;
		try {
			//“ªº∂ª∫¥Ê≤‚ ‘
			resourceAsStream = Resources.getResourceAsStream(resource);
			sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
			/*session = sessionFactory.openSession();
			List<Object> selectList = session.selectList("cacheTest");
			logger.debug("++++++++++++++++++++++++++++++selectList1++++++++++++++++++++++++++++++");
			session.clearCache();
			List<Object> selectListAll = session.selectList("cacheTest");
			logger.debug("++++++++++++++++++++++++++++++cacheTest2++++++++++++++++++++++++++++++");*/
			
			//∂˛º∂ª∫¥Ê≤‚ ‘
			session1 = sessionFactory.openSession();
			session1.selectList("cacheTest");
			session1.commit();
			logger.debug("++++++++++++++++++++++++++++++selectList1++++++++++++++++++++++++++++++");
			session2 = sessionFactory.openSession();
			session2.selectList("cacheTest");
			logger.debug("++++++++++++++++++++++++++++++selectList1++++++++++++++++++++++++++++++");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
