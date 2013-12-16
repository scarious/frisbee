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
	<div class="topPlayers">
			<h2>TOP Tímy ::</h2> <h3><a href="teams">Vyhľadávanie</a>&nbsp;:&nbsp;<a href="teamsTop">Najlepšie tímy</a>&nbsp;:&nbsp;<a href="newTeam">Vytvor nový tím</a></h3>
			<div id="centerContent" class="topFiveMain">
			<table id="topTeams">
				<tr class="grayRow"><td>Poradie</td><td>Názov tímu</td><td>Skóre</td><td>Mesto</td><td>Profil tímu</td></tr>
				
				<c:forEach var="teams" items="${topTeamsList}" varStatus="status">	
				<tr><td></td><td>${topTeamsListData[status.index].name}</td><td>${teams.points}</td><td>${topTeamsListData[status.index].city}</td><td><a href="profileTeam?id=${teams.team_id}">Profil tímu</a></td></tr>
				</c:forEach>
				
			</table>
			</div>
			<script type="text/javascript">
						var table = document.getElementById('topTeams');
						var totalRows = table.getElementsByTagName("tr").length;
						for(var i=0;i<totalRows-1;i++){
							table.rows[i+1].cells[0].innerHTML = i+1;
						}
			</script>
		</div>
		

	</div>
	<c:import url="import/footer.jsp"></c:import>

</div>

</body>

</html>
	