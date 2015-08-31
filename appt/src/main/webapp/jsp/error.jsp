<%@ page isErrorPage="true" %>
<%@ page import="com.appt.common.utils.HTMLUtils" %>

<%
	// get error status/message/uri	
	Object statusCode = request.getAttribute("javax.servlet.error.status_code"); 
	Object exceptionType = request.getAttribute("javax.servlet.error.exception_type"); 
	Object message = request.getAttribute("javax.servlet.error.message"); 
	String errorRequestURI = (String) request.getAttribute("javax.servlet.error.request_uri");
%>

<html>
	<body>		
			<div>
				<h2>&nbsp;&nbsp;An Error has occurred in the Appt Application:</h2>
				<center>
				<table cellpadding="4" cellspacing="0" border="1" width="90%">
				    <tr>
						<td width="20%" valign="top">Status Code</td> 
						<td width="80%" valign="top"><%=statusCode%>&nbsp;</td>
				    </tr>
				    <tr>
						<td width="20%" valign=TOP>Exception Type</td> 
						<td width="80%" valign=TOP><%=exceptionType%>&nbsp;</td>
				    </tr>
				    <tr>
						<td width="20%" valign=TOP>Message</td> 
						<td width="80%" valign=TOP><%=message%>&nbsp;</td>
				    </tr>
				    <tr>
						<td width="20%" valign=TOP>Error URI</td> 
						<td width="80%" valign=TOP><%=errorRequestURI%>&nbsp;</td>
				    </tr>
				    <tr>
						<td width="20%" valign=TOP>Exception</td> 
						<td width="80%" valign=TOP>
						    <%
							if (exception != null) {
								String stackTrace = HTMLUtils.forceWrappingInHTML(HTMLUtils.getStackTrace(exception), 70);
							    out.print("<PRE>");
							    out.print(stackTrace);
							    out.print("</PRE>");
							}    
						    %>&nbsp;
						</td>
				    </tr>
				    <tr>
						<td width="20%" valign=TOP>Root Cause</td> 
						<td>
						</td>
				    </tr>
				</table>
				<br/><br/><br/>
				</center>
			</div>
	</body>
</html>