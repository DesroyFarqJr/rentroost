<template>
  <div>
    <table>
      <thead>
        <tr>
          <th>Tenant Name</th>
          <th>Description</th>
          <th>Address</th>
          <th>Assigned Employee</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="tenant in tenants.slice(0, 5)" v-bind:key="tenant.id">
          <td>{{ tenant.name }}</td>
          <td>{{ tenant.description }}</td>
          <td>{{ tenant.address }}</td>
          <td>
            <button
              v-if="!tenant.assignedEmployee"
              @click="assign(tenant)"
            >
              Assign
            </button>
            <span v-if="tenant.assignedEmployee">{{
              tenant.assignedEmployee.name
            }}</span>
            <span v-if="tenant.isAssigning">
              <select
                v-model="tenant.assignedEmployee"
                @change="onSelectionChange(tenant)"
              >
                <option
                  v-for="employee in employees"
                  :value="employee"
                  v-bind:key="employee.id"
                >
                  {{ employee.id}} - {{employee.name }}
                </option>
              </select>
            </span>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>
<script>
export default {
  data() {
    return {
      tenants: [
        {
          id: 1,
          name: "John Doe",
          description: "Change light bulb",
          address: "123 Main Street",
          isAssigning: false,
          assignedEmployee: "",
        },
        {
          id: 2,
          name: "Jane Doe",
          description: "Repair toilet",
          address: "456 Main Street",
          isAssigning: false,
          assignedEmployee: "",
        },
      ],
      employees: [
        { id: 10, name: "Bob Smith" },
        { id: 20, name: "James Robbins" },
      ],
    };
  },
  methods: {
    assign(tenant) {
      tenant.isAssigning = true;
    },
    onSelectionChange(tenant) {
      tenant.isAssigning = false;
    },
  }
};


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