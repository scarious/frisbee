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
	<h2>Vytvorenie turnaja ::</h2> <h3><a href="tournaments">Vyhľadávanie</a>&nbsp;:&nbsp;<a href="tournamentsNew">Pridaj nový turnaj</a></h3>
		<div id="centerContent">
			<form>
			<table>
				<tr><td>Nazov turnaja:</td><td><input type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Mesto:</td><td><input type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Krajina:</td><td><input type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Dátum zaciatku:</td><td><input type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Dátum ukoncenia:</td><td><input type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Max. pocet timov:</td><td><input type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Usporiadatel:</td><td><input type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Kontakt (email):</td><td><input type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Kontakt (telefon):</td><td><input type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Kontakt (FB):</td><td><input type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Registračný poplatok: (tím):</td><td><input type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Registračný poplatok: (hráč):</td><td><input type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Divízia:</td><td><select>
												<option>Open</option>
												<option>Mixed</option>
												<option>Women</option>
										 </select></td></tr>
				<tr><td>Kategória:</td><td><select><option>U18</option>
												<option>U20</option>
												<option>U23</option>
												<option>Elite</option>
												<option>Master</option>
										 </select></td></tr>

						




			</table>
			<br/>
			<table>
				<tr><td><p>Pridaj tímy:<br/><small><a href="#">Obnov zoznam</a></small></p></td><td>
						<form name="myform">
						<select id="zoznamHracov" multiple="multiple" size="6">
							<option>Tím 1</option>
							<option>Tím 2</option>
							<option>Tím 3</option>
							<option>Tím 4</option>
						</select>
						<script type="text/javascript">
							<!--
							var myfilter = new filterlist(document.getElementById("zoznamHracov"));
							//-->
							</script>
						</form>
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
				
			<input type="submit" value="Vytvor turnaj"/>
		</form>
		</div>
	
	
	
	</div>
	<c:import url="import/footer.jsp"></c:import>

</div>

</body>

</html>
	