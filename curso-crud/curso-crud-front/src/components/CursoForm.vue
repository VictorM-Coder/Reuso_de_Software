<script setup lang="ts">
import H1Curso from "./H1Curso.vue";
import PrimaryButton from "./PrimaryButton.vue";
import {onMounted, type PropType, ref} from "vue";
import type {Curso} from "../types/Curso.ts";
import {cursoService} from "../services/CursoService.ts";
import router from "../router";

const props = defineProps({
  type: {
    type: String as PropType<'ADD' | 'EDIT'>,
    required: true
  },
  curso: {
    type: Object as () => Curso
  }
})

const cursoForm = ref<Curso>({
  id: '',
  nome: '',
  descricao: '',
  url: ''
})

onMounted(() => {
  if (props.curso) {
    cursoForm.value = {...props.curso};
  }
});

function submit() {
  if (props.type === "ADD") {
    addCurso()
  } else {
    putCurso()
  }
}

function addCurso() {
  cursoService.post(cursoForm.value)
      .then(() => {
        window.alert('Curso adicionado com sucesso!')
        router.push('/')
      }).catch(value => {
        window.alert('Falha ao adicionar o curso: ' + value.response.data.message)
  })
}

function putCurso() {
  const id: string = cursoForm.value.id!
  cursoService.update(id, cursoForm.value)
      .then(() => {
        window.alert('Curso atualizado com sucesso!')
        router.push('/')
      }).catch(value => {
    window.alert('Falha ao atualizar o curso: ' + value.response.data.message)
  })
}
</script>

<template>
  <form class="grid grid-cols-2 gap-4 m-auto max-w-screen-md bg-white p-8 rounded-md">
    <h1-curso class="col-span-2 mb-2">
      {{ (props.type == 'ADD' ? 'Adicionar' : 'Atualizar') + ' Curso' }}
    </h1-curso>
    <div class="w-full">
      <label
          for="nomeInput"
          class="font-bold"
      >Nome do curso
      </label>
      <input
          id="nomeInput"
          v-model="cursoForm.nome"
          type="text"
          class="block w-full mt-0.5 h-8 p-2 border-2 border-black rounded-md"
      />
    </div>

    <div class="w-full">
      <label
          for="urlInput"
          class="font-bold"
      >Link do curso
      </label>
      <input
          id="urlInput"
          v-model="cursoForm.url"
          type="url"
          class="block w-full mt-0.5 h-8 p-2 border-2 border-black rounded-md"
      />
    </div>

    <div class="w-full col-span-2">
      <label
          for="descricaoInput"
          class="font-bold"
      >Link do curso
      </label>
      <textarea
          id="descricaoInput"
          v-model="cursoForm.descricao"
          class="block w-full mt-0.5 p-2 border-2 border-black rounded-md"
      />
    </div>
    <div class="flex justify-end col-span-2">
      <router-link to="/">
        <button class="border-black border-2 rounded-md py-1 px-4 font-medium hover:bg-black hover:text-white">
          Cancelar
        </button>
      </router-link>

      <primary-button @click.prevent="submit">
        {{ props.type == 'ADD' ? 'Adicionar' : 'Atualizar' }}
      </primary-button>
    </div>
  </form>
</template>
