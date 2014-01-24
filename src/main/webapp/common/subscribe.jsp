<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<div align="center" class="centerContent">
	<html:form action="subscribe">
			<table>
				<tr>
				<td class="errors" COLSPAN="2"><html:errors/></td>
			</tr>
			<tr>
				<td>Adresse e-mail : </td>
				<td><html:text  property="mail" errorStyleClass="inputAlert"/></td>
			</tr>
			<tr>
				<td>Nom : </td>
				<td><html:text property="nom" errorStyleClass="inputAlert"/></td>
			</tr>
			<tr>
				<td>Prénom : </td>
				<td><html:text property="prenom" errorStyleClass="inputAlert"/></td>
			</tr>
			<tr>
				<td>Mot de passe : </td>
				<td><html:password property="password" redisplay="false" errorStyleClass="inputAlert"/></td>
			</tr>
			<tr>
				<td>Confirmation du mot de passe : </td>
				<td><html:password property="password2" redisplay="false" errorStyleClass="inputAlert"/></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<html:submit property="Envoyer" />
					<html:reset/>
				</td>
			</tr>
		</table>
	</html:form>
</div>
			