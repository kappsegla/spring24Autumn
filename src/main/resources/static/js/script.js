// Function to dynamically load the Leaflet.js script
function loadLeafletScript(callback) {
    var script = document.createElement('script');
    script.src = 'https://unpkg.com/leaflet@1.7.1/dist/leaflet.js';
    script.onload = function () {
        var clusterScript = document.createElement('script');
        clusterScript.src = 'https://unpkg.com/leaflet.markercluster/dist/leaflet.markercluster-src.js';
        clusterScript.onload = callback;
        document.head.appendChild(clusterScript);
    };
    document.head.appendChild(script);
}


// Function to dynamically load the Leaflet.js script
function loadLeafletScript(callback) {
    var script = document.createElement('script');
    script.src = 'https://unpkg.com/leaflet@1.7.1/dist/leaflet.js';
    script.onload = function () {
        var clusterScript = document.createElement('script');
        clusterScript.src = 'https://unpkg.com/leaflet.markercluster/dist/leaflet.markercluster-src.js';
        clusterScript.onload = callback;
        document.head.appendChild(clusterScript);
    };
    document.head.appendChild(script);
}

function initializeMap() {
    var map = L.map('map').setView([56.6616, 16.3616], 13);

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(map);

    // Define custom icons using emojis with custom popupAnchor positions
    var customIcons = [
        L.divIcon({
            html: '<div class="custom-icon">❤️</div>',
            className: '',
            iconSize: [24, 24],
            iconAnchor: [12, 12],
            popupAnchor: [0, -12]
        }),
        L.divIcon({
            html: '<div class="custom-icon">⭐</div>',
            className: '',
            iconSize: [24, 24],
            iconAnchor: [12, 12],
            popupAnchor: [0, -12]
        }),
        L.divIcon({
            html: '<div class="custom-icon">🔥</div>',
            className: '',
            iconSize: [24, 24],
            iconAnchor: [12, 12],
            popupAnchor: [0, -12]
        })
    ];

    // Define marker locations around Kalmar, Sweden
    var markerLocations = [
        [56.6616, 16.3616], // Kalmar
        [56.6734, 16.3564], // Near Kalmar Castle
        [56.6569, 16.3660]  // Near Kalmar Cathedral
    ];

    // Create a marker cluster group
    var markers = L.markerClusterGroup();

    // Add markers to the cluster group
    for (var i = 0; i < markerLocations.length; i++) {
        var marker = L.marker(markerLocations[i], {icon: customIcons[i]}).bindPopup('Marker ' + (i + 1));
        //map.addLayer(marker);
        markers.addLayer(marker);
    }

    // Add the marker
    map.addLayer(markers);
}

// Load the Leaflet.js script and initialize the map
loadLeafletScript(initializeMap);
