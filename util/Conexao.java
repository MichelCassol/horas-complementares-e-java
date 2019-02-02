package br.edu.ifpr.projetoIntegrador.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
    
    public static Connection getConexao() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            return DriverManager.getConnection("jdbc:mysql://localhost/BD_ProjetoIntegrador","root","ifpr1");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco");
            throw new SQLDataException(e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            getConexao();
            System.out.println("Conexão realizada com sucesso");
        } catch (SQLException e) {
            System.out.println("Conexão não realizada");
        }
    }

}
