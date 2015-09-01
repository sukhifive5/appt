<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="layout-main" flush="true">
 
 	<tiles:putAttribute name="pageTitle">Appt</tiles:putAttribute>
	<tiles:putAttribute name="pageHTMLHeadContent">&nbsp;</tiles:putAttribute>
	
	<tiles:putAttribute name="pageBody">
		<script>
			var app = angular.module('myAppt', []);
			app.controller('apptInfo', function($scope) {
			    $scope.name = "John",
			    $scope.phoneNumber = "111-111-1111"
			    $scope.myVar = false;
			    $scope.toggle = function() {
			        $scope.myVar = !$scope.myVar;
			    }
			});
		</script>
		
		<div>
			<div id="container-fluid">
				<div class="row">
					<div id="left" class="col-sm-2">
						
					</div>
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
					<ng-include src="template"></ng-include>
					<script type="text/ng-template" id="page1">
					<div data-ng-app="myAppt" ng-controller="apptInfo" class="col-sm-4">

						<h2>Add Appointment</h2>
						
						Name: <input type="text" ng-model="name">
						Phone number: <input type="text" ng-model="phoneNumber">
						Service: <input type="text" ng-model="service">
						Service by: <input type="text" ng-model="serviceBy">
						Time: <input type="text" ng-model="time">
						<br/>
						<br/><br/>
						<br/><br/>
						
					</div>
					</script>
					<div class="col-sm-2">
						<button ng-click="count = count + 1" ng-init="count=0">
							  Submit
							  
							</button>
						</div>
				</div>
			</div>			
		</div>
	</tiles:putAttribute>
	
</tiles:insertDefinition>