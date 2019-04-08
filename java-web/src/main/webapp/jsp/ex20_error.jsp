<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    errorPage="ex20_error.jsp"
    isErrorPage="true"
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex20_error</title>
</head>
<body>
<h1>오류 발생!</h1>
<%=exception.getMessage() %>

</body>
</html>
<%-- 
오류가 발생했을 때 실행되는 JSP 페이지는
exception이라는 변수를 통해 오류 내용을 받을 수있다.
단, isErrorPage 속성에 true 이어야 해당 변수가 준비된다.
 --%>
