<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
   <title>mirjalolcode Company Home Page</title>
</head>

<body>
   <h2>mirjalolcode Company Home Page</h2>
   <hr>
   
   <p>
   Welcome to the mirjalolcode company home page!
   </p>
   
   <!-- Add Logout button -->
   <form:form action="${pageContext.request.contextPath}/logout"
              method="POST">
              
              <input type="submit" value="logout"/>
   </form:form>
   
</body>

</html>