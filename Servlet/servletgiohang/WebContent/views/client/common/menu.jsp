<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1 class="my-4">JavaMaster</h1>
<div class="list-group">
	<ul>
		<c:if test="${sessionScope.loginUser != null }">
			<li>Xin chao ${sessionScope.loginUser.name}</li>
			<li><a href="/finalweb10/client/logout">Thoat</a></li>
			
			<li><a href="/finalweb10/member/bills">Don hang</a></li>
		</c:if>
		<c:if test="${sessionScope.loginUser == null }">
			<li><a href="/finalweb10/client/register">Dang ky</a></li>
			<li><a href="/finalweb10/login-member">Login</a></li>
		</c:if>
		
		<li><a href="/finalweb10/cart">Giỏ hàng</a></li>
	</ul>
	<c:forEach items="${categoryList}" var="cate">
		<a href="/finalweb10/client/product/category?cid=${cate.id }" class="list-group-item">${cate.name }</a>
	</c:forEach>
</div>