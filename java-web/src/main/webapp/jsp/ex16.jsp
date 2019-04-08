<%@page import="java.util.ArrayList"%>
<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    buffer="8kb"
    autoFlush="false"
    import="bitcamp.vo.Board" 
    import="java.util.ArrayList"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex11</title>
</head>
<body>
<h1>JSP 액션 태그 - jsp:useBean(계속)</h1>


<%-- type 속성 대신에 class 속성을 사용하면
     id로 지정한 객체를 찾지 못했을 때 해당 객체를 만들고,
      그 id로 보관소에 저장한다.   --%>
<jsp:useBean id="list" type="java.util.ArrayList<String>" scope="page"/>
<%-- 자바코드로 표현해보면,
     (java.util.ArrayList<String>) list =
       
  if(list == null) {
   throw new Throwable("list라는 이름의 빈이 없습니다.");
   
  }
 --%>
 <%
 // 제네릭 문법을 사용하지 못했기 때문에 list의 타입은 java.util.ArrayList이다.
 // 따라서 for 문에서 항목의 타입을 지정할 때 String으로 지정할 수 없다.
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

