<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<title>Board</title>
</head>

<script src="https://code.jquery.com/jquery-latest.min.js"></script>

<script>
	$(document).ready(function() {

		var formObj = $("#product");

		$("#btnRegister").on("click", function() {
			formObj.attr("action", "/product/register");
			formObj.attr("method", "post");
			formObj.submit();
		});

		$("#btnList").on("click", function() {
			self.location = "/product/list";
		});

	});
</script>

<body>
	<h2>REGISTER</h2>

	<form:form modelAttribute="product" action="register">
		<table>
			<tr>
				<td>상품명</td>
				<td><form:input path="name" /></td>
				<td><font color="red"><form:errors path="name" /></font></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><form:input path="price" /></td>
				<td><font color="red"><form:errors path="price" /></font></td>
			</tr>
			<tr>
				<td>상품 세부 정보</td>
				<td><form:textarea path="description" /></td>
				<td><font color="red"><form:errors path="description" /></font></td>
			</tr>
		</table>
	</form:form>
	
	<div>
		<button type="submit" id="btnRegister">Register</button>
		<button type="submit" id="btnList">List</button>
	</div>
</body>
</html>
