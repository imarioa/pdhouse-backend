<template>
  <div>
    <Message :msg="msg" v-show="msg" />
    <div>
      <form id="register-form">
        <div class="input-container">
          <label for="name">Seu nome</label>
          <input
            type="text"
            id="name"
            v-model="name"
            placeholder="Digite seu nome completo"
          />
        </div>
        <div class="input-container">
          <label for="email">Seu email</label>
          <input
            type="email"
            id="email"
            v-model="email"
            placeholder="Digite seu email"
          />
        </div>
        <div class="input-container">
          <label for="telephone">Telefone</label>
          <input
            type="tel"
            id="telephone"
            v-model="telephone"
            placeholder="(DDD)98765-4321"
          />
        </div>
        <div class="input-container">
          <label for="address">Seu endereço</label>
          <input
            type="text"
            id="address"
            v-model="address"
            placeholder="Rua ? Casa ? Cidade ?"
          />
        </div>
        <div class="input-container">
          <label for="cpf">CPF</label>
          <input
            type="text"
            id="cpf"
            v-model="cpf"
            placeholder="xxx.xxx.xxx-xx"
          />
        </div>
        <div class="input-container">
          <label for="password">Senha</label>
          <input
            type="password"
            id="password"
            v-model="password"
            placeholder="Digite sua senha"
          />
        </div>
        <div class="input-container">
          <label for="password-rp">Repetir senha</label>
          <input
            type="password"
            id="password-rp"
            v-model="passwordrp"
            placeholder="Repita sua senha"
          />
        </div>
        <router-link to="/login">
        <div class="input-container">
          <input
            @click="registerUser"
            type="submit"
            class="submit-btn"
            value="Cadastrar"
          />
        </div>
        </router-link>
      </form>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import Message from "./Message.vue";
export default {
  name: "RegisterForm",
  data() {
    return {
      name: "",
      email: "",
      telephone: "",
      cpf: "",
      password: "",
      passwordrp: "",
      address: "",
      msg: "",
      baseURI: "http://localhost:8083/api/usuarios/register",
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