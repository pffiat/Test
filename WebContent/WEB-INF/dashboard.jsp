<%@include file="/WEB-INF/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Buy A Start-Up</title>
</head>
<body>
	SUPER FRY is a tocard !!!

	<c:forEach var="game" items="${listGame.resultList}">
		<p>${game.id}   ${game.rev} </p>
	</c:forEach>


	<%-- show paging status --%>
	<p>
		Showing: ${listGame.resultFrom} - ${listGame.resultTo} of total	${listGame.totalResults}

		<%-- handle navigation --%>
	<p>
		<c:choose>
			<c:when test="${listGame.hasPrevious}">
				<a href="/BuyAStartup/Dashboard?param=${listGame.previousParam}"> Previous </a>
			</c:when>
			<c:otherwise> Previous </c:otherwise>
		</c:choose>

		${listGame.pageNumber}

		<c:choose>
			<c:when test="${listGame.hasNext}">
				<a href="/BuyAStartup/Dashboard?param=${listGame.nextParam}"> Next </a>
			</c:when>
			<c:otherwise> Next </c:otherwise>
		</c:choose>
</body>
</html>