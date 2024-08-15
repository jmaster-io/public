<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="/hellomvc/login" method="post">
		<div>
			<label>Username:</label>
			<input name="username"/>
		</div>
		<div>
			<label>Password:</label> 
			<input name="password" type="password" />
		</div>
		<div>
			<button type="submit">Login</button>
		</div>
	</form>
</body>
</html>