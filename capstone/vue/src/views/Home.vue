<template>
  <div class="home">
    <nav class="navbar navbar-expand-md navbar-light fixed-top">
      <div class="container-fluid">
        <a href="#" class="navbar-brand"
          ><img alt="logo" src="../../public/images/logo.png"
        /></a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="navbarsExampleDefault"
          label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item">
              <router-link class="nav-link" to="/user">Username</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="/logout">
                Log out</router-link
              >
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <div id="maps">
      <map-with-pins id="map"> </map-with-pins> 
      <div class="light-grey-box">
        <div class="rectangular-box"></div>
        <div class="rectangular-box"></div>
        <div class="price-scale-widget">
          <select id="price-scale">
      <option value="high-to-low">High to Low</option>
      <option value="low-to-high">Low to High</option>
    </select>
    </div>
  </div>
</div>
  </div>


</template>

<script>
import MapWithPins from "../components/MapWithPins.vue";

export default {
  name: "home",
  components: {
    MapWithPins,
  },
};

</script>

<style scoped>
.navbar-collapse {
  display: flex;
  justify-content: flex-end;
}
.navbar-brand {
  padding: 0;
  margin: 0;
}
.navbar-brand img {
  display: flex;
  justify-content: flex-start;
  height: 50px;
  width: 200px;
  padding: 0;
  margin: 0;
  left: 0;
}
.navbar-brand {
  text-transform: uppercase;
  color: red;
}
.navbar-light {
  display: flex;
  flex-direction: column;
  flex-wrap: nowrap;
  justify-content: flex-end;
  align-items: baseline;
  align-content: stretch;
  border-bottom: 2px solid transparent;

  background-color: #ffffff;
  box-shadow: 0px 5px 5px #7f7d7e;
}




#maps {
  
  height: 60vh;
  width: 70%;
  background-color: grey;
  float: left;
}
  

  
  .light-grey-box {
    width: 30%;
    height: auto;
    background-color: #D3D3D3;
    float: right;
    padding: 20px;
  }
  
  .rectangular-box {
    width: 45%;
    height: 100px;
    background-color: white;
    display: inline-block;
    margin-right: 10px;
  }
  
  .price-scale-widget {
    width: 100%;
    height: 50px;
    background-color: white;
    clear: both;
    margin-top: 20px;
  }

</style>
