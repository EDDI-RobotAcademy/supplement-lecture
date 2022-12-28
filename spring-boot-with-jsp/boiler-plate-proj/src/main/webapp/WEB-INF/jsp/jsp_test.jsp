<%@ page import="java.util.Random" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Spring Boot with JSP</title>
</head>

<body>
    <%
        Random random = new Random();
        int randomNumber = random.nextInt(33) + 7;
        out.print("<h1> Random: " + randomNumber + "</h1>");
    %>
</body>
</html>