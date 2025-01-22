<script setup lang="ts">
import H1Curso from "../components/H1Curso.vue";
import CursoCard from "../components/CursoCard.vue";
import PrimaryButton from "../components/PrimaryButton.vue";

const cursos = [
  {
    nome: "Curso de JavaScript",
    descricao: "Aprenda JavaScript do básico ao avançado.",
    url: "https://javascript.com",
  },
  {
    nome: "Curso de Python",
    descricao: "Domine Python com projetos práticos.",
    url: "https://python.org",
  },
  {
    nome: "Curso de Vue.js",
    descricao: "Construa aplicações web com Vue.js.",
    url: "https://vuejs.org",
  },
  {
    nome: "Curso de Java",
    descricao: "Fundamentos de Java para iniciantes. Fundamentos de Java para iniciantesFundamentos de Java para iniciantesFundamentos de Java para iniciantesFundamentos de Java para iniciantesFundamentos de Java para iniciantesFundamentos de Java para iniciantes",
    url: "https://java.com",
  },
  {
    nome: "Curso de JavaScript",
    descricao: "Aprenda JavaScript do básico ao avançado.",
    url: "https://javascript.com",
  },
  {
    nome: "Curso de Python",
    descricao: "Domine Python com projetos práticos.",
    url: "https://python.org",
  },
  {
    nome: "Curso de Vue.js",
    descricao: "Construa aplicações web com Vue.js.",
    url: "https://vuejs.org",
  },
  {
    nome: "Curso de Java",
    descricao: "Fundamentos de Java para iniciantes. Fundamentos de Java para iniciantesFundamentos de Java para iniciantesFundamentos de Java para iniciantesFundamentos de Java para iniciantesFundamentos de Java para iniciantesFundamentos de Java para iniciantes",
    url: "https://java.com",
  },
  {
    nome: "Curso de JavaScript",
    descricao: "Aprenda JavaScript do básico ao avançado.",
    url: "https://javascript.com",
  },
  {
    nome: "Curso de Python",
    descricao: "Domine Python com projetos práticos.",
    url: "https://python.org",
  },
  {
    nome: "Curso de Vue.js",
    descricao: "Construa aplicações web com Vue.js.",
    url: "https://vuejs.org",
  },
  {
    nome: "Curso de Java",
    descricao: "Fundamentos de Java para iniciantes. Fundamentos de Java para iniciantesFundamentos de Java para iniciantesFundamentos de Java para iniciantesFundamentos de Java para iniciantesFundamentos de Java para iniciantesFundamentos de Java para iniciantes",
    url: "https://java.com",
  },
];
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

      <div class="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-4 mt-6">
        <curso-card
            v-for="(curso, index) in cursos"
            :key="index"
            :descricao="curso.descricao"
            :nome="curso.nome"
            :url="curso.url"
        />
      </div>
    </section>
  </main>
</template>
