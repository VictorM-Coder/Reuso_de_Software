package org.example.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InFileRepository<T> implements CrudRepository<T> {
    private int idCount;
    private final Class<T> type;
    private final ObjectMapper objectMapper;
    private final File saveDirectory;

    public InFileRepository(Class<T> type) {
        this.type = type;
        this.objectMapper = new ObjectMapper();
        saveDirectory = new File("target/saves/" + type.getName() + "/");
        initializeRepository();
    }

    private void initializeRepository() {
        if (!saveDirectory.exists()) {
            saveDirectory.mkdirs();
        }
        idCount = getNextId();
    }

    private int getNextId() {
        String[] files = saveDirectory.list((dir, name) -> name.endsWith(".json"));
        if (files == null || files.length == 0) {
            return 0;
        }
        return Arrays.stream(files)
                .mapToInt(name -> Integer.parseInt(name.replace(".json", "")))
                .max()
                .orElse(0) + 1;
    }

    @Override
    public void save(T entity) {
        try {
            objectMapper.writeValue(new File(saveDirectory, idCount + ".json"), entity);
            idCount++;
        } catch (IOException e) {
            System.err.println("Falha ao tentar salvar a entidade: " + e.getMessage());
        }
    }

    @Override
    public T findById(int id) {
        File fileToRead = new File(saveDirectory, id + ".json");
        if (!fileToRead.exists()) {
            System.err.println("Entidade com ID " + id + " não encontrada.");
            return null;
        }
        try {
            return objectMapper.readValue(fileToRead, type);
        } catch (IOException e) {
            System.err.println("Falha ao ler entidade: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void update(int id, T entity) {
        File fileToUpdate = new File(saveDirectory, id + ".json");
        if (!fileToUpdate.exists()) {
            System.err.println("Entidade com ID " + id + " não encontrada para atualização.");
            return;
        }
        try {
            objectMapper.writeValue(fileToUpdate, entity);
        } catch (IOException e) {
            System.err.println("Falha ao atualizar a entidade: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        File fileToDelete = new File(saveDirectory, id + ".json");
        if (!fileToDelete.exists()) {
            System.err.println("Entidade com ID " + id + " não encontrada para exclusão.");
            return;
        }
        if (!fileToDelete.delete()) {
            System.err.println("Falha ao deletar a entidade com ID " + id);
        }
    }

    @Override
    public List<T> findAll() {
        List<T> entities = new ArrayList<>();
        File[] files = saveDirectory.listFiles((dir, name) -> name.endsWith(".json"));

        if (files == null) {
            return entities;
        }

        for (File file : files) {
            try {
                T entity = objectMapper.readValue(file, type);
                entities.add(entity);
            } catch (IOException e) {
                System.err.println("Falha ao ler a entidade do arquivo " + file.getName() + ": " + e.getMessage());
            }
        }
        return entities;
    }
}
