<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GoogleSearch</title>
<style type="text/css">
#padding{
	padding: 15px 15px 15px 15px;
}
a {
	color: #0B173B;
	font-size: 30px;
	text-decoration: none;
}
a:hover{
text-decoration:underline;
}
.border-style {
	border-radius: 90px/90px;
}
</style>
</head>
<body>
<body style='background-color: #FDFCDC'>
<form action='${requestUri}' method='get'>

	<div style='position: absolute;margin-top:190px;margin-left:50px'>
		<%
		String[][] orderList = (String[][]) request.getAttribute("hashmap");
		for (int i = 1; i < orderList.length; i++) {
			String s=orderList[i][1];
			//s=s.substring(7);
		%>
		
		<a href='<%=s%>'><%=orderList[i][0]%> </a> <br>連結<br>
		<br>
		<%
}
%>
	</div>
	<div>
		<img src="images/icon.png"
			style='position: absolute; width: 323.25px; height: 148px; left: 50%; top: 50%; margin-top: -300px; margin-left: -700px'>
	</div>
		<div>
		<input type='text' class="border-style" id="padding" name='keyword'
			style='font-size: 120%; position: absolute; left: 50%; top: 48%; margin-top: -240px; margin-left: -380px; width: 800px; height: 25px'
			placeholder = '請輸入關鍵字' value='<%=request.getParameter("keyword")%>'/>
	</div>

</form>
</body>
</html>
