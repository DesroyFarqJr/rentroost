
<template>
    
    <div class ="employee">
      
        <list-of-tenants-table/>
        <maintenance-request-table/>
        <account-creator-form/>
    </div>
</template>

<script>
import AccountCreatorForm from '../components/AccountCreatorForm.vue'
import ListOfTenantsTable from '../components/ListOfTenantsTable.vue';
import MaintenanceRequestTable from '../components/MaintenanceRequestTable.vue';
export default {
  components: {AccountCreatorForm, ListOfTenantsTable, MaintenanceRequestTable},
  name: "employee"
};
</script>

<style>

</style>
