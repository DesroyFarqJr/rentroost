import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'
import * as VueGoogleMaps from "vue2-google-maps" // Google Maps package


require('dotenv').config()
Vue.config.productionTip = false

axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;


Vue.use(VueGoogleMaps, {
  load: {
    key: process.env.VUE_APP_GMAPSAPIKEY,
    libraries: "places"
  }
});

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app');

////Liked image code below ////
const initApp = async () => {

  //get json data from db
const contacts = await getDataFromDB();

  //render data to page
renderContacts(contacts);
  // add listeners 

}

document.addEventListener("DOMContentLoaded", initApp);

const getDataFromDB = async () => {
  const fakeDataStream = await fetch(
    "https://fakerapi.it/api/v1/persons?_quantity=50"
    );
  const jsonData = await fakeDataStream.json();
  return jsonData.data;
};

const renderContacts = (contacts) => {
  const main = document.querySelector("main");
  const cardsArray = [];


  contacts.forEach((contact) => {
    const elemObj = createCardElements();
    const card = createPersonCard(elemObj, contact);
    cardsArray.push(card);
    // card elements
    // person card
    //push each card to the empty array

  });

cardsArray.forEach(card => {
  main.appendChild(card);
});

};

const createCardElements = () => {
  const article = document.createElement("article");
  const img = document.createElement("img");
  const details = document.createElement("div");
  const like = document.createElement("h2");
  const email = document.createElement("p");
  return { article, img, details, like, name, email};
};

const createPersonCard = (elemObj, person) => {
const {article, img, details, like, name, email} = elemObj; 

details.className = "details";
like.classlist.add("like", "like-no");

name.textContent = `${person.firstname} ${person.lastname}`;
img.src = person.image;
email.textContent = person.email; 

article.appendChild(img);
details.appendChild(name);
details.appendChild(email);
article.appendChild(details);
article.appendChild(like);

return article;




}