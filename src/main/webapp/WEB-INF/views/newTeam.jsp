<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/style.css"></c:url>'/>
<script type="text/javascript"
     src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDYr2Hd6_FhH1YQCtDf4-8AGRM5qN4JiEY&sensor=true">
</script>
<script type="text/javascript" src='<c:url value="/resources/markerwithlabel.js"></c:url>'></script>
<script type="text/javascript" src='<c:url value="/resources/mapa.js"></c:url>'></script>
<title>${pageTitle}</title>
<script type="text/javascript" src='<c:url value="/resources/filterlist.js"></c:url>'></script>

</head>

<body>

<div id="wrapper">
	<c:import url="import/menu.jsp"></c:import>
	<div id="content">
	<h2>Vytvorenie nového tímu ::</h2>
		<form id="centerContent" name="newTeamForm" method="post" action="/aplikacia/newTeam">
			<table>
				<tr><td>Názov tímu:</td><td><input name="name" type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Mesto:</td><td>
									<select name="city">
																  <optgroup label="Mestá">
																    <c:if test="${playerAddress.city != null}">
																	    	<option value="${playerAddress.city}">${playerAddress.city}</option>
																	</c:if>
																    <c:if test="${playerAddress.city != 'PO' }"><option value="PO">PO</option></c:if>
																    <c:if test="${playerAddress.city != 'MI' }"><option value="MI">MI</option></c:if>
																    <c:if test="${playerAddress.city != 'SL' }"><option value="SL">SL</option></c:if>
																    <c:if test="${playerAddress.city != 'PP' }"><option value="PP">PP</option></c:if>
																    <c:if test="${playerAddress.city != 'KE' }"><option value="KE">KE</option></c:if>
																    <c:if test="${playerAddress.city != 'BA' }"><option value="BA">BA</option></c:if>
																    <c:if test="${playerAddress.city != 'TN' }"><option value="TN">TN</option></c:if>
																  </optgroup>
									</select>
									</td>
				</tr>
				<tr><td>Krajina:</td><td>
										
										<select name="country">
																  <optgroup label="Krajiny">
																    <c:if test="${playerAddress.country != null}">
																	    	<option value="${playerAddress.country}">${playerAddress.country}</option>
																	</c:if>
																    <c:if test="${playerAddress.country != 'Slovensko' }"><option value="Slovensko">Slovensko</option></c:if>
																    <c:if test="${playerAddress.country != 'Česko' }"><option value="Česko">Česko</option></c:if>
																    <c:if test="${playerAddress.country != 'Poľsko' }"><option value="Poľsko">Poľsko</option></c:if>
																  </optgroup>
										</select>
									</td>
				</tr>
				<tr><td>Dátum zalozenia:</td><td><input name="datumZalozenia" type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Web:</td><td><input name="website" type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Kontakt (email):</td><td><input name="contact_email" type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Kontakt (telefon):</td><td><input name="contact_phone" type="text" size="30" maxlength="50"/></td></tr>
				<tr><td>Kontakt (FB):</td><td><input name="contact_fb" type="text" size="30" maxlength="50"/></td></tr>

			</table>
			<br/>
			<table>
				<tr class="boldTextTd"><td>Tréningy</td></tr>
				<tr><td>Pondelok</td><td><input id="poChk" type="checkbox"/></td><td>o <input id="poTime" type="text"/> hod</td></tr>
				<tr><td>Utorok</td><td><input id="utChk" type="checkbox"/></td><td>o <input id="utTime" type="text"/> hod</td></tr>
				<tr><td>Streda</td><td><input id="strChk" type="checkbox"/></td><td>o <input id="strTime" type="text"/> hod</td></tr>
				<tr><td>Štvrtok</td><td><input id="stvChk" type="checkbox"/></td><td>o <input id="stvTime" type="text"/> hod</td></tr>
				<tr><td>Piatok</td><td><input id="piChk" type="checkbox"/></td><td>o <input id="piTime" type="text"/> hod</td></tr>
				<tr><td>Sobota</td><td><input id="soChk" type="checkbox"/></td><td>o <input id="soTime" type="text"/> hod</td></tr>
				<tr><td>Nedeľa</td><td><input id="neChk" type="checkbox"/></td><td>o <input id="neTime" type="text"/> hod</td></tr>
				<tr><td></td><td></td></tr>
				<tr><td>Miesto tréningu:</td><td></td><td><input id="gps" value="Klikni na mape!" size="50" name="gpsMiestoTreningu" readonly type="text"/></td></tr>
			</table>
				<input type="hidden" value="" name="trainings"/>
			<br/>
			<table>
			<div onclick="setGpsNewTeam()" id="centerContent"><div id="map-canvas"></div></div>
				</br>
				</br>
				<tr><td><p>Pridaj hráčov:<br/><small><a href="#">Obnov zoznam</a>
				</small></p></td><td>

						<select id="zoznamHracov" multiple="multiple" size="6">
							<c:forEach var="players" items="${playerData}">
							<option value="${players.player_id}">${players.firstName} ${players.lastName}</option>
							</c:forEach>
						</select>
						<script type="text/javascript">
							
							var myfilter = new filterlist(document.getElementById("zoznamHracov"));
						
							</script>
						
				</td><td>Rýchle hľadanie<br/><input id="textBoxSearch" type="text" value="" onkeyup="myfilter.set(this.value);"/></td>
				<td><br/><input type="button" value="Pridaj" onclick="moveToAnotherList()" />
				<input type="button" value="Odober" onclick="remove_player()" /></td>
				<td><select name="zoznamPridanychHracov" id="zoznamPridanychHracov" multiple="multiple" size="6"></select></td></tr>
				
			</table>
			<br/>
			<input type="hidden" name="playersForParsing" id="playersForParsing" value=""/>	
			<input class="btnForCheck" value="Vytvor tím" type="button" onclick="kontrolaTeamForm()"/>
		</form>
		<script type="text/javascript">
			function moveToAnotherList(){
				try{
				var selected = document.getElementById('zoznamHracov').options[document.getElementById('zoznamHracov').selectedIndex];
				var idFromSelected = document.getElementById('zoznamHracov').options[document.getElementById('zoznamHracov').selectedIndex].value;
				var options = '\<option value\=' + idFromSelected + '\>' + selected.innerHTML;
			
				var second = document.getElementById('zoznamPridanychHracov');
				var options = second.innerHTML + options;
				
				second.innerHTML = options;
				
				addIdForParsing();
				document.getElementById('zoznamHracov').remove(document.getElementById('zoznamHracov').selectedIndex);
				
				document.getElementById('textBoxSearch').value = "";
				}
				catch(err){}
			}	
			
			function remove_player(){
				try{
				var selected = document.getElementById('zoznamPridanychHracov').options[document.getElementById('zoznamPridanychHracov').selectedIndex];
				var idFromSelected = document.getElementById('zoznamPridanychHracov').options[document.getElementById('zoznamPridanychHracov').selectedIndex].value;
				var options = '\<option value\=' + idFromSelected + '\>' + selected.innerHTML;
				
	
				
				var second = document.getElementById('zoznamHracov');
				var options = second.innerHTML + options;
				
				second.innerHTML = options;
				
				addIdForParsing();
				document.getElementById('zoznamPridanychHracov').remove(document.getElementById('zoznamPridanychHracov').selectedIndex);
				}catch(err){}
	//			var selected = document.getElementById('zoznamPridanychHracov').options[document.getElementById('zoznamPridanychHracov').selectedIndex];
	//			var options = '\<option\>' + selected.innerHTML;
	//			var second = document.getElementById('zoznamHracov');
	//			var options = second.innerHTML + options;
	//			var i = 1;
	//			second.innerHTML = options;
	//			document.getElementById('zoznamPridanychHracov').remove(document.getElementById('zoznamPridanychHracov').selectedIndex);
					
			}
		
			function addIdForParsing(){
				
				var dlzkaZoznamu = document.getElementById('zoznamPridanychHracov').length;
				var temp = "";
				for(var i=0;i<dlzkaZoznamu;i++){
					temp = temp + document.getElementById('zoznamPridanychHracov').options[i].value + ";";
				}
				document.getElementById('playersForParsing').value = temp;
			}
			
			function checkIfTimeIsOk(time){
				var hh = time.split(":")[0];
				var mm = time.split(":")[1];
				if(isNaN(hh) || isNaN(mm)){
					return false;
				} else if(hh > 23 || mm > 59) {
					return false;
				}
				return true;
			}
		
			function concatTrainingData(){
				var finalString = "";
				var temp = "";
				var error = false;
				document.forms['newTeamForm']['trainings'].value;
				
				if(document.getElementById('poChk').checked){
					temp = document.getElementById('poTime').value;
					if(!checkIfTimeIsOk(temp)){
						error = true;
					}
					finalString = finalString + "Po," + temp + ";";
				} 
				
				if(document.getElementById('utChk').checked) {
					temp = document.getElementById('utTime').value;
					if(!checkIfTimeIsOk(temp)){
						error = true;
					}
					finalString = finalString + "Ut," + temp + ";";
				} 
				
				if(document.getElementById('strChk').checked) {
					temp = document.getElementById('strTime').value;
					if(!checkIfTimeIsOk(temp)){
						error = true;
					}
					finalString = finalString + "Str," + temp + ";";
				} 
				
				if(document.getElementById('stvChk').checked) {
					temp = document.getElementById('stvTime').value;
					if(!checkIfTimeIsOk(temp)){
						error = true;
					}
					finalString = finalString + "Stv," + temp + ";";
				} 
				
				if(document.getElementById('piChk').checked) {
					temp = document.getElementById('piTime').value;
					if(!checkIfTimeIsOk(temp)){
						error = true;
					}
					finalString = finalString + "Pi," + temp + ";";
				} 
				
				if(document.getElementById('soChk').checked) {
					temp = document.getElementById('soTime').value;
					if(!checkIfTimeIsOk(temp)){
						error = true;
					}
					finalString = finalString + "So," + temp + ";";
				} 
				
				if(document.getElementById('neChk').checked) {
					temp = document.getElementById('neTime').value;
					if(!checkIfTimeIsOk(temp)){
						error = true;
					}
					finalString = finalString + "Ne," + temp + ";";
					
				}
				
				if(error){
					alert("Chybný formát času! Zadajte v tvare HH:MM (napr. 13:30)");
				} else {
					document.forms['newTeamForm']['trainings'].value = finalString;
				}
			}
			
			function kontrolaTeamForm(){
				
				concatTrainingData();
				
				var input = new Array();
				input[0] = document.forms['newTeamForm']['name'].value;
				input[1] = document.forms['newTeamForm']['datumZalozenia'].value;
				
				
				var allOk = true;
				var allOk2 = true;
				var error = "";
				for(var i = 0; i < input.length; i++){
					if (input[i] == null || input[i] == ""){
						error = error + "\nNázov a dátum založenia musia byť vyplnené!";
						allOk = false;
						break;
					} 
				}
				
				input[0] = document.forms['newTeamForm']['website'].value;
				input[1] = document.forms['newTeamForm']['contact_email'].value;
				input[2] = document.forms['newTeamForm']['contact_phone'].value;
				input[3] = document.forms['newTeamForm']['contact_fb'].value;
				
				for(var i = 0; i < input.length; i++){
					if (input[i] == null || input[i] == ""){
						
						allOk2 = false;
						
					} else {
						allOk2 = true;
						break;
					}
					if(i == (input.length-1))
					error = error + "\nAspoň jedna kontaktná info musí byť vyplnená (web, email, cislo, fb)!";
				}
				
				if(allOk == true && allOk2 == true){
					document.getElementsByClassName('btnForCheck')[0].type = "submit";
					document.getElementsByClassName('btnForCheck')[1].type = "submit";
				}else{
					alert("Chyba" + error);
				}
				
				
			}
			
		</script>
	</div>
	<c:import url="import/footer.jsp"></c:import>

</div>

</body>

</html>