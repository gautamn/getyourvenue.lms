<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%StringBuffer buffer = new StringBuffer(); %>
<c:forEach var="leadAlliedService" items="${alliedList}">
	<% String leadId = (String)pageContext.getAttribute("leadAlliedService"); 
	   buffer.append(leadId+";");				         
	%>
</c:forEach>
<%=buffer%>
