<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Database Login</title>

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

	<h3 align="center">Database Login</h3>
	<hr>
	<br />
	<center> <a href="index.jsp">Home</a> </center>
	<br /> <hr> <br />
	<center>
		<h:form>
			<h:outputText value="* denotes Required fields"/>
			<h:panelGrid columns="3">
				<h:outputText value="User Name:" />
				<h:outputText value="*" />
				<h:inputText id="userName" value="#{databaseLoginBean.userName}" />

				<h:outputText value="Password:" />
				<h:outputText value="*" />
				<h:inputSecret  id="password"  value="#{databaseLoginBean.password}" />
				
				<h:outputText value="Host:" />
				<h:outputText value="*" />
				<h:selectOneListbox id="host" value="#{databaseLoginBean.host}" size="1">
						<f:selectItem itemValue="131.193.209.54" itemLabel="Server 54"/>
						<f:selectItem itemValue="131.193.209.57" itemLabel="Server 57"/>
						<f:selectItem itemValue="localHost" itemLabel="Local Host"/>
				</h:selectOneListbox>
				
				<h:outputText value="RDBMS:" />
				<h:outputText value="*" />
				<h:selectOneListbox id="rdbms" value="#{databaseLoginBean.rdbms}" size="1">
						<f:selectItem itemValue="mySQl" itemLabel="MySQL"/>
						<f:selectItem itemValue="oracle" itemLabel="Oracle"/>
						<f:selectItem itemValue="db2" itemLabel="DB2"/>
				</h:selectOneListbox>
				
				<h:outputText value="Database Schema:" />
				<h:outputText value="*" />
				<h:inputText id="dbSchema" value="#{databaseLoginBean.dbSchema}" />
				
				<h:outputText value="Port No.:" />
				<h:outputText value="*" />
				<h:inputText id="portNo" value="#{databaseLoginBean.portNo}" />
				
				<h:commandButton type="submit" value="Login"  action="#{databaseAccess.dbLogin }"/>
			</h:panelGrid>
			 <h:outputText rendered="#{databaseLoginBean.renderMessage}" value="#{databaseLoginBean.errorMessage}" styleClass="color-red"/>
		</h:form>
	</center>
	
</f:view>
</body>
</html>