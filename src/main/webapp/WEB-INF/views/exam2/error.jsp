<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error page</title>
</head>
<script>

function gologin(){
	window.location='/';
}
</script>
<body>

<h2>시스템에 문제가 생겼습니다. 관리자에게 문의해주세요.</h2>
<button onclick='gologin()'>로그인페이지 이동</button>
</body>
</html>