<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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

		ajax.open('post','inputfilewrite');
		ajax.onreadystatechange = callbackpostajax;
		ajax.setRequestHeader('Content-Type','application/json');
		ajax.send(JSON.stringify(data));
	}
	
	function callbackpostajax(){
		if (ajax.readyState === XMLHttpRequest.DONE) {
	
			alert(ajax.responseText);
		} else {
			
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
			<th>기능</th>
			
		</tr>
	</thead>
	<tbody>
		<tr>
			<form id='formid' action='inputpersonpostform'>
				<td><input name='name'></td>
				<td><input name='age'></td>
				<td><input name='gender'></td>
				<td><input type='button' onclick="inputajaxpost()" value="저장"></td>
			</form>
			
		</tr>
	</tbody>

</table>

</body>
</html>