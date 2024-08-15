<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>

	<h1>Register</h1>
	<form method="post" action="/hellomvc/register">
		<label>Username: </label>
		<input name="username" />
		
		<label>Password: </label>
		<input name="password123"/>
		
		<label>Name: </label>
		<input name="name"/>
		
		<label>Role: </label>
		<input type="radio" name="role" value="ROLE_ADMIN"/>ADMIN
		<input type="radio" name="role" value="ROLE_MEMBER"/>MEMBER
		
		<button type="submit">Register</button>
	</form>

</body>
</html>