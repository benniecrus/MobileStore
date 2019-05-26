<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="getIOException" method="post">
	Error: <input name="error" value="true">
	<button type="submit">IO Exception</button>
	</form>
	<form action="getNullException" method="post">
	Error: <input name="error" value="true">
	<button type="submit">Null Exception</button>
	</form>
</body>
</html>