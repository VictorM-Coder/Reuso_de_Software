<script setup lang="ts">

import type {Curso} from "../types/Curso.ts";
import {cursoService} from "../services/CursoService.ts";

const props = defineProps({
  curso: {
    type: Object as ()=> Curso,
    required: true
  }
})

const emit = defineEmits([
    'deleted'
])

function deleteCurso(event: Event) {
  event.preventDefault()
  event.stopPropagation()
  const response = window.confirm("O Curso será apagado para sempre")

  if (response) {
    cursoService.deleteById(props.curso.id!)
        .then(() => {
          window.alert('Curso apagado com sucesso!')
          emit('deleted')
        }).catch(response => {
          window.alert('Falha ao apagar o curso' + response)
    })
  }
}
</script>

<template>
  <a :href="curso.url" target="_blank">
    <div class="p-4 bg-white rounded-md h-full">
      <div class="flex justify-between items-start">
        <h2 class="text-xl text-bold me-4 truncate-lines">
          {{ curso.nome }}
        </h2>

        <span class="min-w-fit">
          <router-link :to="`/curso/${curso.id}`">
            <button>
              <span class="material-symbols-outlined me-2">
                edit
              </span>
            </button>
          </router-link>

          <button @click.stop="deleteCurso">
            <span class="material-symbols-outlined">
              delete_forever
            </span>
          </button>
      </span>
      </div>
      <p class="mt-2 truncate-lines">
        {{ curso.descricao }}
      </p>
    </div>
  </a>
</template>

<style scoped>
.truncate-lines {
  display: -webkit-box;
  -webkit-box-orient: vertical;
  overflow: hidden;
  text-overflow: ellipsis;
  -webkit-line-clamp: 2; /* Número de linhas */
}

</style>
