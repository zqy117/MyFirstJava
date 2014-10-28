<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>车票预订系统4SS</h1>
 
	<s:form action="Welcome">
		<s:textfield name="idCard" label="身份证号" />
		<s:password name="password" label="密码" />
		<s:submit value="提交" />
	</s:form>
</body>
</html>