<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error</title>
</head>
<body>
 <p>Spring Handler method: ${handler}</p>
 <p>
  Status:<%=request.getAttribute("javax.servlet.error.status_code") %>
 </p>
 <p>
  Reason: <%=request.getAttribute("javax.servlet.error.message") %>
 </p>
 <p>
  Type: <%=request.getAttribute("javax.servlet.error.exception_type") %>
 </p>
</body>
</html>