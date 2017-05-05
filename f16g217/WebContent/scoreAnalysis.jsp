<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Score Analysis</title>
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
		<h:outputText value="Score Analysis " />
	</h3>
	<hr>
	<br />
	<center> 
		<h:form>
				<h:commandLink action="welcomeInstructor.jsp" actionListener="#{databaseAccess.resetRenders}">Back</h:commandLink>&nbsp;&nbsp;&nbsp; 
				<h:commandLink action="logout.jsp" >Logout</h:commandLink>&nbsp;&nbsp;&nbsp; 
				<h:commandLink action="terminateConnection.jsp" >Terminate Connection</h:commandLink>
		</h:form>
		<hr/>
		<br/>
		<h:form>
		<h:panelGrid columns="2">
			<h:commandButton type="submit" value="Select a course CRN:"  action="#{databaseAccess.populateCrnList}"/>
			<h:selectOneMenu value="#{scoreAnalysisBean.selectedCrn}">
    			<f:selectItems value="#{scoreAnalysisBean.crnList}" />
			</h:selectOneMenu>
			<h:outputText value="Show Descriptive Analysis:" />
			<h:selectOneListbox id="rdbms" value="#{scoreAnalysisBean.examType}" size="1">
						<f:selectItem itemValue="exam01" itemLabel="Exam01"/>
						<f:selectItem itemValue="exam02" itemLabel="Exam02"/>
						<f:selectItem itemValue="exam03" itemLabel="Exam03"/>
						<f:selectItem itemValue="project" itemLabel="Project"/>
						<f:selectItem itemValue="total" itemLabel="Total"/>
				</h:selectOneListbox>
			<h:commandButton type="submit" value="Show Descriptive Analysis"  action="#{databaseAccess.descriptiveAnalysis}"/>
			<h:commandButton type="submit" value="Clear"  action="#{databaseAccess.clearDescriptiveAnalysis}"/>
		</h:panelGrid>
		<br/>
		<hr/>
		<br/>
		<br/>
		Data for Descriptive Statistics:
		
		<h4>Descriptive Statistics<h4>
		
		5 Number Summary:
		<h:panelGrid columns = "2">
			<h:outputText value="min:" />
			<h:outputText value="#{scoreAnalysisBean.minVal}" />
			
			<h:outputText value="Q1:" />
			<h:outputText value="#{scoreAnalysisBean.q1}" />
			
			<h:outputText value="Q2/median:" />
			<h:outputText value="#{scoreAnalysisBean.median}" />
			
			<h:outputText value="Q3:" />
			<h:outputText value="#{scoreAnalysisBean.q3}" />
			
			<h:outputText value="max:" />
			<h:outputText value="#{scoreAnalysisBean.maxVal}" />
			</h:panelGrid>	 
		<br/><br/>
		
		Measures of Central Tendency:
		<h:panelGrid columns = "2">
			<h:outputText value="mean:" />
			<h:outputText value="#{scoreAnalysisBean.mean}" />
			
			<h:outputText value="median:" />
			<h:outputText value="#{scoreAnalysisBean.median}" />
		<br/><br/>
			</h:panelGrid>	 
		Measures of Variation:
		<h:panelGrid columns = "2">
			<h:outputText value="variance:" />
			<h:outputText value="#{scoreAnalysisBean.variance}" />
			
			<h:outputText value="SD:" />
			<h:outputText value="#{scoreAnalysisBean.std}" />
			
			<h:outputText value="Range:" />
			<h:outputText value="#{scoreAnalysisBean.range}" />
			
			<h:outputText value="IQR:" />
			<h:outputText value="#{scoreAnalysisBean.iqr}" />
		</h:panelGrid>	
		<h:commandButton value="Pie Chart" type="submit" action="#{databaseAccess.processPieChart}"/>	
		<h:commandButton value="Bar Chart" type="submit" action="#{databaseAccess.processBarChart}"/>	 
		<br/>
		</h:form>
     
        <h:graphicImage value="#{chartBean.fullPathPieChart}"
							height="450" width="600"
							rendered="#{chartBean.pieChartRender}"
							alt="pieChart"/>
	    <br><br>
	     <h:graphicImage value="#{chartBean.fullPathBarChart}"
							height="450" width="600"
							rendered="#{chartBean.barChartRender}"
							alt="barChart"/>
     
	</center>

</f:view>
</body>
</html>