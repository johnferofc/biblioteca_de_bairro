package br.com.john.bibliotbairro.dao;

import br.com.john.bibliotbairro.database.ConnectionFactory;
import br.com.john.bibliotbairro.model.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    public void adicionarLivro(Livro livro){
        String sql = "INSERT INTO livros (titulo, autor, ano, copias_disponiveis, total_copias) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1,livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getAno());
            stmt.setInt(4, livro.getCopiasDisponiveis());
            stmt.setInt(5, livro.getTotalCopias());

            stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Livro> listarLivros(){
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM livros";

        try(Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()){
                livros.add(new Livro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("ano"),
                        rs.getInt("copias_disponiveis"),
                        rs.getInt("total_copias")
                ));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return livros;
    }

    public void atualizarCopias(int idLivro, int novasCopias){
        String sql = "UPDATE livros SET copias_disponiveis = ? WHERE id = ?";
        try(Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, novasCopias);
            stmt.setInt(2, idLivro);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
