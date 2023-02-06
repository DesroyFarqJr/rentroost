<template>

 <div class="landlord">
    <maintenance-request-table />
    <list-of-tenants-table />
  
  <form @submit.prevent="submitForm">
    <input type="file" ref="fileInput" @change="uploadImage" />
    <textarea v-model="description"></textarea>
    <button class="reg" type="submit">uploadImage</button>
    <button type="submit">Submit</button>
    
  </form>
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
</style>
