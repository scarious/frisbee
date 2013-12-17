<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<h2>Turnaje ::</h2> <h3><a href="tournaments">Vyhľadávanie</a>&nbsp;:&nbsp;<a href="tournamentsNew">Pridaj nový turnaj</a></h3>
		<div id="centerContent">
			Filter: 
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
				  <optgroup label="Registračný poplatok">
				  	<option value="SK">Bez poplatku</option>
				    <option value="SK">S poplatkom &lt; 5€ </option>
				    <option value="SK">S poplatkom &lt; 10€ </option>
					<option value="SK">S poplatkom &lt; 20€ </option>
					<option value="SK">Všetky</option>
				  </optgroup>
			</select>	
			<br/>
			Vyhľadávanie: <input type="text" size="25" maxlength="50"/>	
			<input type="submit" name="Hľadaj" title="asd" value="Hľadaj"/>
		</div>
		<br/><br/>
		<div id="centerContent">
			
			<!--	<img  id="cal" src='<c:url value="/resources/images/calendar.JPG"></c:url>' alt="Kalendar"/>   -->
							
			<div id="tournamentsList">
				<table>
					<tr><td><b>Najblizšie turnaje</b></td></tr>
					<tr class="grayRow"><td>Dátum</td><td>Názov turnaja</td><td>Miesto konania</td></tr>
					<c:forEach var="tournaments" items="${tournament}" varStatus="status" end="10">
						<tr>
							<td><fmt:formatDate value="${tournaments.date}" pattern="yyyy-MM-dd" /></td>
							<td><a href="profileTournament?id=${tournaments.tournament_id}">${tournaments.name}</a></td>
							<td>${tournaments.city}</td>
						</tr>
					</c:forEach>
				</table>
				<br/><br /><br />
				Filter: 
			<select>
				  <optgroup label="Rok">
				    <option value="SK">Všetky roky</option>
				    <option value="2013">2013</option>
				    <option value="2012">2012</option>
				  </optgroup>
			</select>
			<select>
				  <optgroup label="Mesiac">
				    <option value="SK">Všetky mesiace</option>
				    <option value="Jan">Jan</option>
				    <option value="Feb">Feb</option>
				    <option value="Mar">Mar</option>
					<option value="Apr">Apr</option>
					<option value="Maj">Maj</option>
					<option value="Jun">Jun</option>
					<option value="Jul">Jul</option>
					<option value="Aug">Aug</option>
					<option value="Sep">Sep</option>
					<option value="Okt">Okt</option>
					<option value="Nov">Nov</option>
					<option value="Dec">Dec</option>
				  </optgroup>
			</select>
			<select>
				  <optgroup label="Den">
				  	<option value="SK">Vsetky dni</option>
				    <option value="1">1.</option>
				    <option value="2">2.</option>
				    <option value="3">3.</option>
				    <option value="4">4.</option>
				    <option value="5">5.</option>
				  </optgroup>
			</select>	
			<br/>
				<table>
					<tr><td><b>Turnaje pre zvolený dátum</b></td></tr>
					<tr class="grayRow"><td>Dátum</td><td>Názov turnaja</td><td>Miesto konania</td></tr>
					<tr><td>-</td><td><a href="">-</a></td><td>-</td></tr>
				</table>

				<br/><br/>
				<table>
					<tr><td><b>Všetky turnaje</b></td></tr>
					<tr class="grayRow"><td>Názov turnaja</td><td>Miesto konania</td><td>Profil</td></tr>
					<c:forEach var="alltournaments" items="${alltournaments}" varStatus="status">
					<tr><td>${alltournaments.name}</td><td>${alltournaments.city} (${alltournaments.country})</td><td><a href="profileTournament?id=${alltournaments.tournament_id}">Profil</a></td></tr>
					</c:forEach>
				</table>
			</div>
			
		</div>
	
	
	
	</div>
	<c:import url="import/footer.jsp"></c:import>

</div>

</body>

</html>
	