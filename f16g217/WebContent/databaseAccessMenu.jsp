<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Database Access Menu</title>
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
		<h:outputText value="Aministrator" />
		<br/>
		<h:outputText value="Database Access Menu " />
	</h3>
	<hr>
	<br/>
	<center>
		<h:form>
			<h:commandLink action="welcomeAdmin.jsp" actionListener="#{databaseAccess.resetRenders}">Back</h:commandLink>&nbsp;&nbsp;&nbsp; 
			<h:commandLink action="logout.jsp">Logout</h:commandLink>&nbsp;&nbsp;&nbsp; 
			<h:commandLink action="terminateConnection.jsp">Terminate Connection</h:commandLink>
		</h:form>
		<hr/>
		<br/>
		<h:form>
				<h:commandButton value="TableList" action="#{databaseAccess.displayTableList}"/> &nbsp;
				<h:commandButton value="ColumnList" action="#{databaseAccess.displayTableColumnList}"/> &nbsp;
				<h:commandButton value="DisplayTable" action="#{databaseAccess.displayTable}"/> &nbsp;
				<h:commandButton value="DisplaySelectedColumns" action="#{databaseAccess.displaySelectedColumns}"/> &nbsp;
				<h:commandButton value="DropTable" action="#{databaseAccess.dropTable}"/> &nbsp;
				<h:commandButton value="ProcessSQLQuery" action="#{databaseAccess.processSQLQuery}"/> &nbsp;
				<h:commandButton value="Clear" action="#{databaseAccessMenuBean.clear}"/> &nbsp;
		<br/><br/>
		
				<h:selectOneListbox
					size="10" styleClass="selectOneListbox_mono"
					value="#{databaseAccessMenuBean.tableName}">
					<f:selectItems value="#{databaseAccessMenuBean.tableViewList}" />
				</h:selectOneListbox>
				&nbsp;
				<h:selectManyListbox
					size="10" styleClass="selectManyListbox"
					value="#{databaseAccessMenuBean.columnNamesSelected}">
					<f:selectItems value="#{databaseAccessMenuBean.columnNames}" />
				</h:selectManyListbox>
				&nbsp;
				<h:inputTextarea rows="10" cols="50"  value="#{databaseAccessMenuBean.sqlQuery}"  readonly="true"/>
		<br/><br/>
		<hr/>
		<br/>
			<h:panelGrid columns="2">
				<h:outputText value="SQL Query:" />
				<h:inputText value="#{databaseAccessMenuBean.sqlQuery}" />
				<h:outputText value="Number of Columns:" />
				<h:inputText value="#{databaseAccessMenuBean.columnCount}" />
				<h:outputText value="Number of Rows:" />
				<h:inputText value="#{databaseAccessMenuBean.rowCount}" />
				<h:commandButton type="submit" value="Download"  action="#{databaseAccess.downloadFileMethod}"/>
			</h:panelGrid>
		<br/>
		<hr/>
		<br/><br/>
				<div style="background-attachment: scroll; overflow:auto; height:400px; background-repeat: repeat">
					<t:dataTable value="#{databaseAccessMenuBean.resultSet}"
							 var="row"
							 rendered="#{databaseAccessMenuBean.renderList}"
							 border="1" cellspacing="0" cellpadding="1"
							 columnClasses="columnClass1 border"
							 headerClass="headerClass"
							 footerClass="footerClass"
							 rowClasses="rowClass2"
							 styleClass="dataTableEx"
							 width="900">
						<t:columns var="col" value="#{databaseAccessMenuBean.columnNamesSelected}">
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