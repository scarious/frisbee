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
	<h2>Tímy ::</h2> <h3><a href="teams">Vyhľadávanie</a>&nbsp;:&nbsp;<a href="teamsTop">Najlepšie tímy</a>&nbsp;:&nbsp;<a href="newTeam">Vytvor nový tím</a></h3>
		<div id="centerContent">
			Filter tímov podľa: 
			<select>
				  <optgroup label="Krajiny">
				    <option value="SK">Všetky Krajiny</option>
				    <option value="SK">SK</option>
				    <option value="CZ">CZ</option>
				  </optgroup>
			</select>
			<select>
				  <optgroup label="Mestá">
				    <option value="SK">Všetky mestá</option>
				    <option value="SK">KE</option>
				    <option value="CZ">PO</option>
				    <option value="CZ">BA</option>
					<option value="CZ">BB</option>
				  </optgroup>
			</select>
	
			<br/>
			Vyhľadávanie: <input type="text" size="25" maxlength="50"/>	
			<input type="submit" name="Hľadaj" title="asd" value="Hľadaj"/>
		</div>
		<div id="centerContent" class="topFiveMain">
			<table id="topTeamsIndexTable">
				<tr class="grayRow"><td>Názov tímu</td><td>Krajina</td><td>Mesto</td><td>Počet hráčov</td><td></td></tr>
				<c:forEach var="teams" items="${teamsList}" varStatus="status">
					<tr><td>${teams.name}</td><td>${teams.country}</td><td>${teams.city}</td><td id="centerContent">${playersCount[status.index]}</td><td><a href="profileTeam?id=${teams.team_id}">Profil</a></td></tr>
				</c:forEach>
			</table>
		</div>
	
	
	
	</div>
	<c:import url="import/footer.jsp"></c:import>

</div>

</body>

</html>
	