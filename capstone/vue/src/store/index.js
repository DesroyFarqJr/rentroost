import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if (currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    properties: [
      {
        id: 10,
        image: "https://rentalroost.s3.us-east-2.amazonaws.com/image103.jpg",
        address: "246 Main St.",
        bedrooms: 3,
        price: 1800
      },
      {
        id: 20,
        image: "https://rentalroost.s3.us-east-2.amazonaws.com/image104.jpg",
        address: "488 South St.",
        bedrooms: 2,
        price: 1500
      },
      {
        id: 40,
        image: "https://rentalroost.s3.us-east-2.amazonaws.com/image103.jpg",
        address: "246 Main St.",
        bedrooms: 3,
        price: 1800
      },
      {
        id: 50,
        image: "https://rentalroost.s3.us-east-2.amazonaws.com/image103.jpg",
        address: "246 Main St.",
        bedrooms: 3,
        price: 1800
      },
      {
        id: 60,
        image: "https://rentalroost.s3.us-east-2.amazonaws.com/image104.jpg",
        address: "488 South St.",
        bedrooms: 2,
        price: 1500
      },
      {
        id: 80,
        image: "https://rentalroost.s3.us-east-2.amazonaws.com/image103.jpg",
        address: "246 Main St.",
        bedrooms: 3,
        price: 1800
      },
      {
        id: 900,
        image: "https://rentalroost.s3.us-east-2.amazonaws.com/image103.jpg",
        address: "246 Main St.",
        bedrooms: 3,
        price: 1800
      }
    ]

  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user', JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    }
  }

})
