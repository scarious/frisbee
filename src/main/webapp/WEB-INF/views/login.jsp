<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/style.css"></c:url>'/>
<title>${pageTitle}</title>
</head>

<body  onload='document.f.j_username.focus();'>

<div id="wrapper">
	<c:import url="import/menu.jsp"></c:import>
	<div id="content">
	<c:if test="${regOk}">
	  <div>
	   Registácia prebehla úspešne! Je možné sa prihlásiť. 
	  </div>
	</c:if>
	<c:if test="${loginFailed}">
	  <div>
	   Prihlásenie sa nepodarilo. Príčina:   ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
	  </div>
	</c:if>
		<h2><b>Prihlásenie ::</b></h2>
		<div id="centerContent">
			<form name="loginForm" action="j_spring_security_check" method="post">
			<table>
				<tr><td>Meno:</td><td><input name="j_username" type="text"/></td></tr>
				<tr><td>Heslo:</td><td><input name="j_password" type="password"/></td></tr>
				<tr><td></td><td><input id="loginBtn" onclick="kontrolaLoginForm()" type="button" name="submit" value="Prihlás"/></td></tr>
			</table>
			</form>
			<!--  <br/>alebo<br/><br/>
			<img src='<c:url value="/resources/images/loginFB.png"></c:url>' alt="Facebook login"/> --><br/>
		</div>
	</div>
	<script type="text/javascript">
		function kontrolaLoginForm(){
			var menoInput = document.forms['loginForm']['j_username'].value;
			var hesloInput = document.forms['loginForm']['j_password'].value;
			
			if (menoInput == null || hesloInput == null || menoInput == "" || hesloInput == ""){
				alert("Meno alebo heslo nemôže byť prázdne!")
				return false;
			} else {
				document.getElementById('loginBtn').type = "submit";
			}
		}
	</script>
	<c:import url="import/footer.jsp"></c:import>

</div>

</body>

</html>
	