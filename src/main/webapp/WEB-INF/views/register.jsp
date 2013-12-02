<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			<table>
				<tr><td>Meno:</td><td><input type="text"/></td></tr>
				<tr><td>Heslo:</td><td><input type="password"/></td></tr>
				<tr><td>Heslo znova:</td><td><input type="password"/></td></tr>
				<tr><td>E-mail:</td><td><input type="password"/></td></tr>
				<tr><td></td><td><input type="button" value="Registruj"/></td></tr>
			</table>
			 
			<br/>alebo<br/><br/>
			<img src='<c:url value="/resources/images/loginFB.png"></c:url>' alt="Facebook login"/>
		</div>
		
	</div>
	<c:import url="import/footer.jsp"></c:import>

</div>

</body>

</html>
	