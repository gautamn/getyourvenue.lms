<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<body>
	the view lead page
	
	<h2>${leadHeader}</h2>
	
	<c:forEach items="${leadHeader.leadHistory}" var="contact">
			    <tr>
			        <td>${contact.historyId}</td>
			    </tr>
			</c:forEach>
	
	</body>
</html>
