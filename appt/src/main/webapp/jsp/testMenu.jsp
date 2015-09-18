<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="layout-main" flush="true">
 	
 	<tiles:putAttribute name="pageTitle">Appt</tiles:putAttribute>
	<%-- <tiles:putAttribute name="pageHTMLHeadContent">&nbsp;</tiles:putAttribute>	--%>
	<tiles:putAttribute name="pageBody">		
		<div ng-view></div>	
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/app.js"></script>

	</tiles:putAttribute>
	
</tiles:insertDefinition>