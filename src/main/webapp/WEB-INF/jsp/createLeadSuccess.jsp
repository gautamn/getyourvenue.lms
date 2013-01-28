<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page import="com.getyourvenue.lms.model.LeadHeader" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"><head>
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
<div id="header">
    <!-- Header. Main part -->
   	<div id="header-main" class="rel">

    <!-- Header. Status part -->
    <div id="header-status" class="rightalign">
	<div>

                     <div class="">
              <span><a href="javascript:void(0);" id="logout">Logout</a></span>
              <span id="admin"> Welcome : <a href="http://localhost/gyvcmsdemo/webdocs/home">Admin</a>
                              </span>

            </div>
                </div>
        <!--<div style="clear:both;"></div>-->
    </div>
    <!-- End #header-status -->

<!-- Header. Main part -->
<div>
	<div id="logo"><img src="./view/images/logogyv.jpg" alt="GYV Admin"></div>
</div>

<div class="float-left">
		<div id="hdtxt"><img src="./view/images/adminhdtxt.png" alt="admin control"></div>

<div class="gyvMainNav">
                    <ul id="nav" style="display:block; float:none;">
                        
<li style="float:right;">
<div class="menuLink">
  <div id="fdv" style="position:absolute; background:#fff; width:200px; border:1px solid #999; padding:10px; margin:34px 0 0 -163px; display:none; font-size:12px; color:#0063BE">
                          <div class="clear"></div>
<!--
<a class="noHover" href="http://localhost/gyvcmsdemo/webdocs/changepassword" style="background:url('http://localhost/gyvcmsdemo/webdocs/interface/skins/default//images/arrow.gif') no-repeat 5px; padding-left:28px; color:#000;">Change Password</a> -->
                                                            <div class="clear"></div>

<a class="noHover" href="http://localhost/gyvcmsdemo/webdocs/adminusers" style="background:url('http://localhost/gyvcmsdemo/webdocs/interface/skins/default//images/arrow.gif') no-repeat 5px; padding-left:28px; color:#000;">Admin</a>
                                                          </div>
</div>
</li>

                                                </ul>

</div>
    </div>
    
    <b>Lead Created Successfully</b>

<div class="module">
    <h2><span> Lead Information</span></h2>
    <div class="module-table-body">
    <table id="myTable" class="tablesorter">
              <tbody>
                <tr>
                    <td class="align-left"><B>LeadDate:</B><c:out value="${leadHeader.createdStamp}"/></td>
			        <td class="align-left"><B>PreferredNoOfGuest:</B><c:out value="${leadHeader.pre_no_of_guest}"/></td>
			        <td class="align-left"><B>PreferredDate:</B><c:out value="${leadHeader.preferDate}"/></td>
			    </tr>
			    <tr>    
			        <td class="align-left"><B>FromChannel:</B><c:out value="${leadHeader.fromChannel}"/></td>
			        <td class="align-left"><B>Budget:</B><c:out value="${leadHeader.budget}"/></td>
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
                    <td class="align-left"><B>LeadName:</B><c:out value="${leadContact.clientName}"/></td>
			        <td class="align-left"><B>ContactInfo:</B><c:out value="${leadContact.addressInfo}"/></td>
			        <td class="align-left"><B>Email:</B><c:out value="${leadContact.emailId}"/></td>
			        <td class="align-left"><B>Phone No:</B><c:out value="${leadContact.phoneNumber}"/></td>
			    </tr>
			   </c:forEach>  
              </tbody>
     </table>
    </div>
    
    <h2><span> Activity History</span></h2>

    <div class="module-table-body">
    <table id="myTable" class="tablesorter">
              <tbody>
                 <c:forEach var="leadHist" items="${leadHeader.leadHistory}">
                      <tr>
                         <td class="align-left"><B>Created Date:</B><c:out value="${leadHist.createdStamp}"/></td>
                         <td class="align-left"><B>Status:</B><c:out value="${leadHist.statusId}"/></td>
                         <td class="align-left"><B>Assigned From:</B><c:out value="${leadHist.assignedFrom}"/></td>
                         <td class="align-left"><B>Assigned To:</B><c:out value="${leadHist.assignedTo}"/></td>
                      </tr>
                 </c:forEach>
              </tbody>
     </table>
    </div>
    
    <h2><span> Allied Services</span></h2>

    <div class="module-table-body">
    <table id="myTable" class="tablesorter">
              <tbody>
                 <c:forEach var="leadAlliedServices" items="${leadHeader.alliedService}">
                      <tr>
                         <td class="align-left"><B>Allied Services:</B><c:out value="${leadAlliedServices.alliedServicesId}"/></td>
                      </tr>
                 </c:forEach>
              </tbody>
     </table>
    </div>
     <!-- End .module-table-body -->
</div> <!-- End .module -->
</div>
	</div>
  <div style="clear:both;"></div>
  </div>
	 <!-- Footer -->
 <div id="footer">
        	<div class="container_12">
            	<div class="grid_12">
                	<!-- You can change the copyright line for your own -->
                  <p>© 2012 <a href="http://localhost/gyvcmsdemo/webdocs/" target="_blank" title="GYV@2012">GetYourVenue.com</a></p>
        		</div>
            </div>
            <div style="clear:both;"></div>
        </div> <!-- End #footer -->
<script src="./view/js/jquery_003.js" type="text/javascript" language="javascript"></script>
<script src="./view/js/loader.js" type="text/javascript" language="javascript"></script>
<script src="./view/js/global.js" type="text/javascript" language="javascript"></script>
<script src="./view/js/login.js" type="text/javascript" language="javascript"></script>
<script src="./view/js/messages.js" type="text/javascript" language="javascript"></script>
<script src="./view/js/lightmodal.js" type="text/javascript" language="javascript"></script>
<script src="./view/js/ajaxloader.js" type="text/javascript" language="javascript"></script>
<script src="./view/js/jquery_002.js" type="text/javascript" language="javascript"></script>
<script src="./view/js/jquery_006.js" type="text/javascript" language="javascript"></script>
<script src="./view/js/jquery_005.js" type="text/javascript" language="javascript"></script>
<script src="./view/js/jquery_004.js" type="text/javascript" language="javascript"></script>
<script src="./view/js/jquery.js" type="text/javascript" language="javascript"></script>
<script src="./view/js/fileuploader.js" type="text/javascript" language="javascript"></script>
<script src="./view/js/venue.js" type="text/javascript" language="javascript"></script>
<script>
    var urlstr = '';
    </script>
<div id="tooltip"></div>
</div>

</div></div></body></html>