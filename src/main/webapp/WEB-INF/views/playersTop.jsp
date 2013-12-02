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
				<tr class="grayRow"><td>Poradie</td><td>Prezývka</td><td>Skóre</td><td>Krajina</td><td>Profil</td></tr>
				<tr><td>1.</td><td>Player 1</td><td>1000</td><td>SK</td><td><a href="profile.html">Profil hráča</a></td></tr>
				<tr><td>2.</td><td>Player 2</td><td>900</td><td>SK</td><td><a href="profile.html">Profil hráča</a></td></tr>
				<tr><td>3.</td><td>Player 3</td><td>845</td><td>SK</td><td><a href="profile.html">Profil hráča</a></td></tr>
				<tr><td>4.</td><td>Player 4</td><td>700</td><td>SK</td><td><a href="profile.html">Profil hráča</a></td></tr>
				<tr><td>5.</td><td>Player 5</td><td>500</td><td>SK</td><td><a href="profile.html">Profil hráča</a></td></tr>
				<tr><td>1.</td><td>Player 1</td><td>1000</td><td>SK</td><td><a href="profile.html">Profil hráča</a></td></tr>
				<tr><td>2.</td><td>Player 2</td><td>900</td><td>SK</td><td><a href="profile.html">Profil hráča</a></td></tr>
				<tr><td>3.</td><td>Player 3</td><td>845</td><td>SK</td><td><a href="profile.html">Profil hráča</a></td></tr>
				<tr><td>4.</td><td>Player 4</td><td>700</td><td>SK</td><td><a href="profile.html">Profil hráča</a></td></tr>
				<tr><td>5.</td><td>Player 5</td><td>500</td><td>SK</td><td><a href="profile.html">Profil hráča</a></td></tr>
				<tr><td>1.</td><td>Player 1</td><td>1000</td><td>SK</td><td><a href="profile.html">Profil hráča</a></td></tr>
				<tr><td>2.</td><td>Player 2</td><td>900</td><td>SK</td><td><a href="profile.html">Profil hráča</a></td></tr>
				<tr><td>3.</td><td>Player 3</td><td>845</td><td>SK</td><td><a href="profile.html">Profil hráča</a></td></tr>
				<tr><td>4.</td><td>Player 4</td><td>700</td><td>SK</td><td><a href="profile.html">Profil hráča</a></td></tr>
				<tr><td>5.</td><td>Player 5</td><td>500</td><td>SK</td><td><a href="profile.html">Profil hráča</a></td></tr>
				<tr><td>1.</td><td>Player 1</td><td>1000</td><td>SK</td><td><a href="profile.html">Profil hráča</a></td></tr>
				<tr><td>2.</td><td>Player 2</td><td>900</td><td>SK</td><td><a href="profile.html">Profil hráča</a></td></tr>
				<tr><td>3.</td><td>Player 3</td><td>845</td><td>SK</td><td><a href="profile.html">Profil hráča</a></td></tr>
				<tr><td>4.</td><td>Player 4</td><td>700</td><td>SK</td><td><a href="profile.html">Profil hráča</a></td></tr>
				<tr><td>5.</td><td>Player 5</td><td>500</td><td>SK</td><td><a href="profile.html">Profil hráča</a></td></tr>

			</table>
		</div>
		

	</div>
	<c:import url="import/footer.jsp"></c:import>

</div>

</body>

</html>
