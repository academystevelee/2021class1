<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import ="com.stevelee.springmvc.day1_data.Person" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>


</head>
<body>

<table border=1>
	<thead>
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>비번</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="logindto" items="${logindtolist}" varStatus="status">
		<tr>
			<td>${status.index }</td>
			<td>${logindto.getId() }</td>
			<td>${logindto.getPw() }</td>
		</tr>
		
		
		
	
	</c:forEach>
	</tbody>
</table>

<button onclick='gologin()'>돌아가기</button> 
<button onclick='session1()'>세션1</button> 
<script>


	function gologin(){
		window.location='logincookie';
	}
	

	function session1(){
		var json = '${logindtolistjson}';
		console.log('json:'+json);
		sessionStorage.setItem('loginlist',json);
	}
</script>

</body>
</html>