<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page pageEncoding="UTF-8" %>
<div id="topMenu">
		<div class="topMenuItem"><a href="index">Domov</a></div>
		<div class="topMenuItem"><a href="players">Hráči</a></div>
		<div class="topMenuItem"><a href="teams">Tímy</a></div>
		<div class="topMenuItem"><a href="tournaments">Turnaje</a></div>
		<div class="topMenuItem"><a href="profile">Profil</a></div>
</div>
<div id="loginArea">
		<sec:authorize access="hasRole('ROLE_USER')">
		<a href='<c:url value="j_spring_security_logout" />'>Logout</a> 
		</sec:authorize>
		<sec:authorize access="isAnonymous()">
		<a href="login">Prihlásenie</a><a href="register">Registrácia</a>
		</sec:authorize>
		
</div>