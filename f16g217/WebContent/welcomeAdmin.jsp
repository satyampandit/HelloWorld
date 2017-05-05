<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Administrator</title>
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
		<h:outputText value="Administrator" />
		<br/>
		<h:outputText value="Welcome " />
		<h:outputText value="#{userLoginBean.userName}" />
	</h3>
	<hr>
	<br />
	<center>
		<h:form>
			<h:commandLink action="index.jsp" actionListener="#{databaseAccess.resetRenders}">Home</h:commandLink>&nbsp;&nbsp;&nbsp; 
			<h:commandLink action="logout.jsp" >Logout</h:commandLink>&nbsp;&nbsp;&nbsp; 
			<h:commandLink action="terminateConnection.jsp">Terminate Connection</h:commandLink>
		</h:form>
		<hr>
		<br>
			<a href="databaseAccessMenu.jsp">Database Access Menu</a> &nbsp;&nbsp;&nbsp;
			<a href="courseUpload.jsp"> Upload Course Roster</a> &nbsp;&nbsp;&nbsp;
			<a href="studentUpload.jsp">Upload Student data </a> &nbsp;&nbsp;&nbsp;
			
		<hr>
		<br>
	</center>
	
</f:view>
</body>
</html>