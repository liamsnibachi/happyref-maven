<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="header">
	<div>
		<div align=right>
			<c:if test="${empty user}">
				<a style="color:green;text-decoration:none;" href="auth.do">login</a>
			</c:if>
			<c:if test="${!(empty user)}">
				<a style="color:green;text-decoration:none;" href="logout.do">logout</a>
			</c:if>
		
		</div>
		<form action="search.do" method="post">
		<span>
			<a href="index.jsp" ><img alt="HappyRef" src="img/happyref_logo.png"/></a>
		</span>
		
		<span class="searchBar">
			<input type="text" name="word" value="${word}"/>
			<input type="image" src="img/search.jpg" onclick="submit();"/>
		</span>
		</form>
	</div>
	<div id="menuho">
		<ul>
			<li><a href="index.jsp" title="Accueil">Accueil</a></li>
			<li><a href="search.do?categoryId=5" title="Nouveaut&eacute;s">Nouveaut&eacute;s</a></li>
			<li><a href="search.do?categoryId=1" title="Informatique">Informatique</a></li>
			<li><a href="search.do?categoryId=4" title="M&eacute;decine">M&eacute;decine</a></li>
			<li><a href="search.do?categoryId=6" title="Droit">Droit</a></li>
			<li><a href="search.do?categoryId=3" title="Histoire">Histoire</a></li>      
			<li><a href="search.do?categoryId=2" title="Romans">Romans</a></li>
		</ul>
	</div>
</div>