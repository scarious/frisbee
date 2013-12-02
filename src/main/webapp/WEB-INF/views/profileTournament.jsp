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
	<h2>PROFIL Turnaja ::</h2>
		<div id="profileInfo">		
			<table>
				<tr><td class="boldTextTd">Nazov turnaja:</td><td>Vianocny turnaj</td></tr>
				<tr><td class="boldTextTd">Mesto:</td><td>KE</td></tr>
				<tr><td class="boldTextTd">Krajina:</td><td>SK</td></tr>
				<tr><td class="boldTextTd">Dátum zaciatku:</td><td>23.12.2013</td></tr>
				<tr><td class="boldTextTd">Dátum ukončenia:</td><td>23.12.2013</td></tr>
				<tr><td class="boldTextTd">Max. počet timov (prihlásených):</td><td>4 (3)</td></tr>
				<tr><td class="boldTextTd">Usporiadatel:</td><td>Jano</td></tr>
				<tr><td class="boldTextTd">Kontakt (email):</td><td>organizator@turnaja.sk</td></tr>
				<tr><td class="boldTextTd">Kontakt (telefon):</td><td>0900 000 000</td></tr>
				<tr><td class="boldTextTd">Kontakt (FB):</td><td><a href="#">FB Profil</a></td></tr>
				<tr><td class="boldTextTd">Registračný poplatok: (tím):</td><td>1€</td></tr>
				<tr><td class="boldTextTd">Registračný poplatok: (hráč):</td><td>1€</td></tr>
				<tr><td class="boldTextTd">Divízia:</td><td>Open</td></tr>
				<tr><td class="boldTextTd">Kategória:</td><td>Master</td></tr>
			</table>
		</div>
				<br/><br/><br/>
		<div id="centerContent">
			<table>
				<tr class="boldTextTd"><td>Prihlásené tímy</td></tr>
				<tr class="grayRow"><td>Názov tímu</td></tr>
				<tr><td>Tím A</td></tr>
				<tr><td>Tím B</td></tr>
				<tr><td>Tím C</td></tr>
			</table>
			<table>
				<tr class="boldTextTd"><td>Rozpis</td></tr>
				<tr class="boldTextTd grayRow"><td>Zápas</td><td>Dátum</td><td>Čas</td><td></td><td>vs</td><td></td></tr>
				<tr style="text-align:center"><td>1</td><td>23.12.2013</td><td>12:00</td><td>Tím A</td><td>-</td><td>Tím B</td></tr>
				<tr style="text-align:center"><td>2</td><td>23.12.2013</td><td>13:00</td><td>Tím A</td><td>-</td><td>Tím C</td></tr>
				<tr style="text-align:center"><td>3</td><td>23.12.2013</td><td>14:00</td><td>Tím B</td><td>-</td><td>Tím C</td></tr>
			</table>
		</div>
		<br/>
		<div>
			<table>
				<tr class="boldTextTd"><td>Výsledky</td></tr>
				<tr><td>Turnaj sa ešte nekonal</td><td></td><td></td><td></td></tr>
			</table>
		</div>	
	</div>
	<c:import url="import/footer.jsp"></c:import>

</div>

</body>

</html>
	