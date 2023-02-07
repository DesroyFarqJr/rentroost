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
        <div class="_collapse _navbar-collapse">
          <!-- ^^ class name changed...rename if needed -->
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
    <div class="maps-wrapper">
      <map-filter id="spacer" />
      <!-- Map component  -->
      <div class="maps">
        <map-with-pins id="map"> </map-with-pins>
      </div>
    </div>

 
    <div class="footer-dark">
      <footer>
        <div class="footer-container">
          <div class="footer-section">
            <h3>Services</h3>
            <ul>
              <li><a href="#">Payment</a></li>
              <li><a href="#">Rentals</a></li>
              <li><a href="#">Privacy</a></li>
            </ul>
          </div>
          <div class="footer-section">
            <h3>About</h3>
            <ul>
              <li><a href="#">Blog</a></li>
              <li><a href="#">Team</a></li>
              <li><a href="#">Careers</a></li>
            </ul>
          </div>
          <div class="footer-section">
            <h3>Rent Roost</h3>
            <p>
              Praesent sed lobortis mi. Suspendisse vel placerat ligula. Vivamus
              ac sem lacus. Ut vehicula rhoncus elementum. Etiam quis tristique
              lectus. Aliquam in arcu eget velit pulvinar dictum vel in justo.
            </p>
            <div class="col item social">
              <a href="#"><i class="icon ion-social-facebook"></i></a
              ><a href="#"><i class="icon ion-social-twitter"></i></a
              ><a href="#"><i class="icon ion-social-snapchat"></i></a
              ><a href="#"><i class="icon ion-social-instagram"></i></a>
            </div>
          </div>
        </div>

        <div class="footer-container footer-container-bottom">
          <p class="copyright">Rent Roost © 2023</p>
          <p>
            Roost Coop is committed to ensuring digital accessibility for
            individuals with disabilities. We are continuously working to
            improve the accessibility of our web experience for everyone, and we
            welcome feedback and accommodation requests. If you wish to report
            an issue or seek an accommodation, please.
          </p>
        </div>

      </footer>
    </div>
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
.maps-wrapper {
  width: 100%;
  display: flex;
  height: 90vh;
}

.footer-container {
  display: flex;
  width: 1080px;
  max-width: 100%;
  margin: 0 auto;
  padding-top: 5px;
}

.footer-container-bottom {
  flex-direction: column;
  text-align: center;
  align-items: center;
}

.footer-container > * {
  flex-basis: 25%;
}
.footer-section:last-child {
  flex-grow: 2;
}
.footer-section ul li {
  display: block;
  text-align: left;
  margin: 10px 0;
}
#spacer {
  padding-top: 0px;
}

.home {
  display: flex;
  flex-direction: column;
  margin-top: 40px;
}

.navbar navbar-expand-md navbar-light fixed-top {
  display: flex;
  justify-content: end;
}

.navbar-collapse {
  width: 100%;
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
  padding-left: 0;
  margin: 0;
  left: 0;
}
.navbar-brand {
  text-transform: uppercase;
<<<<<<< HEAD
  color: red
=======
  color: red;
>>>>>>> main
}

.navbar-light {
  display: flex;
  justify-content: flex-end;
  align-content: flex-end;
  align-items: baseline;
  align-content: stretch;
  background-color: #ffffff;
  box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
}

#map {
  border-radius: 40px;
  border-radius: 25px;
  margin: 0 auto;
  -moz-border-radius: 25px;
  -webkit-mask-border-radius: 25px;
  -webkit-border-radius: 25px;
  -webkit-transform: translate3d(0px, 0px, 0px);
  -webkit-mask-image: -webkit-radial-gradient(#d3d3d3, #d3d3d3);
  height: 100%;
}

.maps {
  height: auto;
  width: 100%;
  background-color: #d3d3d3;
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

ul {
  columns: 1;
  padding-left: 200px;
  line-height: 30px;
}

li {
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

p {
  color: #ffffff;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-transform: none;
  font-family: "Fira Sans", sans-serif;
  font-weight: 400;
  font-size: 12px;
  line-height: 16px;
  margin: 0;
  padding-bottom: 5px;
  padding-top: 10px;
}

.commited {
  max-width: 720px;
  margin: auto;
  margin-bottom: 24px;
}

.lower {
  margin: auto;
  padding: 24px 0;
  color: rgb(160, 160, 160);
  text-align: center;
}

.footer-dark {
  padding: 100;
  color: #ffffff;
  width: 100%;
  background-color: #3a3a3a;
  bottom: 0;
}

.footer-dark h3 {
  margin-top: 0;
  padding-top: 10px;
  margin-bottom: 12px;
  font-weight: bold;
  font-size: 16px;
}

.footer-dark ul {
  padding: 5px;
  list-style: none;
  line-height: 1.6;
  font-size: 14px;
  margin-bottom: 0;
}

.footer-dark ul a {
  color: inherit;
  text-decoration: none;
  opacity: 0.6;
}

.footer-dark ul a:hover {
  opacity: 0.8;
}

@media (max-width: 767px) {
  .footer-dark .item:not(.social) {
    text-align: center;
    padding-bottom: 20px;
  }
}

.footer-dark .item.text {
  margin-bottom: 36px;
}

@media (max-width: 767px) {
  .footer-dark .item.text {
    margin-bottom: 0;
  }
}

.footer-dark .item.text p {
  opacity: 0.88;
  margin-bottom: 0;
}

.footer-dark .item.social {
  text-align: center;
  padding-top: 20px;
}

@media (max-width: 991px) {
  .footer-dark .item.social {
    text-align: center;
    margin-top: 20px;
  }
}

.footer-dark .item.social > a {
  font-size: 20px;
  width: 36px;
  height: 36px;
  line-height: 36px;
  display: inline-block;
  text-align: center;
  border-radius: 50%;
  box-shadow: 0 0 0 1px rgb(255, 255, 255);
  margin: 0 8px;
  color: #fff;
  opacity: 0.95;
}

.footer-dark .item.social > a:hover {
  opacity: 0.5;
}

.footer-dark .copyright {
  text-align: center;
  padding-top: 24px;
  opacity: 0.9;
  font-size: 13px;
  margin-bottom: 0;
  color: rgb(255, 45, 45);
  font-family: "Fira Sans", sans-serif;
  font-weight: 400;
}

@media only screen and (min-width: 768px) {
  .navbar-collapse,
  .navbar-expand-md,
  .collapse {
    display: unset !important;
  }
}
</style>