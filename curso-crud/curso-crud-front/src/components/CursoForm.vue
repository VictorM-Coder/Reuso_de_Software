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
        class="block w-full mt-0.5 p-2 border-2 border-black rounded-md"
    />
  </div>
  <div class="flex justify-end col-span-2">
    <router-link to="/">
      <button class="border-black border-2 rounded-md py-1 px-4 font-medium hover:bg-black hover:text-white">
        Cancelar
      </button>
    </router-link>

    <primary-button>
      {{ props.type == 'ADD' ? 'Adicionar' : 'Atualizar' }}
    </primary-button>
  </div>
</form>
</template>


<script setup lang="ts">
import H1Curso from "./H1Curso.vue";
import PrimaryButton from "./PrimaryButton.vue";
import type {PropType} from "vue";

const props = defineProps({
  type: {
    type: String as PropType<'ADD' | 'EDIT'>,
    required: true
  }
})
</script>