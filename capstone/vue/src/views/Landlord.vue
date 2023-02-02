<template>
    <div class ="landlord">
        <maintenance-request-table/>
        <list-of-tenants-table/>
    </div>
</template>

<script>
import ListOfTenantsTable from '../components/ListOfTenantsTable.vue';
import MaintenanceRequestTable from '../components/MaintenanceRequestTable.vue';
export default {
  components: {MaintenanceRequestTable, ListOfTenantsTable},
  name: "landlord"
};
</script>

<style>

</style>
