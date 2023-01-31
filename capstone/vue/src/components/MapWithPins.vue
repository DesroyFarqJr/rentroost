<template>
  <div>
    <!-- gmap tag pulls from node_modules.vue2-google-maps and creates a window @ the specified size -->
    <gmap-map :zoom="13" :center="center" style="width: 100%; height: 600px">
      <!-- info windows pop out when a user clicks on a map marker -->
      <gmap-info-window
        :options="infoOptions"
        :position="infoPosition"
        :opened="infoOpened"
        :content="infoContent"
        @closeclick="infoOpened = false"
      ></gmap-info-window>
      <!-- place map markers for each marker object in the store -->
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
      // infobox values
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
      // property markers
      // TODO move property markers to a store that populates from the API
      propertyLocationMarkers: [
        {
          position: {
            lat: 40.44104,
            lng: -80.00221
          },
          infoText: "<div>Rent: 2,150<br>Bedrooms: 2</div>"
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
      ]
    };
  },
  methods: {
    // toggle property marker location based on click and set its values
    toggleInfo(marker, index){
      this.infoPosition = marker.position;
      this.infoOptions.content = marker.infoText;

      if (this.currentKey === index) {
        this.infoOpened = !this.infoOpened;
      } else {
        this.infoOpened = true;
        this.currentKey = index;
      }
    }
  }
};
</script>