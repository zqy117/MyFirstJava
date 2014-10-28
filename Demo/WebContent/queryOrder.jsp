<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单查询</title>
</head>
<body>
	<s:iterator id="so" value="soList" var="item">
		<p>订单Code<s:property value="#item.code" /></p>
		<p>身份证号码<s:property value="#item.idCard" /></p>
		<s:iterator id="t" value="#item.tickets" var="ticket">
			<p>始发站<s:property value="#ticket.fromStation.name" /></p>
			<p>目标站<s:property value="#ticket.toStation.name" /></p>
			<p>车票类型<s:property value="#ticket.ticketType" /></p>
			<p>票价<s:property value="#ticket.price" /></p>
			<p><s:property value="#ticket.carriageNumber" />号车厢<s:property value="#ticket.seatNumber" />号座位</p>
			<p>票对应的身份证号码<s:property value="#ticket.idCard" /></p>
		</s:iterator>
	</s:iterator>
	<a href="welcome_user.jsp">返回首页</a>
</body>
</html>