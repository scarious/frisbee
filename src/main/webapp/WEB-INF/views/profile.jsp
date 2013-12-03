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
	<h2>PROFIL Hráča ::</h2>
		<div id="profileInfo">		
			<table>
				<tr><td class="boldTextTd">Meno:</td><td>${player.firstName}</td></tr>
				<tr><td class="boldTextTd">Priezvisko:</td><td>${player.lastName}</td></tr>
				<tr><td class="boldTextTd">Mesto:</td><td>${playerAddress.city}</td></tr>
				<tr><td class="boldTextTd">Krajina:</td><td>${playerAddress.country}</td></tr>
				<tr><td class="boldTextTd">Vek:</td><td>20</td></tr>
				<tr><td class="boldTextTd">Rating:</td><td>123</td></tr>
				<tr><td class="boldTextTd">Číslo dresu:</td><td>99</td></tr>
				<tr><td class="boldTextTd">Hráčom od:</td><td>1.1.2013</td></tr>
				<tr><td class="boldTextTd">Pozícia v hre:</td><td>handler/middle/long</td></tr>
				<tr><td class="boldTextTd">Tím(y):</td><td><br/></td></tr>
				<tr><td><a href="profile/edit">Upraviť</a></td><td></td></tr>
			</table>
		</div>
		<div id="profileAvatar"><img id="profileAvatarImg" alt="Avatar hraca" src='<c:url value="/resources/images/default_avatar.jpg"></c:url>'/></div>	
		<br/><br/><br/>
		<div id="centerContent">
			<table>
				<tr class="boldTextTd grayRow"><td>Odohrané zápasy</td><td>Výhry</td><td>Prehry</td></tr>
				<tr style="text-align:center"><td>20</td><td>15</td><td>5</td></tr>
			</table>
		</div>	
	</div>
	<c:import url="import/footer.jsp"></c:import>

</div>

</body>

</html>
	