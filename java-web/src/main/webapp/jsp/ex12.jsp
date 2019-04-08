<%@page import="java.util.ArrayList"%>
<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    buffer="8kb"
    autoFlush="false"
    import="bitcamp.vo.Board" 
    import="java.util"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex11</title>
</head>
<body>
<h1>JSP 액션 태그 - jsp:useBean(계속)</h1>
<%
ArrayList<String> names = new ArrayList<>();
names.add("홍길동");
names.add("임꺽정");
names.add("안중근");
names.add("윤봉길");

pageContext.setAttribute("list", names);
%>



<jsp:useBean id="list" type="java.util.ArrayList<String>" scope="page"/>
<%-- 자바코드로 표현해보면,
  java.util.ArrayList<String> list = 
     (ArrayList<String>) a
 --%>
 <%
 for (String n : list) {
   out.println(n + "<br>");
 }
 %>
<jsp:useBean id="s2" type="java.lang.String" scope="session"/>
<jsp:useBean id="s3" type="java.lang.String" scope="request"/>
<jsp:useBean id="s4" type="java.lang.String" scope="page"/>


<%=s1%><br>
<%=s2%><br>
<%=s3%><br>
<%=s4%><br>


<%--
<jsp:useBean id="s5" type="java.lang.String" scope="page"/>
 --%>
 
</body>
</html>
<%--
jsp:useBean (계속)

1) type 속성
   

--%>

