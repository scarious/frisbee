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
	<c:if test="${empty loggedPlayerData}">
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
				<form name="loginForm" action="/aplikacia/profile" method="post">
			</c:if>
			<c:if test="${empty loggedPlayerData}">
				<form name="loginForm" action="/aplikacia/profile/New" method="post">
			</c:if>
				<table>
					<tr><td class="boldTextTd">Meno:</td><td class="elementsContainer">
															<p class="viewOnly" style="visibility: visible;">${loggedPlayerData.firstName}</p> 
															<input class="editOnly" style="visibility: hidden;" type="text" name="firstName" value="${loggedPlayerData.firstName}"/>
														 </td></tr>
					<tr><td class="boldTextTd">Priezvisko:</td><td class="elementsContainer">
																<p class="viewOnly" style="visibility: visible;">${loggedPlayerData.lastName}</p>
																<input class="editOnly" style="visibility: hidden;" type="text" name="lastName" value="${loggedPlayerData.lastName}"/>
															   </td></tr>
					<tr><td class="boldTextTd">Mesto:</td><td class="elementsContainer">
															<p class="viewOnly" style="visibility: visible;">${playerAddress.city}</p> 
															<select class="editOnly" style="visibility: hidden;" name="city">
																  <optgroup label="Mestá">
																    <option value="${playerAddress.city}">${playerAddress.city}</option>
																    <option value="PO">PO</option>
																    <option value="MI">MI</option>
																    <option value="SL">SL</option>
																    <option value="PP">PP</option>
																  </optgroup>
															</select>
												</td></tr>
					<tr><td class="boldTextTd">Krajina:</td><td class="elementsContainer">
															<p class="viewOnly" style="visibility: visible;">${playerAddress.country}</p>
															<select class="editOnly" style="visibility: hidden;" name="country">
																  <optgroup label="Krajiny">
																    <option value="${playerAddress.country}">${playerAddress.country}</option>
																    <option value="Česko">Česko</option>
																    <option value="Poľsko">Poľsko</option>
																  </optgroup>
															</select>
												</td></tr>
					<tr><td class="boldTextTd">Dátum narodenia:</td><td class="elementsContainer">
																		<p class="viewOnly" style="visibility: visible;"><fmt:formatDate value="${loggedPlayerData.dateOfBirth}" pattern="yyyy-MM-dd" /></p>
																		<input class="editOnly" style="visibility: hidden;" type="text" name="dateOfBirth" value="<fmt:formatDate value="${loggedPlayerData.dateOfBirth}" pattern="yyyy-MM-dd" />"/>
																	</td></tr>
					<tr><td class="boldTextTd">Pohlavie:</td><td class="elementsContainer">
																<p class="viewOnly" style="visibility: visible;">${loggedPlayerData.pohlavie}</p>
																<input class="editOnly" style="visibility: hidden;" type="text" name="pohlavie" value="${loggedPlayerData.pohlavie}"/>
															 </td></tr>
					<tr><td class="boldTextTd">Hráčom od:</td><td class="elementsContainer">
																<p class="viewOnly" style="visibility: visible;"><fmt:formatDate value="${loggedPlayerData.activeSince}" pattern="yyyy-MM-dd" /></p>
																<input class="editOnly" style="visibility: hidden;" type="text" name="activeSince" value="<fmt:formatDate value="${loggedPlayerData.activeSince}" pattern="yyyy-MM-dd" />"/>
															  </td></tr>
					<tr><td class="boldTextTd">Dominantná ruka:</td><td class="elementsContainer">
																	<p class="viewOnly" style="visibility: visible;">${loggedPlayerData.dominantHand}</p>
																	<input class="editOnly" style="visibility: hidden;" type="text" name="dominantHand" value="${loggedPlayerData.dominantHand}"/>
																	</td></tr>
					<tr><td class="boldTextTd">Výška:</td><td class="elementsContainer">
																	<p class="viewOnly" style="visibility: visible;">${loggedPlayerData.height}</p>
																	<input class="editOnly" style="visibility: hidden;" type="text" name="height" value="${loggedPlayerData.height}"/>
														  </td></tr>
					<tr><td class="boldTextTd">Disciplíny:</td><td class="elementsContainer">
																	<p class="viewOnly" style="visibility: visible;">${loggedPlayerData.disciplines}</p>
																	<input class="editOnly" style="visibility: hidden;" type="text" name="disciplines" value="${loggedPlayerData.disciplines}"/>
															   </td></tr>
					<tr><td class="boldTextTd">Tím(y):</td><td class="elementsContainer"><br/>
															</td></tr>
					<c:if test="${(not empty loggedPlayerData) and (empty otherPlayerData)}">
						<tr><td><input id="updProfileBtn" style="visibility: hidden;" type="submit" name="submit" value="Aktualizovať údaje"/></td><td></td></tr>
					</c:if>
					<c:if test="${(empty loggedPlayerData) and (empty otherPlayerData)}">
						<tr><td></td><td><input type="submit" name="submit" value="VYTVORIŤ PROFIL"/></td></tr>
						<script type="text/javascript">
							function showEditables(){
								for(var i = 0; i<document.getElementsByClassName('viewOnly').length; i++){
									document.getElementsByClassName('viewOnly')[i].style.visibility="hidden";
									document.getElementsByClassName('editOnly')[i].style.visibility="visible";
								}
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
						document.getElementById('updProfileBtn').style.visibility="visible";
						editable = false;
					} else {
						for(var i = 0; i<document.getElementsByClassName('viewOnly').length; i++){
							document.getElementsByClassName('viewOnly')[i].style.visibility="visible";
							document.getElementsByClassName('editOnly')[i].style.visibility="hidden";
						}
						document.getElementById('updProfileBtn').style.visibility="hidden";
						editable = true;
					}
					
				
				}
				
				
			</script>
		</div>
		<c:if test="${not empty loggedPlayerData}">
			<div id="profileAvatar"><img id="profileAvatarImg" alt="Avatar hraca" src='<c:url value="/resources/images/default_avatar.jpg"></c:url>'/></div>	
			<br/><br/><br/>
			<div id="centerContent">
				<table>
					<tr class="boldTextTd grayRow"><td>Odohrané zápasy</td><td>Výhry</td><td>Prehry</td></tr>
					<tr style="text-align:center"><td>20</td><td>15</td><td>5</td></tr>
				</table>
			</div>
		</c:if>	
	
	</div>
	<c:import url="import/footer.jsp"></c:import>

</div>

</body>

</html>
	