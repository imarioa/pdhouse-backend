<template>
  <div class="main-container">
    <Message :msg="msg" v-show="msg" />
    <div class="line-container">
      <form id="register-form">
        <h1>Cadastrar imóvel</h1>
        <div class="input-container">
          <div class="input-container">
            <label for="owner">Nome do proprietario</label>
            <input
              type="text"
              id="owner"
              v-model="owner"
              placeholder="Digite seu nome completo"
            />
          </div>
          <div class="input-container">
            <label for="type">Tipo de imóvel</label>
            <select name="type" id="type" v-model="type">
              <option value="">Selecione o tipo de imóvel</option>
              <option value="apartment">Apartamento</option>
              <option value="house">Casa</option>
              <option value="flat">Flat</option>
            </select>
          </div>
          <div class="line-container">
            <div class="input-container">
              <label for="state">Estado</label>
              <select id="state" name="state" v-model="state">
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
            </div>
            <div class="input-container">
              <label for="city">Cidade</label>
              <input
                type="text"
                id="city"
                v-model="city"
                placeholder="Digite a cidade"
              />
            </div>
          </div>
          <div class="line-container">
            <div class="input-container">
              <label for="district">Bairro</label>
              <input
                type="text"
                id="district"
                v-model="district"
                placeholder="Digite o bairro"
              />
            </div>
            <div class="input-container">
              <label for="street">Rua</label>
              <input
                type="text"
                id="street"
                v-model="street"
                placeholder="Digite a rua"
              />
            </div>
            <div class="input-container">
              <label for="house-number">Numero</label>
              <input
                description="teste"
                type="text"
                id="house-number"
                v-model="housenumber"
              />
            </div>
          </div>
          <h3>Dados do imóvel</h3>
          <div class="input-container">
            <label for="price">Preço </label>
            <input type="number" id="price" v-model="price" placeholder="R$" />
          </div>
          <div class="input-container">
            <label for="area">Área</label>
            <input type="text" id="area" v-model="area" placeholder="Em m²" />
          </div>
          <div class="line-container">
            <label for="bedrooms" id="infolabel">Quartos</label>
            <div class="info-buttons">
              <input type="text" id="n_bed" v-model="n_bed" />
            </div>
          </div>
          <div class="line-container">
            <label for="bathrooms" id="infolabel">Banheiros</label>
            <div class="info-buttons">
              <input type="text" id="n_bath" v-model="n_bath" />
            </div>
          </div>
          <div class="line-container">
            <label for="garage" id="infolabel">Garagem</label>
            <div class="info-buttons">
              <input type="text" id="n_garage" v-model="n_garage" />
            </div>
          </div>
          <div class="input-container">
            <label for="title">Descrição</label>
            <textarea
              name="title"
              id="title"
              v-model="title"
              maxlength="3000"
            ></textarea>
          </div>
            <div class="input-container">
              <input
                @click="postProduct"
                type="submit"
                class="submit-btn"
                value="Cadastrar"
              /></div
          >
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import Message from "./Message.vue";

export default {
  name: "RegisterImmobileForm",
  data() {
    return {
      user: {},
      email: "",
      owner: "",
      type: "",
      state: "",
      city: "",
      district: "",
      street: "",
      housenumber: "",
      price: "",
      area: "",
      msg: "",
      title: "",
      n_bath: 0,
      n_bed: 0,
      n_garage: 0,
      products: [],
      token: this.$route.params.token,
      email: this.$route.params.email,
      baseURI: "http://localhost:8083/api/usuarios/",
      selectedFile: null,
    };
  },
  components: {
    Message,
  },
  methods: {
    Showmessage: function () {
      this.msg = "Cadastro realizado com sucesso!";
      this.owner = "";
      this.type = "";
      this.state = "";
      this.city = "";
      this.district = "";
      this.street = "";
      this.housenumber = "";
      this.price = "";
      this.area = "";
      this.msg = "";
      this.n_bath = 0;
      this.n_bed = 0;
      this.n_garage = 0;
      setTimeout(() => (this.msg = ""), 3000);
    },
    postProduct: function () {
      var userid;
      const config = {
        headers: { Authorization: "Bearer " + this.token },
      };

      axios
        .get(this.baseURI + "procurar?email=" + this.email, config)
        .then((result) => {
          userid = result.data.id;
          axios({
            method: "post",
            url: this.baseURI + userid + "/announcements",
            headers: { Authorization: "Bearer " + this.token },
            data: {
              owner: this.owner,
              type: this.type,
              state: this.state,
              city: this.city,
              district: this.district,
              street: this.street,
              number_house: this.housenumber,
              price: parseFloat(this.price),
              m_square_ground: parseInt(this.area),
              qt_bathrooms: parseInt(this.n_bath),
              qt_bedrooms: parseInt(this.n_bed),
              qt_garage_spaces: parseInt(this.n_garage),
            },
          });
        })
        .catch(function (error) {
          console.log(error);
        });
        console.log(this.email);
        this.$router.push({name: 'profile', params:{email:this.email, token: this.token}});
    },
    teste: function () {
      console.log(this.$route.query.email);
    },
  },
};
</script>

<style scoped>
#register-form {
  max-width: 400px;
  margin-left: 60px;
}
.input-container {
  display: flex;
  flex-direction: column;
  margin-bottom: 20px;
}
.line-container {
  display: flex;
  flex-direction: row;
}
label {
  font-weight: bold;
  margin-bottom: 15px;
  color: #222;
}
.info-buttons {
  display: flex;
  flex-direction: row;
  margin: 0 auto;
}
#infolabel {
  font-weight: lighter;
  color: rgb(49, 48, 48);
  margin-bottom: 20px;
}
#owner,
#district,
input,
select {
  padding: 5px 10px;
  width: auto;
  height: 40px;
  font-size: 15px;
}
#house-number {
  padding: 5px 10px;
  margin-left: 5px;
  width: 50px;
}
#street {
  padding: 5px 10px;
  margin-left: 5px;
  width: 150px;
}
#city {
  margin-left: 5px;
  width: 170px;
}
#n_garage {
  height: 30px;
  width: 80px;
  margin-left: 50px;
}
#n_bed {
  height: 30px;
  width: 80px;
  margin-left: 60px;
}
#n_bath {
  height: 30px;
  width: 80px;
  margin-left: 43px;
}
#tittle {
  height: 150px;
  resize: none;
  padding: 10px;
}
#state {
  width: 225px;
}
#infolabel {
  margin-top: 10px;
}
p {
  margin-top: 10px;
  margin-left: 20px;
}
button {
  background-color: #222;
  color: #fcba03;
  font-weight: bold;
  border: 2px solid #222;
  padding: 10px;
  font-size: 16px;
  margin-left: 20px;
  margin-bottom: 20px;
  cursor: pointer;
  transition: 0.5s;
  width: 50px;
}
.submit-btn {
  background-color: #222;
  color: #fcba03;
  font-weight: bold;
  border: 2px solid #222;
  padding: 10px;
  font-size: 16px;
  margin: 0 auto;
  cursor: pointer;
  transition: 0.5s;
  width: 406px;
}
button:hover,
.submit-btn:hover {
  background-color: transparent;
  color: #222;
}
textarea {
  height: 150px;
  padding: 10px;
  font-size: 15px;
  resize: none;
}
</style>