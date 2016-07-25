/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function initialize() {
		var mapOptions = {
			zoom: 12,
			center: new google.maps.LatLng(-25.363882,131.044922),
			mapTypeId: google.maps.MapTypeId.ROADMAP
		}
		var map = new google.maps.Map(document.getElementById("map"), mapOptions);
		google.maps.event.addListener(map, 'click', function(event) {
    		placeMarker(event.latLng);
  		});

  		function placeMarker(location) {
		var marker = new google.maps.Marker({
			position: location,
			map: map,
			title: "new Marker",
			animation: google.maps.Animation.DROP
		});

		$('#latitude').val(location.lat())
		$('#longitude').val(location.lng())
		map.setCenter(location);
                
	}
        
        google.maps.event.addListener(map, 'click', function(event) {
        alert(event.latLng)
});
	}


	function loadScript() {
		var script = document.createElement("script");
		script.type = "text/javascript";
		script.src = src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCRIyAgKD5uTIEUwTcnfAW_SuJqyqnahtc&callback=initMap&region=br";
		document.body.appendChild(script);
	}




/* adicinando funcoes */
function addCoordenada(){
    var coordenada = google.maps.event.addListener(map, 'click', function(event) {
        return coordenada;
    });

}