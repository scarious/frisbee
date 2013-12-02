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
			<table id="centerContent">
				<tr class="grayRow"><td>Poradie</td><td>Názov tímu</td><td>Skóre</td><td>SK</td><td>Profil tímu</td></tr>
				<tr><td>1.</td><td>Team 1</td><td>1000</td><td>SK</td><td><a href="profileTeam.html">Profil tímu</a></td></tr>
				<tr><td>2.</td><td>Team 2</td><td>1000</td><td>SK</td><td><a href="profileTeam.html">Profil tímu</a></td></tr>
				<tr><td>3.</td><td>Team 3</td><td>1000</td><td>SK</td><td><a href="profileTeam.html">Profil tímu</a></td></tr>
				<tr><td>4.</td><td>Team 4</td><td>1000</td><td>SK</td><td><a href="profileTeam.html">Profil tímu</a></td></tr>
				<tr><td>5.</td><td>Team 5</td><td>1000</td><td>SK</td><td><a href="profileTeam.html">Profil tímu</a></td></tr>				
			</table>
		</div>
		

	</div>
	<c:import url="import/footer.jsp"></c:import>

</div>

</body>

</html>
	