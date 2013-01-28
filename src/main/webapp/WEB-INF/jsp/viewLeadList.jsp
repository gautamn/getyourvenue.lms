<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GetYourVenue.com - CMS - VENUE</title>
<link rel="shortcut icon" type="image/x-icon" href="/images/favicon.ico">
<!-- CSS Includes section -->
<link rel="stylesheet" type="text/css" href="./view/css/lightmodal.css">
<link rel="stylesheet" type="text/css" href="./view/css/messagebox.css">
<link rel="stylesheet" type="text/css" href="./view/css/grid.css">
<link rel="stylesheet" type="text/css" href="./view/css/ie.css">
<link rel="stylesheet" type="text/css" href="./view/css/ie6.css">
<link rel="stylesheet" type="text/css" href="./view/css/jquery.css">
<link rel="stylesheet" type="text/css" href="./view/css/reset.css">
<link rel="stylesheet" type="text/css" href="./view/css/styles.css">
<link rel="stylesheet" type="text/css" href="./view/css/tablesorter.css">
<link rel="stylesheet" type="text/css" href="./view/css/theme-blue.css">
<link rel="stylesheet" type="text/css" href="./view/css/thickbox.css">
<link rel="stylesheet" type="text/css" href="./view/css/style1.css">
<!-- JS Includes section -->
</head>
<body class="homeinner">

<script>
function togelmenu(did){
  $('#'+did).toggle('slow');
}
</script>
<div id="header"><!-- Header. Main part -->
<div id="header-main" class="rel"><!-- Header. Status part -->
<div id="header-status" class="rightalign">
<div>

<div class=""><span><a href="javascript:void(0);"
	id="logout">Logout</a></span> <span id="admin"> Welcome : <a
	href="http://localhost/gyvcmsdemo/webdocs/home">Admin</a> </span></div>
</div>
<!--<div style="clear:both;"></div>--></div>
<!-- End #header-status --> <!-- Header. Main part -->
<div>
<div id="logo"><img src="./view/images/logogyv.jpg"
	alt="GYV Admin"></div>
</div>

<div class="float-left">
<div id="hdtxt"><img src="./view/images/adminhdtxt.png"
	alt="admin control"></div>

<div class="gyvMainNav">
<ul id="nav" style="display: block; float: none;">

	<li style="float: right;">
	</li>

</ul>

</div>
<!---SUBNAVIGATION--->
<div id="subnav">
<div class="">
<div class="float-right ">
<ul>
	<li><a  target="_blank"
		href="http://localhost:8080/lms/createlead.htm">Create Lead</a></li>
</ul>

</div>
<!-- End. .grid_12--></div>
<!-- End. .container_12 -->
<div style="clear: both;"></div>
</div>
<!-- End #subnav --></div>
<div style="clear: both;"></div>
<div class="wrapper">
<div class="container_12">
<div class="OuterMostWrapper">

<div id="venueBlock">
<div class="module">
<h2><span> Search</span></h2>
<div class="module-table-body">
<form action="" method="post" id="searchVenue" name="searchVenue">
<table class="NoBorder" border="0">
	<tbody>
		<tr>
			<td class="wid35prcnt"><span class="FieldBox">Keyword : <input
				class="input-medium" name="sh_keyword" id="sh_keyword" type="text"></span>
			<span class="FieldBox">Status : <select id="sh_status"
				name="sh_status">
				<option value="" selected="selected">All</option>
				<option value="0">Inactive</option>
				<option value="1">Active</option>
			</select> </span> <span class="FieldBox">Phone No. : <input
				class="input-medium" name="ph_keyword" id="ph_keyword" type="text"></span>
			</span> <span class="FieldBox"><input class="submit-green"
				onclick="javascript:searchVenues();" value="Search" type="button"></span>
			</td>
		</tr>
	</tbody>
</table>
</form>
</div>
</div>


<div class="module">
<h2><span> Lead Listing</span></h2>

