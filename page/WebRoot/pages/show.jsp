<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页</title>
</head>
<body>
<!-- method="get" action="/page/StudentServlet?pageNum=1&pageSize=10"
	当表单请求方式为get时，action后添加的参数是不会传递的
	理由：这是因为浏览器会将表单中的数据封装为字符串，然后将其直接附加在action的URL之后，URL和封装后的字符串之间会有一个‘?’分隔。
	如果在表单的action属性中已经包含了参数，浏览器会直接将其过滤掉，再附加form表单数据。
	所以请求方法为GET的表单，其action属性中不能携带参数，如果要实现参数的传递，有如下三种方式：
	1、使用POST方式进行传递，可以在action中添加参数； 
　　	2、如果要用GET方式，那么可以采用上述的方式，通过表单数据进行传递，例如：

	<input type="hidden" name="name" value="Jack"/>
	<input type="text" name="age" value="10"/>
　　	3、使用超链接（超链接默认的请求方式为GET）：
	
	<a href="XXX?name=Jack&age=10">提交</a>

 -->
<!-- 	<a href="/page/StudentServlet?pageNum=1&pageSize=20">查询</a> -->
	<c:if test="${not empty pageBean }">
		<table border="1" width="100%">
			<tr>
				<td align="center" width="25%">id</td>
				<td align="center" width="25%">age</td>
				<td align="center" width="25%">name</td>
				<td align="center" width="25%">gender</td>
			</tr>
		</table>
	</c:if>

	
	<c:forEach var="i" begin="1" end="${pageBean.pageSize}">
		<table border="1" width="100%">
			<tr>
				<td align="center" width="25%">${pageBean.list[i-1].id}</td>
				<td align="center" width="25%">${pageBean.list[i-1].age}</td>
				<td align="center" width="25%">${pageBean.list[i-1].name}</td>
				<td align="center" width="25%">${pageBean.list[i-1].gender}</td>
			</tr>
		</table>
	</c:forEach>
	<c:if test="${not empty pageBean }">
		<!-- 判断显示页面上的连接的起始值 -->
		<c:choose>
			<c:when test="${pageBean.totalPage<=10}">
				<c:set var="start" value="1"/>
				<c:set var="end" value="10"/>
			</c:when>
			<c:when test="${pageBean.pageNum<10}">
				<c:set var="start" value="1"/>
				<c:set var="end" value="10"/>
			</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${pageBean.pageNum>pageBean.totalPage-9&& pageBean.pageNum<=pageBean.totalPage}">
						<c:set var="start" value="${pageBean.totalPage-9}"/>
						<c:set var="end" value="${pageBean.totalPage}"/>
					</c:when>
				
					<c:otherwise>
						<c:set var="start" value="${pageBean.pageNum-4}"/>
						<c:set var="end" value="${pageBean.pageNum+5}"/>
					</c:otherwise>
				</c:choose>
				
			</c:otherwise>
		</c:choose>
		
		<!-- 显示界面的链接 -->
		<div align="right">
			<a href="/page/StudentServlet?pageNum=1&pageSize=20">首页</a>
			<!-- 添加上一页链接 -->
			<c:if test="${pageBean.pageNum!=1 }">
				<a href="/page/StudentServlet?pageNum=${pageBean.pageNum-1 }&pageSize=20">上一页</a>
			</c:if>
			<!-- 添加所有待加入的链接 -->
			<c:forEach var="j" begin="${start }" end="${end }">
				<a href="/page/StudentServlet?pageNum=${j }&pageSize=20">${j }</a>
			</c:forEach>
			
			<!-- 添加下一页链接 -->
			<c:if test="${pageBean.pageNum!=pageBean.totalPage }">
				<a href="/page/StudentServlet?pageNum=${pageBean.pageNum+1 }&pageSize=20">下一页</a>
			</c:if>
			<a href="/page/StudentServlet?pageNum=${pageBean.totalPage }&pageSize=20">尾页</a>
		<span>第${pageBean.pageNum }页/共${pageBean.totalPage}页</span>
		</div>
	</c:if>

	

	
	
</body>
</html>