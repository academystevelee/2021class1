<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>
	jQuery.fn.serializeObject = function() { 
	    var obj = null; 
	    try { 
	        if(this[0].tagName && this[0].tagName.toUpperCase() == "FORM" ) { 
	            var arr = this.serializeArray(); 
	            if(arr){ obj = {}; 
	            jQuery.each(arr, function() { 
	                obj[this.name] = this.value; }); 
	            } 
	        } 
	    }catch(e) { 
	        alert(e.message); 
	    }finally {} 
	    return obj; 
	}
	
	var ajax = new XMLHttpRequest();
	
	function inputajaxpost(){
		var data = $('#formid').serializeObject();
		alert(data);
		alert(JSON.stringify(data));
		
		
		ajax.open('post','inputpersonpostajax');
		ajax.onreadystatechange = callbackpostajax;
		ajax.setRequestHeader('Content-Type','application/json');
		ajax.send(JSON.stringify(data));
	}
	
	function callbackpostajax(){
		if (ajax.readyState === XMLHttpRequest.DONE) {
			alert(ajax.responseText);
		    // 이상 없음, 응답 받았음
		} else {
			//alert(ajax.responseText);
		    // 아직 준비되지 않음
		}
		
	}


</script>
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
			<form id='formid' action='inputpersonpostform'>
				<td><input name='name'></td>
				<td><input name='age'></td>
				<td><input name='gender'></td>
				<td><input type='button' onclick="inputajaxpost()" value="등록"></td>
			</form>
			
		</tr>
	</tbody>

</table>

</body>
</html>