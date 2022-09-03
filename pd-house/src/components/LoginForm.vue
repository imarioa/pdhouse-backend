<template>
  <div>
    <div>
      <form id="register-form">
        <div class="input-container">
          <label for="email">Email</label>
          <input
            type="email"
            id="email"
            v-model="email"
            placeholder="Digite seu email"
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
          <input
            @click="login"
            type="submit"
            class="submit-btn"
            value="Entrar"
          />
        </div>
        <div class="hyper-link">
         <a href="/#/register"> Cadastre-se aqui</a>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import Message from "./Message.vue";
export default {
  name: "LoginForm",
  data() {
    return {
      email: "",
      password: "",
      baseURI: "http://localhost:8083/api/usuarios/register",
      oauth: "http://localhost:8083/oauth/token",
      msg: "Usuario errado",
      token: ""
    };
  },
  components: {
    Message,
  },
  methods: {
    login: function () {
                    var formData = new FormData();
                    formData.append('username', this.email);
                    formData.append('password', this.password);
                    formData.append('grant_type', "password");
 
                    axios.post(this.oauth, formData, { auth: { username: 'mandacaru', password: 'senha123' } }).then((result) => {
                        this.token = result.data.access_token;
                        this.$router.push({name: 'profile', params:{email:this.email, token: this.token}});
                    }).catch(function (error) {
                            console.log(error);
                    });
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
  font-size: 18px;
}
input {
  padding: 5px 10px;
  width: 400px;
  height: 50px;
  font-size: 16px;
}
.hyper-link{
  text-align: center;
  text-decoration: none;
}
a{
  text-decoration: none;
}
a:visited{
  color:#000000;
  text-decoration:none;
}
a:hover{
  color:#000000;
  text-decoration:underline;
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