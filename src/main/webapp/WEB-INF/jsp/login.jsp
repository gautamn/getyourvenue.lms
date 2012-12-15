<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>GetYourVenue.com - LMS - Home</title>
			<link rel="shortcut icon" type="image/x-icon" href="http://cms.getyourvenue.com/webdocs/interface/skins/default/images/favicon.ico">
			<script>
				var JSWebURLUI = 'http://getyourvenue.com/'
				var JSWebURL = 'http://cms.getyourvenue.com/webdocs/'
				var JSWebStaticURL = 'http://cms.getyourvenue.com/'
				var JSThemeURL = 'http://cms.getyourvenue.com/webdocs/interface/skins/default/'
				var isLoggedIn = false;
				var LoggedInUserId = parseInt('0');
				var requestedPage = "home";
				var userEvent = "";
			</script>
			<link rel="stylesheet" type="text/css" href="css/lightmodal.css">
			<link rel="stylesheet" type="text/css" href="css/messagebox.css">
			<link rel="stylesheet" type="text/css" href="css/grid.css">
			<link rel="stylesheet" type="text/css" href="css/ie.css">
			<link rel="stylesheet" type="text/css" href="css/ie6.css">
			<link rel="stylesheet" type="text/css" href="css/jquery.css">
			<link rel="stylesheet" type="text/css" href="css/reset.css">
			<link rel="stylesheet" type="text/css" href="css/styles.css">
			<link rel="stylesheet" type="text/css" href="css/tablesorter.css">
			<link rel="stylesheet" type="text/css" href="css/theme-blue.css">
			<link rel="stylesheet" type="text/css" href="css/thickbox.css">
			<link rel="stylesheet" type="text/css" href="css/style1.css">
			<!--[if IE 7]> <html class="ie8"> <![endif]-->
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
		    <div id="header-status" class="rightalign"></div>
		    <!-- End #header-status -->
			<!-- Header. Main part -->
		<div>
			<div id="logo"><img src="images/logogyv.jpg" alt="GYV Admin"></div>
		</div>
		<div class="float-left">
				<div id="hdtxt">
					<img src="images/adminhdtxt.png" alt="Lead Management System">
				</div>
		
				<div class="gyvMainNav">
				        <ul id="nav" style="display:block; float:none;"></ul>
				</div>
		
		<!---SUBNAVIGATION--->
		</div>
		 <div style="clear: both;"></div>
		 <div class="wrapper">
			  <div class="container_12">
				<div class="OuterMostWrapper">
			 	<div class="grid_3">&nbsp;</div>
				<div class="grid_6">
				    <div class="module">
				    <h2><span>Login - Lead Management System</span></h2>
				    
				    <div class="module-body">
				              <span id="msg" class="notification n-error hideSection"></span>
				      
				      <c:if  test="${!empty invalidUserMsg}">
				      	<span class="error">${invalidUserMsg}</span>
				      </c:if>
				      
				      <form:form action="login.htm" method="POST"> 
				         <p>
				          <label>Email:</label>
				          <form:input path="email" id="email" class="input-medium" type="text" />
				         </p>
				         <p>
				          <label>Password:</label>
				          <form:input path="password" id="password" class="input-medium" value="" type="password" />
				         </p>
				         
				         <fieldset>
				          <input class="submit-green" value="Login" id="signIn" type="submit" />
				          <input class="submit-gray" value="Reset" type="reset" />
				          <!--<a href="javascript:void(0)" onclick="forgetPassword()">Forgot password?</a>-->
				         </fieldset>
				      </form:form>
				
				    </div> <!-- End .module-body -->
				  </div>  &nbsp;
				</div>
				<div class="grid_3">&nbsp;</div>
			</div>
		  <div style="clear:both;"></div>
		  </div>
	 			<!-- Footer -->
		 		<div id="footer">
		        	<div class="container_12">
		            	<div class="grid_12">
		                	<!-- You can change the copyright line for your own -->
		                  <p>© 2012 <a href="http://getyourvenue.com/" target="_blank" title="GYV@2012">GetYourVenue.com</a></p>
		        		</div>
		            </div>
		            <div style="clear:both;"></div>
		        </div> <!-- End #footer -->
				<script src="js/jquery_002.js" type="text/javascript" language="javascript"></script>
				<script src="js/loader.js" type="text/javascript" language="javascript"></script>
				<script src="js/global.js" type="text/javascript" language="javascript"></script>
				<script src="js/login.js" type="text/javascript" language="javascript"></script>
				<script src="js/messages.js" type="text/javascript" language="javascript"></script>
				<script src="js/lightmodal.js" type="text/javascript" language="javascript"></script>
				<script src="js/ajaxloader.js" type="text/javascript" language="javascript"></script>
				<script src="js/jquery_005.js" type="text/javascript" language="javascript"></script>
				<script src="js/jquery.js" type="text/javascript" language="javascript"></script>
				<script src="js/jquery_003.js" type="text/javascript" language="javascript"></script>
				<script src="js/jquery_004.js" type="text/javascript" language="javascript"></script>
				<script src="js/jquery_006.js" type="text/javascript" language="javascript"></script>
				<script src="js/fileuploader.js" type="text/javascript" language="javascript"></script>
				<script src="js/ajaxloader.js" type="text/javascript" language="javascript"></script>
				<script>var urlstr = '';</script>
			<div id="tooltip"></div>
			</div>
		</div>
	</div>
	</body>
</html>