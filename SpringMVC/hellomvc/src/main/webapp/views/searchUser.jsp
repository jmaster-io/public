<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search User</title>
</head>
<body>
	<h1>Xin chao ${sessionScope.loginUser.name}</h1>
	
	<h1>User Table</h1>
	<a href='/hellomvc/register'>Them moi </a>
	
	<form method="get" action="/hellomvc/admin/user/search">
		<input name="name">
		<button type="submit">Search</button>
	</form>
	
	<table>
		<c:forEach var="user" items="${uList}">
			<tr>
				<td>${user.id}</td>
				<td>${user.getUsername() }</td>
				<td>${user.getPassword()}</td>
				<td>${user.role}</td>
				<td>${user.name}</td>
				<td>
					<a href='/hellomvc/admin/user/delete?id=${user.id}'> Xoa </a>
					<a href='/hellomvc/admin/user/edit?id=${user.id}'> Sua </a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>