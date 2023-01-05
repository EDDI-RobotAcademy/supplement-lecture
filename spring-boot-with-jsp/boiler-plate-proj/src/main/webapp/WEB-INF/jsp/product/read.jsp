<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<title>Board</title>
</head>

<script src="https://code.jquery.com/jquery-latest.min.js"></script>

<script>
	$(document).ready(function() {

		var formObj = $("#product");

		console.log(formObj);

		$("#btnEdit").on("click", function() {
			var productId = $("#id");
			var productIdValue = parseInt(productId.val());
			
			self.location = "/product/modify?productId=" + productIdValue;
		});

		$("#btnRemove").on("click", function() {
			formObj.attr("action", "/product/remove");
			formObj.submit();
		});

		$("#btnList").on("click", function() {
			self.location = "/product/list";
		});

	});
</script>

<body>
	<h2>READ</h2>
	
	<form:form modelAttribute="product">
		<form:hidden path="id" />
	
		<table>
			<tr>
				<td>상품명</td>
				<td><form:input path="name" readonly="true" /></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><form:input path="price" readonly="true" /></td>
			</tr>
			<tr>
				<td>상품 세부 정보</td>
				<td><form:textarea path="description" readonly="true" /></td>
			</tr>
		</table>
	
	</form:form>
	
	<div>
		<button type="submit" id="btnEdit">Edit</button>
		<button type="submit" id="btnRemove">Remove</button>
		<button type="submit" id="btnList">List</button>
	</div>
</body>
</html>
