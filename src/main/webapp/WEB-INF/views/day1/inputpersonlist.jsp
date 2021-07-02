<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import ="com.stevelee.springmvc.day1_data.Person" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>personlist obj</title>
</head>
<body>


	<c:forEach var="person" items="${personlist}">

		${person.getName() }
		${person.getAge() }
		${person.getGender() }
		<c:out value="${person.getName() }"></c:out>
		<c:out value="${person.getAge() }"></c:out>
		<br>
	
	</c:forEach>

</body>
</html>