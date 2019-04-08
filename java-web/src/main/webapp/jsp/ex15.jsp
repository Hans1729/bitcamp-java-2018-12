<%@page import="java.util.ArrayList"%>
<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    buffer="8kb"
    autoFlush="false"
    import="bitcamp.vo.Board" 
    import="java.util.list"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex11</title>
</head>
<body>
<h1>JSP 액션 태그 - jsp:useBean(계속)</h1>


<%-- id로 지정된 객체를 찾지 못하면 예외가 발생한다. --%>
<jsp:useBean id="list" type="java.util.List<String>" scope="page"/>
<%-- 자바코드로 표현해보면,
  type 속성에 인터페이스를 지정해도 된다. 위 코드는 다음의 자바 코드와 같다.
     (ArrayList<String>) a
  if(list == null) {
   throw new Throwable("list라는 이름의 빈이 없습니다.");
   
  }
 --%>
 <%
 for (String n : list) {
   out.println(n + "<br>");
 }
 %>


<%--
<jsp:useBean id="s5" type="java.lang.String" scope="page"/>
 --%>
 
</body>
</html>
<%--
jsp:useBean (계속)

1) type 속성
   

--%>

