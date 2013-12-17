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
	<c:if test="${not empty badUsername}">
	  <div>
	  	Registrácia sa nepodarila! Skúste zvoliť iné prihlasovacie meno (login).
	  </div>
	</c:if>
	<h2><b>Registrácia ::</b></h2>
		<div id="centerContent">
			<form:form method="POST" name="registerForm" action="/aplikacia/register">
			<table>
				<tr><td>Meno:</td><td><form:input name="username" path="username"/></td></tr>
				<tr><td>Heslo:</td><td><form:input type="password" name="password" path="password"/></td></tr>
				<tr><td>Heslo znovu:</td><td><input name="passwordRepeat" type="password"/></td></tr>
				<tr><td>E-mail:</td><td><form:input name="emailAddress" path="emailAddress"/></td></tr>
				<tr><td></td><td><input id="registruj" onclick="kontrolaRegisterForm()" type="button" value="Registruj"/></td></tr>
			</table>
			</form:form> 
			<!-- <br/>alebo<br/><br/>
			<img src='<c:url value="/resources/images/loginFB.png"></c:url>' alt="Facebook login"/> --><br/>
		</div>
	</div>
	<script type="text/javascript">
		function kontrolaRegisterForm(){
			var menoInput = document.forms['registerForm']['username'].value;
			var hesloInput = document.forms['registerForm']['password'].value;
			var hesloRepeat = document.forms['registerForm']['passwordRepeat'].value;
			var emailInput = document.forms['registerForm']['emailAddress'].value;
			if (menoInput == null || hesloInput == null || menoInput == "" || hesloInput == ""
					|| hesloRepeat == null || hesloRepeat == "" || emailInput == null || emailInput == ""){
				alert("Žiadne z polí nesmie byť prázdne!");
			} else if(hesloInput != hesloRepeat) {
				alert("Heslá sa nezhodujú!");
			} else {
				document.getElementById('registruj').type = "submit";
			}
		}
	</script>
	<c:import url="import/footer.jsp"></c:import>

</div>

</body>

</html>
	