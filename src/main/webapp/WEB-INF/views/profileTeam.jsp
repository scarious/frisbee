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

<body>

<div id="wrapper">
	<c:import url="import/menu.jsp"></c:import>
	<div id="content">
	<h2>PROFIL Tímu ::</h2>
		<div id="profileInfo">		
			<table>
				<tr><td class="boldTextTd">Názov:</td><td>${teamData.name}</td></tr>
				<tr><td class="boldTextTd">Mesto:</td><td>${teamData.city}</td></tr>
				<tr><td class="boldTextTd">Krajina:</td><td>${teamData.country}</td></tr>
				<tr><td class="boldTextTd">Dátum založenia:</td><td><c:if test="${not empty teamData.datumZalozenia}"><fmt:formatDate value="${teamData.datumZalozenia}" pattern="yyyy-MM-dd" /></c:if></td></tr>
				<tr><td class="boldTextTd">Web:</td><td><a href="${teamData.website}">${teamData.website}</a></td></tr>
				<tr><td class="boldTextTd">Kontakt (email):</td><td>${teamData.contact_email}</td></tr>
				<tr><td class="boldTextTd">Kontakt (telefón):</td><td>${teamData.contact_phone}</td></tr>
				<tr><td class="boldTextTd">Kontakt (FB):</td><td><a href="#">${teamData.contact_fb}</a></td></tr>
				<tr><td class="boldTextTd">Doplňujúce info:</td><td><a href="#">${teamData.contact_fb}</a></td></tr>
				<c:if test="${not empty hadEditRight}">
					<tr><td><a href="">Upraviť</a></td><td></td></tr>
				</c:if>
			</table>
		</div>
		<div id="profileTeamTreningy">
			<table>
				<tr class="boldTextTd"><td>Tréningy</td></tr>
				<tr><td>Pondelok</td><td><input id="ponChk" type="checkbox" disabled="disabled"/></td><td id="ponHour">Tréning nie je</td></tr>
				<tr><td>Utorok</td><td><input id="utoChk" type="checkbox" disabled="disabled"/></td><td id="utoHour">Tréning nie je</td></tr>
				<tr><td>Streda</td><td><input id="strChk" type="checkbox" disabled="disabled"/></td><td id="strHour">Tréning nie je</td></tr>
				<tr><td>Štvrtok</td><td><input id="stvChk" type="checkbox" disabled="disabled"/></td><td id="stvHour">Tréning nie je</td></tr>
				<tr><td>Piatok</td><td><input id="piaChk" type="checkbox" disabled="disabled"/></td><td id="piaHour">Tréning nie je</td></tr>
				<tr><td>Sobota</td><td><input id="sobChk" type="checkbox" disabled="disabled"/></td><td id="sobHour">Tréning nie je</td></tr>
				<tr><td>Nedeľa</td><td><input id="nedChk" type="checkbox" disabled="disabled"/></td><td id="nedHour">Tréning nie je</td></tr>
				<tr></tr>
				<!-- <tr><td>Miesto tréningu</td><td></td></tr> -->
			</table>
		<input id="unparsedTrainings" type="hidden" value="${teamData.trainings}"/>
		<script type="text/javascript">
			var unparsed =  document.getElementById('unparsedTrainings').value;
			var splitUnparsed = unparsed.split(';');
			
			for(var i = 0;i<splitUnparsed.length;i++){
				var singleDay = splitUnparsed[i];
				var splitSingleDay = singleDay.split(',');
				if(splitSingleDay[0] == 'Po'){
					document.getElementById('ponChk').checked = true;
					document.getElementById('ponHour').innerHTML = "o " + splitSingleDay[1];
				} else if(splitSingleDay[0] == 'Ut'){
					document.getElementById('utoChk').checked = true;
					document.getElementById('tuoHour').innerHTML = "o " + splitSingleDay[1];
				} else if(splitSingleDay[0] == 'Str'){
					document.getElementById('strChk').checked = true;
					document.getElementById('strHour').innerHTML = "o " + splitSingleDay[1];
				} else if(splitSingleDay[0] == 'Stv'){
					document.getElementById('stvChk').checked = true;
					document.getElementById('stvHour').innerHTML = "o " + splitSingleDay[1];
				} else if(splitSingleDay[0] == 'Pi'){
					document.getElementById('piaChk').checked = true;
					document.getElementById('piaHour').innerHTML = "o " + splitSingleDay[1];
				} else if(splitSingleDay[0] == 'So'){
					document.getElementById('sobChk').checked = true;
					document.getElementById('sobHour').innerHTML = "o " + splitSingleDay[1];
				} else if(splitSingleDay[0] == 'Ne'){
					document.getElementById('nedChk').checked = true;
					document.getElementById('nedHour').innerHTML = "o " + splitSingleDay[1];
				}
			}
			
		</script>
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
				<c:forEach var="playersTeam" items="${playersInTeam}">
					<tr><td>${playersTeam.firstName} ${playersTeam.lastName}</td><td>-</td><td>-</td><td><a href="profile?id=${playersTeam.player_id}">Profil hráča</a></td></tr>
				</c:forEach>
			</table>
		</div>	
	</div>
	<c:import url="import/footer.jsp"></c:import>

</div>

</body>

</html>
	