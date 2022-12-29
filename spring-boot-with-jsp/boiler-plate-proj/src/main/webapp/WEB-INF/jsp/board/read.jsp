<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<title>Board</title>
</head>

<script src="https://code.jquery.com/jquery-latest.min.js"></script>

<script>
	$(document).ready(function() {

		var formObj = $("#board");

		console.log(formObj);

		$("#btnEdit").on("click", function() {
			var boardNo = $("#boardNo");
			var boardNoVal = boardNo.val();
			
			self.location = "/board/modify?boardNo=" + boardNoVal;
		});

		$("#btnRemove").on("click", function() {
			formObj.attr("action", "/board/remove");
			formObj.submit();
		});

		$("#btnList").on("click", function() {
			self.location = "/board/list";
		});

	});
</script>

<body>
	<h2>READ</h2>
	
	<form:form modelAttribute="board">
		<form:hidden path="boardNo" />
	
		<table>
			<tr>
				<td>Title</td>
				<td><form:input path="title" readonly="true" /></td>
			</tr>
			<tr>
				<td>Writer</td>
				<td><form:input path="writer" readonly="true" /></td>
			</tr>
			<tr>
				<td>Content</td>
				<td><form:textarea path="content" readonly="true" /></td>
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
