package org.example;

import org.example.entities.Cliente;
import org.example.entities.Produto;
import org.example.repositories.InFileRepository;
import org.example.repositories.InMemoryRepository;

public class Main {
    public static void main(String[] args) {
        System.out.println("========== TESTANDO PRODUTOS ==========");
        testarProdutos();

        System.out.println("\n========== TESTANDO CLIENTES ==========");
        testarClientes();
    }

    private static void testarProdutos() {
        System.out.println("\n--- InMemoryRepository ---");
        InMemoryRepository<Produto> produtoRepoMem = new InMemoryRepository<>();
        Produto p1 = new Produto("Laptop", 3000.0);
        Produto p2 = new Produto("Mouse", 50.0);
        produtoRepoMem.save(p1);
        produtoRepoMem.save(p2);

        System.out.println("Produtos cadastrados:");
        produtoRepoMem.findAll().forEach(System.out::println);

        Produto p2Updated = new Produto("Mouse Gamer", 150.0);
        produtoRepoMem.update(2, p2Updated);
        System.out.println("\nProduto atualizado:");
        System.out.println(produtoRepoMem.findById(2));

        produtoRepoMem.delete(1);
        System.out.println("\nProdutos após deletar o Laptop:");
        produtoRepoMem.findAll().forEach(System.out::println);

        System.out.println("\n--- InFileRepository ---");
        InFileRepository<Produto> produtoRepoFile = new InFileRepository<>(Produto.class);
        produtoRepoFile.save(p1);
        produtoRepoFile.save(p2);

        System.out.println("Produtos salvos no arquivo:");
        produtoRepoFile.findAll().forEach(System.out::println);

        produtoRepoFile.update(1, p2Updated);
        System.out.println("\nProduto atualizado no arquivo:");
        System.out.println(produtoRepoFile.findById(1));

        produtoRepoFile.delete(0);
        System.out.println("\nProdutos após deletar o Laptop do arquivo:");
        produtoRepoFile.findAll().forEach(System.out::println);
    }

    private static void testarClientes() {
        System.out.println("\n--- InMemoryRepository ---");
        InMemoryRepository<Cliente> clienteRepoMem = new InMemoryRepository<>();
        Cliente c1 = new Cliente("João", "joao@example.com");
        Cliente c2 = new Cliente("Maria", "maria@example.com");
        clienteRepoMem.save(c1);
        clienteRepoMem.save(c2);

        System.out.println("Clientes cadastrados:");
        clienteRepoMem.findAll().forEach(System.out::println);

        Cliente c2Updated = new Cliente("Maria Clara", "maria.clara@example.com");
        clienteRepoMem.update(2, c2Updated);
        System.out.println("\nCliente atualizado:");
        System.out.println(clienteRepoMem.findById(2));

        clienteRepoMem.delete(1);
        System.out.println("\nClientes após deletar João:");
        clienteRepoMem.findAll().forEach(System.out::println);

        System.out.println("\n--- InFileRepository ---");
        InFileRepository<Cliente> clienteRepoFile = new InFileRepository<>(Cliente.class);
        clienteRepoFile.save(c1);
        clienteRepoFile.save(c2);

        System.out.println("Clientes salvos no arquivo:");
        clienteRepoFile.findAll().forEach(System.out::println);

        clienteRepoFile.update(1, c2Updated);
        System.out.println("\nCliente atualizado no arquivo:");
        System.out.println(clienteRepoFile.findById(1));

        clienteRepoFile.delete(0);
        System.out.println("\nClientes após deletar João do arquivo:");
        clienteRepoFile.findAll().forEach(System.out::println);
    }
}
