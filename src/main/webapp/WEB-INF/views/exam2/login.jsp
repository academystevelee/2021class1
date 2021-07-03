<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user login</title>
</head>

<script>

window.onload = function(){
	
	var onloadresult = '${loginresult}';
	if(onloadresult == 'false') alert('로그인을 다시 시도해주세요.');
	
}

function cookieput(){
	
	document.cookie='id=' + document.getElementById('idid').value+';';
	document.cookie='pw=' + document.getElementById('pwid').value+';';
	alert('logincookiecallback :' + document.cookie);
	
}


</script>

<body>



<table border="1">

	<thead>
		<tr>
			<th>아아디</th>
			<th>비밀번호</th>
			<th>기능</th>
			
		</tr>
	</thead>
	<tbody>
		<tr>
			<form action='loginaction' method="post">
				<td><input id='idid' name='id'></td>
				<td><input id='pwid' type="password" name='pw'></td>
				<td><input type='submit' onclick="cookieput()" value="로그인"></td>
			</form>
			
		</tr>
	</tbody>

</table>
</body>
</html>