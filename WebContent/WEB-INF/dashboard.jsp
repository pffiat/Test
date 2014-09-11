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
	<table class="game zebra-striped">
		<thead>
			<tr>
				<th>ID Game</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<c:forEach var="game" items="${listGame}">
					<td>${game.id}</td>

				</c:forEach>
			</tr>
		</tbody>
	</table>
</body>
</html>