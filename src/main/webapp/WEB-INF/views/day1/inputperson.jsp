<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<table border="1">

	<thead>
		<tr>
			<th>이름</th>
			<th>나이</th>
			<th>성별</th>
			<th>실행</th>
			
		</tr>
	</thead>
	<tbody>
		<tr>
			<form action='inputpersonform'>
				<td><input name='name'></td>
				<td><input name='age'></td>
				<td><input name='gender'></td>
				<td><input type='submit' name='등록'></td>
			</form>
			
		</tr>
	</tbody>

</table>

</body>
</html>