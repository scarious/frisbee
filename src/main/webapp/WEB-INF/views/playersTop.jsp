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
			<h2>TOP Hráči ::</h2> <h3><a href="players">Vyhľadávanie</a>&nbsp;:&nbsp;<a href="playersTop">Najlepší hráči</a></h3>
			<div id="centerContent" class="topFiveMain">
				<table id="topPlayers">
					<tr class="grayRow"><td>Poradie</td><td>Meno</td><td>Skóre</td><td>Krajina</td><td>Profil</td></tr>
					<c:forEach var="users" items="${topUsersList}" varStatus="status">
						<tr><td></td><td>${users.name}</td><td>${users.points}</td><td>${topPlayersInfo[status.index].address.country}</td><td><a href="profile?id=${users.player_id}">Profil</a></td></tr>
					</c:forEach>
				</table>
			</div>
			<script type="text/javascript">
						var table = document.getElementById('topPlayers');
						var totalRows = table.getElementsByTagName("tr").length;
						for(var i=0;i<totalRows;i++){
							table.rows[i+1].cells[0].innerHTML = i+1;
						}
					</script>
		</div>
		

	</div>
	<c:import url="import/footer.jsp"></c:import>

</div>

</body>

</html>
