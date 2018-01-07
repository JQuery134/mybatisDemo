package com.baohuajie.batchInsert;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.baohuajie.resultMapAndResultType.bean.Person;


public class BatchInsert {
	
	private static Logger logger=Logger.getLogger(BatchInsert.class);
	public static void main(String[] args) {
		//º”‘ÿmybatis-config.xml≈‰÷√Œƒº˛
		String resource="com/baohuajie/batchInsert/mybatis-config.xml";
		InputStream resourceAsStream=null;
		SqlSessionFactory sqlSessionFactory=null;
		SqlSession session=null;
		try {
			resourceAsStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
			session = sqlSessionFactory.openSession();
			Person person=new Person();
			person.setNum("201802010");
			person.setName("Jquery20180206");
			Person person1=new Person();
			person1.setNum("20180211");
			person1.setName("Jquery20180209");
			List<Person> list=new ArrayList<Person>();
			list.add(person);
			list.add(person1);
			int insert = session.insert("batchInsertTest", list);
			System.out.println(insert);
			session.commit();
			logger.info(list.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		
	}

}
