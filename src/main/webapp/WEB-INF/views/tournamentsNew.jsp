<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/style.css"></c:url>'/>
<title>${pageTitle}</title>
<script type="text/javascript" src='<c:url value="/resources/filterlist.js"></c:url>'></script>
<script type="text/javascript" src='<c:url value="/resources/schedules.js"></c:url>'></script>
<script type="text/javascript">
var schedule = true; // global
</script>
</head>

<body>

<div id="wrapper">
	<c:import url="import/menu.jsp"></c:import>
	<div id="content">
	<h2>Vytvorenie turnaja ::</h2> <h3><a href="tournaments">Vyhľadávanie</a>&nbsp;:&nbsp;<a href="tournamentsNew">Pridaj nový turnaj</a></h3>
		<div id="centerContent">
			<form id="novyturnaj" name="newtournamentform" method="POST" action="/aplikacia/tournamentsNew">
			<table>
				<tr><td>Nazov turnaja:</td><td><input name="name" type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Mesto:</td><td><input name="city" type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Krajina:</td><td><input name="country" type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Dátum:</td><td><input name="date2" type="text" size="30" maxlength="50"/></td></tr>	
				<tr><td>Discipliny:</td><td><input name="disciplines" type="text" size="30" maxlength="50"/></td></tr>		
				<tr><td>Kontakt (email):</td><td><input type="text" name="email2" size="30" maxlength="50"/></td></tr>
				<tr><td>Kontakt (telefon):</td><td><input type="text" name="contact" size="30" maxlength="50"/></td></tr>
				<tr><td>Povrch:</td><td><input type="text" name="surface" size="30" maxlength="50"/></td></tr>
				<tr><td>Uroven hry:</td><td><input type="text" name="level_of_play" size="30" maxlength="50"/></td></tr>	
				<tr><td>Divizia:</td><td><input name="division" type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>GPS:</td><td><input name="gps_coord" type="text" size="30" maxlength="50"/></td></tr>
				
				<tr><td>Usporiadatel:</td><td><input type="text" name="organizator" size="30" maxlength="50"/></td></tr>
				<tr><td>Min. pocet timov:</td><td><input name="minPocet" id="minPocet" type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Registračný poplatok: (tím):</td><td><input name="PF2" type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Registračný poplatok: (hráč):</td><td><input name="TF2" type="text" size="30" maxlength="50"/></td></tr>
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
				<tr><td>Schedule</td>			
				</tr>
			</table>
			<br/>
			<table>
				<tr><td><p>Pridaj tímy:<br/><small><a href="#">Obnov zoznam</a></small></p></td><td>
						<!-- <form name="myform">  -->
						<select id="zoznamTimov" multiple="multiple" size="6">
							<option>Tím 1</option>
							<option>Tím 2</option>
							<option>Tím 3</option>
							<option>Tím 4</option>
							<option>Tím 5</option>
							<option>Tím 6</option>
							<option>Tím 7</option>
							<option>Tím 8</option>
							<option>Tím 9</option>
						</select>
						<script type="text/javascript">
							<!--
							var myfilter = new filterlist(document.getElementById("zoznamHracov"));
							//-->
							</script>
						<!-- </form>  -->
				</td><td>Rýchle hľadanie<br/><input id="textBoxSearch" type="text" value="" onkeyup="myfilter.set(this.value);"/></td>
				<td><br/><input type="button" value="Pridaj" onclick="
															var selected = document.getElementById('zoznamTimov').options[document.getElementById('zoznamTimov').selectedIndex];
															var options = '\<option\>'+ selected.innerHTML;
															
															var second = document.getElementById('zoznamPridanychTimov');
															var options = second.innerHTML + options;
															var i = 1;
															second.innerHTML = options;
															document.getElementById('zoznamTimov').remove(document.getElementById('zoznamTimov').selectedIndex);
															schedule = true;
															" />
					<input type="button" value="Odober" onclick="
					var selected = document.getElementById('zoznamPridanychTimov').options[document.getElementById('zoznamPridanychTimov').selectedIndex];
			     	var options = '\<option\>' + selected.innerHTML;
					
					var second = document.getElementById('zoznamTimov');
					var options = second.innerHTML + options;
					var i = 1;
					second.innerHTML = options;
					document.getElementById('zoznamPridanychTimov').remove(document.getElementById('zoznamPridanychTimov').selectedIndex);
					schedule = true;
					" />
															</td>
				<td><select id="zoznamPridanychTimov" multiple="multiple" size="6"></select></td></tr>
				<td><br/><input type="button" id ="gen" value="Generuj rozpis" onclick="
				javascript:
				var minpocet = document.getElementById('minPocet').value;
				var aktual = document.getElementById('zoznamPridanychTimov').length;
				var tabrozpis = document.getElementById('rozpis');
				var tabskupiny = document.getElementById('skupiny');
				var bool = schedule;
				 schedulegen(minpocet,aktual,tabrozpis,tabskupiny,schedule);

				
				 
				 " /></td>
			</table>
			<table id="skupiny" align="left"><tr><td>Skupiny</td></table>
 	<div style="margin-left:100px" position: relative>
			<table id="rozpis">
				<tr><td>Ihrisko 1</td></tr>
				
			</table>
			</div>>
				
			<input type="submit" name="submit" value="Vytvor turnaj"/>
		</form>
		</div>
	
	
	
	</div>
	<c:import url="import/footer.jsp"></c:import>

</div>

</body>

</html>
	