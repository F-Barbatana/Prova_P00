package DAO;

import MethodFactory.ConectionFactory;
import Model.Campanha;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CampanhaDAO {

    public void save(Campanha p,int key){
        String sql = "INSERT INTO Campanhas (codeCampanha, NomeCampanha, descricao, numDados, TipoDados, TipoRpg, codeMesa) values (?,?,?,?,?,?)";
        ConectionFactory factory = new ConectionFactory();
        try (PreparedStatement stmt = factory.createPreparedStatement(sql)) {
            stmt.setInt(1, p.getCode());
            stmt.setString(2, p.getNome());
            stmt.setString(3, p.getDescricao());
            stmt.setInt(4, p.getNumDados());
            stmt.setString(5, p.getTipoDadosString());
            stmt.setString(6, p.getTipoRPGString());
            stmt.setInt(7, key);
            stmt.execute();
        }catch (SQLException e){e.printStackTrace();}
    }

    public void update(Campanha p,int key){
        String sql = "INSERT INTO Campanhas (codeCampanha, NomeCampanha, descricao, numDados, TipoDados, TipoRpg, codeMesa) values (?,?,?,?,?,?)";
        ConectionFactory factory = new ConectionFactory();
        try (PreparedStatement stmt = factory.createPreparedStatement(sql)) {
            stmt.setInt(1, p.getCode());
            stmt.setString(2, p.getNome());
            stmt.setString(3, p.getDescricao());
            stmt.setInt(4, p.getNumDados());
            stmt.setString(5, p.getTipoDadosString());
            stmt.setString(6, p.getTipoRPGString());
            stmt.setInt(7, key);
            stmt.executeUpdate();
        } catch (SQLException e) {e.printStackTrace();}
    }

    public void delete(long key){
        String sql = "DELETE FROM Campanhas WHERE codeCampanha = ?" ;
        ConectionFactory factory = new ConectionFactory();
        try (PreparedStatement stmt = factory.createPreparedStatement(sql)) {
            stmt.setLong(1, key);
            stmt.execute();
        } catch (SQLException e) {e.printStackTrace();}
    }

    public Campanha read(long pKey) {
        String sql = "SELECT * FROM Campanhas WHERE codeMesa = ?";
        Campanha p = null;
        ConectionFactory factory = new ConectionFactory();
        try (PreparedStatement stmt = factory.createPreparedStatement(sql)) {
            stmt.setLong(1, pKey);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
                p = new Campanha(rs.getString("NomeCampanha"), rs.getString("descricao"),rs.getInt("numDados"),
                        rs.getString("TipoDados"), rs.getString("TipoRpg"),rs.getInt("codeCampanha"));
        } catch (SQLException e) {e.printStackTrace();}
        return p;
    }



}
