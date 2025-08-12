package br.com.john.bibliotbairro.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://localhost/database";
    private static final String USER = "root";
    private static final String PASSWORD = "sua_senha_aqui";

    public static Connection getConnection() throws SQLException{
            return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
