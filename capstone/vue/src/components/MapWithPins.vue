<template>
  <div>
    <!-- <div>
      <label>
        <gmap-autocomplete
          @place_changed="initMarker"
          :options="{
            fields: ['geometry', 'formatted_address', 'address_components'],
          }"
        ></gmap-autocomplete>
        <button @click="addLocationMarker">Add</button>
      </label>
      <br />
    </div>
    <br /> -->
    <gmap-map :zoom="13" :center="center" style="width: 100%; height: 600px">
      <gmap-info-window
        :options="infoOptions"
        :position="infoPosition"
        :opened="infoOpened"
        :content="infoContent"
        @closeclick="infoOpened = false"
      ></gmap-info-window>

      <gmap-marker
        :key="index"
        v-for="(m, index) in propertyLocationMarkers"
        :position="m.position"
        :clickable="true"
        :draggable:="false"
        @click="toggleInfo(m, index)"
      ></gmap-marker>
    </gmap-map>
  </div>
</template>
   
  <script>
  export default {
    name: "MapWithPins",
    data() {
      return {
        center: { 
          lat: 40.44104,
          lng: -80.00221
        },
      infoPosition: null,
      infoContent: null,
      infoOpened: false,
      infoCurrentKey: null,
      infoOptions: {
        pixelOffset: {
          width: 0,
          height: -35
        },
        content: "null content error"
      },
        propertyLocationMarkers: [
          {
            position: {
              lat: 40.44104,
              lng: -80.00221
            },
            infoText: "lat: 40.44104, lng: -80.00221"
          },
          {
            position: {
              lat: 40.45358,
              lng: -79.98055
            },
            infoText: "lat: 40.45358, lng: -79.98055"
          },
          {
            position: {
              lat: 40.455,
              lng: -80
            },
            infoText: "40.455, lng: -80"
          }
        ],
        locationMarkers: [],
        locPlaces: [],
        existingPlace: []
      };
    },
   
    mounted() {
      this.locateGeoLocation();
    },
    methods: {
      toggleInfo(marker, index){
        this.infoPosition = marker.position;
        this.infoOptions.content = marker.infoText;

        if (this.currentKey === index) {
          this.infoOpened = !this.infoOpened;
        } else {
          this.infoOpened = true;
          this.currentKey = index;
        }
      },
      initMarker(loc) {
        console.log(loc);
        this.existingPlace = loc;
      },
      addLocationMarker() {
        if (this.existingPlace) {
          const marker = {
            lat: this.existingPlace.geometry.location.lat(),
            lng: this.existingPlace.geometry.location.lng()
          };
          this.locationMarkers.push({ position: marker });
          this.locPlaces.push(this.existingPlace);
          this.center = marker;
          this.existingPlace = null;
        }
      },
      locateGeoLocation: function() {
        navigator.geolocation.getCurrentPosition(res => {
          this.center = {
            lat: res.coords.latitude,
            lng: res.coords.longitude
          };
        });
      }
    }
  };
  </script>