package br.com.john.bibliotbairro.model;

public class Usuario {
    private int id;
    private String nome;
    private String contato;

    public Usuario(int id, String nome, String contato) {
        this.id = id;
        this.nome = nome;
        this.contato = contato;
    }

    public Usuario(String nome, String contato){
        this(0, nome, contato);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getContato() {
        return contato;
    }
}
