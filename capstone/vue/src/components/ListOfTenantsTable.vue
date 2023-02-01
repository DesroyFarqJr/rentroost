<template>
  <table>
    <thead>
      <tr>
        <th>Name</th>
        <th>Phone</th>
        <th>Rent Payment</th>
        <th>Address</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="tenant in tenants" v-bind:key="tenant.id">
        <td>{{ tenant.name }}</td>
        <td>{{ tenant.phone }}</td>
        <td>{{ tenant.payment }}</td>
        <td>
          <span v-if="tenant.address">{{ tenant.address.address }}</span>
          <select v-else @change="changeAddress(tenant)" v-model="tenant.address">
            <option v-for="address in addresses" :value="address" v-bind:key="address.id">{{ address.address }}</option>
          </select>
        </td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  data() {
  return {
  tenants: [
  { id: 10, name: 'John Doe', phone: '123-456-7890', payment: '$1000', address: '' },
  { id: 20, name: 'Jane Doe', phone: '123-456-7890', payment: '$1200', address: '' },
  { id: 30, name: 'Billy Bob', phone: '123-456-7890', payment: '$1500', address: '123 Main St.' }
  ],
  addresses: [
      {id: 1,
      address: '123 Main St.'},
      {id: 2,
      address: '456 Elm St.'},
  ]
  }
  },
  methods: {
  assignAddress(tenant) {
  tenant.address = this.addresses[0];
  },
  changeAddress(tenant) {
  tenant.addrss = event.target.value;
  }
  }
}
</script>

<style scoped>
table {
  width: 70%;
  text-align: left;
  border-collapse: collapse;
  box-shadow: rgba(0, 0, 0, 0.07) 0px 1px 3px 0px,
    rgba(27, 31, 35, 0.15) 0px 0px 0px 1px;
  font-size: 16px;
  background-color: #fafafa;
  border-radius: 3px;
  border-top: solid 10px #ff0000;
}

th {
  padding-top: 40px;
  padding: 10px;
  font-weight: bold;
  font-size: 18px;
  border-bottom: 1px solid #f2f2f2;
}

td {
  padding: 10px;
  border-bottom: 1px solid #f2f2f2;
}

td button {
  background-color: #ff0000;
  box-shadow: none;
  border-radius: 3px;
  color: white;
  font-weight: 300;
  margin-top: 0px;
  padding: 10px 0;
  outline: 0;
}

td button:hover {
  box-shadow: rgba(0, 0, 0, 0.02) 0px 1px 3px 0px,
    rgba(27, 31, 35, 0.15) 0px 0px 0px 1px;
}

select {
  background-color: #f5f5f5;
  border: none;
  box-shadow: none;
  border-radius: 3px;
  color: #000;
  font-weight: 300;
  margin: 0px;
  padding: 10px 0;
  outline: 0;
  width: 100%;
}
</style>