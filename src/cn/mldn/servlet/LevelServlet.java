package cn.mldn.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.mldn.service.ILevelService;
import cn.mldn.service.impl.LevelServiceImpl;
import cn.mldn.split.SplitPageUtils;
import cn.mldn.util.factory.ServiceFactory;

@SuppressWarnings("serial")
@WebServlet("/LevelServlet")
public class LevelServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		SplitPageUtils sp = new SplitPageUtils(request) ;
		ILevelService levelService = ServiceFactory.getInstance(LevelServiceImpl.class) ;
		try {
			String url="LevelServlet";
			String columnData = "编号:lid|职位:title" ;
			System.out.println(sp.getColumn() + sp.getKeyWord()+sp.getCurrentPage()+sp.getLineSize());
			Map<String,Object> map = levelService.list(sp.getColumn(),sp.getKeyWord(),sp.getCurrentPage(),sp.getLineSize()) ;
			System.out.println(map);
			request.setAttribute("allLevel", map.get("allLevel"));
			request.setAttribute("allRecorders", map.get("allCount"));
			request.setAttribute("currentPage", sp.getCurrentPage()); 
			request.setAttribute("lineSize", sp.getLineSize()); 
			request.setAttribute("column", sp.getColumn()); 
			request.setAttribute("keyWord", sp.getKeyWord());  
			request.setAttribute("url", url);  
			request.setAttribute("columnData", columnData);  
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/split.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
