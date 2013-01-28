<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page import="com.getyourvenue.lms.model.LeadHeader"%>
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
	<div class="menuLink">
	<div id="fdv"
		style="position: absolute; background: #fff; width: 200px; border: 1px solid #999; padding: 10px; margin: 34px 0 0 -163px; display: none; font-size: 12px; color: #0063BE">
	<div class="clear"></div>
	<!--
<a class="noHover" href="http://localhost/gyvcmsdemo/webdocs/changepassword" style="background:url('http://localhost/gyvcmsdemo/webdocs/interface/skins/default//images/arrow.gif') no-repeat 5px; padding-left:28px; color:#000;">Change Password</a> -->
	<div class="clear"></div>

	<a class="noHover"
		href="http://localhost/gyvcmsdemo/webdocs/adminusers"
		style="background: url('http://localhost/gyvcmsdemo/webdocs/interface/skins/default//images/arrow.gif') no-repeat 5px; padding-left: 28px; color: #000;">Admin</a>
	</div>
	</div>
	</li>

</ul>

</div>
</div>
<form action="editLeadAction.htm" method="post">
<div class="module">
<h2><span> Lead Information</span></h2>
<div class="module-table-body">
<table id="myTable" class="tablesorter">
	<tbody>
		<tr>
		<input type="hidden" name="leadid" value="${leadHeader.leadId}">
			<td class="align-left"><B>LeadDate:</B><input type="text" value="${leadHeader.createdStamp}"></td>
			<td class="align-left"><B>Status:</B><input type="text" name="statusId" value="${leadHeader.statusId}"></input></td>
			<td class="align-left"><B>PreferredNoOfGuest:</B><input type="text" name="prefnoofguest" value="${leadHeader.pre_no_of_guest}"></td>
			<td class="align-left"><B>PreferredDate:</B><input type="text" name="date" value="${leadHeader.preferDate}"></td>
		</tr>
		<tr>
			<td class="align-left"><B>FromChannel:</B><input type="text" name="frmchannel" value="${leadHeader.fromChannel}"></td>
			<td class="align-left"><B>Budget:</B><input type="text" name="budget" value="${leadHeader.budget}"></td>
			<td class="align-left"><B>Assigned To:</B><input type="text" name="assignto" value="${leadHeader.assignTo}"></td>
		</tr>
	</tbody>
</table>
</div>

<h2><span> Contact Information</span></h2>

<div class="module-table-body">
<table id="myTable" class="tablesorter">
	<tbody>
		<c:forEach var="leadContact" items="${leadHeader.contactInfo}">
			<tr>
				<td class="align-left"><B>LeadName:</B><input type="text" name="leadname" value="${leadContact.clientName}"></td>
				<td class="align-left"><B>ContactInfo:</B><input type="text" name="contactinfo" value="${leadContact.addressInfo}"></td>
				<td class="align-left"><B>Email:</B><input type="text" name="email" value="${leadContact.emailId}"></td>
				<td class="align-left"><B>Phone No:</B><input type="text" name="phoneno" value="${leadContact.phoneNumber}"></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>

<h2><span> Allied Services</span></h2>

