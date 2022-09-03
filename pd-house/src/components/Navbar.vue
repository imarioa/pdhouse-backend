<template>
  <nav v-if="this.teste == 'A'">
    <router-link to="/" id="logo_url">
      <img :src="logo" :alt="alt" id="logo" />
    </router-link>
  </nav>
  <nav v-if="this.teste == 'B'">
    <router-link to="/" id="logo_url">
      <img :src="logo" :alt="alt" id="logo" />
    </router-link>
        <router-link to="/login">Entrar</router-link>
        <router-link to="/register">Cadastrar</router-link>          
    <!--   <router-link to="/register">Cadastrar</router-link>
    <router-link to="/immobile">Cadastrar Imovel</router-link> -->
  </nav>
</template>
<script>
export default {
  name: "Navbar",
  props: ["logo", "alt"],
  data() {
    return {
      teste: "B",
    };
  },
};
</script>
<style scoped>
nav {
  background-color: #222;
  border-bottom: 4px solid #111;
  padding: 15px 50px;
  display: flex;
  justify-content: flex-end;
  align-items: center;
}
#logo_url {
  margin: auto;
  margin-left: 0;
}
#logo {
  width: 40px;
  height: 40px;
}
nav a {
  color: #fcba03;
  text-decoration: none;
  margin: 12px;
  transition: 0.5s;
}
nav a:hover {
  color: #fff;
}
.dropdown-content {
  display: none;
  position: absolute;
  background-color: #222;
  min-width: 80px;
  box-shadow: 0px 8px 8px 0px rgba(0,0,0,0.2);
  z-index: 1;
}
.dropdown:hover .dropdown-content {
  display: block;
}
.dropdown-content a{
  color: fcba03;
  padding: 10px 10px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #222}

.dropdown:hover .dropdown-content {
  display: block;
}


</style>
