<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="Models.*"%>
<%@ page import="user.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	
	<h1>欢迎进入车票订购系统</h1>

	<p>
		Hello:
		<a id="soIdcard"><s:property value="idCard" /></a>
	</p>
	
	<s:form action="QuerySalesOrder">
		<s:submit value="查询您的订单" />
	</s:form>
	
<!-- 	<p>
		<a href="queryOrder.jsp">查询您的订单</a>
	</p> -->
	<form>
		目的地: <input id="toStation1" type="text" name="firstname" /> 身份号:<input id="idCard1" type="text" name="lastname" />
		<br />
		目的地: <input id="toStation2" type="text" name="firstname" /> 身份号:<input id="idCard2" type="text" name="lastname" />
		<br />
		目的地: <input id="toStation3" type="text" name="firstname" /> 身份号:<input id="idCard3" type="text" name="lastname" />
	</form>
	<p>
		<button type="button" onclick="myFunction()">订票</button>
	</p>
	<script type="text/javascript">
		
		function myFunction() {
			var args = [ document.getElementById("toStation1").value,
					document.getElementById("idCard1").value,
					document.getElementById("toStation2").value,
					document.getElementById("idCard2").value,
					document.getElementById("toStation3").value,
					document.getElementById("idCard3").value, ];
			document.forms[0].action = "/Demo/BookTicketAction.action?args="
					+ args + "&soIdcard="
					+ document.getElementById("soIdcard").innerHTML;
			document.forms[0].submit();
		}
	</script>
</body>
</html>