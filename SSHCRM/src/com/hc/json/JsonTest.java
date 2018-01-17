package com.hc.json;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JsonTest {
	@Test
	public void test(){
		User user = new User();
		Role role = new Role();
		Role role2 = new Role();
		User user2 = new User();
		user2.setUname("闭月羞花");
		user2.setUage(20);
		user.setUname("逍遥释哥");
		user.setUage(18);
		role.setRname("似水骄阳");
		role2.setRname("沉鱼落雁");
		role.setUser(user);
		user.getRoles().add(role);
		user.getRoles().add(role2);
		String jsonString = JSON.toJSONString(user, SerializerFeature.DisableCircularReferenceDetect);
		
		System.out.println(jsonString);
	}
}
