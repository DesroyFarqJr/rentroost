<template>
  <div class="map-filter-template">
    <form>
      <div class="select-group">
        <label for="bedrooms">Number of bedrooms</label>
        <select id="bedrooms">
          <option value="Studio">Studio</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3" selected>3</option>
        </select>
        <div class="rent-slider">
        <label for="rent-range">Rent Minimum</label>
          <input
            type="range"
            min="500"
            max="10000"
            value="1200"
            class="slider"
            id="rent-range"
          />
          
        </div>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
        
      message: "Hello from Vue component",
      name: "mapFilter",
      methods: {

      },
    };
  },
};
</script>

<style scoped>

form {
    width: 70%;
}

.map-filter-template {
    width: 20%;
    min-height: calc("100vh - 50px");
  background-color: #f5f5f5;
  align-items: center;
}
.rent-slider {
    display: flex;
    flex-direction: column;
}
</style>