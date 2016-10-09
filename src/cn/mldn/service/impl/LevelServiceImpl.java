package cn.mldn.service.impl;

import java.util.HashMap;
import java.util.Map;

import cn.mldn.dao.ILevelDAO;
import cn.mldn.dao.impl.LevelDAOImpl;
import cn.mldn.service.ILevelService;
import cn.mldn.util.factory.DAOFactory;
import cn.mldn.vo.Level;

public class LevelServiceImpl implements ILevelService {

	@Override
	public Map<String, Object> list(String column,String keyWord,int currentPage,int lineSize) throws Exception {
		ILevelDAO levelDAO = DAOFactory.getInstance(LevelDAOImpl.class) ;
		Map<String,Object> map = new HashMap<>() ;
		Level vo = new Level();
		vo.setTitle("你");
		levelDAO.doCreate(vo);
		if(column == null || "".equals(column) || "null".equals(column) ||keyWord == null || "".equals(keyWord)|| "null".equals(keyWord)){
			map.put("allLevel",levelDAO.findAllSplit(currentPage, lineSize)) ;
			map.put("allCount",levelDAO.getAllCount()) ;
		}else{
			map.put("allLevel",levelDAO.findAllSplit(column, keyWord, currentPage, lineSize)) ;
			map.put("allCount",levelDAO.getAllCount(column, keyWord)) ;
		}
		return map ;
	}
	
}
