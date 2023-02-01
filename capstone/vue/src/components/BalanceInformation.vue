<template>
  <div id="main-container">
      <div id="current-balance-container">
         <h4>Your Current Balance</h4>
         <h1>${{balance}}</h1>
         <button class="tenant-button">Pay Balance</button>
      </div>
    

  </div>
</template>

<script>
export default {
  data() {
    return {
      message: "Hello from Vue component",
      name: "balanceInformation",
      balance: 2800,
    };
  }
};
</script>

<style>
#main-container {
    border-top: solid 10px #ff0000;
    width: 45%;
    border-radius: 3px;
    background-color: #f5f5f5;
    display: flex;
    justify-content: center;
    font-family:Verdana, Geneva, Tahoma, sans-serif;
    padding-bottom: 50px;
    box-shadow: rgba(0, 0, 0, 0.02) 0px 1px 3px 0px, rgba(27, 31, 35, 0.15) 0px 0px 0px 1px;
}
#current-balance-container {
    margin-top: 40px;
    width: 80%;
    display: flex;
    flex-direction: column;}

h4 {
    font-weight: 200;
}
h1 {
    font-weight: 400;
    margin-top: -8px;
}

.tenant-button {
    background-color: #ff0000;
    box-shadow: none;
    border-radius: 3px;
    color: white;
    font-weight: 300;
    margin: 0px;
    margin-top: 20px;
}

.tenant-button:hover {
    color: white;
        box-shadow: rgba(0, 0, 0, 0.02) 0px 1px 3px 0px, rgba(27, 31, 35, 0.15) 0px 0px 0px 1px;
}

</style>