import axios from "axios";
import type {Curso} from "../types/Curso.ts";

const apiService = axios.create({
    baseURL: 'http://localhost:8080/cursos',
});

export const cursoService = {

    getAll: (pagina: number) => {
        return apiService.get('', {
            params: {
                pagina: pagina
            }
        })
    },

    getById: (id: string) => {
        return apiService.get(`/${id}`)
    },

    deleteById: (id: string) => {
        return apiService.delete(`/${id}`)
    },

    update: (id: string, curso: Curso) => {
        return apiService.put(`/${id}`, curso)
    },

    post: async (curso: Curso) => {
        return await apiService.post('', curso)
    }
}