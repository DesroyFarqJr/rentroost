 <template>
    <div>
      <property-card  v-bind:property="property" v-for="property in $store.state.properties" v-bind:key="property.id" />
    </div>
</template>

<script>
import PropertyCard from './PropertyCard.vue';

export default {
  components: {PropertyCard},
  name: "propertyList",
};
</script>

<style scoped>
div {
  display: flex;
  flex-wrap: wrap;
  gap: 2em;
}
</style>
 