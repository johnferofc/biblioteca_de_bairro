package br.com.john.bibliotbairro.service;

import br.com.john.bibliotbairro.dao.LivroDAO;
import br.com.john.bibliotbairro.dao.UsuarioDAO;
import br.com.john.bibliotbairro.model.Livro;
import br.com.john.bibliotbairro.model.Usuario;

import java.util.List;

public class BibliotecaService {
    private LivroDAO livroDAO = new LivroDAO();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public void cadastrarLivro(String titulo, String autor, int ano, int copias){
        livroDAO.adicionarLivro(new Livro(titulo, autor, ano, copias));
    }

    public void cadastrarUsuario(String nome, String contato){
        usuarioDAO.adicionarUsuaraio(new Usuario(nome, contato));
    }

    public List<Livro> listarLivros(){
        return livroDAO.listarLivros();
    }

    public List<Usuario> listarUsuarios(){
        return usuarioDAO.listarUsuarios();
    }

    public void emprestarLivro(int idLivro){
        List<Livro> livros = livroDAO.listarLivros();
        for (Livro l: livros){
            if(l.getId() == idLivro && l.getCopiasDisponiveis() > 0){
                livroDAO.atualizarCopias(idLivro, l.getCopiasDisponiveis() - 1);
                System.out.println("Livro emprestado com sucesso!");
                return;
            }
        }
        System.out.println("Livro indisponível para empréstimo.");
    }

    public void devolverLivro(int idLivro) {
        List<Livro> livros = livroDAO.listarLivros();
        boolean devolvido = false; // Flag para controlar se houve devolução

        for (Livro l : livros) {
            // Verifica se o livro corresponde e se ainda é possível devolver
            if (l.getId() == idLivro && l.getCopiasDisponiveis() < l.getTotalCopias()) {
                livroDAO.atualizarCopias(idLivro, l.getCopiasDisponiveis() + 1);
                System.out.println("Livro devolvido com sucesso");
                devolvido = true;
                break; // Sai do loop pois já encontrou o livro
            }
        }

        if (!devolvido) {
            System.out.println("Erro ao devolver livro!");
        }
    }


}
