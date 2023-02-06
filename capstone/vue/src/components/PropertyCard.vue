<template>
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
</template>
<script>
export default {
  methods: {
    updateProperty() {
      this.editMode = false;
      this.$emit("update-property", this.tempProperty);
    },
  },
  props: {
    property: Object,
  },
  data() {
    return {
      message: "Hello from Vue component",
      name: "propertyCard",
      editMode: false,
      tempProperty: { ...this.property },
    };
  },
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

.propDescription {
  font-weight: 200;
  max-height: 120px;
  overflow: hidden;
  max-width: 75%;
  text-align: center;
}
</style>