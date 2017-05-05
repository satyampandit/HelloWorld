<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login</title>
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

	<h3 align="center">User Login</h3>
	<hr>
	<br />
	<center> <a href="index.jsp">Home</a>&nbsp;&nbsp;&nbsp; 
	<h:form>
	<h:commandLink action="terminateConnection.jsp">Terminate Connection</h:commandLink>
	 </h:form></center>
	<br /> <hr> <br />
	<center>
		<h:form>
			<h:outputText value="* denotes Required fields"/>
			<h:panelGrid columns="3">
				<h:outputText value="User Type:" />
				<h:outputText value="*" />
				<h:selectOneListbox id="userType" value="#{userLoginBean.userType}" size="3">
						<f:selectItem itemValue="student" itemLabel="Student"/>
						<f:selectItem itemValue="instructor" itemLabel="Faculty"/>
						<f:selectItem itemValue="admin" itemLabel="Admin"/>
				</h:selectOneListbox>

				<h:outputText value="User Name:" />
				<h:outputText value="*" />
				<h:inputText id="userName" value="#{userLoginBean.userName}" />

				<h:outputText value="Password:" />
				<h:outputText value="*" />
				<h:inputSecret id="password" value="#{userLoginBean.password}" />
				
			
				<h:commandButton type="submit" value="Login"  action="#{databaseAccess.userLogin}"/>
			</h:panelGrid>
			 <h:outputText rendered="#{userLoginBean.renderMessage}" value="#{userLoginBean.errorMessage}" styleClass="color-red"/>
		</h:form>
	</center>
	
</f:view>
</body>
</html>