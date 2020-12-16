<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<html>

<head>
   <title>Custom Login Page</title>
</head>

<body>
<h3>My Custom Login Page</h3>

   <form:form action="${pageContext.request.contextPath}/authenticateTheUser"
			   method="POST">
       
       <p>
			User name: <input type="text" name="username" />
		</p>

		<p>
			Password: <input type="password" name="password" />
		</p>
		
		<input type="submit" value="Login" />
       
   </form:form>

</body>
</html>