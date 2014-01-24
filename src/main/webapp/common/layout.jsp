<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html lang="true">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="css/soat.css"/>
		<title><tiles:getAsString name="pageTitle"/> </title>
	</head>
	<body>
		<div class="homeContainer">
			<tiles:insert  attribute="header" />
			
			<div class="colContainer">
			    <tiles:insert  attribute="content" />
			</div>
			
			<tiles:insert  attribute="footer" />
		</div>
	</body>
</html:html>