<template>
  <div class="property-card">
    <!-- DISPLAY MODE -->
    <div class="property-image">
      <img v-bind:src="property.imageUrl" />
    </div>
    <div class="prop-details">
      <div class="propAddress">
        {{ property.propertyAddress }}
      </div>
        <div class="propDescription">
          ${{ property.propertyRent }} | Beds: {{ property.propertyBedrooms }} | Baths: {{ property.propertyBathrooms }}
        </div>
      <div class="more-details-link">
        <router-link v-bind:to="{ name: 'PropertyDetails',  params: {id: property.propertyId}}">More Details...</router-link>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      name: "mini-property-card",
      editMode: false,
      tempProperty: { ...this.property },
      hrefUrl: `PropertyDetails/1` + this.tempProperty.propertyAddress
    };
  },
  methods: {},
  props: {
    property: Object,
  },
};
</script>
<style scoped>
.property-image, img {
  height: inherit;
  width: 8vw;
  object-fit: cover;
  border-radius: 3px;
}

.property-card {
  font-family: Verdana, Geneva, Tahoma, sans-serif;
  background-color: white;
  margin: 10px;
  height: 100px;
  width: 95%;
  border-radius: 3px;
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  align-items: center;
  box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px;
  /* padding-bottom: 10px; */
}

button {
  background-color: #ff0000;
  box-shadow: none;
  border-radius: 3px;
  color: white;
  font-weight: 300;
  margin-top: -20px;
  padding: 10px 0;
  outline: 0;
}

#cancel-button {
  background-color: white;
  color: #ff0000;
  border-color: black;
  border-radius: 10px;
  font-weight: 300;
  margin-top: -20px;
  padding: 10px 0;
  outline: 10px;
}
.propAddress {
  font-size: 13px;
  max-height: 120px;
  overflow: hidden;
  max-width: 75%;
  text-align: left;
  padding-left: 5px;
}

.propDescription {
  font-size: 10px;
  max-height: 120px;
  overflow: hidden;
  max-width: 75%;
  text-align: left;
  padding-left: 5px;
}
.more-details-link {
  justify-content: end;
  margin-top: 10px;
}

a {
  font-size: 15px;
}
</style>