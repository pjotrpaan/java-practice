    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Qualifications List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Id</th><th>Name</th><th>Level</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="emp" items="${list}"> 
    <tr>
    <td>${emp.id}</td>
    <td>${emp.qualification}</td>
    <td>${emp.level}</td>
    <td><a href="editqualification/${emp.id}">Edit</a></td>
    <td><a href="deletequalification/${emp.id}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="../qualificationform/${empId}">Add New Qualification</a>