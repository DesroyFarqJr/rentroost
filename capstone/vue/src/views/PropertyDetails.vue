<template>
  <div class="main-container">
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
              <router-link class="nav-link" to="/user">Account</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="/logout"> Log out</router-link>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <div class="container">
      <div class="left-side">
        <img :src="property.imageUrl" alt="Main Image" />
      </div>
      <div class="right-side">
        <h1>{{ property.propertyAddress }}</h1>
        <p>{{ property.propertyDescription }}</p>
        <div class="property-details">
          <h3>${{ property.propertyRent }}</h3>
          <h3>|</h3>
          <h3>Bed: {{ property.propertyBedrooms }}</h3>
          <h3>|</h3>
          <h3>Bath: {{ property.propertyBathrooms }}</h3>
        </div>
      </div>
    </div>
    
    <div class="container-similar">
      <h2>Similar Properties</h2>
      


      <div class="property-cards">
        <div v-for="prop in similarProperties" :key="prop.id">
          <img :src="prop.imageUrl">
          <h3>{{ prop.propertyAddress }}</h3>
          <p>{{ prop.propertyDescription }}</p>
          <div class="details-similar">
            <h4>{{ prop.propertyRent }}</h4>
            <h4>Bed: {{ prop.propertyBedrooms }}</h4>
            <h4>Bath: {{ prop.propertyBathrooms }}</h4>
          </div>
        </div>
      </div>
    </div>
    
    <properties-list-2 />  
  </div>
</template>



<script>
import PropertiesList2 from "../components/PropertiesList2.vue";
import propertyService from "../services/PropertyService";
export default {
   components: { PropertiesList2,},
  
  name: "PropertyDetails",
  methods: {
    getPropertyDetails() {
      let propertyId = this.$route.params.id;
      propertyService.getProperty(propertyId).then((response) => {
        this.property = response.data;
        console.log(this.property);
      });
    },
    fillArraySimProps() {
      async function getProperty(propertyId) {
        let property = await propertyService.getProperty(propertyId);
        return property.data;
      }

      for (let i = 0; i < 3; i++) {
        let propertyId = this.$route.params.id + i;
        getProperty(propertyId).then((property) => {
          this.similarProperties.push(property);
        });
      }
    },
  },
  data() {
    return {
      property: {},
      similarProperties: [
        // ...
      ],
    };
  },
  created() {
    this.getPropertyDetails();
    this.fillArraySimProps();
  },
};
</script>


<style scoped>
div {
    border-radius: 3px;
}
.container {
  display: flex;
  padding-top: 50px;
}
.container-similar {
  display: flex;
}


.left-side {
  width: 60%;
}

.right-side {
  width: 100%;
  padding: 20px;
  background-color: #fafafa;
}

.property-details {
  display: flex;
  justify-content: space-between;
  margin-top: 20px;
}

.property-cards {
  display: flex;
  flex-wrap: wrap;
  margin-top: 20px;
}

.property-cards div {
  width: 30%;
  margin-right: 10px;
  padding: 20px;
  background-color: #eaeaea;
}

img {
    border-radius: 3px;
}
</style>
