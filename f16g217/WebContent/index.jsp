<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TEST BOARD</title>
<style>

{ margin: 0; padding: 0; }
body { 
        background: url('files/background.jpg') no-repeat center center fixed; 
        -webkit-background-size: cover;
        -moz-background-size: cover;
        -o-background-size: cover;
        background-size: cover;
}

</style>
</head>
<body>
<f:view>
	<h1 align="center">TEST BOARD</h1>
	<h4 align="center">IDS517 f16g217</h4>
	<hr>
	<center>
		<a href="databaseLogin.jsp"  >Database Login</a>&nbsp;&nbsp;&nbsp;
		<a href = "files/ProgrammersDocumentation.pdf" target="_blank" > Programmers Documentation </a>&nbsp;&nbsp;&nbsp;
		<a href = "files/UsersGuide.pdf" target="_blank">Users Guide</a>
		<br/>
		<br/>
		<h:graphicImage value="files/testtaking.jpg" />
		<br/>
		<br/>
		Author:<b> Satyam Pandit &nbsp;&nbsp;&nbsp;|  &nbsp;&nbsp;&nbsp;</b> 
		Group: <b>f16g217 &nbsp;&nbsp;&nbsp;|  &nbsp;&nbsp;&nbsp;</b>
		UIN:<b>658362755</b>
	</center>
</f:view>
</body>
</html>