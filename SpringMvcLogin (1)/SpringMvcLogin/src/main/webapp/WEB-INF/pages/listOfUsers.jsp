<%@page contentType = "text/html;charset = UTF-8" language = "java" %>
<%@page isELIgnored = "false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import = "java.util.*" %>
<%@page import = "com.hcl.model.User" %>
<title>Insert title here</title>
</head>
<body>

<h1>List of User Details</h1>


<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>password</th>
				<th>mail</th>
				
			</tr>
		</thead>
		<tbody>
			<%
				
				List<User> list = (List<User>) request.getAttribute("listOfUsers");
			%>
 
			<%
				for (User u : list) {
			%>
			<tr>
				
				<td><%=u.getId()%></td>
				<td><%=u.getName()%></td>
				<td><%=u.getPassword()%></td>
				<td><%=u.getEmail()%></td>
				
			</tr>
			<%
				}
			%>
		</tbody>
	</table>

</body>
</html>