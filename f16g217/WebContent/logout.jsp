<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout Page</title>
<style>
{ margin: 0; padding: 0; }
body { 
        background: url('files/background.jpg') no-repeat center center fixed; 
        -webkit-background-size: cover;
        -moz-background-size: cover;
        -o-background-size: cover;
        background-size: cover;
}

.color-red {
    color: #F00;
}
</style>
</head>
<body>
<f:view>
	<h3 align="center">
		<h:outputText value="Logout" />
	</h3>
	<hr>
	<br/>
	<center> 
		<h:outputText value="Are you sure you want to Logout? " />
		<br/>
		<h:form>
		<h:commandLink action="userLogin.jsp" actionListener="#{databaseAccess.calculateEndTime}">YES</h:commandLink>
		<!-- <a href="userLogin.jsp">YES</a> &nbsp;&nbsp;&nbsp;&nbsp; --></h:form>
	 	<a href="javascript:history.back()">NO</a> 
	</center>
	<br /> <hr> <br />
	<center>
		
	</center>
</f:view>
</body>
</html>