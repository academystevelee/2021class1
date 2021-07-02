<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import ="com.stevelee.springmvc.day1_data.Person" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<script>

var ajax = new XMLHttpRequest();


function callbackpostajax(){
	if (ajax.readyState === XMLHttpRequest.DONE) {
		//alert(ajax.responseText);
		
		if(ajax.responseText = true){
			alert('삭제완료 되었습니다');
		}else{
			alert('삭제가 실패하였습니다.관리자에게 문의하세요.');
		}
		window.location.reload();
	} else {
		//alert(ajax.responseText);
	}
	
}


function removeobj(index){

	ajax.open('post','inputfileremove');
	ajax.onreadystatechange = callbackpostajax;
	ajax.send(index);
	
}

</script>

</head>
<body>

<table border=1>
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>나이</th>
			<th>성별</th>
			<th>기능</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="person" items="${personlist}" varStatus="status">
		<tr>
			<td>${status.index }</td>
			<td>${person.getName() }</td>
			<td>${person.getAge() }</td>
			<td>${person.getGender() }</td>
			<td><button onclick="removeobj(${status.index })">제거</button>
		</tr>
		
		
		
	
	</c:forEach>
	</tbody>
</table>

 
</body>
</html>