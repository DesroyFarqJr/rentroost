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
              <router-link class="nav-link" to="/user">Account</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="/logout">Logout</router-link>
            </li>
          </ul>
        </div>
      </div>
    </nav>

   <saved-homes />

    <!-- <div v-bind="like in likes" @click="toggleLike(like)"> -->
   
    <!-- <h2>{{ like.firstname }} {{ like.lastname }}</h2> -->
    <!-- <p>{{ like.email }}</p> -->
  <!-- </div> -->
  </div>
</template>
    


<script>
import SavedHomes from '../components/SavedHomes.vue';

export default {
  components: { SavedHomes },
 
  name: "user",
  data() {
    return {
      likes: [],
    };
  },

  methods: {
    toggleLike(like) {
      like.classList.toggle("like-no");
      like.classList.toggle("like-yes");
      if (like.classList.contains("like-yes")) {
        console.log(" Saving Favorite");
        this.getFavoriteData(like);
      } else {
        console.log(" Removing Favorite");
        this.getFavoriteData(like);
      }
    },
    getFavoriteData(like) {
      const img = like.querySelector("img").src;
      const name = like.querySelector("h2").textContent;
      const email = like.querySelector("p").textContent;
      const [firstname, lastname] = name.split(" ");
      const faveObj = { img, firstname, lastname, email };

      console.log(faveObj);
    },
  },
};
</script>


<style>

.saved-homes {
  display: flex;
    justify-content: center;
    width: 100%;
    background-color: lightgray;

}
main {
  display: flex;
  justify-content:  space-evenly;
  align-items: center;
  flex-wrap: wrap;

}


article {
  max-width: 300px;
  margin: 20px 10pc 0;
  border: 1px solid #000;
  border-radius: 15px;
  box-shadow: 5px 5px 10px #333;
  position: relative;
  background-color: white;
}

img {
  display: block;
  width: 100%;
  border-radius: 10px 10px 0 0;

}

.details {
  padding: 10px;

}

.like{
  width: 48px;
  height: 48px;
  position: absolute;
  top: 2%;
  right: 2%;

}

.like-no {
  background: url("../../public/images/egg-unsave-btn.svg") no-repeat;

}

.like{
  background: url("../../public/images/egg-save-btn.svg") no-repeat;

}
</style>
