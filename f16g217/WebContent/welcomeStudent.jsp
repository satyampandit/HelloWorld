<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Student</title>
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
		<h:outputText value="Student" />
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
			<h:commandLink action="terminateConnection.jsp" >Terminate Connection</h:commandLink>
		</h:form>
	</center>
	<br /> <hr> <br />
	<center>
	<h:form>
		<h:commandButton value="Show Tests" action="#{databaseAccess.getTestDetails}"/>
		<br /> <br />
		<t:dataTable value="#{testBean.resultSet}" var="rowNumber"  rendered="#{testBean.renderList}"  border="1" cellspacing="0" cellpadding="1" columnClasses="columnClass1 border" headerClass="headerClass" footerClass="footerClass" rowClasses="rowClass2" styleClass="dataTableEx" width="800">
		<h:column>
			<f:facet name="header">
				<h:outputText>Test ID</h:outputText>
			</f:facet>
			<h:outputText value="#{rowNumber.examId}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText>CRN</h:outputText>
			</f:facet>
		<h:outputText value="#{rowNumber.CRN}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText>Course Code</h:outputText>
			</f:facet>
			<h:outputText value="#{rowNumber.courseCode}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText>Availability Start Date</h:outputText>
			</f:facet>
			<h:outputText value="#{rowNumber.AvailabilityStartDate}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText>Availability End Date</h:outputText>
			</f:facet>
			<h:outputText value="#{rowNumber.AvailabilityEndDate}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText>Test Duration</h:outputText>
			</f:facet>
			<h:outputText value="#{rowNumber.Duration}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText>Take Test</h:outputText>
			</f:facet>
			<h:commandButton type="submit" label="#{rowNumber.examId}" value="Take Test" action="#{databaseAccess.takeTest}" >
			</h:commandButton>
		</h:column>
	</t:dataTable>
	
	<br/><hr/><br/>
	
	<h:outputText rendered="#{testBean.questionPaperRenderList}">~~~~Test Paper~~~~</h:outputText><br/><br/>
	<t:dataTable value="#{databaseAccess.testBeanList}" var="rowNumber"  rendered="#{testBean.questionPaperRenderList}"  border="1" cellspacing="0" cellpadding="1" columnClasses="columnClass1 border" headerClass="headerClass" footerClass="footerClass" rowClasses="rowClass2" styleClass="dataTableEx" width="800">
		<h:column>
			<f:facet name="header">
				<h:outputText>Question</h:outputText>
			</f:facet>
		<h:outputText value="#{rowNumber.question}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText>Answer</h:outputText>
			</f:facet>
			<h:inputText id="userAnswer" value="#{rowNumber.userAnswer}" />
		</h:column>
	</t:dataTable>
	<br/>
	<h:commandButton rendered="#{testBean.questionPaperRenderList}" type="submit"  value="Submit" action="#{databaseAccess.submitMethod}" />
	<br/><br/>
	<h:outputText rendered="#{testBean.renderMessage}" value="#{testBean.outputMessage}" styleClass="color-red"/><br/>
	<h:outputText value="Score:" rendered="#{testBean.renderMessage}" />
	<h:outputText value="#{testBean.finalScore}" rendered="#{testBean.renderMessage}" />
	</h:form>
	</center>
	
</f:view>
</body>
</html>