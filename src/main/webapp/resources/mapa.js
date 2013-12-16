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
	
	var trainingMarkers = [];
	
	function putTrainingsOnMap(){
		var unparsed = document.getElementsByName('treningyNaMapu');
		var temp;
		var pName = [];
		var pLan = [];
		var pLng = [];
		
		trainingMarkers = [];
		
		for(var i = 0; i<unparsed.length; i++){
			temp = unparsed[i].value.split(";");
			pName[i] = temp[0];
			pLan[i] = temp[1];
			pLng[i] = temp[2];
			
			trainingMarkers[i] = new MarkerWithLabel({
				   position: new google.maps.LatLng(pLan[i], pLng[i]),
				   draggable: false,
				   animation: google.maps.Animation.DROP,
				   map: map,
				   labelContent: pName[i],
				   labelAnchor: new google.maps.Point(40, 75),
				   labelClass: "popisZnacky", // the CSS class for the label
				   labelStyle: {opacity: 0.65}
				 });
			//alert("pridavam " + pName[i] + " " + pLan[i] + " " + pLng[i]);
		}
		
		
	}
	
	function setAllMap(markers ,map) {
		  for (var i = 0; i < markers.length; i++) {
		    markers[i].setMap(map);
		  }
	}
	
	function hideAll() {
		  setAllMap(trainingMarkers, null);
	}
	
	google.maps.event.addDomListener(window, 'load', initialize);  	
	
		