
<h1 align="center">
  <br>
  <a href="https://github.com/DesroyFarqJr/rentroost"><img src="https://raw.githubusercontent.com/DesroyFarqJr/rentroost/main/vue/public/images/logo.png" alt="RentRoost" width="350"></a>
</h1>

<h4 align="center">A minimum-viable real estate web application built with Vue.js and Java Spring Boot.</h4>

<p align="center">
  <a href="#key-features">Key Features</a> •
  <a href="#how-to-use">How To Use</a> •
  <a href="#credits">Credits</a>
</p>

## Key Features
* Google Maps Integration
  - Properties pinned in map location. Geocoding information automatically tagged when a new property is added.
  - Pin clusters automatically generated based on pin volume in map area.
  - Property details available on pin click.
* Distinct functionality for landlord vs application vs unauthenticated user.
* 

## How To Use

Step One: Clone this repository

```bash
# Clone this repo
$ git clone https://github.com/DesroyFarqJr/rentroost.git
```

Step Two: Setup the Database
* Install and run a PostgreSQL Server
* Create a new database called rental_property_db
* Open dropdb.sql and run
* Open schema.sql and run
* Open user.sql and run
* Open property.sql and run
* Open data.sql and run

Step Three: Setup and run the frontend / backend servers

```bash
# Clone this repository
$ git clone https://github.com/DesroyFarqJr/rentroost.git

# Go into the Vue directory
$ cd Vue

# Install dependencies
$ npm install

# Run the app
$ npm run serve

# Go into main the backend directory
$ cd ../java/src/main/java/com/techelevator/

# Run the backend server
```

## Credits

This software uses the following open source packages:

- [Vue.js](https://vuejs.org/)
- [vue2-google-maps](https://github.com/xkjyeah/vue-google-maps)
- [Java Spring Boot](https://spring.io/)
