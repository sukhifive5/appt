<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div>
	Phone Number: <input type="text" ng-model="phoneNumber">  <input type="checkbox" name="newCustomer" value="true"> Create new customer account<br>
	First Name: <input type="text" ng-model="firstName"><br>
	Last Name: <input type="text" ng-model="lastName"><br>
	Service: <input type="text" ng-model="service"><br>
	Service By: <input type="text" ng-model="serviceBy"><br>
	Time: <input type="text" ng-model="time"><br>
	<br>					
	<button>Create Appointment</button>
</div>