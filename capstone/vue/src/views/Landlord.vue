<template>

 <div class="landlord">

   <div class="tenant">
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
    <!-- Nav Bar Above -->
<div id="box">
  <div id="box2">
  </div>
    <maintenance-request-table id="MT" />
    <list-of-tenants-table id="LTT" />
  
  <form @submit.prevent="submitForm">
    <input type="file" ref="fileInput" @change="uploadImage" />
    <textarea v-model="description"></textarea>
    <button class="reg" type="submit">uploadImage</button>
    <button type="submit">Submit</button>
    
  </form>
</div>
 </div>
 </div>
</template>

<script>
import AWS from "aws-sdk";
import ListOfTenantsTable from "../components/ListOfTenantsTable.vue";
import MaintenanceRequestTable from "../components/MaintenanceRequestTable.vue";
export default {
  components: { MaintenanceRequestTable, ListOfTenantsTable },
  name: "landlord",
  data() {
    return {
      description: "",
      imageUrl: "",
    };
  },
  methods: {
    uploadImage() {
      const s3 = new AWS.S3({
        accessKeyId: "AKIA2RQODBA7E5HWSEXS",
        secretAccessKey: "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",
      });
      const file = this.$refs.fileInput.files[0];
      const params = {
        Bucket: "rent-roost",
        Key: file.name,
        Body: file,
      };
      s3.upload(params, (err, data) => {
        if (err) {
          console.error(err);
        } else {
          this.imageUrl = data.Location;
        }
      });
    },
    submitForm() {
      // send the property information, including the image URL, to the database
      console.log(this.description, this.imageUrl);
    },
  },
};
</script>

<style>
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

#MT {
  /* For some reason adding on a Boc shadow results in table extenstion
    Box shadow removed until figured out */
}

#LTT{
  box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px;
}
#box2{
  padding: 5 5 5 5;
}

#box{
  padding-top: 100px;
  
  
}
</style>
