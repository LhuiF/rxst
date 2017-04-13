package com.unionx.core.util;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Jackson工具类
 * @author zyb
 *
 */
public class JacksonMapper {
	//构造方法私有化
	private JacksonMapper(){}
	
	private static final ObjectMapper mapper = new ObjectMapper();

	public static ObjectMapper getInstance() {
		return mapper;
	}
	
	 /**   
     * 获取泛型的Collection Type  
     * @param collectionClass 泛型的Collection   
     * @param elementClasses 元素类   
     * @return JavaType Java类型   
     *  
     */  
	public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {   
		//mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);   
		return mapper.getTypeFactory(). constructParametrizedType(collectionClass, collectionClass, elementClasses);
	}
	
}
