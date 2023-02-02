<template>
  <div class="user">
        <nav class="navbar navbar-expand-md navbar-light fixed-top">
      <div class="container-fluid">
        <a href="#" class="navbar-brand"
          ><img alt="logo" src="../../public/images/logo.png"
        /></a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="navbarsExampleDefault"
          label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item">
              <router-link class="nav-link" to="/login">Login</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="/register"> Sign up</router-link>
            </li>
          </ul>
        </div>
      </div>
    </nav>

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
export default {
  data() {
    return {
      message: "Hello from Vue component",
      name: "UserHeader",
      methods: {

      }
    };
  }
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

  .input-group > * {
  }
    .input-group > * {
    margin-bottom: 5%;
  }
</style>
