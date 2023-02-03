<template>
  <div class="property-card">
      <img v-bind:src="property.image">
      <h3>{{property.address}}</h3>
      <h5>${{property.price}} | BR: {{property.bedrooms}}</h5>
      <button>Edit Property</button>
  </div>
</template>

<script>
export default {

      props: {
        property: Object

      },
  data() {
    return {
        
      message: "Hello from Vue component",
      name: "propertyCard",

      methods: {

      },
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
    margin-top: -30px;
}
.property-card {
    font-family:Verdana, Geneva, Tahoma, sans-serif;
    background-color: #fafafa;
    margin: 30px;
    width: 25%;

        border-radius: 3px;
  display: flex;
  flex-direction: column;
  align-items: center;
  box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px;
  padding-bottom: 30px
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
</style>