<!-- <template>
  <div class="property-card">
    <img v-bind:src="property.image" />
    <h3 v-if="!editMode">{{ property.address }}</h3>
    <input type="text" v-model="tempProperty.address" v-if="editMode" />
    <h5 v-if="!editMode">
      ${{ property.price }} | BR: {{ property.bedrooms }}
    </h5>
    <input type="text" v-model="tempProperty.price" v-if="editMode" />
    <h5 class="propDescription" v-if="!editMode">{{ property.description }}</h5>
    <textarea v-model="tempProperty.description" v-if="editMode"></textarea>
    <button v-if="!editMode" @click="editMode = true">Edit Property</button>
    <button v-if="editMode" @click="updateProperty()">Done</button>
  </div>
</template> -->

<template>
  <div class="property-card">
    <!-- DISPLAY MODE -->
    <img v-bind:src="property.image" />
    <h3 v-if="!editMode">{{ property.name }}</h3>
    <h3 v-if="!editMode">{{ property.address }}</h3>
    <h5 v-if="!editMode">
      ${{ property.price }} | Beds: {{ property.bedrooms }} | Baths: {{ property.bathrooms }}
    </h5>
    <h5 class="propDescription" v-if="!editMode">{{ property.description }}</h5>
    <button v-if="!editMode" v-on:click="editProperty">Edit Property</button>
    <!-- EDIT MODE -->
    <label v-if="editMode">Name: </label><input type="text" v-model="tempProperty.name" v-if="editMode" />
    <label v-if="editMode">Address: </label><input type="text" v-model="tempProperty.address" v-if="editMode" />
    <label v-if="editMode">Price: </label><input type="text" v-model="tempProperty.price" v-if="editMode" />
    <label v-if="editMode">Bedrooms: </label><input type="text" v-model="tempProperty.bedrooms" v-if="editMode" />
    <label v-if="editMode">Bathrooms: </label><input type="text" v-model="tempProperty.bathrooms" v-if="editMode" />
    <label v-if="editMode">Description: </label><textarea v-model="tempProperty.description" v-if="editMode"></textarea>
    <button v-if="editMode" @click="updateProperty()">Done</button>
    <button id="cancel-button" v-if="editMode" @click="cancelEdit()">Cancel</button>
  </div>
</template>
<script>
export default {
  data() {
    return {
      name: "propertyCard",
      editMode: false,
      tempProperty: { ...this.property },
      editCache: {}
    }
  },
  methods: {
    updateProperty() {
      this.editMode = false;
      this.$emit("update-property", this.tempProperty);
    },
    editProperty() {
      console.log("edit property clicked");
      // take all property details and add to edit cache
      this.editCache.name = this.tempProperty.name;
      this.editCache.address = this.tempProperty.address;
      this.editCache.price = this.tempProperty.price;
      this.editCache.bedrooms = this.tempProperty.bedrooms;
      this.editCache.bathrooms = this.tempProperty.bathrooms;
      this.editCache.description = this.tempProperty.description;
      this.editMode = true;
    },
    cancelEdit() {
      this.editCache = {};
      this.editMode = false;
    }
  },
  props: {
    property: Object,
  }
};
</script>
<style scoped>
img {
  width: 100%;
  height: 20vh;
  object-fit: cover;
  border-radius: 3px;
}

h3 {
  margin-top: 4px;
}
h5 {
  margin-top: -35px;
}
.property-card {
  font-family: Verdana, Geneva, Tahoma, sans-serif;
  background-color: #fafafa;
  margin: 30px;
  width: 25%;

  border-radius: 3px;
  display: flex;
  flex-direction: column;
  align-items: center;
  box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px;
  padding-bottom: 30px;
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
}

#cancel-button {
  background-color: white;
  color: #ff0000;
  border-color: black;
  border-radius: 10px;
  font-weight: 300;
  margin-top: -20px;
  padding: 10px 0;
  outline: 10px;
}

.propDescription {
  font-weight: 200;
  max-height: 120px;
  overflow: hidden;
  max-width: 75%;
  text-align: center;
}
</style>