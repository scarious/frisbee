<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	<c:if test="${empty loggedPlayerData and empty otherPlayerData}">
    	<div id="profileInfoNoData">
    		Nemáš ešte vytvorený profil hráča! <br />
    		Vytvoríš si ho po vyplnení údajov nižšie a kliknutí na tlačidlo "Vytvoriť profil" pod formulárom.
    	</div>
	</c:if>
	
	
	<h2>PROFIL Hráča ::
		<c:if test="${not empty loggedPlayerData and empty otherPlayerData}">
			<input type="button" onclick="editOnOff()" id="editSwitch" value="UPRAVIŤ"/>
		</c:if></h2>
		<div id="profileInfo">
			<c:if test="${(not empty loggedPlayerData) or (not empty otherPlayerData)}">
				<form name="profileForm" action="/aplikacia/profile" method="post">
			</c:if>
			<c:if test="${empty loggedPlayerData}">
				<form name="profileForm" action="/aplikacia/profile/New" method="post">
			</c:if>
				<table>
					<tr><td class="boldTextTd">Meno:</td><td class="elementsContainer">
															<p class="viewOnly" style="visibility: visible;">${loggedPlayerData.firstName}</p> 
															<input class="editOnly" size="30" style="visibility: hidden;" type="text" name="firstName" value="${loggedPlayerData.firstName}"/>
														 </td></tr>
					<tr><td class="boldTextTd">Priezvisko:</td><td class="elementsContainer">
																<p class="viewOnly" style="visibility: visible;">${loggedPlayerData.lastName}</p>
																<input class="editOnly" size="30" style="visibility: hidden;" type="text" name="lastName" value="${loggedPlayerData.lastName}"/>
															   </td></tr>
					<tr><td class="boldTextTd">Mesto:</td><td class="elementsContainer">
															<p class="viewOnly" style="visibility: visible;">${playerAddress.city}</p> 
															<select class="editOnly"style="visibility: hidden;" name="city">
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
												</td></tr>
					<tr><td class="boldTextTd">Krajina:</td><td class="elementsContainer">
															<p class="viewOnly" style="visibility: visible;">${playerAddress.country}</p>
															<select class="editOnly" style="visibility: hidden;" name="country">
																  <optgroup label="Krajiny">
																    <c:if test="${playerAddress.country != null}">
																	    	<option value="${playerAddress.country}">${playerAddress.country}</option>
																	</c:if>
																    <c:if test="${playerAddress.country != 'Slovensko' }"><option value="Slovensko">Slovensko</option></c:if>
																    <c:if test="${playerAddress.country != 'Česko' }"><option value="Česko">Česko</option></c:if>
																    <c:if test="${playerAddress.country != 'Poľsko' }"><option value="Poľsko">Poľsko</option></c:if>
																  </optgroup>
															</select>
												</td></tr>
					<tr><td class="boldTextTd">Dátum narodenia:</td><td class="elementsContainer">
																		<p class="viewOnly" style="visibility: visible;"><fmt:formatDate value="${loggedPlayerData.dateOfBirth}" pattern="yyyy-MM-dd" /></p>
																		<input size="30" class="editOnly" style="visibility: hidden;" type="text" name="dateOfBirth" value="<fmt:formatDate value="${loggedPlayerData.dateOfBirth}" pattern="yyyy-MM-dd" />"/>
																	</td></tr>
					<tr><td class="boldTextTd">Pohlavie:</td><td class="elementsContainer">
																<p class="viewOnly" style="visibility: visible;">${loggedPlayerData.pohlavie}</p>
																<select class="editOnly" style="visibility: hidden;" name="pohlavie">
																	  <optgroup label="Pohlavie">
																	    <c:if test="${loggedPlayerData.pohlavie != null}">
																	    	<option value="${loggedPlayerData.pohlavie}">${loggedPlayerData.pohlavie}</option>
																	    </c:if>
																	    <c:if test="${loggedPlayerData.pohlavie != 'Muž' }"><option value="Muž">Muž</option></c:if>
																	    <c:if test="${loggedPlayerData.pohlavie != 'Žena' }"><option value="Žena">Žena</option></c:if>
																	  </optgroup>
																</select>
									
																 </td></tr>
					<tr><td class="boldTextTd">Hráčom od:</td><td class="elementsContainer">
																<p class="viewOnly" style="visibility: visible;"><fmt:formatDate value="${loggedPlayerData.activeSince}" pattern="yyyy-MM-dd" /></p>
																<input class="editOnly" size="30" style="visibility: hidden;" type="text" name="activeSince" value="<fmt:formatDate value="${loggedPlayerData.activeSince}" pattern="yyyy-MM-dd" />"/>
															  </td></tr>
					<tr><td class="boldTextTd">Dominantná ruka:</td><td class="elementsContainer">
																	<p class="viewOnly" style="visibility: visible;">${loggedPlayerData.dominantHand}</p>
																	<select class="editOnly" style="visibility: hidden;" name="dominantHand">
																	  <optgroup label="DominantnaRuka">
																	    <c:if test="${loggedPlayerData.dominantHand != null}">
																	    	<option value="${loggedPlayerData.dominantHand}">${loggedPlayerData.dominantHand}</option>
																		</c:if>
																	    <c:if test="${loggedPlayerData.dominantHand != 'pravá' }"><option value="pravá">Pravá</option></c:if>
																	    <c:if test="${loggedPlayerData.dominantHand != 'ľavá' }"><option value="ľavá">Ľavá</option></c:if>
																	  </optgroup>
																	</select>
																	</td></tr>
					<tr><td class="boldTextTd">Výška:</td><td class="elementsContainer">
																	<p class="viewOnly" style="visibility: visible;">${loggedPlayerData.height}</p>
																	<input class="editOnly" size="30" style="visibility: hidden;" type="text" name="height" value="${loggedPlayerData.height}"/>
														  </td></tr>
					<tr><td class="boldTextTd">Disciplíny:</td><td class="elementsContainer">
																	<p class="viewOnly" style="visibility: visible;">${loggedPlayerData.disciplines}</p>
																	<input class="editOnly" size="30" style="visibility: hidden;" type="text" name="disciplines" value="${loggedPlayerData.disciplines}"/>
															   </td></tr>
					<tr><td class="boldTextTd" >Fotka (URL):</td><td class="elementsContainer">
																	<p class="viewOnly" style="visibility: visible;">${loggedPlayerData.urlImage}</p>
																	<input class="editOnly" size="30" style="visibility: hidden;" type="text" name="urlImage" value="${loggedPlayerData.urlImage}"/>
															   </td></tr>
					<tr class="viewOnlyWithoutStyle"><td class="boldTextTd">Tím(y):</td>
															<td class="elementsContainer"><br/>
															<c:if test="${(not empty playerTeams)}">
																<c:forEach var="teams" items="${playerTeams}" varStatus="status">
																	<a href="profileTeam?id=${teams.team_id}">${teams.name}</a></br>
																</c:forEach>
															</c:if>
															<c:if test="${(empty playerTeams)}">
																<p>Hráč nie je v žiadnom tíme.</p>
															</c:if>
															</td></tr>
					<c:if test="${(not empty loggedPlayerData) and (empty otherPlayerData)}">
						<tr><td><input id="updProfileBtn" class="btnForCheck" style="visibility: hidden;" onclick="kontrolaProfileForm()" type="button" name="submit" value="Aktualizovať údaje"/></td><td></td></tr>
					</c:if>
					<c:if test="${(empty loggedPlayerData) and (empty otherPlayerData)}">
						<tr><td></td><td><input class="btnForCheck" onclick="kontrolaProfileForm()" type="button" name="submit" value="VYTVORIŤ PROFIL"/></td></tr>
						<script type="text/javascript">
							function showEditables(){
								for(var i = 0; i<document.getElementsByClassName('viewOnly').length; i++){
									document.getElementsByClassName('viewOnly')[i].style.visibility="hidden";
									document.getElementsByClassName('editOnly')[i].style.visibility="visible";
								}
								document.getElementsByClassName('viewOnlyWithoutStyle')[0].style.visibility="hidden";
							}
							showEditables();
						</script>
					</c:if>
				</table>
			</form>		
			<script type="text/javascript">
				var editable = true;
				function editOnOff(){
					
					if(editable){
						for(var i = 0; i<document.getElementsByClassName('viewOnly').length; i++){
							document.getElementsByClassName('viewOnly')[i].style.visibility="hidden";
							document.getElementsByClassName('editOnly')[i].style.visibility="visible";
						}
						document.getElementsByClassName('viewOnlyWithoutStyle')[0].style.visibility="hidden";
						document.getElementById('updProfileBtn').style.visibility="visible";
						editable = false;
					} else {
						for(var i = 0; i<document.getElementsByClassName('viewOnly').length; i++){
							document.getElementsByClassName('viewOnly')[i].style.visibility="visible";
							document.getElementsByClassName('editOnly')[i].style.visibility="hidden";
						}
						document.getElementsByClassName('viewOnlyWithoutStyle')[0].style.visibility="visible";
						document.getElementById('updProfileBtn').style.visibility="hidden";
						editable = true;
					}
					
				
				}
				
				function kontrolaProfileForm(){
					var input = new Array();
					input[0] = document.forms['profileForm']['firstName'].value;
					input[1] = document.forms['profileForm']['lastName'].value;
					input[1] = document.forms['profileForm']['dateOfBirth'].value;
					input[1] = document.forms['profileForm']['activeSince'].value;
					input[1] = document.forms['profileForm']['height'].value;
					
					var allOk = true;
					var error = "";
					for(var i = 0; i < input.length; i++){
						if (input[i] == null || input[i] == ""){
							error = error + "\nVšetky polia musia byť vyplnené!";
							allOk = false;
							break;
						} 
					}
					
					if(allOk){
						document.getElementsByClassName('btnForCheck')[0].type = "submit";
						document.getElementsByClassName('btnForCheck')[1].type = "submit";
					}else{
						alert("Chyba" + error);
					}
					
					
				}
				
			</script>
		</div>
		<c:if test="${not empty loggedPlayerData}">
			<div id="profileAvatar"><img id="profileAvatarImg" alt="Avatar hraca" src='<c:url value="/resources/images/default_avatar.jpg"></c:url>'/></div>	
			<br/><br/><br/>
			<div id="centerContent" class="topFiveMain">
				<p>Štatistika hráča</p>
				<table>
					<tr class="boldTextTd grayRow"><td>Body</td><td>Prihrávky</td><td>Úspešné prihrávky</td><td>Dropy</td><td>Obrany</td></tr>
					<c:if test="${(not empty loggedPlayerData) and (not empty playerStats)}">
					<tr><td>${playerStats.points}</td><td>${playerStats.sent_passes}</td><td>${playerStats.successfull_passes}</td><td>${playerStats.drops}</td><td>${playerStats.defences}</td></tr>
					</c:if>
				</table>
			</div>
		</c:if>	
	
	</div>
	<c:import url="import/footer.jsp"></c:import>

</div>

</body>

</html>
	