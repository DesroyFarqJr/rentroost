<template>
  <div class="tenant">
    <div id="top-row">
      <div class="input-group">
        <balance-information />
        <maintenance-request-form />
      </div>
      <div class="submit-group">
        <e-check />
      </div>
    </div>
  </div>
</template>

<script>
import BalanceInformation from '../components/BalanceInformation.vue';
import ECheck from '../components/eCheck.vue';
import MaintenanceRequestForm from '../components/MaintenanceRequestForm.vue';
export default {
  components: { BalanceInformation, MaintenanceRequestForm, ECheck },
  name: "tenant"
};
</script>

<style>
.tenant {
      display: flex;
    justify-content: center;
    width: 100%
}

  .input-group {
    display: flex;
    justify-content: space-between;
  }

 
</style>
