/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Instrutor
 */
public class Conexao {
    
    // Nome do banco de dados
    private static final String USERNAME = "root";
    // Senha do Banco de dados
    private static final String PASSWORD = "";
    // Caminho do banco de dados, porta(padrão 3306), e nome da base dados
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/crud_java";
    
    public static Connection createConnectionToMysql() throws Exception{
        
        // Carregar a classe de conexao com o msql pela JVM
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Criar conexao com banco de dados
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        
        return connection;
    
    }
    
    public static void main(String[] args) throws Exception {
        
        // Estabelecer ou Recuperar uma conexao com a base de dados
        Connection con = createConnectionToMysql();
        
        // Teste de conexao
        if (con != null ) {
            
            System.out.println("Conexao estabelecida com sucesso!!");
            con.close();
        } else {
            System.out.println("Deu ruim");
        }
        
    }
    
    
}
