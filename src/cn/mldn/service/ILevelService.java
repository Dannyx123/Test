package cn.mldn.service;

import java.util.Map;

public interface ILevelService {
	public Map<String,Object> list(String column,String keyWord,int currentPage,int lineSize) throws Exception ;
}
