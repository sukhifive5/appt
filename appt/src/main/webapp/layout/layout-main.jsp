<%@ page session="true"%>
<%@ page import="com.appt.common.utils.HTMLUtils" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

 
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	
	<title><tiles:getAsString name="pageTitle" /></title>
	
	<!-- CSS Includes -->
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- JS Includes 
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/dateUtils.js"></script> -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>
	<script type="text/javascript" src="https://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.9.0.js"></script>
		
	<!-- Define URL Path As javascript variable -->
	<script>
		var CONTEXT_PATH = "${pageContext.request.contextPath}";
	</script>
	
	<!-- Tiles Attribute for Page Specific Header Content -->
 	<tiles:insertAttribute name="pageHTMLHeadContent" />
</head>

<body>
	<div id="wrapper">

		<div id="header">
			<tiles:insertAttribute name="pageHeader" />
		</div>

		<div id="page">
			<div id="container-fluid">
					<div class="row">
						<div id="content" class="col-sm-12">
							<tiles:insertAttribute name="pageBody" />
						</div>
					</div>
			</div>
		</div>

	</div>
	<div id="footer">
		<tiles:insertAttribute name="pageFooter" />
	</div>
</body>
</html>
