<template>
  <div class="main-container">
    <div class="input-container">
      <h3 for="upload">Carregue as fotos</h3>
      <input
        type="file"
        accept="image/png, image/jpeg"
        @change="onFileChanged"
      />
    </div>
    <div class="input-container">
      <input
        @click="teste"
        type="submit"
        class="submit-btn"
        value="Concluir"
      />
    </div>
  </div>
</template>
          
<script>
import axios from "axios";

export default {
  name: "ImageUpload",
  data() {
    return {
      selectedFile: null,
    }
  },
  methods: {
    teste() {
      const formData = new FormData();
      formData.append("file", this.selectedFile, this.selectedFile.name);
      
      axios.post(
        "http://localhost:8083/api/announcements/7/files",
        formData
      );
    },

    onFileChanged(event) {
      this.selectedFile = event.target.files[0];
    },
  },
};
</script> 
<style scoped>
.input-container {
  display: flex;
  flex-direction: column;
  margin-bottom: 20px;
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
  width: 406px;
}
button:hover,
.submit-btn:hover {
  background-color: transparent;
  color: #222;
}
</style>
          
