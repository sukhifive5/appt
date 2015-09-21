<%@ page session="true"%>
<%@ page import="com.appt.common.utils.HTMLUtils" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

 
<html ng-app="myApp">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	
	<title><tiles:getAsString name="pageTitle" /></title>
	
	<!-- CSS Includes -->
	
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.css" rel="stylesheet">
	<link href='${pageContext.request.contextPath}/css/fullcalendar.css' rel='stylesheet' />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/calendarDemo.css" />
	<!-- JS Includes 
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/dateUtils.js"></script> -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>
	<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="https://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.9.0.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/moment.min.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/fullcalendar.js"></script>	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/gCal.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/calendar.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/calendarDemo.js"></script>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-route.js"></script>
	
	
	   
	
	


    
    
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/appt.css" />
    
    
    <meta name="viewport" content="initial-scale=1" />
    
 
		
	<!-- Define URL Path As javascript variable -->
	<script>
		var CONTEXT_PATH = "${pageContext.request.contextPath}";
	</script>
	
	
	
	<!-- Tiles Attribute for Page Specific Header Content -->
 	<tiles:insertAttribute name="pageHTMLHeadContent" />
 	<style type="text/css">
 	body { padding-top: 70px; }
 	
 	#calendar { padding-top: 20px; }
 	</style>
 	
</head>

<body>

	

		<div id="header">
			<tiles:insertAttribute name="pageHeader" />
		</div>

		<div class="center-block" id="page">
			<div id="container-fluid">
					<div class="row">
						<div id="content" class="container">
							<tiles:insertAttribute name="pageBody" />
						</div>
					</div>
			</div>
		</div>

	
	
</body>
<div id="footer">
		<tiles:insertAttribute name="pageFooter" />
	</div>
</html>
