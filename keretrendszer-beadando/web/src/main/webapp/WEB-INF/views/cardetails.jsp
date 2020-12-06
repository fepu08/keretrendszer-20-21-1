<%--
  Created by IntelliJ IDEA.
  User: frank
  Date: 2020. 12. 01.
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>${car.id}</title>
</head>
<body>
    <table>
        <tr><td>ID:</td><td>${car.id}</td></tr>
        <tr><td>Model:</td><td>${car.model}</td></tr>
        <tr><td>Color:</td><td>${car.color}</td></tr>
        <tr><td>Production Date:</td><td>${car.productionDate}</td></tr>
        <tr><td>Fuel Type:</td><td>${car.fuelType}</td></tr>
        <tr><td>Extras:</td><td>${car.extras}</td></tr>
        <tr><td>Price:</td><td>${car.price}</td></tr>
    </table>
    <form action="${pageContext.servletContext.contextPath}/">
        <input type="submit" value="Home">
    </form>
</body>
</html>
