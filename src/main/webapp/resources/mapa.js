/**
 * 
 */
var mapaSirka = 500;
var mapaVyska = 360;

var map, mLat, mLng;
var marker = [];
		
	function initialize() {
		var keLanLng = new google.maps.LatLng(48.72099560, 21.25774770);
		var mapOptions = {
	    zoom: 12,
	    center: keLanLng,
	    mapTypeId: google.maps.MapTypeId.ROADMAP
	   };
	 	
	   map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);
	   
	   google.maps.event.addListener(map, 'click', function(event) {
	          mLat = event.latLng.lat();
	          mLng = event.latLng.lng();
	   });	   

	}
		
	
	
	//Window.onload = initialize;
	
	
	function setGpsNewTeam(){
		document.getElementById('gps').value = mLat + ";" + mLng;
		
		if(marker[0] != undefined)
			marker[0].setMap(null);
		
	//	marker[0] = new google.maps.Marker({
	//		map:map,
	//		draggable:false,
	//		labelContent: "asd",
	//		animation: google.maps.Animation.DROP,
	//		position: new google.maps.LatLng(mLat, mLng)
	//	});
		
		marker[0] = new MarkerWithLabel({
			   position: new google.maps.LatLng(mLat, mLng),
			   draggable: false,
			   map: map,
			   labelContent: "Miesto konania tréningov",
			   labelAnchor: new google.maps.Point(40, 75),
			   labelClass: "popisZnacky", // the CSS class for the label
			   labelStyle: {opacity: 0.65}
			 });
	}
	
	function putGpsForTeam(){
		var coordUnparsed = document.getElementById('gpsMiestoTreningu').value.split(";");
		if(coordUnparsed.length > 1){
			var parsedLan = coordUnparsed[0];
			var parsedLng = coordUnparsed[1];
			//alert("Parsed: " + parsedLan + " " + parsedLng);
			
			var trainingPosition = new google.maps.LatLng(parsedLan, parsedLng);
			map.setCenter(trainingPosition);
			
			if(marker[0] != undefined)
				marker[0].setMap(null);
			
			marker[0] = new google.maps.Marker({
				map:map,
				draggable:false,
				animation: google.maps.Animation.DROP,
				position: trainingPosition
			});
		}
		
	}
	
	function putGpsForTournament(){
		var coordUnparsed = document.getElementById('gpsMiestoTurnaja').value.split(";");
		if(coordUnparsed.length > 1){
			var parsedLan = coordUnparsed[0];
			var parsedLng = coordUnparsed[1];
			//alert("Parsed: " + parsedLan + " " + parsedLng);
			
			var trainingPosition = new google.maps.LatLng(parsedLan, parsedLng);
			map.setCenter(trainingPosition);
			
			if(marker[0] != undefined)
				marker[0].setMap(null);
			
			marker[0] = new google.maps.Marker({
				map:map,
				draggable:false,
				animation: google.maps.Animation.DROP,
				position: trainingPosition
			});
		}
		
	}
	
	var trainingMarkers = [];
	
	function putTrainingsOnMap(){
		var unparsed = document.getElementsByName('treningyNaMapu');
		var temp;
		var pName = [];
		var pLan = [];
		var pLng = [];
		
		
		hideTrainingsMarkers();
		trainingMarkers = [];
		
		for(var i = 0; i<unparsed.length; i++){
			temp = unparsed[i].value.split(";");
			pName[i] = temp[0];
			pLan[i] = temp[1];
			pLng[i] = temp[2];
			//alert(temp.length + " ");
			if((pName[i] != null) && (pLan[i] != null) && (pLng[i] != null)){
				trainingMarkers[i] = new MarkerWithLabel({
					   position: new google.maps.LatLng(pLan[i], pLng[i]),
					   draggable: false,
					   animation: google.maps.Animation.DROP,
					   map: map,
					   labelContent: pName[i],
					   labelAnchor: new google.maps.Point(40, 70),
					   labelClass: "popisZnacky", // the CSS class for the label
					   labelStyle: {opacity: 0.65}
				});
				//alert("pridavam " + pName[i] + " " + pLan[i] + " " + pLng[i]);	
			}
		}
		if(trainingMarkers.length == 0) alert("Žiadne tréningy s polohou na zobrazenie");
		hideTournamentsMarkers();
	}
	
	var tournamentsMarkers = [];
	
	function putTournamentsOnMap(){
		var unparsed = document.getElementsByName('turnajeNaMapu');
		var temp;
		var pName = [];
		var pLan = [];
		var pLng = [];
		
		hideTournamentsMarkers();
		tournamentsMarkers = [];
		
		for(var i = 0; i<unparsed.length; i++){
			temp = unparsed[i].value.split(";");
			pName[i] = temp[0];
			pLan[i] = temp[1];
			pLng[i] = temp[2];
			
			if((pName[i] != null) && (pLan[i] != null) && (pLng[i] != null)){
				tournamentsMarkers[i] = new MarkerWithLabel({
					   position: new google.maps.LatLng(pLan[i], pLng[i]),
					   draggable: false,
					   animation: google.maps.Animation.DROP,
					   map: map,
					   labelContent: pName[i],
					   labelAnchor: new google.maps.Point(40, 70),
					   labelClass: "popisZnackyTurnaj", // the CSS class for the label
					   labelStyle: {opacity: 0.65}
				});
				//alert("pridavam " + pName[i] + " " + pLan[i] + " " + pLng[i]);	
			}
		}
		if(tournamentsMarkers.length == 0) alert("Žiadne turnaje s polohou na zobrazenie");
		hideTrainingsMarkers();
	}
	
	function setAllMap(markers,map) {
		  if(markers != null){
			  for (var i = 0; i < markers.length; i++) {
				    markers[i].setMap(map);
			  }
		  }
		 
	}
	
	function hideTrainingsMarkers(){
		setAllMap(trainingMarkers, null);
	}
	
	function hideTournamentsMarkers(){
		setAllMap(tournamentsMarkers, null);
	}
	
	function hideAll() {
		hideTrainingsMarkers();
		hideTournamentsMarkers();
	}
	
	//
	google.maps.event.addDomListener(window, 'load', initialize);  	
	
		