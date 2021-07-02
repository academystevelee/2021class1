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
	
	function inputajaxget(){
		var data = $('#formid').serializeObject();
		alert(data);
		alert(JSON.stringify(data));
		
		ajax.open('get','inputpersonpostajax?person='+JSON.stringify(data));
		ajax.onreadystatechange = callbackgetajax;
		//ajax.setRequestHeader('Content-Type','application/json');
		ajax.send();
	}
	
	function callbackgetajax(){
		if (ajax.readyState === XMLHttpRequest.DONE) {
			alert(ajax.responseText);
		    // �̻� ����, ���� �޾���
		} else {
			//alert(ajax.responseText);
		    // ���� �غ���� ����
		}
		
	}


</script>
</head>
<body>

<table border="1">

	<thead>
		<tr>
			<th>�̸�</th>
			<th>����</th>
			<th>����</th>
			<th>����</th>
			
		</tr>
	</thead>
	<tbody>
		<tr>
			<form id='formid' action='inputpersongetform'>
				<td><input name='name'></td>
				<td><input name='age'></td>
				<td><input name='gender'></td>
				<td><input type='button' onclick="inputajaxget()" value="���"></td>
			</form>
			
		</tr>
	</tbody>

</table>

</body>
</html>