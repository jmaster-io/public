<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login Form</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
			
				<img style="width: 50%;" src="https://trungtamjava.com/wp-content/uploads/2018/02/trung-tam-java-new-logo.png" />
				
				<p class="text-danger">${msg}</p>
				<form role="form" action="/finalweb10/login-member" method="post">
					<div class="form-group">
						<label> Username </label> <input type="text" class="form-control" name="username" />
					</div>
					<div class="form-group">
						<label> Password </label> <input type="password" class="form-control" name="password" />
					</div>
					<div class="form-group">
						<a href="/finalweb10/client/register">Dang ky</a>
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-primary">Login</button>
					</div>
				</form>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
</body>
</html>