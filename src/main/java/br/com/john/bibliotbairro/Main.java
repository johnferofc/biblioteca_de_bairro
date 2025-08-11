package br.com.john.bibliotbairro;

import br.com.john.bibliotbairro.service.BibliotecaService;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        BibliotecaService service = new BibliotecaService();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do{
            System.out.println("\n=== SISTEMA BIBLIOTECA DE BAIRRO ===");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Cadastrar Usuario");
            System.out.println("3. Listrar Livros");
            System.out.println("4. Listar Usuários");
            System.out.println("5. Emprestar Livro");
            System.out.println("6. Devolver Livro");
            System.out.println("0. Sair");
            System.out.println("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao){
                case 1 -> {
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    System.out.print("Ano: ");
                    int ano = sc.nextInt();
                    System.out.print("Copias: ");
                    int copias = sc.nextInt();
                    service.cadastrarLivro(titulo, autor, ano, copias);
                }
                case 2 -> {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Contato: ");
                    String contato = sc.nextLine();
                    service.cadastrarUsuario(nome, contato);
                }
                case 3 -> service.listarLivros().stream().forEach(l ->
                        System.out.println(l.getId() + " - " + l.getTitulo() +
                                "(" + l.getCopiasDisponiveis() + "/" + l.getTotalCopias() + ")"));
                case 4 -> service.listarUsuarios().stream()
                        .forEach(u ->
                                System.out.println(u.getId() + " - " + u.getNome() + " - " + u.getContato()));
                case 5 -> {
                    System.out.print("ID do Livro:");
                    int idLivroEmp = sc.nextInt();
                    service.emprestarLivro(idLivroEmp);
                }
                case 6 -> {
                    System.out.print("ID do Livro: ");
                    int idLivroDev = sc.nextInt();
                    service.devolverLivro(idLivroDev);
                }
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção Inválida");
            }
        } while (opcao != 0);

        sc.close();

    }
}