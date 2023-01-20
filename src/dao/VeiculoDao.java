/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Veiculo;

/**
 *
 * @author Instrutor
 */
public class VeiculoDao {
    
    public void criar(Veiculo veiculo) {
        
        String sql = "INSERT INTO veiculo(nome, valor, fabricante) VALUES (? ,?, ?)";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
            
            // Criar conexao com a base de dados
            conn = Conexao.createConnectionToMysql();
            // Criar uma confirmação para executar uma query(consulta)
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            // Adicionar os valores que serão esperados pela query 
            pstm.setString(1, veiculo.getNome());
            pstm.setDouble(2, veiculo.getValor());
            pstm.setString(3, veiculo.getFabricante());
            
            // Executar a query
            pstm.execute();
            
            System.out.println("Veiculo Cadastrado com Sucesso!!");
            
        } catch (Exception e) {
            
            System.out.println("Não foi possível cadastrar veiculo!!");
            e.printStackTrace();
            
        } finally {
            
            try {
                if (pstm != null) { pstm.close(); }
                if (conn != null) { conn.close(); }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
    }
    
    public List<Veiculo> ListarVeiculos() {
        
        String sql = "SELECT * FROM veiculo";
        
        List<Veiculo> veiculos = new ArrayList<Veiculo>();
        
        Connection conn = null;
        PreparedStatement pstm = null;
        // Classe que vai recuperar os dados do banco
        ResultSet rset = null;
        
        try {
            
            conn = Conexao.createConnectionToMysql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            rset = pstm.executeQuery();
            
            while (rset.next()) {
                
                Veiculo veiculo = new Veiculo();
                
                // Recuperar dados de cada coluna no banco de dados
                veiculo.setId(rset.getInt("idveiculo"));
                veiculo.setNome(rset.getString("nome"));
                veiculo.setValor(rset.getDouble("valor"));
                veiculo.setFabricante(rset.getString("fabricante"));
                
                veiculos.add(veiculo);
            }
            
            System.out.println("Veiculos listados com sucesso!!");
            
        } catch (Exception e) {
            
            System.out.println("Erro ao listar os veiculos!!");
            e.printStackTrace();
            
        } finally {
            
            try {
                
                if (pstm != null) { pstm.close(); }
                if (conn != null) { conn.close(); }
                if (rset != null) { rset.close(); }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
        return veiculos;
    }
    
    public List<Veiculo> ListarVeiculoPorCod(int id) {
        
        String sql = "SELECT * FROM veiculo WHERE idveiculo = ?";
        
        List<Veiculo> veiculos = new ArrayList<Veiculo>();
        
        Connection conn = null;
        PreparedStatement pstm = null;
        // Classe que vai recuperar os dados do banco
        ResultSet rset = null;
               
        try {
            
            conn = Conexao.createConnectionToMysql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            pstm.setInt(1, id);
            pstm.execute();
            
            rset = pstm.executeQuery();
            
            while (rset.next()) {
                
                Veiculo veiculo = new Veiculo();
                
                // Recuperar dados de cada coluna no banco de dados
                veiculo.setId(rset.getInt("idveiculo"));
                veiculo.setNome(rset.getString("nome"));
                veiculo.setValor(rset.getDouble("valor"));
                veiculo.setFabricante(rset.getString("fabricante"));
                
                veiculos.add(veiculo);
             
            }
            
            System.out.println("Veiculo listado com sucesso!!");
            
        } catch (Exception e) {
            
            System.out.println("Erro ao listar o veiculo!!");
            e.printStackTrace();
            
        } finally {
            
            try {
                
                if (pstm != null) { pstm.close(); }
                if (conn != null) { conn.close(); }
                if (rset != null) { rset.close(); }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
        return veiculos;
    }
    
    public void alterar(Veiculo veiculo) {
        
        String sql = "UPDATE veiculo SET nome = ?, valor = ?, fabricante = ? WHERE idveiculo = ?";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
            
            conn = Conexao.createConnectionToMysql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            // Adicionar os resgistros que serão atualizados
            pstm.setString(1, veiculo.getNome());
            pstm.setDouble(2, veiculo.getValor());
            pstm.setString(3, veiculo.getFabricante());
            
            // Recebe qual ID do veiculo deseja alterar
            pstm.setInt(4, veiculo.getId());
            
            // Executar a query
            pstm.execute();
            
            System.out.println("Veiculo atualizado com sucesso!!");
            
        } catch (Exception e) {
            
            System.out.println("Erro ao tentar atualizar o veiculo!");
            e.printStackTrace();
            
        } finally {
            
            try {
                
                if (pstm != null) { pstm.close(); }
                if (conn != null) { conn.close(); }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
    }
    
    public void excluir(int id) {
        
        String sql = "DELETE FROM veiculo WHERE idveiculo = ?";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
            
            conn = Conexao.createConnectionToMysql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            pstm.setInt(1, id);
            pstm.execute();
            
            System.out.println("Veiculo excluido com sucesso!");
            
        } catch (Exception e) {
            
            System.out.println("Erro ao tentar excluir o veiculo!");
            e.printStackTrace();
            
        } finally {
            
            try {
                
                if (pstm != null) { pstm.close(); }
                if (conn != null) { conn.close(); }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
                
        
    }
    
}
