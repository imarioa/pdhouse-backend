<template>
  <div class="main-container">
    <p>{{ announcements }}</p>
    <ul>
      <li v-for="announcement in announcements" :key="announcement.id">
        <p>Estado: {{ announcement.state }}</p>
        <p>Bairro: {{ announcement.district }}</p>
        <p>Cidade: {{ announcement.city }}</p>
        <p>Rua: {{ announcement.street }}</p>
        <p>Número de quartos: {{ announcement.qt_bedrooms }}</p>
        <p>Número de banheiros: {{ announcement.qt_bathrooms }}</p>
        <p>Número de vagas na garagem:{{ announcement.qt_garage_spaces }}</p>
        <p>Preço: R${{ announcement.price }}</p>
      </li>
    </ul>
  </div>
</template>
<script>
import axios from "axios";

export default {
  name: "Search",
  data() {
    return {
      state: "",
      district: "",
      city: "",
      price: "",
      street: "",
      type: "",
      m_square_ground: "",
      qt_bedrooms: "",
      qt_bathrooms: "",
      qt_garage_spaces: "",
      status: "",
      baseURI: "http://localhost:8083/api/announcements",
      announcement: {},
      announcements: this.result,
    };
  },
  props: {
    result: Array,
  },
  methods: {
    fetchProducts: function () {
      console.log(JSON.parse(this.$route.params.result));

      this.announcements = JSON.parse(this.$route.params.result);
      console.log(this.announcements);
    },
  },
};
</script>
<style scoped>
#search-form {
  max-width: 420px;
}
.input-container {
  display: flex;
  flex-direction: column;
  margin-bottom: 30px;
  margin-left: 20px;
}
.line-container {
  display: flex;
  flex-direction: row;
}
.img-container {
  width: 700px;
  height: 380px;
  margin-left: 150px;
}
label {
  font-weight: bold;
  margin-bottom: 15px;
  color: #222;
  padding: 5px 10px;
  border-left: 4px solid #222;
}
input,
select {
  padding: 7px 10px;
  width: 220px;
  margin-bottom: 20px;
  font-size: 15px;
}

.submit-btn {
  background-color: #222;
  color: #fcba03;
  font-weight: bold;
  border: 2px solid #222;
  padding: 10px;
  font-size: 16px;
  cursor: pointer;
  transition: 0.5s;
  width: 462px;
}
.submit-btn:hover {
  background-color: transparent;
  color: #222;
}
</style>
