<%--
  Created by IntelliJ IDEA.
  User: frank
  Date: 2020. 12. 01.
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Add Car</title>
</head>
<body>
    <form:form method="post" action="addCar" modelAttribute="car">
        <form:label path="model">Model</form:label>
        <form:input path="model"/>
        <form:label path="color">Color</form:label>
        <form:input path="color"/>
        <form:label path="productionDate">Production Date</form:label>
        <form:input type="date" path="productionDate"/>
        <form:label path="fuelType">Fuel Type</form:label>
        <form:select path="fuelType">
            <form:options items="${fuelTypes}"/>
        </form:select>

        <form:label path="price">Price</form:label>
        <form:input type="number" path="price"/>
        <input type="submit" value="Add the Car!"/>
    </form:form>
</body>
</html>
