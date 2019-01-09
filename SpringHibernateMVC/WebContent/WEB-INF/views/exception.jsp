<%@ page language="java" 
contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exception Page</title>
</head>
<body>
	<h1>Ops! Something went wrong</h1>

	<b>${name}</b>: ${message}
	<h3>${exception.exceptionMsg}</h3>
</body>
</html>