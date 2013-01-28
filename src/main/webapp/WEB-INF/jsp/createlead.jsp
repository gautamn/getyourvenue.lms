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

<script>

 

</script>
<body class="homeinner" onload="autoload();">
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
	<div class="clear"></div>

	<a class="noHover"
		href="http://localhost/gyvcmsdemo/webdocs/adminusers"
		style="background: url('http://localhost/gyvcmsdemo/webdocs/interface/skins/default//images/arrow.gif') no-repeat 5px; padding-left: 28px; color: #000;">Admin</a>
	</div>
	</div>
	</li>
</ul>

</div>
<!---SUBNAVIGATION--->
<div id="subnav">
<div class="">
<div class="float-right "></div>
<!-- End. .grid_12--></div>
<!-- End. .container_12 -->
<div style="clear: both;"></div>
</div>
<!-- End #subnav --></div>


<form action="createLeadAction.htm" method="post">
<div class="module">
<h2><span> Lead Information</span></h2>
<div class="module-table-body">
<table id="myTable" class="tablesorter">
	<tbody>
		<tr>
			<td class="align-left"><B>PreferredNoOfGuest: </B><input
				type="text" name="prefnoofguest" value="" maxlength="10" /></td>
			<td class="align-left"><B>PreferredDate: </B><input name="date"
				type="date" value=""></td>
		</tr>
		<tr>
			<td class="align-left"><B>FromChannel: </B><input type="text"
				name="frmchannel" value="" maxlength="100" /></td>
			<td class="align-left"><B>Budget: </B><input type="text"
				name="budget" value="" maxlength="10" /></td>
			<td class="align-left"><B>Assign To: </B><input type="text"
				name="assignto" value="" maxlength="100" /></td>
			<td class="align-left"><B>Uploader Login: </B><input type="text"
				name="uploadlogin" value="" maxlength="100" /></td>
			<td class="align-left"><B>Approver Login: </B><input type="text"
				name="approvelogin" value="" maxlength="100" /></td>
		</tr>
	</tbody>
</table>
</div>

<h2><span> Contact Information</span></h2>

<div class="module-table-body">
<table id="myTable" class="tablesorter">
	<tbody>
		<tr>
			<td class="align-left"><B>LeadName: </B><input type="text"
				name="leadname" value="" maxlength="100" /></td>
			<td class="align-left"><B>Address Info: </B><input type="text"
				name="contactinfo" value="" maxlength="100" /></td>
			<td class="align-left"><B>Email: </B><input type="text"
				name="email" value="" maxlength="100" /></td>
			<td class="align-left"><B>Phone No: </B><input type="text"
				name="phoneno" value="" maxlength="20" /></td>
		</tr>
	</tbody>
</table>
</div>

<h2><span> Allied Services</span></h2>

<div class="module-table-body">
<table id="myTable" class="tablesorter">
	<tbody>
		<tr>
			<td class="align-left"><B>Allied Services: </B></td>
			<td class="align-left"><SELECT multiple id="allied" name="allied">
				<OPTION VALUE="1" >Band, ghori, baggi services</option>
				<OPTION VALUE="2" >Bridal Make Up</option>
				<OPTION VALUE="3" >Celebrities</option>
				<OPTION VALUE="4" >DJ and Sound Systems</option>
				<OPTION VALUE="5" >Fireworks</option>
				<OPTION VALUE="6" >The Grooms Wedding Attires</option>
				<OPTION VALUE="7" >Photography</option>
				<OPTION VALUE="8" >Lodging & Transportation</option>
				<OPTION VALUE="9" >Varmala Theme</option>
				<OPTION VALUE="10" >Catering services</option>
				<OPTION VALUE="11" >Wedding decor</option>
				<OPTION VALUE="12" >Exclusive Wedding Lehengas for the Stunning Bride in You!</option>
				<OPTION VALUE="13" >Wedding Planning</option>
			</SELECT></td>
		</tr>
	</tbody>
</table>
</div>
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
<!-- End .module-table-body --></div>
<!-- End .module --></form>
</div>
</div>
<div style="clear: both;"></div>
</div>
<!-- Footer -->
<div id="footer">
<div class="container_12">
<div class="grid_12"><!-- You can change the copyright line for your own -->
<p>Â© 2012 <a href="http://localhost/gyvcmsdemo/webdocs/"
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