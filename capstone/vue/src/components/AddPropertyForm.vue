<template>
  <div class="form">
    <form v-on:submit.prevent="submitProperty">
      <div class="formGroup">
        <label for="propertyName">Property Name</label>
        <input v-model="formEntry.name" id="propertyName" type="text" />
      </div>
      <div class="formGroup">
        <label for="propertyAddress">Address</label>
        <input v-model="formEntry.address" id="propertyAddress" type="text" />
      </div>
      <div class="formGroup">
        <label for="propertyDescription">Property Description</label>
        <textarea
          v-model="formEntry.propertyDescription"
          id="propertyDescription"
          name="propertyDescription"
          rows="4"
          cols="50"
          placeholder="Write Description Here"
        >
        </textarea>
      </div>
      <div class="formGroup">
        <label for="numOfBedrooms">Number Of Bedrooms</label>
        <input
          v-model="formEntry.numberOfBedrooms"
          id="numOfBedrooms"
          type="number"
        />
      </div>
      <div class="formGroup">
        <label for="numOfBathrooms">Number Of Bathrooms</label>
        <input
          v-model="formEntry.numberOfBathrooms"
          id="numOfBathrooms"
          type="number"
        />
      </div>
      <div class="formGroup">
        <label for="rentAmount">Rent Price</label>
        <input v-model="formEntry.rentPrice" id="rentAmount" type="number" />
      </div>
      <div class="formGroup">
        <label for="currentlRented">Currently rented?</label>
        <input
          v-model="formEntry.currentlyRented"
          id="currentlRented"
          type="checkbox"
        />
      </div>
      <div class="formGroup">
        <label for="photoUrl">Photo Url</label>
        <input v-model="formEntry.photoUrl" id="photoUrl" type="text" />
      </div>
      <input type="submit" />
    </form>
  </div>
</template>


<script>
import propertyService from "../services/PropertyService";

export default {
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
        photoUrl: "www.google.com",
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
        imageUrl: this.formEntry.currentlyRented,
      };
      propertyService
        .addProperty(newProperty)
        .then((response) => {
          if (response === 201) {
            console.log("success");
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

<style scoped>
.form {
  width: 80%;
  background-color: #fafafa;
  display: flex;
  justify-content: center;
}
.formGroup {
  display: flex;
  flex-direction: column;
}

.textarea {
  height: 100px;
}
</style>