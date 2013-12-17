<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/style.css"></c:url>'/>
<script type="text/javascript"
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDYr2Hd6_FhH1YQCtDf4-8AGRM5qN4JiEY&sensor=true">
</script>
<script type="text/javascript" src='<c:url value="/resources/mapa.js"></c:url>'></script>

<title>${pageTitle}</title>
</head>

<body <c:if test="${not empty tournament.gps_coord}">onload="putGpsForTournament()"</c:if>>

<div id="wrapper">
	<c:import url="import/menu.jsp"></c:import>
	<div id="content">
	<h2>PROFIL Turnaja ::</h2>
		<div id="profileInfo">		
			<table>
				<tr><td class="boldTextTd">Nazov turnaja:</td><td>${tournament.name}</td></tr>
				<tr><td class="boldTextTd">Mesto:</td><td>${tournament.city}</td></tr>
				<tr><td class="boldTextTd">Krajina:</td><td>${tournament.country}</td></tr>
				<tr><td class="boldTextTd">Dátum zaciatku:</td><td><fmt:formatDate value="${tournament.date}" pattern="yyyy-MM-dd" /></td></tr>
				<tr><td class="boldTextTd">Doba trvania (dní):</td><td>${tournament.durationDays}</td></tr>
				<tr><td class="boldTextTd">Max./Min. počet timov:</td><td>-/-</td></tr>
				<tr><td class="boldTextTd">Usporiadatel:</td><td>Jano</td></tr>
				<tr><td class="boldTextTd">Kontakt (email):</td><td>${tournament.contact_email}</td></tr>
				<tr><td class="boldTextTd">Kontakt (telefon):</td><td>${tournament.contact_number}</td></tr>
				<tr><td class="boldTextTd">Kontakt (FB):</td><td><a href="#">${tournament.contact_fb}</a></td></tr>
				<tr><td class="boldTextTd">Registračný poplatok: (tím):</td><td>${tournament.regpoplatoktim}€</td></tr>
				<tr><td class="boldTextTd">Registračný poplatok: (hráč):</td><td>${tournament.regpoplatokhrac}€</td></tr>
				<tr><td class="boldTextTd">Divízia:</td><td>${tournament.division}</td></tr>
				<tr><td class="boldTextTd">Úroveň:</td><td>${tournament.level_of_play}</td></tr>
			</table>
		</div>
				<br/><br/><br/>
		<div id="centerContent">
			<div class="topFiveMain" id="centerContent">
			<table>
				<tr class="boldTextTd"><td>Prihlásené tímy</td></tr>
				<tr class="grayRow"><td>Názov tímu</td></tr>
				<c:forEach var="teamsOnTournament" items="${teamsOnTournament}" varStatus="status">
					<tr><td><a href="profileTeam?id=${teamsOnTournament.team_id}">${teamsOnTournament.name}</a></td></tr>
				</c:forEach>
			</table>
			</div>
						<br/><br/><br/>
			<input id="gpsMiestoTurnaja" type="hidden" value="${tournament.gps_coord}"/>
			
			<div id="centerContent" >
			<h3>Miesto konania turnaja</h3>
				<c:if test="${not empty tournament.gps_coord}">
					<div id="map-canvas"></div>
				</c:if>
			</div>
			<br/>
			<div class="topFiveMain">
				<table>
					<tr class="boldTextTd"><td>Rozpis</td></tr>
					<tr class="boldTextTd grayRow"><td>Zápas</td><td>Dátum</td><td>Čas</td><td></td><td>vs</td><td></td></tr>
					<tr style="text-align:center"><td>1</td><td>23.12.2013</td><td>12:00</td><td>Tím A</td><td>-</td><td>Tím B</td></tr>
					<tr style="text-align:center"><td>2</td><td>23.12.2013</td><td>13:00</td><td>Tím A</td><td>-</td><td>Tím C</td></tr>
					<tr style="text-align:center"><td>3</td><td>23.12.2013</td><td>14:00</td><td>Tím B</td><td>-</td><td>Tím C</td></tr>
				</table>
			</div>
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
	