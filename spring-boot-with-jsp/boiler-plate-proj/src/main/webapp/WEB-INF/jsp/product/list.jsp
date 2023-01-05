<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<title>Product</title>
</head>
<body>
	<h2>List</h2>
	<a href="register">New</a>
	<table border="1">
		<tr>
			<th align="center" width="80">상품 번호</th>
			<th align="center" width="320">상품명</th>
			<th align="center" width="100">가격</th>
			<th align="center" width="180">등록일자</th>
		</tr>
		
	<c:choose>
		<c:when test="${empty list}">
			<tr>
				<td colspan="4">
					List is empty.
				</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${list}" var="product">
				<tr>
					<td align="center">${product.id}</td>
					<td align="left"><a href="/product/read?productId=${product.id}">${product.name}</a></td>
					<td align="right">${product.price}</td>
					<td align="center"><javatime:format value="${product.createdTime}" pattern="yyyy-MM-dd HH:mm" /></td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
		
	</table>
</body>
</html>
