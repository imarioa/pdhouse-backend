<template>

<div class="input-container">
              <input
                @click="fetchProductByEmail"
                type="submit"
                class="submit-btn"
                value="Exibir anuncios"
              /></div>
            <div class="input-container">
              <input
                @click="register"
                type="submit"
                class="submit-btn"
                value="Cadastrar Anuncio"
              /></div>
 
            <ul>
                <li v-for="announcement in user.announcements" :key="announcement.id">
                    <p>Tipo: {{announcement.type}}</p>
                    <p>Endereço: {{announcement.street}}, {{announcement.district}}, {{announcement.city }} - {{announcement.state}}</p>
                    <p>Area: {{announcement.m_square_ground }} m²</p>
                    <p>Número de quartos: {{announcement.qt_bedrooms}}</p>
                    <p>Número de banheiros: {{ announcement.qt_bathrooms }}</p>
                    <p>Número de vagas na garagem:{{announcement.qt_garage_spaces }}</p>
                    <p>Preço: R${{ announcement.price }}</p> <br>
                </li>
            </ul>
</template>

<script>
import axios from "axios";
import Message from "./Message.vue";
export default {
  name: "PosLogin",
  data() {
    return {
      iduser: "",
      idannouncement:"",
      city:"",
      state:"",
      district:"",
      street:"",
      type:"",
      area:"",
      qt_bed:"",
      qt_bath:"",
      qt_garage:"",
      price:"",
      status:"",
      name: "",
      email: this.$route.params.email,
      token: this.$route.params.token,
      msg: "",
      announcement: {},
      announcements: [],
      user: {},
      baseURI: "http://localhost:8083/api/usuarios",
      oauth: "http://localhost:8080/oauth/token"
    };
  },
  components: {
    Message,
  },
  methods: {
    Showmessage: function () {
      this.msg = "Cadastro realizado com sucesso!";
      this.name = "";
      this.email = "";
      this.telephone = "";
      this.cpf = "";
      this.password = "";
      this.passwordrp = "";
      setTimeout(() => (this.msg = ""), 3000);
    },
    registerUser: function () {
      axios({
        method: "post",
        url: this.baseURI,
        headers: {},
        data: {
          name: this.name,
          email: this.email,
          password: this.password,
          cpf: this.cpf,
          tel: this.telephone,
          address: this.address,
        },
      });
      this.msg = "Cadastro realizado com sucesso!";
      this.name = "";
      this.email = "";
      this.telephone = "";
      this.cpf = "";
      this.password = "";
      this.passwordrp = "";
      this.address = "";
      setTimeout(() => (this.msg = ""), 3000);
    },
    fetchProductByEmail: function () {
                    const config = {
                        headers: { Authorization: "Bearer " + this.token }
                    };
                    console.log(this.token);
                    axios
                        .get(this.baseURI + "/procurar?email=" + this.email, config)
                        .then((result) => {
                            this.user = result.data;
                        })
                        .catch(function (error) {
                            console.log(error);
                        });
                    axios.get(this.baseURI + "")
                },
    register: function (){
        this.$router.push({name: 'immobile', params:{email:this.email, token: this.token}});
    }
  },
};
</script>

<style scoped>
#register-form {
  max-width: 400px;
  margin: 0 auto;
}
.input-container {
  display: flex;
  flex-direction: column;
  margin-bottom: 20px;
}
label {
  font-weight: bold;
  margin-bottom: 15px;
  color: #222;
  padding: 5px 10px;
  border-left: 4px solid #222;
}
input {
  padding: 5px 10px;
  width: 400px;
  height: 40px;
  font-size: 15px;
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
}
.submit-btn:hover {
  background-color: transparent;
  color: #222;
}
</style>