<div class="module-table-body">
<table id="myTable" class="tablesorter">
	<tbody>
	<tr>
	<td class="align-left"><B>Allied Services:</B></td>
					<td class="align-left"><SELECT multiple id="allied" name="allied">
		<c:forEach var="leadAlliedServices" items="${leadHeader.alliedService}">
					<c:choose>
					<c:when test="${leadAlliedServices.alliedServiceComposite.alliedServicesId eq 'Band, ghori, baggi services'}" >
						<OPTION VALUE="1" selected>Band, ghori, baggi services</option>
					</c:when>
				    <c:otherwise>
				        <OPTION VALUE="1" >Band, ghori, baggi services</option>
				    </c:otherwise>
				    </c:choose>
				    <c:choose>
				    <c:when test="${leadAlliedServices.alliedServiceComposite.alliedServicesId eq 'Bridal Make Up'}" >
						<OPTION VALUE="2" selected>Bridal Make Up</option>
					</c:when>
				    <c:otherwise>
				        <OPTION VALUE="2" >Bridal Make Up</option>
				    </c:otherwise>
				    </c:choose>
				    <c:choose>
				    <c:when test="${leadAlliedServices.alliedServiceComposite.alliedServicesId eq 'Celebrities'}" >
						<OPTION VALUE="3" selected>Celebrities</option>
					</c:when>
				    <c:otherwise>
				        <OPTION VALUE="3" >Celebrities</option>
				    </c:otherwise>
				    </c:choose>
				    <c:choose>
				    <c:when test="${leadAlliedServices.alliedServiceComposite.alliedServicesId eq 'DJ and Sound Systems'}" >
						<OPTION VALUE="4" selected>DJ and Sound Systems</option>
					</c:when>
				    <c:otherwise>
				        <OPTION VALUE="4" >DJ and Sound Systems</option>
				    </c:otherwise>
				    </c:choose>
				    <c:choose>
				    <c:when test="${leadAlliedServices.alliedServiceComposite.alliedServicesId eq 'Fireworks'}" >
						<OPTION VALUE="5" selected>Fireworks</option>
					</c:when>
				    <c:otherwise>
				        <OPTION VALUE="5" >Fireworks</option>
				    </c:otherwise>
				    </c:choose>
				    <c:choose>
				    <c:when test="${leadAlliedServices.alliedServiceComposite.alliedServicesId eq 'The Grooms Wedding Attires'}" >
						<OPTION VALUE="6" selected>The Grooms Wedding Attires</option>
					</c:when>
				    <c:otherwise>
				        <OPTION VALUE="6" >The Grooms Wedding Attires</option>
				    </c:otherwise>
				    </c:choose>
				    <c:choose>
				    <c:when test="${leadAlliedServices.alliedServiceComposite.alliedServicesId eq 'Photography'}" >
						<OPTION VALUE="7" selected>Photography</option>
					</c:when>
				    <c:otherwise>
				        <OPTION VALUE="7" >Photography</option>
				    </c:otherwise>
				    </c:choose>
				    <c:choose>
				    <c:when test="${leadAlliedServices.alliedServiceComposite.alliedServicesId eq 'Lodging & Transportation'}" >
						<OPTION VALUE="8" selected>Lodging & Transportation</option>
					</c:when>
				    <c:otherwise>
				        <OPTION VALUE="8" >Lodging & Transportation</option>
				    </c:otherwise>
				    </c:choose>
				    <c:choose>
				    <c:when test="${leadAlliedServices.alliedServiceComposite.alliedServicesId eq 'Varmala Theme'}" >
						<OPTION VALUE="9" selected>Varmala Theme</option>
					</c:when>
				    <c:otherwise>
				        <OPTION VALUE="9" >Varmala Theme</option>
				    </c:otherwise>
				    </c:choose>
				    <c:choose>
				    <c:when test="${leadAlliedServices.alliedServiceComposite.alliedServicesId eq 'Catering services'}" >
						<OPTION VALUE="10" selected>Catering services</option>
					</c:when>
				    <c:otherwise>
				        <OPTION VALUE="10" >Catering services</option>
				    </c:otherwise>
				    </c:choose>
				    <c:choose>
				    <c:when test="${leadAlliedServices.alliedServiceComposite.alliedServicesId eq 'Wedding decor'}" >
						<OPTION VALUE="11" selected>Wedding decor</option>
					</c:when>
				    <c:otherwise>
				        <OPTION VALUE="11" >Wedding decor</option>
				    </c:otherwise>
				    </c:choose>
				    
				    <c:choose>
				    <c:when test="${leadAlliedServices.alliedServiceComposite.alliedServicesId eq 'Exclusive Wedding Lehengas for the Stunning Bride in You!'}" >
						<OPTION VALUE="11" selected>Exclusive Wedding Lehengas for the Stunning Bride in You!</option>
					</c:when>
				    <c:otherwise>
				        <OPTION VALUE="11" >Exclusive Wedding Lehengas for the Stunning Bride in You!</option>
				    </c:otherwise>
				    </c:choose>
				    
				    <c:choose>
				    <c:when test="${leadAlliedServices.alliedServiceComposite.alliedServicesId eq 'Wedding Planning'}" >
						<OPTION VALUE="11" selected>Wedding Planning</option>
					</c:when>
				    <c:otherwise>
				        <OPTION VALUE="11" >Wedding Planning</option>
				    </c:otherwise>
				    </c:choose>
		</c:forEach>
		</SELECT></td>
			</tr>
	</tbody>
</table>
<div class="module-table-body">
<table id="myTable" class="tablesorter">
	<tbody>
		<tr>
			<td class="align-center"><B><input type="submit"
				name="submit" value="Save Lead" /></B></td>
		</tr>
	</tbody>
</table>
</div>
</div>
<!-- End .module-table-body --></div>
</form>
<!-- End .module --></div>

</div>
<div style="clear: both;"></div>

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
<!-- End #footer -->
<script src="./view/js/jquery_003.js" type="text/javascript"
	language="javascript"></script>
<script src="./view/js/loader.js" type="text/javascript"
	language="javascript"></script>
<script src="./view/js/global.js" type="text/javascript"
	language="javascript"></script>
<script src="./view/js/login.js" type="text/javascript"
	language="javascript"></script>
<script src="./view/js/messages.js" type="text/javascript"
	language="javascript"></script>
<script src="./view/js/lightmodal.js" type="text/javascript"
	language="javascript"></script>
<script src="./view/js/ajaxloader.js" type="text/javascript"
	language="javascript"></script>
<script src="./view/js/jquery_002.js" type="text/javascript"
	language="javascript"></script>
<script src="./view/js/jquery_006.js" type="text/javascript"
	language="javascript"></script>
<script src="./view/js/jquery_005.js" type="text/javascript"
	language="javascript"></script>
<script src="./view/js/jquery_004.js" type="text/javascript"
	language="javascript"></script>
<script src="./view/js/jquery.js" type="text/javascript"
	language="javascript"></script>
<script src="./view/js/fileuploader.js" type="text/javascript"
	language="javascript"></script>
<script src="./view/js/venue.js" type="text/javascript"
	language="javascript"></script>
<script>
    var urlstr = '';
    </script>
<div id="tooltip"></div>
</div>

</div>
</div>
</body>
</html>