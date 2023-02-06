<template>
  <div class="map-filter-template">
    <form v-on:change.prevent="submitSearch">
      <div class="select-group">
        <label for="bedrooms">Bedrooms: </label>
        <select id="bedrooms" v-model="searchForm.bedrooms">
          <option value="0" selected>Studio</option>
          <option value="1">1+</option>
          <option value="2">2+</option>
          <option value="3">3+</option>
        </select>
        <br>
        <label for="bathrooms">Bathrooms: </label>
        <select id="bathrooms" v-model="searchForm.bathrooms">
          <option value="1" selected>1+</option>
          <option value="2">2+</option>
          <option value="3">3+</option>
        </select>
        <div class="rent-slider">
        <label for="rent-range">Rent Maximum: </label>
          <input
            type="range"
            min="500"
            max="10000"
            value="1200"
            class="slider"
            id="rent-range"
            v-model="searchForm.maxRent"
          />
        </div>
      </div>
    </form>
  </div>
</template>

<script>
import propertyService from "../services/PropertyService";
export default {
  data() {
    return {
      searchForm: {
        bedrooms: 0,
        bathrooms: 1,
        minRent: 0,
        maxRent: 10000
      },
      message: "Hello from Vue component",
      name: "mapFilter",
      methods: {

      },
    };
  },
  methods: {
    submitSearch() {
      this.searchProperties(this.searchForm.bedrooms, this.searchForm.bathrooms, this.searchForm.minRent, this.searchForm.maxRent);
    },
    searchProperties(bedrooms, bathrooms, minRent, maxRent) {
      propertyService.searchProperties(bedrooms, bathrooms, minRent, maxRent).then((response) => {
        if (response.status == 200) {
          this.$store.commit("SET_PROPERTIES", response.data)
        }
      }).catch((error) => {
        const response = error.response;
        if (response.status == 401) {
          this.invalidCredentials = true;
        }
      });
    }
  }
};
</script>

<style scoped>

form {
    width: 70%;
}

.map-filter-template {
    width: 20%;
    height: 65vh;
    min-height: calc("100vh - 50px");
  background-color: #f5f5f5;
  align-items: center;
}
.rent-slider {
  padding-top: 20px;
    display: flex;
    flex-direction: column;
}
</style>