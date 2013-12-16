<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
	<h2>Hráči ::</h2> <h3><a href="players">Vyhľadávanie</a>&nbsp;:&nbsp;<a href="playersTop">Najlepší hráči</a></h3>
		<div id="centerContent">
			Filter hráčov podľa: 
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
			<select>
				  <optgroup label="Tímov">
				  	<option value="SK">Všetky tímy</option>
				    <option value="SK">Tím 1</option>
				    <option value="SK">Tím 2</option>
					<option value="SK">Tím 3</option>
					<option value="SK">Tím 4</option>
				  </optgroup>
			</select>	
			<br/>
			Vyhľadávanie: <input type="text" size="25" maxlength="50"/>	
			<input type="submit" name="Hľadaj" title="asd" value="Hľadaj"/>
		</div>
	<div id="centerContent" class="topFiveMain">
	<table>
			<tr class="grayRow"><td>Meno a priezvisko (prezývka)</td><td>Krajina</td><td>Tím</td><td>Profil</td></tr>
			<c:forEach var="players" items="${playersData}" varStatus="status">
				<tr>
					<td>${players.firstName} ${players.lastName}</td>
					<td>${players.address.country}</td><td>${playersTeam[status.index].name}</td><td><a href="profile?id=${players.player_id}">Profil</a></td></tr>
			</c:forEach>
	</table>
	</div>
	
	</div>
	<c:import url="import/footer.jsp"></c:import>

</div>

</body>

</html>
	