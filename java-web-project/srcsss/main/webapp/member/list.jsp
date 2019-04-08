<%@page import="java.util.List"%>
<%@page import="com.eomcs.lms.domain.Member"%>
<%@ page language="java" 
  contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% List<Member> list =  (List<Member>)request.getAttribute("list");%>
<html>
<head>
<title>회원 목록</title>
<jsp:include page="/header.jsp"/>
</head>
<body>
	<h1>회원 목록(JSP)</h1>
	<p>
		<a href='add'>새 회원</a>
	</p>
	<table border='1'>
	<tr>
			<th>번호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>전화</th>
			<th>가입일</th>
		</tr>
		<tr>
		<%for (Member member : list) {%>
			<td><%=member.getNo()%></td>
			<td><a href='detail?no=<%=member.getNo()%>'><%=member.getName()%></a></td>
			<td><%=member.getEmail()%></td>
			<td><%=member.getTel() %></td>
			<td><%=member.getRegisteredDate()%></td>
		</tr>
		<%} %>
		</table>
</body>
</html>