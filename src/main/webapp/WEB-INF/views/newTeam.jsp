<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/style.css"></c:url>'/>
<title>${pageTitle}</title>
<script type="text/javascript" src='<c:url value="/resources/filterlist.js"></c:url>'></script>

</head>

<body>

<div id="wrapper">
	<c:import url="import/menu.jsp"></c:import>
	<div id="content">
	<h2>Vytvorenie nového tímu ::</h2>
		<form id="centerContent">
			<table>
				<tr><td>Názov tímu:</td><td><input type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Mesto:</td><td><input type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Krajina:</td><td><input type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Dátum zalozenia:</td><td><input type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Web:</td><td><input type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Kontakt (email):</td><td><input type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Kontakt (telefon):</td><td><input type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Kontakt (FB):</td><td><input type="text" size="30" maxlength="50"/></td></tr>

			</table>
			<br/>
			<table>
				<tr class="boldTextTd"><td>Tréningy</td></tr>
				<tr><td>Pondelok</td><td><input type="checkbox"/></td><td>o <input type="text"/> hod</td></tr>
				<tr><td>Utorok</td><td><input type="checkbox"/></td><td>o <input type="text"/> hod</td></tr>
				<tr><td>Streda</td><td><input type="checkbox"/></td><td>o <input type="text"/> hod</td></tr>
				<tr><td>Štvrtok</td><td><input type="checkbox"/></td><td>o <input type="text"/> hod</td></tr>
				<tr><td>Piatok</td><td><input type="checkbox"/></td><td>o <input type="text"/> hod</td></tr>
				<tr><td>Sobota</td><td><input type="checkbox"/></td><td>o <input type="text"/> hod</td></tr>
				<tr><td>Nedeľa</td><td><input type="checkbox"/></td><td>o <input type="text"/> hod</td></tr>
			</table>
			<br/>
			<table>
				
				<tr><td><p>Pridaj hráčov:<br/><small><a href="#">Obnov zoznam</a></small></p></td><td>
						
						<select id="zoznamHracov" multiple="multiple" size="6">
							<c:forEach var="players" items="${playerData}">
							<option value="${players.player_id}">${players.firstName} ${players.lastName}</option>
							</c:forEach>
						</select>
						<script type="text/javascript">
							<!--
							var myfilter = new filterlist(document.getElementById("zoznamHracov"));
							//-->
							</script>
						
				</td><td>Rýchle hľadanie<br/><input id="textBoxSearch" type="text" value="" onkeyup="myfilter.set(this.value);"/></td>
				<td><br/><input type="button" value="Pridaj" onclick="
															var selected = document.getElementById('zoznamHracov').options[document.getElementById('zoznamHracov').selectedIndex];
															var options = '\<option\>' + selected.innerHTML;
															
															var second = document.getElementById('zoznamPridanychHracov');
															var options = second.innerHTML + options;
															
															second.innerHTML = options;" /></td>
				<td><select id="zoznamPridanychHracov" multiple="multiple" size="6"></select></td></tr>
				
			</table>
			<br/>
				
			<input type="submit" value="Vytvor tím"/>
		</form>

	</div>
	<c:import url="import/footer.jsp"></c:import>

</div>

</body>

</html>