<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Schedule Data Upload </title>
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
		<h:outputText value="Test Upload " />
	</h3>
	<hr/>
	<br/>
	<center>
		<h:form>
				<h:commandLink action="welcomeInstructor.jsp" actionListener="#{databaseAccess.resetRenders}">Back</h:commandLink>&nbsp;&nbsp;&nbsp; 
				<h:commandLink action="logout.jsp">Logout</h:commandLink>&nbsp;&nbsp;&nbsp; 
				<h:commandLink action="terminateConnection.jsp" >Terminate Connection</h:commandLink>
			</h:form>
		<hr/>
		<br/>
		<h:form enctype="multipart/form-data">
		<h:panelGrid columns="2">
			<h:outputText value="Course Name:" />
			<h:inputText id="courseName" value="#{uploadFileBean.courseName}" />
			<h:outputText value="Course Code:" />
			<h:inputText id="courseCode" value="#{uploadFileBean.courseCode}" />
			<h:outputText value="CRN:" />
			<h:inputText id="crn" value="#{uploadFileBean.selectedCrn}" />
			<h:outputLabel value="Choose file Type:" />
			<h:selectOneListbox id="fileType" value="#{uploadFileBean.fileType}" size="2">
						<f:selectItem itemValue="csvType" itemLabel="CSV File"/>
						<f:selectItem itemValue="tsvType" itemLabel="TSV File"/>
			</h:selectOneListbox>
			<h:outputLabel value="Select a file to upload test schedule data:" />
    		<t:inputFileUpload value="#{uploadFileBean.uploadedFile}" accept=".csv,.txt" />
    		<h:outputText value="Start Date (dd-mm-yyyy):" />
			<h:inputText id="startDate" value="#{uploadFileBean.startDate}">
			</h:inputText>	
			<h:outputText value="End Date (dd-mm-yyyy):" />
			<h:inputText id="endDate" value="#{uploadFileBean.endDate}">
			</h:inputText>
			<h:outputText value="Test Duration:" />
			<h:inputText id="duration" value="#{uploadFileBean.duration}" />
			<h:outputText value="Exam Type:" />
			<h:selectOneListbox id="examType" value="#{uploadFileBean.examType}" size="2">
						<f:selectItem itemValue="exam01" itemLabel="Exam01"/>
						<f:selectItem itemValue="exam02" itemLabel="Exam02"/>
						<f:selectItem itemValue="exam03" itemLabel="Exam03"/>
						<f:selectItem itemValue="project" itemLabel="Project"/>
			</h:selectOneListbox>
			<h:outputText value="Overide if test existing?:" />
			<h:selectOneListbox id="overrideTest" value="#{uploadFileBean.overrideTest}" size="2">
						<f:selectItem itemValue="yes" itemLabel="Yes"/>
						<f:selectItem itemValue="no" itemLabel="No"/>
			</h:selectOneListbox>
			<h:outputText value="Points per Question:" />
			<h:inputText id="pointsPerQuestion" value="#{uploadFileBean.pointsPerQuestion}" />
			<h:outputText value="FileType:" />
			<h:selectOneListbox id="fileFunction" value="#{uploadFileBean.fileFunction}" size="3">
						<f:selectItem itemValue="courseRoster" itemLabel="Course Roster"/>
						<f:selectItem itemValue="test" itemLabel="Test"/>
						<f:selectItem itemValue="studentRoster" itemLabel="Student Roster"/>
			</h:selectOneListbox>
			<h:outputText value="Header Row:" />
			<h:selectOneListbox id="headerRow" value="#{uploadFileBean.headerRow}" size="2">
						<f:selectItem itemValue="yes" itemLabel="Yes"/>
						<f:selectItem itemValue="no" itemLabel="No"/>
			</h:selectOneListbox>
    		<h:commandButton value="Upload" action="#{databaseAccess.uploadFile}" />
    		
    		
    	</h:panelGrid>
    	<br/><br/>
    	<h:panelGrid columns="2">
				<h:outputText rendered="#{uploadFileBean.renderQuestionPaperMessage}"  value="Status:" />
				<h:outputText rendered="#{uploadFileBean.renderQuestionPaperMessage}" value="#{uploadFileBean.errorMessage}" styleClass="color-red"/>
				<h:outputText rendered="#{uploadFileBean.renderQuestionPaperMessage}"  value="Number of Columns:" />
				<h:inputText rendered="#{uploadFileBean.renderQuestionPaperMessage}"  value="#{uploadFileBean.columnCount}" />
				<h:outputText rendered="#{uploadFileBean.renderQuestionPaperMessage}"  value="Number of Rows:" />
				<h:inputText rendered="#{uploadFileBean.renderQuestionPaperMessage}"  value="#{uploadFileBean.rowCount}" />
		</h:panelGrid>
		<br/><br/>
		<div style="background-attachment: scroll; overflow:auto; height:400px; background-repeat: repeat">
			<t:dataTable value="#{uploadFileBean.testResultSet}"
					 var="row"
					 rendered="#{uploadFileBean.renderQuestionPaperMessage}"
					 border="1" cellspacing="0" cellpadding="1"
					 columnClasses="columnClass1 border"
					 headerClass="headerClass"
					 footerClass="footerClass"
					 rowClasses="rowClass2"
					 styleClass="dataTableEx"
					 width="900">
				<t:columns var="col" value="#{uploadFileBean.testColumnList}">
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