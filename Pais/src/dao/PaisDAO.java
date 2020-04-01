package dao;

import model.Pais;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaisDAO {
	
    public int incluirPais(Pais pais) {
    	
        String queryInsert = "INSERT INTO pais(nome, populacao, area) VALUES (?, ?, ?)";
        
        try (Connection conn = ConnectionFactory.conectar();
             PreparedStatement stm = conn.prepareStatement(queryInsert);) {
            stm.setString(1, pais.getNome());
            stm.setString(2, String.valueOf(pais.getPopulacao()));
            stm.setString(3, pais.getArea());
            stm.execute();
            
            String query = "SELECT LAST_INSERT_ID()";
            try (PreparedStatement stm2 = conn.prepareStatement(query);
                 ResultSet rs = stm2.executeQuery();) {
                if (rs.next()) {
                    pais.setId(rs.getInt(1));
                }
            } catch (SQLException e) {
            	System.out.println("Erro: " + e.getMessage());
            }
        } catch (SQLException e) {
        	System.out.println("Erro: " + e.getMessage());
        }
        return pais.getId();
    }

    public void upDatePais(Pais pais) {
        String queyUpdate = "UPDATE pais SET nome=?, populacao=?, area=? WHERE id=?";
        
        try (Connection conn = ConnectionFactory.conectar();
             PreparedStatement stm = conn.prepareStatement(queyUpdate);) {
            stm.setString(1, pais.getNome());
            stm.setString(2, String.valueOf(pais.getPopulacao()));
            stm.setString(3, pais.getArea());
            stm.setInt(4, pais.getId());
            stm.execute();
        } catch (Exception e) {
        	System.out.println("Erro: " + e.getMessage());
        }
    }

    public void deletarPais(int id) {
        String queryDelete = "DELETE FROM pais WHERE id = ?";
        
        try (Connection conn = ConnectionFactory.conectar();
             PreparedStatement stm = conn.prepareStatement(queryDelete);) {
            stm.setInt(1, id);
            stm.execute();
        } catch (Exception e) {
        	System.out.println("Erro: " + e.getMessage());
        }
    }

    public Pais carregarPais(int id) {
    	
        Pais pais = new Pais();
        pais.setId(id);
        
        String querySelect = "SELECT nome, populacao, area FROM pais WHERE pais.id = ?";     
        try (Connection conn = ConnectionFactory.conectar();
             PreparedStatement stm = conn.prepareStatement(querySelect);) {
            stm.setInt(1, pais.getId());
            try (ResultSet rs = stm.executeQuery();) {
                if (rs.next()) {
                    pais.setNome(rs.getString("nome"));
                    pais.setPopulacao(Long.parseLong(rs.getString("populacao")));
                    pais.setArea(rs.getString("area"));
                } else {
                    pais.setId(-1);
                    pais.setNome(null);
                    pais.setPopulacao(null);
                    pais.setArea(null);
                }
            } catch (SQLException e) {
            	System.out.println("Erro: " + e.getMessage());
            }
        } catch (SQLException e) {
        	System.out.println("Erro: " + e.getMessage());
        }
        return pais;
    }

}