<div class="module-table-body">
<table id="myTable" class="tablesorter">
	<thead>
		<tr>
			<th style="width: 7%">#</th>
			<th style="width: 25%">Lead Name</th>
			<th style="width: 43%">Status</th>
			<th style="width: 8%">Assigned To</th>
			<th style="width: 10%">Action</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty leadHeaderList}">
			<c:forEach var="lead" items="${leadHeaderList}" varStatus="status">
				<c:choose>
					<c:when test="${(status.count)%2 eq 0}">
						<tr class="even">
					</c:when>
					<c:otherwise>
						<tr class="odd">
					</c:otherwise>
				</c:choose>
				<td align="left"><c:out value="${status.count}" /></td>
				<c:set var="leadId" value="${lead.leadHeader.leadId}" />
				<% String leadId = (String)pageContext.getAttribute("leadId"); %>
				<td><a target="_blank"
					href="http://localhost:8080/lms/viewLead.htm?leadid=<%=leadId%>"><c:out
					value="${lead.leadName}" /> </a></td>
				<td align="left"><c:out value="${lead.status}" /></td>
				<td align="center"><c:out value="${lead.assignTo}" /></td>
				<td align="center"><a title="Edit" target="_blank"
					href="http://localhost:8080/lms/editLead.htm?leadid=<%=leadId%>"><img
					src="./view/images/pencil.gif" alt="edit" height="16" width="16"></a>
				</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>
<!-- Start pagination -->
<div class="pagination"><input id="currPage" name="currPage"
	value="1" type="hidden">
<div class="totalrds">Total Records: <b><c:out
	value="${fn:length(leadHeaderList)}" /></b></div>
<a class="button" href="javascript:void(0);"
	onclick="javascript: showPage(1)"><span><img alt="First"
	src="./view/images/arrow-stop-180-small.gif" height="9" width="12">
First</span></a><a class="button" href="javascript:void(0);"
	onclick="javascript: showPage(1)"><span><img alt="Previous"
	src="./view/images/arrow-180-small.gif" height="9" width="12">
Prev</span></a>
<div class="numbers"><span>Page:</span> <a
	href="javascript:void(0);" onclick="javascript: showPage(1)"><span
	class="current">1</span></a> <span>|</span> <a href="javascript:void(0);"
	onclick="javascript: showPage(2)"><span>2</span></a> <span>|</span> <a
	href="javascript:void(0);" onclick="javascript: showPage(3)"><span>3</span></a>
<span>|</span> <a href="javascript:void(0);"
	onclick="javascript: showPage(4)"><span>4</span></a> <span>|</span> <a
	href="javascript:void(0);" onclick="javascript: showPage(5)"><span>5</span></a>
</div>
<a class="button" href="javascript:void(0);"
	onclick="javascript: showPage(2)"><span>Next <img alt="Next"
	src="./view/images/arrow-000-small.gif" height="9" width="12"></span></a><a
	class="button last" href="javascript:void(0);"
	onclick="javascript: showPage(12)"><span>Last <img
	alt="Last" src="./view/images/arrow-stop-000-small.gif" height="9"
	width="12"></span></a></div>
<!-- End pagination-->
<div style="clear: both"></div>
</div>
<!-- End .module-table-body --></div>
<!-- End .module --></div>
</div>
<div style="clear: both;"></div>
</div>
<!-- Footer -->
<div id="footer">
<div class="container_12">
<div class="grid_12"><!-- You can change the copyright line for your own -->
<p>© 2012 <a href="http://localhost/gyvcmsdemo/webdocs/"
	target="_blank" title="GYV@2012">GetYourVenue.com</a></p>
</div>
</div>
<div style="clear: both;"></div>
</div>
<!-- End #footer --> <script src="./view/js/jquery_003.js"
	type="text/javascript" language="javascript"></script> <script
	src="./view/js/loader.js" type="text/javascript" language="javascript"></script>
<script src="./view/js/global.js" type="text/javascript"
	language="javascript"></script> <script src="./view/js/login.js"
	type="text/javascript" language="javascript"></script> <script
	src="./view/js/messages.js" type="text/javascript"
	language="javascript"></script> <script src="./view/js/lightmodal.js"
	type="text/javascript" language="javascript"></script> <script
	src="./view/js/ajaxloader.js" type="text/javascript"
	language="javascript"></script> <script src="./view/js/jquery_002.js"
	type="text/javascript" language="javascript"></script> <script
	src="./view/js/jquery_006.js" type="text/javascript"
	language="javascript"></script> <script src="./view/js/jquery_005.js"
	type="text/javascript" language="javascript"></script> <script
	src="./view/js/jquery_004.js" type="text/javascript"
	language="javascript"></script> <script src="./view/js/jquery.js"
	type="text/javascript" language="javascript"></script> <script
	src="./view/js/fileuploader.js" type="text/javascript"
	language="javascript"></script> <script src="./view/js/venue.js"
	type="text/javascript" language="javascript"></script> <script>
    var urlstr = '';
    </script>
<div id="tooltip"></div>
</div>

</div>
</div>
</body>
</html>