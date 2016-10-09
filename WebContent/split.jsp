<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="shuxing.cn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div>
	<jsp:include page="/split/split_page_search_plugin.jsp"/>
</div>
   <table border = "1">
     <tr>
       <td>ID</td>
       <td>最低工资</td>
       <td>最高工资</td>
       <td>职位</td>
       <td>标志</td>
     </tr>
     <c:forEach items="${allLevel}" var="level">
     <tr>
       <td>${level.lid}</td>
       <td>${level.losal}</td>
       <td>${level.hisal}</td>
       <td>${level.title}</td>
       <td>${level.flag}</td>
     </tr>
     </c:forEach>
   </table>
   <div>
<jsp:include page="/split/split_page_bar_plugin.jsp"/>
</div>
</body>
</html>