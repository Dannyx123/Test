package cn.mldn.test;

import java.util.Map;

import cn.mldn.service.ILevelService;
import cn.mldn.service.impl.LevelServiceImpl;
import cn.mldn.util.factory.ServiceFactory;

public class TestDemo {
	public static void main(String[] args) {
		ILevelService levelService = ServiceFactory.getInstance(LevelServiceImpl.class) ;
		try {
			Map<String,Object> map = levelService.list("title","实习",1,3) ;
			System.out.println(map);
			 
			System.out.println("你");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
