import { createRouter, createWebHistory } from 'vue-router';
import HomeView from "../views/HomeView.vue";
import AddCursoView from "../views/AddCursoView.vue";
import EditCursoView from "../views/EditCursoView.vue";

const routes = [
    {
        path: '/curso',
        name: 'Adicionar curso',
        component: AddCursoView,
    },
    {
        path: '/curso/:id',
        name: 'Atualizar curso',
        component: EditCursoView,
    },
    {
        path: '/:catchAll(.*)',
        name: 'Home',
        component: HomeView,
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
