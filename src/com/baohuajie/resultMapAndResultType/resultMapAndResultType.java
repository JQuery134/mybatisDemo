package com.baohuajie.resultMapAndResultType;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.baohuajie.resultMapAndResultType.bean.Person;


public class resultMapAndResultType {
	private static Logger logger=Logger.getLogger(resultMapAndResultType.class);
	
	public static void main(String[] args) {
		//º”‘ÿmybatis-config.xml≈‰÷√Œƒº˛
		String resource="com/baohuajie/resultMapAndResultType/mybatis-config.xml";
		InputStream resourceAsStream=null;
		SqlSessionFactory sqlSessionFactory=null;
		SqlSession session=null;
		try {
			resourceAsStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
			session = sqlSessionFactory.openSession();
			//1°¢≤‚ ‘resultMap
			List<Map> selectListMap = session.selectList("resultTypeHashMap");
			System.out.println("Map:"+selectListMap.toString());
			List<Object> selectListInteger = session.selectList("resultTypeInteger");
			System.out.println("Integer:"+selectListInteger.toString());
			List<Person> selectListPerson = session.selectList("resultTypePerson");
			for(Person person:selectListPerson){
				System.out.println(person.toString());
			}
			System.out.println("---------------------------------------");
			List<Person> resultTypePersonMap = session.selectList("resultTypePersonMap");
			for(Person person:resultTypePersonMap){
				System.out.println(person.toString());
			}
			logger.debug(resultTypePersonMap.toString());
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		
	}

}
