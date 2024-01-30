<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Gio hang</title>
</head>
<body>
	<h2>Thong tin gio hang:</h2>
	<table border="1">
		<tr>
			<td>Id SP</td>
			<td>Ten SP</td>
			<td>Anh</td>
			<td>So luong</td>
			<td>Gia</td>
			<td>Tong tien</td>
			<td>Lua chon</td>
		</tr>
		<c:forEach items="${sessionScope.cart}" var="entry">
			<tr>
				<td>${entry.key }</td>
				<td>${entry.value.product.name }</td>
				<td><img src="/finalweb10/download?image=${entry.value.product.image }" width="100" /></td>
				<td>${entry.value.quantity }</td>
				<td>${entry.value.unitPrice }</td>
				<td>${entry.value.quantity * entry.value.unitPrice}</td>
				<td><a href="/finalweb10/delete-from-cart?key=${entry.key }">Xoa</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="/finalweb10/member/add-order">Thanh toan</a>
</body>
</html>