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
	          document.getElementById('latlongclicked').value = event.latLng.lat() + ', ' + event.latLng.lng();
	    });
	   
		
	}
		
	
	google.maps.event.addDomListener(window, 'load', initialize);  	
	
	Window.onload = initialize;
	
	
	function setGpsNewTeam(){
		document.getElementById('gps').value = mLat + ";" + mLng;
		
		if(marker[0] != undefined)
			marker[0].setMap(null);
		
		marker[0] = new google.maps.Marker({
			map:map,
			draggable:true,
			labelContent: "asd",
			animation: google.maps.Animation.DROP,
			position: new google.maps.LatLng(mLat, mLng)
		});
	}
	
	
	function mapDivClicked (event) {
		var target = document.getElementById('map-canvas'),
        posx = event.pageX - target.offsetLeft,
        posy = event.pageY - target.offsetTop,
        bounds = map.getBounds(),
        neLatlng = bounds.getNorthEast(),
        swLatlng = bounds.getSouthWest(),
        startLat = neLatlng.lat(),
        endLng = neLatlng.lng(),
        endLat = swLatlng.lat(),
        startLng = swLatlng.lng(),
        lat = startLat + ((posy/mapaVyska) * (endLat - startLat)),
        lng = startLng + ((posx/mapaSirka) * (endLng - startLng));
		alert ("Lat: " + lat + ", Lon: " + lng + "\n " + mLat + " " + mLng);
		
		if(marker[0] != undefined)
		marker[0].setMap(null);
		//marker[0] = null;
		var myLatLng = new google.maps.LatLng(mLat, mLng);
		
		marker[0] = new google.maps.Marker({
			map:map,
			draggable:true,
			labelContent: "asd",
			animation: google.maps.Animation.DROP,
			position: myLatLng
		});
	}	
		