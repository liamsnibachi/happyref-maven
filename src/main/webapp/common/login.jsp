<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<div align="center" class="centerContent">
	<html:form action="login" >
			<table>
				<tr>
				<td style="color:red;" colspan="2"><html:errors/></td>
			</tr>
			<tr>
				<td>Adresse e-mail : </td>
				<td><html:text property="mail" /></td>
			</tr>
			<tr>
				<td>Mot de passe : </td>
				<td><html:password property="password" redisplay="false"/></td>
			</tr>
			<tr>
				<td></td>
				<td><html:submit property="submit" value="Envoyer"/><html:reset/></td>
			</tr>
			<tr>
				<td></td>
				<td>
				<html:link page="/subscriptionvue.do">Inscrivez-vous ici</html:link>
				
				</td>
			</tr>
		</table>
	</html:form>
</div>