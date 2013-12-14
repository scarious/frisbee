<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/style.css"></c:url>'/>
<title>${pageTitle}</title>
<script type="text/javascript" src='<c:url value="/resources/filterlist.js"></c:url>'></script>
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
			<form name="/aplikacia/tournamentsNewAdd">
			<table>
				<tr><td>Nazov turnaja:</td><td><input type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Mesto:</td><td><input type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Krajina:</td><td><input type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Dátum zaciatku:</td><td><input type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Dátum ukoncenia:</td><td><input type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Min. pocet timov:</td><td><input id="minPocet" type="text" size="30" maxlength="50"/></td></tr>
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
				<tr><td>Schedule</td>
				
				
				</tr>

						




			</table>
			<br/>
			<table>
				<tr><td><p>Pridaj tímy:<br/><small><a href="#">Obnov zoznam</a></small></p></td><td>
						<form name="myform">
						<select id="zoznamTimov" multiple="multiple" size="6">
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
															var selected = document.getElementById('zoznamTimov').options[document.getElementById('zoznamTimov').selectedIndex];
															var options = '\<option\>'+ selected.innerHTML;
															
															var second = document.getElementById('zoznamPridanychTimov');
															var options = second.innerHTML + options;
															var i = 1;
															second.innerHTML = options;
															document.getElementById('zoznamTimov').remove(document.getElementById('zoznamTimov').selectedIndex);
										
															" />
					<input type="button" value="Odober" onclick="

					var selected = document.getElementById('zoznamPridanychTimov').options[document.getElementById('zoznamPridanychTimov').selectedIndex];
					var options = '\<option\>' + selected.innerHTML;
					
					var second = document.getElementById('zoznamTimov');
					var options = second.innerHTML + options;
					var i = 1;
					second.innerHTML = options;
					document.getElementById('zoznamPridanychTimov').remove(document.getElementById('zoznamPridanychTimov').selectedIndex);
					
					" />
															</td>
				<td><select id="zoznamPridanychTimov" multiple="multiple" size="6"></select></td></tr>
				<td><br/><input type="button" value="Generuj rozpis" onclick="
					var minTeamNum = document.getElementById('minPocet').value;		
					var actualTeamNum = document.getElementById('zoznamPridanychTimov').length;
					if (actualTeamNum>=minTeamNum && schedule){
						
						switch(actualTeamNum){
						case 6:
							var table = document.getElementById('rozpis');

								var row1 = table.insertRow(1);
								var row2 = table.insertRow(2);
								var row3 = table.insertRow(3);
								var row4 = table.insertRow(4);
								var row5 = table.insertRow(5);
								var row6 = table.insertRow(6);								
								var row7 = table.insertRow(7);
								var row8 = table.insertRow(8);
								var row9 = table.insertRow(9);
								var row10 = table.insertRow(10);
								var row11 = table.insertRow(11);
								var row12 = table.insertRow(12);
								var row13 = table.insertRow(13);
								var row14 = table.insertRow(14);
								var row15 = table.insertRow(15);


							var cell1 = row1.insertCell(0);
							var cell2 = row2.insertCell(0);
							var cell3 = row3.insertCell(0);
							var cell4 = row4.insertCell(0);
							var cell5 = row5.insertCell(0);
							var cell6 = row6.insertCell(0);
							var cell7 = row7.insertCell(0);
							var cell8 = row8.insertCell(0);
							var cell9 = row9.insertCell(0);
							var cell10 = row10.insertCell(0);
							var cell11 = row11.insertCell(0);
							var cell12 = row12.insertCell(0);
							var cell13 = row13.insertCell(0);
							var cell14 = row14.insertCell(0);
							var cell15 = row15.insertCell(0);

							cell1.innerHTML = 'A4-A5';
							cell2.innerHTML = 'A2-A6';
							cell3.innerHTML = 'A1-A3';
							cell4.innerHTML = 'A2-A4';
							cell5.innerHTML = 'A3-A5';
							cell6.innerHTML = 'A1-A6';
							cell7.innerHTML = 'A2-A3';
							cell8.innerHTML = 'A4-A6';
							cell9.innerHTML = 'A1-A5';
							cell10.innerHTML = 'A3-A6';
							cell11.innerHTML = 'A2-A5';
							cell12.innerHTML = 'A1-A5';
							cell13.innerHTML = 'A5-A6';
							cell14.innerHTML = 'A3-A4';
							cell15.innerHTML = 'A1-A2';
							
							var table1 = document.getElementById('skupiny');
							var row1 = table1.insertRow(1);
							var row2 = table1.insertRow(2);
							var row3 = table1.insertRow(3);
							var row4 = table1.insertRow(4);
							var row5 = table1.insertRow(5);
							var row6 = table1.insertRow(6);								
	


						var cell1 = row1.insertCell(0);
						var cell2 = row2.insertCell(0);
						var cell3 = row3.insertCell(0);
						var cell4 = row4.insertCell(0);
						var cell5 = row5.insertCell(0);
						var cell6 = row6.insertCell(0);


						cell1.innerHTML = 'A1';
						cell2.innerHTML = 'A2';
						cell3.innerHTML = 'A3';
						cell4.innerHTML = 'A4';
						cell5.innerHTML = 'A5';
						cell6.innerHTML = 'A6';

							schedule = false;
							break;
							default:
								//document.getElementById('rozpis').innerHTML='Maly pocet timov';
							alert('maly pocet timov');
							break;
						}
					}

															
										
															" /></td>
		
			</table>
			<table id="skupiny" align="left"><tr><td>Skupiny</td></table>

			<table id="rozpis">
				<tr><td>Ihrisko 1</td></tr>
				
			</table>
			
				
			<input type="submit" value="Vytvor turnaj"/>
		</form>
		</div>
	
	
	
	</div>
	<c:import url="import/footer.jsp"></c:import>

</div>

</body>

</html>
	