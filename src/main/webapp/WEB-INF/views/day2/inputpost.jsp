<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>inputpost</title>
<script type="text/javascript">

function ajaxsend(){
	
    alert(1);

	var ajax = new XMLHttpRequest();
	
    ajax.open('get','inputpostajaxget?name='+document.getElementById('nameid').value+'&age=' + document.getElementById('ageid').value);
    ajax.send();


}

function ajaxpostsend(){
    alert(2);

	var ajax = new XMLHttpRequest();
	
    ajax.open('post','inputpostajaxpost');
    ajax.send(document.getElementById('nameid').value + ',' + document.getElementById('ageid').value); 
    
}

</script>
</head>
<body>


    <table border="1">
        <thead>
            <tr>
                <th>이름</th>
                <th>나이</th>
                <th>기능</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <form action="inputpostform">
                    <td><input id='nameid' type="text" name="name"></td>
                    <td><input id='ageid' type="text" name="age"></td>
                    <td>
                	    <input type="submit" value="formsubmit2">
                </form>
                       <button onclick="ajaxsend()">ajaxbtn</button>
                       <button onclick="ajaxpostsend()">ajaxpostbtn</button>
                    </td>
                
            </tr>
        </tbody>

    </table>
    
        
    
</body>
</html>