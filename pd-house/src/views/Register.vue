<template>
    <div class="main-container">
    <h1>Crie sua conta</h1>
    <RegisterForm />
  </div>
</template>

<script>
import RegisterForm from "../components/RegisterForm.vue"
export default {
    name: "Register",
    components: {
        RegisterForm
    }
}
</script>

<style scoped>

</style>