<template>
  <div>
    <h2></h2>
    <button v-on:click="upload">Upload</button><br />
    <span id="fileResponse"></span>
    <p>{{ message }}</p>
  </div>
</template>

<script>
export default {
  name: "CloudinaryComp",
  data() {
    return {
      myWidget: {},
      message: "",
    };
  },
  methods: {
    upload() {
      this.myWidget.open();
    },
  },
  mounted() {
    this.myWidget = window.cloudinary.createUploadWidget(
      {
        // Our RentRoost cloudname and upload preset
        cloudName: "du2zsmghw",
        uploadPreset: "alhrryca",
        sources: ["camera", "local"],
        googleApiKey: "<image_search_google_api_key>",
        showAdvancedOptions: false,
        cropping: false,
        multiple: false,
        // new stuff added below
        max_files: 1,
        thumbnails: "#thumbnails",
        defaultSource: "local",
        keep_widget_open: true,
        // to here
        styles: {
          // Make everything red to match red roost branding
          palette: {
            window: "#ffffff",
            sourceBg: "#EAEAEA",
            windowBorder: "#FF0000",
            tabIcon: "#000000",
            inactiveTabIcon: "#555a5f",
            menuIcons: "#555a5f",
            link: "#FF0000",
            action: "#339933",
            inProgress: "#FF0000",
            complete: "#339933",
            error: "#cc0000",
            textDark: "#000000",
            textLight: "#fcfffd",
          },
          fonts: {
            default: null,
            "'Fira Sans', sans-serif": {
              url: "https://fonts.googleapis.com/css?family=Fira+Sans",
              active: true,
            },
          },
        },
      },
      (error, result) => {
        if (!error && result && result.event === "success") {
          // alert("Image upload was succesful !!");
          console.log("Here is the image info: ", result.info);
          console.log("Image URL: " + result.info.url);
          //                             ^^ THIS IS THE URL,
          // WHICH NEEDS TO BE PUSHED TO THE PROPERTY SPREADSHEET WITH FORM DATA FROM LANDLORD
          this.message = "Image upload successful !!";
        }
      }
    );
  },
};
</script>

<style scoped>
p {
  font-family: "Fira Sans", sans-serif;
}
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>