<script setup lang="ts">
import H1Curso from "../components/H1Curso.vue";
import CursoCard from "../components/CursoCard.vue";
import PrimaryButton from "../components/PrimaryButton.vue";
import { onBeforeMount, ref } from "vue";
import type { Curso } from "../types/Curso.ts";
import { cursoService } from "../services/CursoService.ts";

const cursos = ref<Curso[]>([]);
const currentPage = ref(1);
const totalPages = ref(1);
const loading = ref(true);
const isEmpty = ref(false);

async function fetchCursos(page: number) {
  loading.value = true;
  isEmpty.value = false;
  cursoService.getAll(page)
      .then((response) => {
        cursos.value = response.data.conteudo;
        totalPages.value = response.data.totalPaginas;
        isEmpty.value = cursos.value.length === 0;
      })
      .catch(error => {
        window.alert("Erro ao buscar os cursos: " + (error.response?.data?.message || error.message));
      })
      .finally(() => {
        loading.value = false;
      });
}

function nextPage() {
  if (currentPage.value < totalPages.value) {
    currentPage.value++;
    fetchCursos(currentPage.value);
  }
}

function prevPage() {
  if (currentPage.value > 1) {
    currentPage.value--;
    fetchCursos(currentPage.value);
  }
}

onBeforeMount(() => {
  fetchCursos(currentPage.value);
});
</script>

<template>
  <main class="bg-red-100 min-h-screen">
    <section class="max-w-screen-xl mx-auto pt-12 px-4 xl:px-0">
      <header class="flex justify-between items-center">
        <h1-curso class="mt"> Cursos </h1-curso>
        <router-link to="/curso">
          <primary-button> Adicionar Curso </primary-button>
        </router-link>
      </header>

      <div v-if="loading" class="text-center py-10 font-bold text-lg">
        Carregando cursos...
      </div>

      <div v-else-if="isEmpty" class="text-center py-10 font-bold text-lg">
        Nenhum curso encontrado.
      </div>

      <div v-else class="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-4 mt-6">
        <curso-card
            v-for="(curso, index) in cursos"
            :key="index"
            :curso="curso"
            @deleted="fetchCursos"
        />
      </div>

      <div v-if="!isEmpty" class="flex justify-center items-center mt-6 space-x-4">
        <button
            @click="prevPage"
            :disabled="currentPage === 1 || loading"
            class="border border-black rounded-md px-4 py-2 disabled:opacity-50"
        >
          Anterior
        </button>

        <span class="font-bold"> Página {{ currentPage }} de {{ totalPages }} </span>

        <button
            @click="nextPage"
            :disabled="currentPage === totalPages || loading"
            class="border border-black rounded-md px-4 py-2 disabled:opacity-50"
        >
          Próxima
        </button>
      </div>
    </section>
  </main>
</template>
