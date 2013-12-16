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
							//var myfilter = new filterlist(document.getElementById('centerContent2'));
							function doSearch(text) {
    var searchText = text.toLowerCase();
    var targetTable = document.getElementById('topTeamsIndexTable');
    var targetTableColCount=0;
            
    //Loop through table rows
    for (var rowIndex = 0; rowIndex < targetTable.rows.length; rowIndex++) {
        var rowData = '';

        //Get column count from header row
        if (rowIndex == 0) {
         //  targetTableColCount = targetTable.rows.item(rowIndex).cells.length;
           continue; //do not execute further code for header row.
        }
                
        //Process data rows. (rowIndex >= 1)
        for (var colIndex = 0; colIndex <= targetTableColCount; colIndex++) {
            rowData += targetTable.rows.item(rowIndex).cells.item(colIndex).textContent.toLowerCase();
        }

        //If search term is not found in row data
        //then hide the row, else show
        if (rowData.indexOf(searchText) == -1)
            targetTable.rows.item(rowIndex).style.display = 'none';
        else
            targetTable.rows.item(rowIndex).style.display = 'table-row';
    }
}
		</script>
</head>

<body>

<div id="wrapper">
	<c:import url="import/menu.jsp"></c:import>
	<div id="content">
	<h2>Tímy ::</h2> <h3><a href="teams">Vyhľadávanie</a>&nbsp;:&nbsp;<a href="teamsTop">Najlepšie tímy</a>&nbsp;:&nbsp;<a href="newTeam">Vytvor nový tím</a></h3>
		<div id="centerContent">
			Filter tímov podľa: 
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
	
			<br/>
			Vyhľadávanie: <input type="text" size="25" maxlength="50" onkeyup="doSearch(this.value);"/>	
			<input type="submit" name="Hľadaj" title="asd" value="Hľadaj"/>
		</div>
		<div id="centerContent" class="topFiveMain">
			<table id="topTeamsIndexTable">
				<tr class="grayRow"><td>Názov tímu</td><td>Krajina</td><td>Mesto</td><td>Počet hráčov</td><td></td></tr>
				<c:forEach var="teams" items="${teamsList}" varStatus="status">
					<tr><td>${teams.name}</td><td>${teams.country}</td><td>${teams.city}</td><td id="centerContent">${playersCount[status.index]}</td><td><a href="profileTeam?id=${teams.team_id}">Profil</a></td></tr>
				</c:forEach>
			</table>
		</div>
	
	
	
	</div>
	<c:import url="import/footer.jsp"></c:import>

</div>

</body>

</html>
	