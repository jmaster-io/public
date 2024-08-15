<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/spring-hello/user/add" method="post">
		<div>
			<label>Name</label> <input type="text" name="name" />
		</div>
		<div>
			<label>Age</label> <input type="text" name="age" />
		</div>
		<div>
			<button type="submit">Add</button>
		</div>
	</form>
</body>
</html>