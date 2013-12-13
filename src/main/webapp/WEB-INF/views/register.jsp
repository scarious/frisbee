<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/style.css"></c:url>'/>
<title>${pageTitle}</title>
</head>

<body>

<div id="wrapper">
	<c:import url="import/menu.jsp"></c:import>
	<div id="content">
	<h2><b>Registrácia ::</b></h2>
		<div id="centerContent">
			<form:form method="POST" action="/aplikacia/register">
			<table>
				<tr><td>Meno:</td><td><form:input path="username"/></td></tr>
				<tr><td>Heslo:</td><td><form:input path="password"/></td></tr>
				<tr><td>E-mail:</td><td><form:input path="emailAddress"/></td></tr>
				<tr><td></td><td><input type="submit" value="Registruj"/></td></tr>
			</table>
			</form:form> 
			<br/>alebo<br/><br/>
			<img src='<c:url value="/resources/images/loginFB.png"></c:url>' alt="Facebook login"/>
		</div>
		
	</div>
	<c:import url="import/footer.jsp"></c:import>

</div>

</body>

</html>
	