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
	<script type="text/javascript" src='<c:url value="/resources/markerwithlabel.js"></c:url>'></script>
	<script type="text/javascript" src='<c:url value="/resources/mapa.js"></c:url>'></script>
	<title>${pageTitle}</title>
</head>
<body onload="initialize">
<div id="wrapper">
	<c:import url="import/menu.jsp"></c:import>
	<div id="content">
		<div id="centerContent">
			<div class="topFiveMain">
				<p>TOP Hráči<br/></p>
				<table id="topPlayersIndexTable">
					<tr class="grayRow"><td>Poradie</td><td>Prezývka</td><td>Skóre</td></tr>
					
					<c:forEach var="users" items="${topUsersList}" end="10">
					<tr><td></td><td>${users.name}</td><td>${users.points}</td></tr>
					</c:forEach>
					
				</table>
					<script type="text/javascript">
						var table = document.getElementById('topPlayersIndexTable');
						var totalRows = table.getElementsByTagName("tr").length;
						for(var i=0;i<totalRows-1;i++){
							table.rows[i+1].cells[0].innerHTML = i+1;
						}
					</script>
				<a href="playersTop">Viac...</a>
			</div>
			<div class="topFiveMain" style=" vertical-align: top;">
				<p>TOP Tímy<br/></p>
				<table id="topTeamsIndexTable">
					<tr class="grayRow"><td>Poradie</td><td>Názov</td><td>Skóre</td></tr>
					
					<c:forEach var="teams" items="${topTeamsList}" varStatus="status" end="10">
					<tr><td></td><td>${topTeamsListData[status.index].name}</td><td>${teams.points}</td></tr>
					 
					</c:forEach>
				</table>
					<script type="text/javascript">
						var table = document.getElementById('topTeamsIndexTable');
						var totalRows = table.getElementsByTagName("tr").length;
						for(var i=0;i<totalRows-1;i++){
							table.rows[i+1].cells[0].innerHTML = i+1;
						}
					</script>
				<a href="teamsTop">Viac...</a>
			</div>
			<div class="topFiveMain" style=" vertical-align: top;">
				<p>Najbližšie turnaje<br/></p>
				<table id= "tournamentTable">
					<tr class="grayRow"><td>Poradie</td><td>Názov</td><td>Datum</td></tr>
					
					<c:forEach var="tournaments" items="${tournamentList}" varStatus="status" end="10">
					<tr><td></td><td>${tournamentList[status.index].name}</td>
					<td><fmt:formatDate value="${tournamentList[status.index].date}" pattern="yyyy-MM-dd" /> </td>
					</tr>
 					 
					</c:forEach>
				</table>
					<script type="text/javascript">
						var table = document.getElementById('tournamentTable');
						var totalRows = table.getElementsByTagName("tr").length;
						for(var i=0;i<totalRows-1;i++){
							table.rows[i+1].cells[0].innerHTML = i+1;
						}
					</script>
				<a href="tournaments">Viac...</a>
			</div>
		<br/><br/>
		<c:if test="${not empty teamsWithGps}">
		<c:forEach var="teamsWithGps" items="${teamsWithGps}" varStatus="status">
			<input name="treningyNaMapu" type="hidden" value="${teamsWithGps.name};${teamsWithGps.gpsMiestoTreningu}"/>
		</c:forEach>
		</c:if>
		<c:if test="${not empty tournamentsWithGps}">
		<c:forEach var="tournamentsWithGps" items="${tournamentsWithGps}" varStatus="status">
			<input name="turnajeNaMapu" type="hidden" value="${tournamentsWithGps.name};${tournamentsWithGps.gps_coord}"/>
		</c:forEach>
		</c:if>
		<h3>Turnaje a tréningy na mape</h3>
			<div id="centerContent">
				<div id="panelMapa">
			      <input onclick="hideAll();" type=button value="Skry všetko">
			      <input onclick="putTrainingsOnMap()" type=button value="Zobraz tréningy">
			      <input onclick="putTournamentsOnMap();" type=button value="Zobraz turnaje">
			    </div>
			    <div id="map-canvas"></div>
			</div>
		</div>
	<c:import url="import/footer.jsp"></c:import>
	</div>
</div>

</body>
</html>
