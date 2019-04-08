<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>입력 받은 값</h1>
<ul>
<%
request.setCharacterEncoding("UTF-8");
//파라미터 이름 목록
Enumeration<String> names = request.getParameterNames();
while(names.hasMoreElements()){
  String name = names.nextElement();%>
  <li>  <%=name%>=
        <%
     String[] values = request.getParameterValues(name);
      for(String v : values){
      out.print( v + ",");
        }
        %>
        </li>
<% }%>

</ul>

</body>
</html>