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

			<table id="centerContent">
				<tr class="grayRow"><td>Poradie</td><td>Meno</td><td>Skóre</td><td>Krajina</td><td>Profil</td></tr>
				<c:forEach var="users" items="${topUsersList}">
					<tr><td>${users.player_id}</td><td>${users.name}</td><td>${users.points}</td><td></td><td><a href="profile?id=${users.player_id}">Profil</a></td></tr>
					
				</c:forEach>
				

			</table>
		</div>
		

	</div>
	<c:import url="import/footer.jsp"></c:import>

</div>

</body>

</html>
