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
			
				<img  id="cal" src='<c:url value="/resources/images/calendar.JPG"></c:url>' alt="Kalendar"/>
							
			<div id="tournamentsList">
				<table>
					<tr><td><b>Najblizšie turnaje</b></td></tr>
					<tr class="grayRow"><td>Dátum</td><td>Názov turnaja</td><td>Miesto konania</td></tr>
					<tr><td>1.12.2013</td><td><a href="profileTournament">Turnaj 1</a></td><td>KE</td></tr>
				</table>
				<br/>
				<table>
					<tr><td><b>Turnaje pre zvolený dátum</b></td></tr>
					<tr class="grayRow"><td>Dátum</td><td>Názov turnaja</td><td>Miesto konania</td></tr>
					<tr><td>3.11.2013</td><td><a href="profileTournament">Turnaj 1</a></td><td>KE</td></tr>
					<tr><td>3.11.2013</td><td><a href="profileTournament">Turnaj 1</a></td><td>KE</td></tr>
					<tr><td>3.11.2013</td><td><a href="profileTournament">Turnaj 1</a></td><td>KE</td></tr>
					<tr><td>3.11.2013</td><td><a href="profileTournament">Turnaj 1</a></td><td>KE</td></tr>
				</table>

				
			</div>
			
		</div>
	
	
	
	</div>
	<c:import url="import/footer.jsp"></c:import>

</div>

</body>

</html>
	