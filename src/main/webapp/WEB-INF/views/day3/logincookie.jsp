<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>

var ajax = new XMLHttpRequest();

function loginajaxpost(){
	var id = document.getElementById('idid').value;
	var pw = document.getElementById('pwid').value;

	var data = {'id':id,'pw':pw};
	console.log('data',data);
	var datajson = JSON.stringify(data);
	console.log('datajson',datajson);

	ajax.open('post','logincookieajax');
	ajax.setRequestHeader('Content-Type','application/json');
	ajax.onreadystatechange = logincookiecallback;
	ajax.send(datajson);
	//alert(1);
}




function logincookiecallback(){
	if(ajax.responseText = ajax.DONE){
		if(ajax.responseText = true){
			document.cookie='id=' + document.getElementById('idid').value+';';
			document.cookie='pw=' + document.getElementById('pwid').value+';';
			console.log('logincookiecallback :' + document.cookie);
			var user = document.cookie.split(';');
			var id = user[0].split('=');
			var idv = id[1];
			var pw = user[1].split('=');
			var pwv = pw[1];
			window.location='logincookielist?id='+idv+'&pw='+pwv;
		}
		//alert('done');
	}
}

window.onload = function (){
	
	
//	var sessionresult = {sessionresult};
//	console.log('sessionresult:' + sessionresult);

	var cookieinit = confirm('쿠키를 초기화할까요');
	
	if(cookieinit == true) {
		document.cookie = 'id=';
		document.cookie = 'pw=';
	}
	
	var user = document.cookie.split(';');
	console.log('user:' + user);
	if(user != null){
		var id = user[0].split('=');
		var idv = id[1];
		var pw = user[1].split('=');
		var pwv = pw[1];
	
	
		var data = {'id':idv,'pw':pwv};
		console.log('data',data);
		var datajson = JSON.stringify(data);
		console.log('datajson',datajson);
	
		ajax.open('post','logincookiesession');
		ajax.setRequestHeader('Content-Type','application/json');
		ajax.onreadystatechange = loginsessioncallback;
		//alert(1);
		ajax.send(datajson);
	}
	
	//console.log(document.cookie,idv,pwv);
}

function loginsessioncallback(){
	if(ajax.readyState = ajax.DONE){
		//alert(ajax.responseText);
		var user = document.cookie.split('/');
		var id = user[0].split('=');
		var idv = id[1];
		var pw = user[1].split('=');
		var pwv = pw[1];
		window.location='logincookielist?id='+idv+'&pw='+pwv;
	}
}

</script>

</head>
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
			<form id='formid'>
				<td><input id='idid' name='id'></td>
				<td><input id='pwid' type="password" name='pw'></td>
				<td><input type='button' onclick="loginajaxpost()" value="로그인"></td>
			</form>
			
		</tr>
	</tbody>

</table>

</body>
</html>