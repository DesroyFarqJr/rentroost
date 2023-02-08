<template>
  <div class="map-filter-template">
    <form v-on:change.prevent="submitSearch">
      <div class="select-group">
        <label class="btn" for="bedrooms">Bedrooms: </label>
        <select id="bedrooms" v-model="searchForm.bedrooms">
          <option value="0" selected>Studio</option>
          <option value="1">1+</option>
          <option value="2">2+</option>
          <option value="3">3+</option>
        </select>
        <br />
        <label class="btn" for="bathrooms">Bathrooms: </label>
        <select id="bathrooms" v-model="searchForm.bathrooms">
          <option value="1" selected>1+</option>
          <option value="2">2+</option>
          <option value="3">3+</option>
        </select>
        <div class="rent-slider" data-min="500" data-max="10000">
          <label for="rent-range">Rent Maximum: </label>
          <input
            type="range"
            min="500"
            max="10000"
            value="1200"
            class="slider"
            id="rent-range"
            v-model="searchForm.maxRent"
            
            onchange="updateTextInput(this.value);"
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
        maxRent: 10000,
      },
      message: "Hello from Vue component",
      name: "mapFilter",
      methods: {},
    };
  },
  methods: {
    submitSearch() {
      this.searchProperties(
        this.searchForm.bedrooms,
        this.searchForm.bathrooms,
        this.searchForm.minRent,
        this.searchForm.maxRent
      );
    },
    searchProperties(bedrooms, bathrooms, minRent, maxRent) {
      propertyService
        .searchProperties(bedrooms, bathrooms, minRent, maxRent)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_PROPERTIES", response.data);
          }
        })
        .catch((error) => {
          const response = error.response;
          if (response.status == 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
  watch: {
    rangeValue(val) {
      this.textValue = val;
    },
  },
};
</script>

<style scoped>
@media screen and (-webkit-min-device-pixel-ratio: 0) {
  input[type="range"] {
    overflow: hidden;
    width: 100;
    -webkit-appearance: none;

    background-color: rgba(197, 197, 197, 0.445);
  }

  input[type="range"]::-webkit-slider-runnable-track {
    height: 100%;
    -webkit-appearance: none;
    color: #ff0000;
    margin-top: -5px;
  }

  input[type="range"]::-webkit-slider-thumb {
    width: 10px;
    -webkit-appearance: none;
    height: 10px;
    cursor: pointer;
    background: rgb(255, 16, 16);
    box-shadow: -85px 0 0 80px #ff0000;
  }
}

form {
  display: flex;
  justify-content: center;
  width: 70%;
}

.select-group {
  width: 300px;
}

select {
  
  padding: 0 30px;
  width: 100%;
  height: 34px;
  border-radius: 6px;
  background-color: #f00;
  font-weight: 600;
  color: white;
}

.map-filter-template {
  width: 20%;
  height: inherit;
  /* min-height: calc("100vh - 50px"); */
  background-color: #f5f5f5;
  display: flex;
  justify-content: center;
  align-items: center;
}
.rent-slider {
  padding-top: -20px;
  display: flex;
  justify-content: flex-start;
  width: 100%;
  align-items: center;
  margin: 20px 0;
  justify-content: center;
  flex-direction: column;
  border-radius: 8px;
  height: 65px;
  color: rgba(255, 255, 255, 0.08);
}

.slider {
  background-color: tomato;
}
.value {
  display: flex;
  justify-content: flex-end;

  width: 40px;
}
/*  */
.container {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.btn {
  outline: 0;
  display: inline-flex;
  align-items: center;
  justify-content: space-between;
  background: transparent;
  min-width: 20%;
  border: 0;
  border-radius: 6px;
  box-shadow: 0 4px 12px rgba(black, 0.1);
  box-sizing: border-box;
  padding: 15px 20px;
  color: rgb(0, 0, 0);
  font-size: 12px;
  font-weight: bold;
  letter-spacing: 1.2px;
  text-transform: uppercase;
  overflow: hidden;
  cursor: pointer;
}

 


.material-icons {
  border-radius: 100%;
  animation: ripple 0.6s linear infinite;
}

.bedrooms {
  position: absolute;
  top: 100%;
  left: 0;
  background: rgba(255, 255, 255, 0.096);
  width: 100%;
  border-radius: 4px;
  box-shadow: 0 4px 12px rgba(black, 0.1);
  text-align: left;
  opacity: 0;
  visibility: hidden;
  transition: 0.3s ease;
}

option {
  z-index: 1;
  position: relative;
  background: white;
  padding: 0 20px;
  color: #666;
}
</style>