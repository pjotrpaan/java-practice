<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="${contextPath}/resources/css/styles.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container emp-list-view">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
		<a onclick="document.forms['logoutForm'].submit()" class="log-out-link">Logout</a>
        <h2>Welcome <span class="name">${pageContext.request.userPrincipal.name}</span></h2>
        
        <a href="/welcome">Home page</a>
		
		<h1>Employees list</h1>
	    <table border="2" width="100%" cellpadding="4">
		<tr>
		<th>Id</th>
		<th>First name</th>
		<th>Last name</th>
		<c:if test="${isAdmin}">
		<th>Person ID</th>
		</c:if>
		<th>Designation</th>
		<th>Date</th>
		<th>Qualifications</th>
		<c:if test="${isAdmin}">
		<th>Edit</th>
		<th>Delete</th>
		</c:if>
		<th>Archived</th></tr>
	    <c:forEach var="emp" items="${list}">
	    <tr>
	    <td>${emp.id}</td>
	    <td>${emp.firstName}</td>
	    <td>${emp.lastName}</td>
	    <c:if test="${isAdmin}">
	    <td>${emp.personalId}</td>
	    </c:if>
	    <td>${emp.designation}</td>
	    <td>${emp.date}</td>
	    <td><a href="/qualification/viewqualification/${emp.id}">View qualifications</a></td>
	    <c:if test="${isAdmin}">
	    <td><a href="/editemployee/${emp.id}">Edit</a></td>
	    <td><a href="/deleteemployee/${emp.id}">Delete</a></td>
	    </c:if>
	    <td><input type="checkbox" <c:if test="${emp.archived}">checked</c:if>/></td>
	    </tr>
	    </c:forEach>
	    </table>
	    <br/>
	    <a href="employeeform">Add New Employee</a>

    </c:if>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
       