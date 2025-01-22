<script setup lang="ts">

defineProps({
  id: {
    required: true,
    type: String,
  },
  url: {
    required: true,
    type: String,
  },
  nome: {
    required: true,
    type: String,
  },
  descricao: {
    required: true,
    type: String,
  }
})

function editCurso(event: Event) {
  event.preventDefault()
  event.stopPropagation()
  window.alert("edit")
}

function deleteCurso(event: Event) {
  event.preventDefault()
  event.stopPropagation()
  const response = window.confirm("O Curso será apagado para sempre")

  if (response) {
    window.alert("apagado")
  }
}
</script>

<template>
  <a :href="url" target="_blank">
    <div class="p-4 bg-white rounded-md h-full">
      <div class="flex justify-between items-start">
        <h2 class="text-xl text-bold me-4 truncate-lines">
          {{ nome }}
        </h2>

        <span class="min-w-fit">
          <router-link :to="`/curso/${id}`">
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
        {{ descricao }}
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
