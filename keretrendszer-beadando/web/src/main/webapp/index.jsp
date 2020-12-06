<%@ page isELIgnored="false" %>
<html>
<body>
<h2>Hello World!</h2>
<form action="${pageContext.servletContext.contextPath}/cars">
    <input type="submit" value="Cars"/>
</form>
<form action="${pageContext.servletContext.contextPath}/addCar">
    <input type="submit" value="Add Car"/>
</form>
</body>
</html>
