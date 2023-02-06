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
              <router-link class="nav-link" to="/logout"> Log out</router-link>
            </li>
          </ul>
        </div>
      </div>
    </nav>
 <!-- Nav above. Map Filter Below -->
    <map-filter id="spacer"/>
  <!-- Map component  -->
    <div class="maps">
      <map-with-pins id="map"> </map-with-pins>
    </div>
  <!-- Footer -->
    
    <footer class="footer" style="position: fixed; bottom: 0; width: 100%;">
      <div class="F-Box2>">
        <nav>
        <ul>
          <li>About</li>
          <li>Research</li>
          <li>Careers</li>
          <li>Help</li>
          <li>Advertise</li>
          <li>Housing Guide</li>
          <li>Terms of Use</li>
          <li>Privacy</li>
          <li>blog</li>
        </ul>
        </nav>
      </div>

      <div class="lower">
        <div class="committed">
          <p>
            Roost Coop is committed to ensuring digital accessibility for individuals with disabilities. We are continuously working to improve the accessibility of our web experience for everyone, and we welcome feedback and accommodation requests. If you wish to report an issue or seek an accommodation, please.
            </p>
      </div>



      </div>
    </footer>
  </div>
</template>

<script>
import MapFilter from "../components/MapFilter.vue";
import MapWithPins from "../components/MapWithPins.vue";

export default {
  name: "home",
  components: {
    MapWithPins,
    MapFilter,
  },
};
</script>

<style scoped>

#spacer{
  padding-top: 40px;
}

.home {
  display: flex;
  margin-top: 40px;;
}
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


  background-color: #ffffff;
box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
}

.maps {
  height: 65vh;
  width: 100%;
  padding-bottom: 100px;
  background-color: grey;
  float: left;
  border-radius: 4px;
}

.light-grey-box {
  width: 30%;
  height: auto;
  background-color: #d3d3d3;
  float: right;
  padding: 20px;
}
ul{
  columns: 1;
  padding-left: 200px;
    line-height: 30px;
}
li{
  margin: 0 10px;
    display: inline-block;
    padding-top: 0;
    text-align: center;
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

.F-box2{
  display: block;
}
.footBOX1{
  position:fixed; bottom:0; left:40%;
   
}
footer{
  background: rgb(243, 243, 243);
  height: 200px;
    max-width: 100%;
    margin-top: -100px;
    clear:both;
    display: table-row;
    
    font-family: 'Open Sans',Gotham,gotham,Tahoma,Geneva,sans-serif;
}
p{
  color: #54545A;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-transform: none;
    font-family: "Open Sans","Adjusted Arial",Tahoma,Geneva,sans-serif;
    font-weight: 400;
    font-size: 10px;
    line-height: 16px;
    margin: 0;
}
.commited{
  max-width: 720px;
    margin: auto;
    margin-bottom: 24px;
}
.lower{
  margin: auto;
    padding: 24px 0;
    color: #666;
    text-align: center;
}
</style>
