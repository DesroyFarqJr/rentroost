<template>
  <div id="app">
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

    <div class="auth-wrapper">
      <div class="auth-inner">
        <div id="login" class="text-center">
          <form class="form-signin" @submit.prevent="login">
            <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
            <div
              class="alert alert-danger"
              role="alert"
              v-if="invalidCredentials"
            >
              Invalid username and password!
            </div>
            <div
              class="alert alert-success"
              role="alert"
              v-if="this.$route.query.registration"
            >
              Thank you for registering, please sign in.
            </div>
            <label for="username" class="sr-only">Username</label>
            <input
              type="text"
              id="username"
              class="form-control"
              placeholder="Username"
              v-model="user.username"
              required
              autofocus
            />
            <label for="password" class="sr-only">Password</label>
            <input
              type="password"
              id="password"
              class="form-control"
              placeholder="Password"
              v-model="user.password"
              required
            />
            <router-link :to="{ name: 'register' }"
              >Need an account?</router-link
            >
            <button class="reg" type="submit">Sign in</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },

      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style scoped>
@import url("https://fonts.googleleapis.com/css?family=Fira+Sans:400,500,600,700,800");

* {
  box-sizing: border-box;
}
body {
  background: #ffffff !important;
  min-height: 100vh;
  display: flex;
  font-weight: 400;
  font-family: "Fira Sans", sans-serif;
}

h1,
h2 h3,
h4,
h5,
h6,
label,
span {
  font-weight: bold;
  font-family: "Fira Sans", sans-serif;
  color: rgba(0, 0, 0, 0.685);
}

body,
html,
#app,
.auth-wrapper {
  width: 100%;
  height: 100%;
}

#app {
  text-align: left;
}

.navbar-collapse {
  display: flex;
  justify-content: flex-end;
}
.navbar-brand {
  padding: 0;
  margin: 0;
}
.navbar-brand img {
  display: flex;
  justify-content: flex-start;
  height: 50px;
  width: 200px;
  padding: 0;
  margin: 0;
  left: 0;
}
.navbar-brand {
  text-transform: uppercase;
  color: red;
}
.navbar-light {
  display: flex;
  flex-direction: column;
  flex-wrap: nowrap;
  justify-content: flex-end;
  align-items: baseline;
  align-content: stretch;
  border-bottom: 2px solid transparent;

  background-color: #ffffff;
box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px;
}
a {
  box-shadow: inset 0 0 0 0 #000000;
  color: #999999;
  padding: 0 0.25rem;
  margin: 0 -0.25rem;
  transition: color 0.3s ease-in-out, box-shadow 0.3s ease-in-out;
}
a:hover {
  box-shadow: inset 179px 0 0 0 #ff0000;
  color: white;
}

/* Presentational styles */
a {
  color: #ff000f;
  font-family: "Fira Sans", sans-serif;
  font-size: 20px;
  font-weight: 700;
  line-height: 1.5;
  padding-left: 15px;
  text-decoration: none;
}
.auth-wrapper {
  display: flex;
  justify-content: center;
  flex-direction: column;
  text-align: left;
}

.auth-inner {
  width: 450px;
  margin: auto;
  background: #ffffff;
  box-shadow: 0px 14px 80px rgba(34, 35, 58, 0.2);
  padding: 40px 55px 45px 55px;
  border-radius: 15px;
  transition: all 0.3s;
}

.auth-wrapper .form-control:focus {
  border-color: #a02021;
  box-shadow: none;
}

.auth-wrapper h3 {
  text-align: center;
  margin: 0;
  line-height: 1;
  padding-bottom: 20px;
}

.custom-control-label {
  font-weight: 400;
}
.navbar-nav .nav-link {
  border-bottom: 2px solid transparent;
}

.forgot-password,
.forgot-password a {
  text-align: right;
  font-size: 13px;
  padding-top: 10px;
  color: #7f7d7e;
  margin: 0;
}

.forgot-password a {
  color: #a02021;
}
button {
  cursor: pointer;
  border: 0;
  border-radius: 4px;
  font-weight: 600;
  margin: 0 10px;
  width: 200px;
  padding: 10px 0;
  box-shadow: 0 0 20px rgba(104, 85, 224, 0.2);
  transition: 0.4s;
}

.reg {
  color: white;
  background-color: rgb(192, 192, 192);
  padding-top: 10px;
}

.log {
  color: rgb(104, 85, 224);
  background-color: rgba(255, 255, 255, 1);
  border: 1px solid rgb(255, 0, 0);
  padding: 10px;
}

button:hover {
  color: white;
  width: 200px;
  box-shadow: 0 0 20px rgba(182, 0, 0, 0);
  background-color: rgb(240, 4, 4);
}
</style>


