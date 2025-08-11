package br.com.john.bibliotbairro.dao;

import br.com.john.bibliotbairro.database.ConnectionFactory;
import br.com.john.bibliotbairro.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public void adicionarUsuaraio(Usuario usuario){
        String sql = "INSERT INTO usuarios (nome, contato) VALUES (?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getContato());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> listarUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()){
                usuarios.add(new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("contato")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}
