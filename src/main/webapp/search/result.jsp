<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="resultTable" >
	<tbody>
		<tr class="enteteTable">
			<td>Illustration</td><td>Titre</td><td>Auteur</td><td>Description</td><td>isbn</td>
		</tr>
		<c:set var="altern" value="0"/>
		<c:forEach var="book" items="${resultset}" >
		
			<tr class="<c:if test="${(altern%2)!=0 }">line</c:if>" >
				<td align="center"><a href="product.do?id=${book.isbn}" title="${book.title}"><img width="50px" src="img/<c:out value="${book.imageName}"/>"/></a></td>
				<td><a href="Product?id=${book.isbn}" title="${book.title}"><c:out value="${book.title}"/></a></td>
				<td><c:out value="${book.author}"/></td>
				<td><c:out value="${book.shortDescription}"/></td>
				<td><c:out value="${book.isbn}"/></td>
			</tr>
			<c:set var="altern" value="${altern+1}" />
		</c:forEach>
		
	</tbody>
</table>