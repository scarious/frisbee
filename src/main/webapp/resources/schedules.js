/**
 * 
 */
function schedulegen(minpocet,aktual,tabrozpis,tabskupiny,bool){
	
	 var rows = tabrozpis.rows;
	  var i = rows.length;
	  while (rows.length>1) {
	    //rows[i].parentNode.removeChild(rows[i]);
	    // or

	    tabrozpis.deleteRow(rows.length-1);
	  //  alert(i);
	//    i--;
	  }
	  
		 var rows = tabskupiny.rows;
		  var i = rows.length;
		  while (rows.length>1) {
		    //rows[i].parentNode.removeChild(rows[i]);
		    // or
		    tabskupiny.deleteRow(rows.length-1);

		  }
		  
	var minTeamNum = minpocet;//document.getElementById('minPocet').value;		
	var actualTeamNum = aktual;//document.getElementById('zoznamPridanychTimov').length;
	if (actualTeamNum>=minTeamNum && bool){
		
		switch (actualTeamNum){
		case 6:
			var table = tabrozpis;// document.getElementById('rozpis');

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
			
			var table1 = tabskupiny;//document.getElementById('skupiny');
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

			bool = false;
			break;
			
		case 7:
			var table = tabrozpis;
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
			var row16 = table.insertRow(16);
			var row17 = table.insertRow(17);
			var row18 = table.insertRow(18);
			var row19 = table.insertRow(19);
			var row20 = table.insertRow(20);
			var row21 = table.insertRow(21);


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
		var cell16 = row16.insertCell(0);
		var cell17 = row17.insertCell(0);
		var cell18 = row18.insertCell(0);
		var cell19 = row19.insertCell(0);
		var cell20 = row20.insertCell(0);
		var cell21 = row21.insertCell(0);
		
		cell1.innerHTML = 'A6-A7';
		cell2.innerHTML = 'A2-A4';
		cell3.innerHTML = 'A3-A5';

		cell4.innerHTML = 'A4-A6';
		cell5.innerHTML = 'A7-A5';
		cell6.innerHTML = 'A1-A3';

		cell7.innerHTML = 'A2-A6';
		cell8.innerHTML = 'A5-A4';
		cell9.innerHTML = 'A1-A7';

		cell10.innerHTML = 'A6-A3';
		cell11.innerHTML = 'A2-A7';
		cell12.innerHTML = 'A1-A5';

		cell13.innerHTML = 'A2-A3';
		cell14.innerHTML = 'A4-A7';
		cell15.innerHTML = 'A1-A6';

		cell16.innerHTML = 'A2-A5';
		cell17.innerHTML = 'A3-A7';
		cell18.innerHTML = 'A1-A4';

		cell19.innerHTML = 'A5-A6';
		cell20.innerHTML = 'A3-A4';
		cell21.innerHTML = 'A1-A2';
		
		var table1 = tabskupiny;//document.getElementById('skupiny');
		
		var row1 = table1.insertRow(1);
		var row2 = table1.insertRow(2);
		var row3 = table1.insertRow(3);
		var row4 = table1.insertRow(4);
		var row5 = table1.insertRow(5);
		var row6 = table1.insertRow(6);
		var row7 = table1.insertRow(7);	



	var cell1 = row1.insertCell(0);
	var cell2 = row2.insertCell(0);
	var cell3 = row3.insertCell(0);
	var cell4 = row4.insertCell(0);
	var cell5 = row5.insertCell(0);
	var cell6 = row6.insertCell(0);
	var cell7 = row7.insertCell(0);


	cell1.innerHTML = 'A1';
	cell2.innerHTML = 'A2';
	cell3.innerHTML = 'A3';
	cell4.innerHTML = 'A4';
	cell5.innerHTML = 'A5';
	cell6.innerHTML = 'A6';
	cell7.innerHTML = 'A7';		
	
			bool = false;
			break;
		case 8:
			var table = tabrozpis;
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
			var row16 = table.insertRow(16);
			var row17 = table.insertRow(17);
			var row18 = table.insertRow(18);
			var row19 = table.insertRow(19);
			var row20 = table.insertRow(20);
			var row21 = table.insertRow(21);
			var row22 = table.insertRow(22);


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
		var cell16 = row16.insertCell(0);
		var cell17 = row17.insertCell(0);
		var cell18 = row18.insertCell(0);
		var cell19 = row19.insertCell(0);
		var cell20 = row20.insertCell(0);
		var cell21 = row21.insertCell(0);
		var cell22 = row22.insertCell(0);
			
			
			cell1.innerHTML ='A2-A4';	
			cell2.innerHTML ='A1-A3';	
			cell3.innerHTML = 'B2-B4';
			cell4.innerHTML = 'B1-B3';
			cell5.innerHTML ='A3-A4';	
			cell6.innerHTML ='A1-A2';	
			cell7.innerHTML = 'B3-B4';
			cell8.innerHTML = 'B1-B2';
			cell9.innerHTML ='A1-A4';	
			cell10.innerHTML ='A2-A3';	
			cell11.innerHTML = 'B1-B4';
			cell12.innerHTML = 'B2-B3';
				
			cell13.innerHTML ='x1:2B-3A';
			cell14.innerHTML ='x2:2A-3B';
			cell15.innerHTML ='S1:lx1-4B';	
			cell16.innerHTML ='S2:lx2-4A';
			cell17.innerHTML ='S3:wx1-1A';
			cell18.innerHTML ='S4:wx2-1B';
			cell19.innerHTML ='7/8:lS1-lS2';	
			cell20.innerHTML ='5/6:wS1-wS2';
			cell21.innerHTML ='3/4:lS3-lS4';	
			cell22.innerHTML ='1/2:wS3-wS4';
			
			var table1 = tabskupiny;//document.getElementById('skupiny');
			
			
			var row1 = table1.insertRow(1);
			var row2 = table1.insertRow(2);
			var row3 = table1.insertRow(3);
			var row4 = table1.insertRow(4);
			var row5 = table1.insertRow(5);
			var row6 = table1.insertRow(6);
			var row7 = table1.insertRow(7);
			var row8 = table1.insertRow(8);
			var row9 = table1.insertRow(9);
			var row10 = table1.insertRow(10);

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
		
		cell1.innerHTML = 'Skupina A';
		cell2.innerHTML = 'A1';
		cell3.innerHTML = 'A2';
		cell4.innerHTML = 'A3';
		cell5.innerHTML = 'A4';
		
		cell6.innerHTML = 'Skupina B';
		cell7.innerHTML = 'B1';
		cell8.innerHTML = 'B2';
		cell9.innerHTML = 'B3';
		cell10.innerHTML = 'B4';
			break;
			
		case 9:
			
			var table = tabrozpis;
			var row0 = table.rows[0];
			var cell0 = row0.insertCell(1);
			cell0.innerHTML='Ihrisko 2';
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
			var row16 = table.insertRow(16);
			
			
			var cell1 = row1.insertCell(0);
			var cell2 = row1.insertCell(1);
			var cell3 = row2.insertCell(0);
			var cell4 = row2.insertCell(1);
			var cell5 = row3.insertCell(0);
			var cell6 = row3.insertCell(1);
			var cell7 = row4.insertCell(0);
			var cell8 = row4.insertCell(1);
			var cell9 = row5.insertCell(0);
			var cell10 = row5.insertCell(1);
			var cell11 = row6.insertCell(0);
			var cell12 = row6.insertCell(1);
			var cell13 = row7.insertCell(0);
			var cell14 = row7.insertCell(1);
			var cell15 = row8.insertCell(0);
			var cell16 = row8.insertCell(1);
			var cell17 = row9.insertCell(0);
			var cell18 = row10.insertCell(0);
			var cell19 = row11.insertCell(0);
			var cell20 = row11.insertCell(1);
			var cell21 = row12.insertCell(0);
			var cell22 = row12.insertCell(1);
			var cell23 = row13.insertCell(0);
			var cell24 = row13.insertCell(1);
			var cell25 = row14.insertCell(0);
			var cell26 = row14.insertCell(1);
			var cell27 = row15.insertCell(0);
			var cell28 = row15.insertCell(1);
			var cell29 = row16.insertCell(0);
			
			
			cell1.innerHTML= 'A1 - A3';
			cell2.innerHTML= 'B1 - B3';
			cell3.innerHTML= 'C1 - C3';
			cell4.innerHTML= 'A2 - A3';
			cell5.innerHTML= 'B2 - B3';
			cell6.innerHTML= 'C2 - C3';
			cell7.innerHTML= 'A1 - A2';
			cell8.innerHTML= 'B1 - B2';
			cell9.innerHTML= 'C1 - C2';
			cell10.innerHTML= 'X1: 1A - 3B';
			cell11.innerHTML= 'M1 - M2';
			cell12.innerHTML= 'X2:1B - 3C';
			cell13.innerHTML= 'M1 - M3';
			cell14.innerHTML= 'X3: 1C - 3A';
			cell15.innerHTML= 'M2 - M3';
			cell16.innerHTML= 'D3 - D5';
			cell17.innerHTML= 'D1/D2 - D4';
			cell18.innerHTML= '2. deň';
			cell19.innerHTML= 'D4 - D5';
			cell20.innerHTML= 'D1/D2 - D3';
			cell21.innerHTML= 'SF1: wX1-1M';
			cell22.innerHTML= 'SF2: wX2 - wX3';
			cell23.innerHTML= 'D1/D2 - D3';
			cell24.innerHTML= 'D1/D2 - D5';
			cell25.innerHTML= 'D1/D2 - D5';
			cell26.innerHTML= 'D1/D2 - D4';
			cell27.innerHTML= 'D3 - D4';
			cell28.innerHTML= '3/4: lSF1 - lSF2';
			cell29.innerHTML= 'F: wSF1-wSF2';
			
	var table1 = tabskupiny;//document.getElementById('skupiny');
			
			
			var row1 = table1.insertRow(1);
			var row2 = table1.insertRow(2);
			var row3 = table1.insertRow(3);
			var row4 = table1.insertRow(4);
			var row5 = table1.insertRow(5);
			var row6 = table1.insertRow(6);
			var row7 = table1.insertRow(7);
			var row8 = table1.insertRow(8);
			var row9 = table1.insertRow(9);
			var row10 = table1.insertRow(10);
			var row11 = table1.insertRow(11);
			var row12 = table1.insertRow(12);

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
		
		cell1.innerHTML = 'Skupina A';
		cell2.innerHTML = 'A1';
		cell3.innerHTML = 'A2';
		cell4.innerHTML = 'A3';
		cell5.innerHTML = 'Skupina B';
		cell6.innerHTML = 'B1';		
		cell7.innerHTML = 'B2';
		cell8.innerHTML = 'B3';
		cell9.innerHTML = 'Skupina C';
		cell10.innerHTML = 'C1';
		cell11.innerHTML = 'C2';
		cell12.innerHTML = 'C3';
			
			break;
			
		case 10:
			var table = tabrozpis;
			var row0 = table.rows[0];
			var cell0 = row0.insertCell(1);
			cell0.innerHTML='Ihrisko 2';
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
			var row16 = table.insertRow(16);
			var row17 = table.insertRow(17);
			var row18 = table.insertRow(18);
			var row19 = table.insertRow(19);
			
			var cell1 = row1.insertCell(0);
			var cell2 = row1.insertCell(1);
			var cell3 = row2.insertCell(0);
			var cell4 = row2.insertCell(1);
			var cell5 = row3.insertCell(0);
			var cell6 = row3.insertCell(1);
			var cell7 = row4.insertCell(0);
			var cell8 = row4.insertCell(1);
			var cell9 = row5.insertCell(0);
			var cell10 = row5.insertCell(1);
			var cell11 = row6.insertCell(0);
			var cell12 = row6.insertCell(1);
			var cell13 = row7.insertCell(0);
			var cell14 = row7.insertCell(1);
			var cell15 = row8.insertCell(0);
			var cell16 = row8.insertCell(1);
			var cell17 = row9.insertCell(0);
			var cell18 = row9.insertCell(1);
			var cell19 = row10.insertCell(0);
			var cell20 = row10.insertCell(1);
			var cell21 = row11.insertCell(0);
			var cell22 = row13.insertCell(0);
			var cell23 = row13.insertCell(1);
			var cell24 = row14.insertCell(0);
			var cell25 = row14.insertCell(1);
			var cell26 = row15.insertCell(0);
			var cell27 = row15.insertCell(1);
			var cell28 = row16.insertCell(0);
			var cell29 = row16.insertCell(1);
			var cell30 = row17.insertCell(0);
			var cell31 = row17.insertCell(1);
			var cell32 = row18.insertCell(0);
			var cell33 = row18.insertCell(1);
			var cell34 = row19.insertCell(0);
			
			
			cell1.innerHTML = 'A3-A5';			
			cell2.innerHTML = 'A2-A4';		
			cell3.innerHTML ='B3-B5';
			cell4.innerHTML ='B2-B4';
			cell5.innerHTML = 'A1-A5';			
			cell6.innerHTML = 'A3-A4';		
			cell7.innerHTML ='B1-B5';
			cell8.innerHTML ='B3-B4';
			cell9.innerHTML = 'A1-A2';			
			cell10.innerHTML = 'A4-A5';		
			cell11.innerHTML ='B1-B2';
			cell12.innerHTML ='B4-B5';
			cell13.innerHTML = 'A1-A3';			
			cell14.innerHTML = 'A2-A5';		
			cell15.innerHTML ='B1-B3';	
			cell16.innerHTML ='B2-B5';
			cell17.innerHTML = 'A1-A4';			
			cell18.innerHTML = 'A2-A3';		
			cell19.innerHTML ='B1-B4';	
			cell20.innerHTML ='B2-B3';
			cell21.innerHTML = 'Den druhy';
			cell22.innerHTML ='x1:4B-5A';			
			cell23.innerHTML ='x2:4A-5B';		
			cell24.innerHTML ='x3:2B-3A';	
			cell25.innerHTML ='x4:2A-3B';
			cell26.innerHTML ='S1:wx1-lx3';		
			cell27.innerHTML ='S2:wx2-lx4';		
			cell28.innerHTML ='S3:1A-wx3';
			cell29.innerHTML ='S4:1B-wx2';
			cell30.innerHTML ='9/10:lx1-lx2';			
			cell31.innerHTML ='7/8:lS1-lS2';		
			cell32.innerHTML ='5/6:wS1-wS2';	
			cell33.innerHTML ='3/4:lS3-lS4';
			cell34.innerHTML ='1/2:wS3-wS4';
			
	var table1 = tabskupiny;//document.getElementById('skupiny');
			
			
			var row1 = table1.insertRow(1);
			var row2 = table1.insertRow(2);
			var row3 = table1.insertRow(3);
			var row4 = table1.insertRow(4);
			var row5 = table1.insertRow(5);
			var row6 = table1.insertRow(6);
			var row7 = table1.insertRow(7);
			var row8 = table1.insertRow(8);
			var row9 = table1.insertRow(9);
			var row10 = table1.insertRow(10);
			var row11 = table1.insertRow(10);
			var row12 = table1.insertRow(10);

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
		
		cell1.innerHTML = 'Skupina A';
		cell2.innerHTML = 'A1';
		cell3.innerHTML = 'A2';
		cell4.innerHTML = 'A3';
		cell5.innerHTML = 'A4';
		cell6.innerHTML = 'A5';
		
		cell7.innerHTML = 'Skupina B';
		cell8.innerHTML = 'B1';
		cell9.innerHTML = 'B2';
		cell10.innerHTML = 'B3';
		cell11.innerHTML = 'B4';
		cell12.innerHTML = 'B5';
			break;
		case 0:
		case 1:
		case 2:	
		case 3:
		case 4:
		case 5:
				//document.getElementById('rozpis').innerHTML='Maly pocet timov';
			alert('maly pocet timov');
			break;
		default:
			alert('Pre takyto pocet timov este nie je rozpis predpripraveny');
			break;
		}
	}
	return;
}