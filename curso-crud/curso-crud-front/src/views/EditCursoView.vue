<script setup lang="ts">

import CursoForm from "../components/CursoForm.vue";
import {onBeforeMount, ref} from "vue";
import {cursoService} from "../services/CursoService.ts";
import {useRoute} from "vue-router";
import type {Curso} from "../types/Curso.ts";
const route = useRoute()

const curso = ref<Curso>({} as Curso);
const loading = ref(true);

onBeforeMount(() => {
  const id = route.params.id as string;
  cursoService.getById(id)
      .then(response => {
        curso.value = response.data;
      })
      .catch(error => {
        window.alert("Falha ao buscar o curso: " + (error.response?.data?.message || error.message));
      })
      .finally(() => {
        loading.value = false;
      });
});

</script>

<template>
  <main class="bg-red-100 flex justify-center items-center h-screen">
    <p v-if="loading">Carregando...</p>
    <curso-form v-else type="EDIT" :curso="curso" />
  </main>

</template>