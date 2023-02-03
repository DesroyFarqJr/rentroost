<template>
  <div id="add-property">
        <h1>Your Properties</h1>
      <div>
              <button>Add Property</button>
      </div>
    <properties-list />
  </div>
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