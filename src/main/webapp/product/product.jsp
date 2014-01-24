<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${!(empty book)}">
	<table class="productTable">
		<tr>
			<td>
				<div><img width="150px" src="img/${book.imageName}"/></div>
				<div class="bookIsbn">isbn : <c:out value="${book.isbn}"/></div>
			</td>
			<td class="description">
				<div class="bookTitle"><c:out value="${book.title}"/></div>
				<div class="bookAuthor"><c:out value="${book.author}"/></div>
				<div><c:out value="${book.longDescription}"/></div>
				<div align="right"><input type="button" value="Reserver"/></div>
			</td>
		</tr>
		<tr></tr>
	</table>
</c:if>