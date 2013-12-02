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
	<h2>PROFIL Tímu ::</h2>
		<div id="profileInfo">		
			<table>
				<tr><td class="boldTextTd">Názov:</td><td>Tím 1</td></tr>
				<tr><td class="boldTextTd">Mesto:</td><td>KE</td></tr>
				<tr><td class="boldTextTd">Krajina:</td><td>SK</td></tr>
				<tr><td class="boldTextTd">Dátum založenia:</td><td>1.1.2013</td></tr>
				<tr><td class="boldTextTd">Web:</td><td><a href="#">www.tim1.sk</a></td></tr>
				<tr><td class="boldTextTd">Kontakt (email):</td><td>tim1@tim1.sk</td></tr>
				<tr><td class="boldTextTd">Kontakt (telefón):</td><td>0900 000 000</td></tr>
				<tr><td class="boldTextTd">Kontakt (FB):</td><td><a href="#">FB stránka</a></td></tr>
				<tr><td><a href="index.html">Upraviť</a></td><td></td></tr>
			</table>
		</div>
		<div id="profileTeamTreningy">
			<table>
				<tr class="boldTextTd"><td>Tréningy</td></tr>
				<tr><td>Pondelok</td><td><input type="checkbox" checked="checked" disabled="disabled"/></td><td>o 15:00 hod</td></tr>
				<tr><td>Utorok</td><td><input type="checkbox" disabled="disabled"/></td><td>o - hod</td></tr>
				<tr><td>Streda</td><td><input type="checkbox" checked="checked" disabled="disabled"/></td><td>o 14:00 a 18:00 hod</td></tr>
				<tr><td>Štvrtok</td><td><input type="checkbox" disabled="disabled"/></td><td>o - hod</td></tr>
				<tr><td>Piatok</td><td><input type="checkbox" checked="checked" disabled="disabled"/></td><td>o 15:00 hod</td></tr>
				<tr><td>Sobota</td><td><input type="checkbox" checked="checked" disabled="disabled"/></td><td>o 11:00 hod</td></tr>
				<tr><td>Nedeľa</td><td><input type="checkbox" disabled="disabled"/></td><td>o - hod</td></tr>
			</table>

		</div>	
		<br/><br/><br/>
		<div id="centerContent">
			<table>
				<tr class="boldTextTd grayRow"><td>Odohrané zápasy</td><td>Výhry</td><td>Prehry</td></tr>
				<tr style="text-align:center"><td>20</td><td>15</td><td>5</td></tr>
			</table>
		</div>
		<br/>
		<div>
			<table>
				<tr class="boldTextTd"><td>Hráči</td></tr>
				<tr class="grayRow"><td>Meno</td><td>Pozícia v hre</td><td>Odohrané zápasy</td></tr>
				<tr><td>Hráč 1</td><td>Kapitán</td><td>Odohrané zápasy</td><td><a href="profile">Profil hráča</a></td></tr>
			</table>
		</div>	
	</div>
	<c:import url="import/footer.jsp"></c:import>

</div>

</body>

</html>
	