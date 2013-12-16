<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
				<table>
					<tr class="grayRow"><td>Dátum</td><td>Názov</td><td>Krajina</td><td>Mesto</td></tr>
					<tr><td>1.1.2014</td><td>Turnaj 1</td><td>SK</td><td>KE</td></tr>
					<tr><td>1.1.2014</td><td>Turnaj 2</td><td>SK</td><td>KE</td></tr>
					<tr><td>1.1.2014</td><td>Turnaj 3</td><td>CZ</td><td>KE</td></tr>
					<tr><td>1.1.2014</td><td>Turnaj 4</td><td>SK</td><td>KE</td></tr>
					<tr><td>1.1.2014</td><td>Turnaj 5</td><td>SK</td><td>KE</td></tr>
				</table>
				<a href="tournaments">Viac...</a>
			</div>
		<br/><br/>
		<h3>Najbližšie turnaje na mape:</h3>
		<div id="map-canvas"></div>
		<div>Lat Lng on click: 
  			<input type="text" id="latlongclicked"></span></div>
		</div>
		</div>
		
	</div>
	<c:import url="import/footer.jsp"></c:import>

</div>

</body>
</html>
