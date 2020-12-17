<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

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
   
   <hr>
   <!-- Display user name and role -->
   <p>
      User: <security:authentication property="principal.username"/>
      <br><br>
      Role(s): <security:authentication property="principal.authorities"/>
   </p>
   
   <hr>
      <!-- Add a link to point to /leaders ... this is for managers -->
      
      <p>
         <a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
          (Only for Manager folks)
      </p>
      
      <!-- Add a link to point to /systems ... that is for admins -->
      
      <p>
         <a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
          (Only for Administrators)
      </p>
   <hr>
   
   <!-- Add Logout button -->
   <form:form action="${pageContext.request.contextPath}/logout"
              method="POST">
              
              <input type="submit" value="logout"/>
   </form:form>
   
</body>

</html>