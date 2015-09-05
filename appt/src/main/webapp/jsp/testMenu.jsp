<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="layout-main" flush="true">
 	
 	<tiles:putAttribute name="pageTitle">Appt</tiles:putAttribute>
	<tiles:putAttribute name="pageHTMLHeadContent">&nbsp;</tiles:putAttribute>	
	<tiles:putAttribute name="pageBody">
		
		
		
		<div>
			<div id="container-fluid">
				<div class="row">
					<div id="left" class="col-sm-2">
						
					</div>
					<!-- 
					<div id="main" class="col-sm-2">
						<h3>App Home Page</h3>
						<a href="${pageContext.request.contextPath}/xxxx/xxx.html">Appt Home Page</a>
						<br/>
						<br/><br/>
						<h3>REST Test Links</h3>
						<a href="/rest/getCurrentDateTime.html">Test Current Date Time</a>
						<br/>
						<br/><br/>
						<br/><br/>	
					</div>
					 -->
					
	
					</div>
				</div>
			</div>
						
			<div ng-view></div>
		
			<script>
				var app = angular.module('myApp', ['ngRoute']);
				
				// configure our routes
			    app.config(function($routeProvider) {
			        $routeProvider

			            // route for the home page
			            .when('/CreateAppointment', {
			                templateUrl : 'CreateAppointment.jhtml',
			                controller  : 'myCtrl',
			                preload: true
			            })

			           
			    });
				//pre loading of templates
			    app.run([
                       '$route', '$templateCache', '$http', (function ($route, $templateCache, $http) {
                           var url;
                           for (var i in $route.routes) {
                               if ($route.routes[i].preload) {
                                   if (url = $route.routes[i].templateUrl) {
                                       $http.get(url, { cache: $templateCache });
                                   }
                               }
                           }
                       })
                   ]);
			    
			    app.controller('myCtrl', function($scope) {
				    $scope.firstName= "John";
				    $scope.lastName= "Doe";
				    
				});
			</script>
	</tiles:putAttribute>
	
</tiles:insertDefinition>