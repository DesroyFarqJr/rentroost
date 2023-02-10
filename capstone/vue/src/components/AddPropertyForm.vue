<template>
  <div class="form">
    <form v-on:submit.prevent="submitProperty">
      <div class="formGroup">
        <label for="propertyName">Property Name</label>
        <input
          v-model="formEntry.name"
          id="propertyName"
          type="text"
          placeholder="Winding River Tower"
          autofocus
          required
        />
      </div>
      <div class="formGroup">
        <label for="propertyAddress">Address</label>
        <input
          v-model="formEntry.address"
          id="propertyAddress"
          type="text"
          placeholder="5000 Forbes Avenue, Pittsburgh, PA 15213"
          autofocus
          required
        />
      </div>
      <div class="formGroup">
        <label class="prop-desc" for="propertyDescription">Property Description</label>
        <textarea
          v-model="formEntry.propertyDescription"
          id="propertyDescription"
          name="propertyDescription"
          rows="4"
          cols="50"
          placeholder="Spacious 2-bedroom apartment with a sunny terrace, updated kitchen, and a fantastic location near parks and recreation. Perfect for nature-lovers and those seeking a peaceful retreat."
          required
        >
        </textarea>
      </div>
      <div class="formGroup">
        <label for="numOfBedrooms">Number Of Bedrooms</label>
        <input
          v-model="formEntry.numberOfBedrooms"
          id="numOfBedrooms"
          type="number"
          required
        />
      </div>
      <div class="formGroup">
        <label for="numOfBathrooms">Number Of Bathrooms</label>
        <input
          v-model="formEntry.numberOfBathrooms"
          id="numOfBathrooms"
          type="number"
          required
        />
      </div>
      <div class="formGroup">
        <label for="rentAmount">Rent Price</label>
        <input
          v-model="formEntry.rentPrice"
          id="rentAmount"
          type="number"
          required
        />
      </div>
      <div class="formGroup">
        <label for="currentlRented">Currently rented?</label>
        <input
          v-model="formEntry.currentlyRented"
          id="currentlRented"
          type="checkbox"
          required
        />
      </div>
      <div class="formGroup">
        <img :src="image" alt="" />
        <cloudinary-comp />
        <!-- <label for="photoUrl">Photo Url</label>
        <input v-model="formEntry.imagUrl" id="photoUrl" type="text" /> -->
      </div>
      <input type="submit" />
    </form>
  </div>
</template>


<script>
import propertyService from "../services/PropertyService";
import CloudinaryComp from "./CloudinaryComp.vue";

export default {
  components: { CloudinaryComp },
  data() {
    return {
      name: "addpropertyform",
      formEntry: {
        name: null,
        address: null,
        propertyDescription: null,
        numberOfBedrooms: 0,
        numberOfBathrooms: 0,
        rentPrice: 0,
        currentlyRented: false,
      },
    };
  },
  methods: {
    submitProperty() {
      const newProperty = {
        propertyName: this.formEntry.name,
        propertyAddress: this.formEntry.address,
        propertyDescription: this.formEntry.propertyDescription,
        propertyBedrooms: this.formEntry.numberOfBedrooms,
        propertyBathrooms: this.formEntry.numberOfBathrooms,
        propertyRent: this.formEntry.rentPrice,
        rented: this.formEntry.currentlyRented,
        imageUrl: this.$store.state.imgUrl,
      };
      propertyService
        .addProperty(newProperty)
        .then((response) => {
          if (response === 201) {
            console.log("success");
            this.$store.commit("CLEAR_PHOTO_URL");
          }
        })
        .catch((error) => {
          const response = error.response;
          if (response.status == 401) {
            this.invalidCredentials = true;
          }
          this.$store.commit("CLEAR_PHOTO_URL");
        });
    },
  },
  computed: {
    image() {
      return this.$store.state.imgUrl;
    },
  },
};

/*
CREATE TABLE property (
property_id serial NOT NULL,
prop_name varchar(200),
prop_address varchar(200) NOT NULL,
prop_lat DECIMAL,
prop_lng DECIMAL,
prop_description varchar(400),
prop_bedrooms INT NOT NULL,
prop_bathrooms INT NOT NULL,
prop_rent DECIMAL NOT NULL,
rented BOOLEAN,
url varchar(100),
CONSTRAINT PK_property_id PRIMARY KEY (property_id)
*/
</script>

<style>
.form {
  width: 80%;
  background-color: #fafafa;
  display: flex;
  justify-content: center;
  height: 60%;
}
.formGroup {
  display: flex;
  flex-direction: column;
}

</style>