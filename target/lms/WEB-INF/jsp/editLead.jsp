<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<body>
	
	<form action="editLeadAction.htm" method="get" name="myForm">
  		First name: <input type="text" name="leadId"><br>
  		Last name: <input type="text" name="statusId"><br>
 		<input type="submit" value="Send form data!">
	</form>
		<!--<h1>Spring MVC Hello World Annotation Example</h1>
		<h2>${msg}</h2>
		
		<h3>Users</h3>
		<c:if  test="${!empty userList}">
			<table class="data">
			<tr>
			    <th>Name</th>
			    <th>&nbsp;</th>
			</tr>
			<c:forEach items="${userList}" var="contact">
			    <tr>
			        <td>${contact.userName}</td>
			    </tr>
			</c:forEach>
			</table>
		</c:if>
		
		
	--></body>
</html>
