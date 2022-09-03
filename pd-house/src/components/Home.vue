<template>
  <div class="main-container">
    <div class="line-container">
      <form id="search-form">
        <h1>Busque seu imóvel</h1>
        <div class="line-container">
          <div class="input-container">
            <label for="state">Estado</label>
            <select id="state" name="state">
              <option value="">Selecione um estado</option>
              <option value="AC">Acre</option>
              <option value="AL">Alagoas</option>
              <option value="AP">Amapá</option>
              <option value="AM">Amazonas</option>
              <option value="BA">Bahia</option>
              <option value="CE">Ceará</option>
              <option value="DF">Distrito Federal</option>
              <option value="ES">Espírito Santo</option>
              <option value="GO">Goiás</option>
              <option value="MA">Maranhão</option>
              <option value="MT">Mato Grosso</option>
              <option value="MS">Mato Grosso do Sul</option>
              <option value="MG">Minas Gerais</option>
              <option value="PA">Pará</option>
              <option value="PB">Paraíba</option>
              <option value="PR">Paraná</option>
              <option value="PE">Pernambuco</option>
              <option value="PI">Piauí</option>
              <option value="RJ">Rio de Janeiro</option>
              <option value="RN">Rio Grande do Norte</option>
              <option value="RS">Rio Grande do Sul</option>
              <option value="RO">Rondônia</option>
              <option value="RR">Roraima</option>
              <option value="SC">Santa Catarina</option>
              <option value="SP">São Paulo</option>
              <option value="SE">Sergipe</option>
              <option value="TO">Tocantins</option>
            </select>
            <label for="disctrict">Bairro</label>
            <input
              type="text"
              id="district"
              v-model="district"
              placeholder="Busque por bairro"
            />
          </div>

          <div class="input-container">
            <label for="city">Cidade</label>
            <input
              type="text"
              id="city"
              v-model="city"
              placeholder="Busque por cidade"
            />

            <label for="price">Preço</label>
            <select name="price" id="price" v-model="price">
              <option value="">Preço até</option>
              <option value="100000">R$ 100.000,00</option>
              <option value="200000">R$ 200.000,00</option>
              <option value="300000">R$ 300.000,00</option>
              <option value="400000">R$ 400.000,00</option>
              <option value="500000">R$ 500.000,00</option>
            </select>
          </div>
        </div>
        
          <div class="input-container">
            <input
              @click="search"
              type="submit"
              class="submit-btn"
              value="Buscar"
            /></div
        >
      </form>
      <img class="img-container" src="/images/house.jpg" alt="" />
    </div>
  </div>
    <ul>
      <li v-for="announcement in announcements" :key="announcement.id">
        <p>Estado: {{ announcement.state }}</p>
        <p>Bairro: {{ announcement.district }}</p>
        <p>Cidade: {{ announcement.city }}</p>
        <p>Rua: {{ announcement.street }}</p>
        <p>Número de quartos: {{ announcement.qt_bedrooms }}</p>
        <p>Número de banheiros: {{ announcement.qt_bathrooms }}</p>
        <p>Número de vagas na garagem:{{ announcement.qt_garage_spaces }}</p>
        <p>Preço: R${{ announcement.price }}</p> <br>
      </li>
    </ul>
</template>
<script>
import axios from "axios";
export default {
  
  name: "Home",
  data(){
    return{
      announcements: [],
        state: "",
        district: "",
        city: "",
        price: "",
        baseURI: "http://localhost:8083/api/searchFilter"

    };
  },
  methods:{
    search: function(){
      const config = {
                        headers: { Authorization: "Bearer " + this.token }
                    };
                    
                    axios
                        .get(this.baseURI + "?price=" + this.price + "&city=" + this.city + "&district=" + this.district + "&state=" + this.state)
                        .then((result) => {
                            this.announcements = result.data
                        })
                        .catch(function (error) {
                            console.log(error);
                        });
    },
  }
}
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
