<%@page contentType = "text/html;charset = UTF-8" language = "java" %>
<%@page isELIgnored = "false" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<title>Insert title here</title>
</head>
<body>
	<h1>List of User Details</h1>

 <table border="1">
 
            <th>Id</th>
            <th>Name</th>
           
 
            <c:forEach var="user" items="${listOfUsers}">
                <tr>
 
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    
                </tr>
            </c:forEach>
        </table>
</body>
</html>