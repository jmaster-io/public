<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit User</title>
<link rel="stylesheet" href="/hellomvc/static/style.css" />
</head>
<body>
	<h1>Edit User</h1>
	<%-- <form method="post" action="/hellomvc/admin/user/edit">
		<label>ID:</label> 
		<input name="id" value="${user.getId()}"/>
		
		<label>Username: </label>
		<input name="username" value="${user.username}"/>
		
		<label>Password: </label>
		<input name="password" value="${user.password}"/>
		
		<label>Name: </label>
		<input name="password" value="${user.name}"/>
		
		<label>Role: </label>
		<c:if test="${user.role == 'ROLE_ADMIN' }">
			<input type="radio" name="role" value="ROLE_ADMIN" checked="checked"/>ADMIN
			<input type="radio" name="role" value="ROLE_MEMBER"/>MEMBER 
		</c:if>
		<c:if test="${user.role == 'ROLE_MEMBER' }">
			<input type="radio" name="role" value="ROLE_ADMIN" />ADMIN
			<input type="radio" name="role" value="ROLE_MEMBER" checked="checked"/>MEMBER 
		</c:if>
		
		<button type="submit">Save</button>
	</form> --%>
	<form:form method="post" action="/hellomvc/admin/user/edit"
		modelAttribute="user">
		<div>
			<label>ID:</label>
			<form:input path="id" />
		</div>

		<div>
			<label><spring:message code="user.name" />: </label>
			<form:input path="name" />
			<form:errors path="name" />
		</div>

		<div>
			<label>Username: </label>
			<form:input path="username" />
			<form:errors path="username" />
		</div>

		<div>
			<label>Password: </label>
			<form:password path="password" />
			<form:errors path="password" />
		</div>

		<label>Role: </label>
		<form:radiobutton path="role" value="ADMIN" />ADMIN
		<form:radiobutton path="role" value="MEMBER" />MEMBER 
		
		<button type="submit">Save</button>
	</form:form>

</body>
</html>