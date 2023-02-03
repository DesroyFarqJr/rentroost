<template>
  <div>
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
div {
  display: flex;
  justify-content: center;
  align-content: center;
}

button {
    height: 10%;
}
</style>