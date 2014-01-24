<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html lang="true">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="css/soat.css"/>
		<title><bean:message key="general.application.home" bundle="messages"/></title>
	</head>
	<body>
		<div class="homeContainer">
			<jsp:include page="/common/header.jsp"/>
			<div class="colContainer">
				<p>
					Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
					Donec leo libero, rutrum at aliquam ac, consectetur eu nisi. 
					Donec et mi risus, vel aliquet massa. Mauris eu diam eu justo
					tempor aliquam. Proin placerat sapien metus, ac elementum mauris. 
					Sed elementum, mauris vitae tristique molestie, massa nisl cursus 
					nisi, nec iaculis libero augue quis mi. Nulla lacus purus, 
					imperdiet a vulputate nec, ultricies eget augue. Sed blandit, eros eu elementum
					adipiscing, nisi risus tempor lacus, vitae vulputate arcu mauris quis magna.
					Pellentesque mattis ultricies libero vitae pharetra. Suspendisse pellentesque 
					tortor eget tellus feugiat adipiscing. Nullam lectus dolor, suscipit id congue at,
					placerat vel turpis. Aliquam facilisis mattis lorem, id fringilla sapien euismod et.
					In pellentesque sapien sed mauris sodales egestas. Donec pulvinar purus id sem 
					blandit ut venenatis dolor imperdiet. Sed rhoncus est eget ligula ornare rhoncus.
				</p>
				<p>
					Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
					Donec leo libero, rutrum at aliquam ac, consectetur eu nisi. 
					Donec et mi risus, vel aliquet massa. Mauris eu diam eu justo
					tempor aliquam. Proin placerat sapien metus, ac elementum mauris. 
					Sed elementum, mauris vitae tristique molestie, massa nisl cursus 
				</p>
			</div>
			<jsp:include page="/common/footer.jsp"/>
		</div>
	</body>
</html:html>