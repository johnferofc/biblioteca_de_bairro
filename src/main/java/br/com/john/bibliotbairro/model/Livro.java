package br.com.john.bibliotbairro.model;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private int ano;
    private int copiasDisponiveis;
    private int totalCopias;

    public Livro(int id, String titulo, String autor, int ano, int copiasDisponiveis, int totalCopias) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.copiasDisponiveis = copiasDisponiveis;
        this.totalCopias = totalCopias;
    }

    public Livro(String titulo, String autor, int ano, int copias) {
        this(0, titulo, autor, ano, copias, copias);
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }

    public int getCopiasDisponiveis() {
        return copiasDisponiveis;
    }

    public int getTotalCopias() {
        return totalCopias;
    }

    public void setCopiasDisponiveis(int copiasDisponiveis) {
        this.copiasDisponiveis = copiasDisponiveis;
    }
}
