<template>
  <div >
    <!-- gmap tag pulls from node_modules.vue2-google-maps and creates a window @ the specified size -->
    <gmap-map :zoom="13" :center="center" style="width: 100%; height: 95vh;" :options="{mapTypeControl: false, streetViewControl: false}">
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
        v-for="(m, index) in $store.state.propertiesList"
        :position="m.propertyPosition"
        :clickable="true"
        :draggable:="false"
        @click="toggleInfo(m, index)"
      ></gmap-marker>
    </gmap-map>
  </div>
</template>
   
<script>
import propertyService from "../services/PropertyService";

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
        content: "null content error",
        infoRent: null,
        infoBedrooms: null
      },
      // property markers
      // TODO move property markers to a store that populates from the API
      propertyLocationMarkers: [
        {
          position: {
            lat: 40.44104,
            lng: -80.00221
          },
          rent: 1850,
          bedrooms: 2,
          imageUrl: "https://rentalroost.s3.us-east-2.amazonaws.com/image103.jpg"
        },
        {
          position: {
            lat: 40.45358,
            lng: -79.98055
          },
          rent: 2125,
          bedrooms: 1,
          imageUrl: "https://rentalroost.s3.us-east-2.amazonaws.com/image104.jpg"
        },
        {
          position: {
            lat: 40.455,
            lng: -80
          },
          rent: 2450,
          bedrooms: 2,
          imageUrl: "https://rentalroost.s3.us-east-2.amazonaws.com/image105.jpg"
        }
      ]
    };
  },
  created() {
    console.log(`called created() in MapWithPins`);
      propertyService.getAllProperties().then((response) => {
        if (response.status == 200) {
          this.$store.commit("SET_PROPERTIES", response.data)
        }
      }).catch((error) => {
        const response = error.response;
        if (response.status == 401) {
          this.invalidCredentials = true;
        }
      });
  },
  methods: {
    // toggle property marker location based on click and set its values
    toggleInfo(marker, index){
      this.infoPosition = marker.propertyPosition;
      // this.infoOptions.content = marker.infoText;
      const contentString = `<div class="info-window">
        <div id="info"><b>Rent:</b> $${marker.propertyRent}<br><b>Bedrooms: </b>${marker.propertyBedrooms}</div>
        <div id="image"><img src="${marker.imageUrl}" alt="Image Not Available" width="150px"></div>
        <div></div>
        <div id="posting-link"><a href="www.google.com">More Details...</a></div>
        </div>
        <style scoped>
          .info-window {
            display: grid;
            grid-template-columns: 1fr 2fr;
            grid-template-areas: 
              "image info"
              "image posting-link";
            gap: 10px;
            }
          #info {
            text-align: left;
          }
          #posting-link {
            text-align: right;
          }
          #image {
          }
          img {
            width:125px;
          }
          </style>`;
      this.infoOptions.content = contentString;

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
