<template>
  <div class="form">
    <form>
      <div class="formGroup">
        <label for="propertyName">Property Name</label>
        <input id="propertyName" type="text" />
      </div>
      <div class="formGroup">
        <label for="propertyAddress">Address</label>
        <input id="propertyAddress" type="text" />
      </div>
      <div class="formGroup">
        <label for="propertyDescription">Property Description</label>
        <textarea
          id="propertyDescription"
          name="propertyDescription"
          rows="4"
          cols="50" placeholder="Write Description Here"
        >
        
        </textarea>
      </div>
      <div class="formGroup">
        <label for="numOfBedrooms">Number Of Bedrooms</label>
        <input id="numOfBedrooms" type="number" />
      </div>
      <div class="formGroup">
        <label for="numOfBathrooms">Number Of Bathrooms</label>
        <input id="numOfBathrooms" type="number" />
      </div>
      <div class="formGroup">
        <label for="rentAmount">Rent Price</label>
        <input id="rentAmount" type="number" />
      </div>
      <div class="formGroup">
        <label for="currentlRented">Currently rented?</label>
        <input id="currentlRented" type="checkbox" />
      </div>
      <input type="submit">
    </form>
  </div>
</template>


<script>
export default {
  name: "addpropertyform",
};

/*
CREATE TABLE property (
property_id serial NOT NULL,
prop_name varchar(200),
prop_address varchar(200) NOT NULL,
prop_lat DECIMAL,
prop_lng DECIMAL,
prop_description varchar(400),
prop_bedrooms INT NOT NULL,
prop_bathrooms INT NOT NULL,
prop_rent DECIMAL NOT NULL,
rented BOOLEAN,
url varchar(100),
CONSTRAINT PK_property_id PRIMARY KEY (property_id)
*/
</script>

<style scoped>

.form {
    width: 80%;
    background-color: #fafafa;
    display: flex;
    justify-content: center;
}
.formGroup {
    display: flex;
    flex-direction: column;
}
</style>