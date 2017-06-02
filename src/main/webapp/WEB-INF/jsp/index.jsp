<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="/lib/jquery/jquery.min.js"></script>
<script src="/js/test.js"></script>
<link rel="stylesheet" href="/css/welcome.css">
</head>
<body>
	<div class="test">
	<img src="/img/logo.png" />
		<h1>${msg}</h1>
	</div>
	<div class="test">
	<c:choose>
		<c:when test="${test==0}">
			0
		</c:when>
		<c:otherwise>
			${test}
		</c:otherwise>
	</c:choose>
	</div>
</body>
</html>