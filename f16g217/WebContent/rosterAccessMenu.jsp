<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Roster Access Menu</title>
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
		<h:outputText value="Instructor" />
		<br/>
		<h:outputText value="Roster Access Menu" />
	</h3>
	<hr>
	<br />
	<center> 
		<h:form>
				<h:commandLink action="welcomeInstructor.jsp" actionListener="#{databaseAccess.resetRenders}">Back</h:commandLink>&nbsp;&nbsp;&nbsp; 
				<h:commandLink action="logout.jsp" >Logout</h:commandLink>&nbsp;&nbsp;&nbsp; 
				<h:commandLink action="terminateConnection.jsp" >Terminate Connection</h:commandLink>
		<hr/>
		<br/>
		<h:panelGrid columns="2">
		<h:commandButton type="submit" value="Select a course CRN:"  action="#{databaseAccess.populateCrnList}"/>
		<h:selectOneMenu value="#{rosterAccessMenuBean.selectedCrn}">
    		<f:selectItems value="#{rosterAccessMenuBean.crnList}" />
		</h:selectOneMenu>
		
		<h:outputText value="Select an Exam type:" />
		<h:selectOneMenu value="#{rosterAccessMenuBean.selectedExamType}">
    		<f:selectItems value="#{rosterAccessMenuBean.examTypeList}" />
		</h:selectOneMenu>
		
		<h:outputText value="Select to View Roster:" />
		<h:selectOneListbox id="rosterTypeID" value="#{rosterAccessMenuBean.rosterType}" size="1">
					<f:selectItem itemValue="studentRoster" itemLabel="Student Roster"/>
					<f:selectItem itemValue="testRoster" itemLabel="Test Roster"/>
		</h:selectOneListbox>
		
		<h:outputText value="Action:" />
		<h:selectOneListbox id="actionType" value="#{rosterAccessMenuBean.action}" size="1">
					<f:selectItem itemValue="view" itemLabel="View Roster"/>
					<f:selectItem itemValue="delete" itemLabel="Delete Roster"/>
		</h:selectOneListbox>
		
		<h:commandButton type="submit" value="Submit"  action="#{databaseAccess.actionRoster}"/>
		<h:commandButton type="submit" value="Download"  action="#{databaseAccess.downloadFileMethod}"/>
		</h:panelGrid>
		
		
		<br/>
		<hr/>
		<br/>
		<h:outputText rendered="#{rosterAccessMenuBean.renderMessage}" value="#{rosterAccessMenuBean.message}" styleClass="color-red"/>
		 
		<div style="background-attachment: scroll; overflow:auto; height:400px; background-repeat: repeat">
			<t:dataTable value="#{rosterAccessMenuBean.testRosterResultSet}"
					 var="row"
					 rendered="#{rosterAccessMenuBean.renderTestRosterResultSet}"
					 border="1" cellspacing="0" cellpadding="1"
					 columnClasses="columnClass1 border"
					 headerClass="headerClass"
					 footerClass="footerClass"
					 rowClasses="rowClass2"
					 styleClass="dataTableEx"
					 width="900">
				<t:columns var="col" value="#{rosterAccessMenuBean.testRosterColumns}">
					<f:facet name="header">
						<t:outputText styleClass="outputHeader" value="#{col}" />
					</f:facet>
					<t:outputText styleClass="outputText" value="#{row[col]}" />
				</t:columns>
			</t:dataTable>
		</div>	
	
		<div style="background-attachment: scroll; overflow:auto; height:400px; background-repeat: repeat">
			<t:dataTable value="#{rosterAccessMenuBean.studentRosterResultSet}"
					 var="row"
					 rendered="#{rosterAccessMenuBean.renderStudentRosterResultSet}"
					 border="1" cellspacing="0" cellpadding="1"
					 columnClasses="columnClass1 border"
					 headerClass="headerClass"
					 footerClass="footerClass"
					 rowClasses="rowClass2"
					 styleClass="dataTableEx"
					 width="900">
				<t:columns var="col" value="#{rosterAccessMenuBean.studentRosterColumns}">
					<f:facet name="header">
						<t:outputText styleClass="outputHeader" value="#{col}" />
					</f:facet>
					<t:outputText styleClass="outputText" value="#{row[col]}" />
				</t:columns>
			</t:dataTable>
		</div>	

		</h:form>
	</center>
</f:view>
</body>
</html>