<%--
  Created by IntelliJ IDEA.
  User: frank
  Date: 2020. 12. 01.
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Cars</title>
</head>
<body>
<h1>Cars Page</h1>
<c:if test="${!empty cars}">
    <table frame="border" rules="all">
        <tr>
            <th>ID</th>
            <th>Model</th>
            <th>Production Date</th>
            <th>Price</th>
            <th>Fuel Type</th>
        </tr>

    <c:forEach items="${cars}" var="car">
        <tr>
            <td><a href="${pageContext.servletContext.contextPath}/car/${car.id}">${car.id}</a></td>
            <td>${car.model}</td>
            <td>${car.productionDate}</td>
            <td>${car.price}</td>
            <td>${car.fuelType}</td>
        </tr>
    </c:forEach>

    </table>
</c:if>

<c:if test="${empty cars}">
    <h3>No cars in the list</h3>
</c:if>

<form action="${pageContext.servletContext.contextPath}/addCar">
    <input type="submit" value="Add Car"/>
</form>

</body>
</html>
