<template>
  <div id="add-property">
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
    <!--  -->


        <h1>Your Properties</h1>
      <div>
              <button >Add Property</button>
      </div>
    <properties-list />  </div>
</template>

<script>
import PropertiesList from "../components/PropertiesList.vue";
export default {
  components: { PropertiesList },
  name: "addproperty",
};
</script>

<style scoped>
#add-property {
  display: flex;
  flex-direction: column;
  justify-content: center;
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
    height: 10%;
}
</style>