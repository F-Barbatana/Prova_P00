package DAO;

import MethodFactory.ConectionFactory;
import Model.Campanha;
import Model.Jogador;
import Model.Mesa;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MesaDAO {


    public void save(Mesa p){
        String sql = "INSERT INTO Mesas (codeMesa, NomeMestre, EmailMesa, Data, IdadeMin,LimiteJogador, codeCampanha) values (?,?,?,?,?,?,?)";
        ConectionFactory factory = new ConectionFactory();
        try (PreparedStatement stmt = factory.createPreparedStatement(sql)) {
            stmt.setInt(1, p.getCode());
            stmt.setString(2, p.getNomeMestre());
            stmt.setString(3, p.getEmailMestre());
            stmt.setDate(4, (Date) p.getData());
            stmt.setInt(5, p.getClassificacaoEtaria());
            stmt.setInt(6, p.getLimeteJogadores());
            stmt.setInt(7, p.getCampanha().getCode());
            stmt.execute();
        }catch (SQLException e){e.printStackTrace();}
    }

    public void update(Mesa p){
        String sql = "INSERT INTO Mesas (codeMesa, NomeMestre, EmailMestre, Data, IdadeMin,LimiteJogador, codeCampanha) values (?,?,?,?,?,?,?)";
        ConectionFactory factory = new ConectionFactory();
        try (PreparedStatement stmt = factory.createPreparedStatement(sql)) {
            stmt.setInt(1, p.getCode());
            stmt.setString(2, p.getNomeMestre());
            stmt.setString(3, p.getEmailMestre());
            stmt.setDate(4, (Date) p.getData());
            stmt.setInt(5, p.getClassificacaoEtaria());
            stmt.setInt(6, p.getLimeteJogadores());
            stmt.setInt(7, p.getCampanha().getCode());
            stmt.executeUpdate();
        } catch (SQLException e) {e.printStackTrace();}
    }

    public void delete(long key){
        String sql = "DELETE FROM Mesas WHERE code = ?" ;
        String sql2 = "DELETE FROM Jogadores WHERE codeMesa = ?";
        String sql3 = "DELETE FROM Campanhas WHERE codeMesa = ?";
        ConectionFactory factory = new ConectionFactory();
        try (PreparedStatement stmt = factory.createPreparedStatement(sql)) {
            stmt.setLong(1, key);
            stmt.execute();
        } catch (SQLException e) {e.printStackTrace();}
        try (PreparedStatement stmt2 = factory.createPreparedStatement(sql2)) {
            stmt2.setLong(1, key);
            stmt2.execute();
        } catch (SQLException e) {e.printStackTrace();}
        try (PreparedStatement stmt3 = factory.createPreparedStatement(sql3)) {
            stmt3.setLong(1, key);
            stmt3.execute();
        } catch (SQLException e) {e.printStackTrace();}
    }

    public Mesa read(long pKey) {
        String sql = "SELECT * FROM Mesas WHERE codeMesa = ?";
        Mesa p = null;
        JogadorDAO jooj = new JogadorDAO();
        CampanhaDAO camp = new CampanhaDAO();
        ConectionFactory factory = new ConectionFactory();
        try (PreparedStatement stmt = factory.createPreparedStatement(sql)) {
            stmt.setLong(1, pKey);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
                p = new Mesa(rs.getString("NomeMestre"), rs.getString("EmailMestre"),jooj.read(rs.getInt("codeMesa")), rs.getInt("IdadeMin"),
                        rs.getInt("LimiteJogador"),camp.read(rs.getInt("codeMesa")),rs.getDate("Data"),rs.getInt("codeMesa"));
        } catch (SQLException e) {e.printStackTrace();}
        return p;
    }

    public List<Mesa> read() {
        String sql = "SELECT * FROM Mesas";
        List<Mesa> MesaBase;
        CampanhaDAO camp = new CampanhaDAO();
        JogadorDAO jooj = new JogadorDAO();
        MesaBase = new ArrayList<>();
        ConectionFactory factory = new ConectionFactory();
        try (PreparedStatement stmt = factory.createPreparedStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                if(!rs.isClosed()){
                    MesaBase.add(new Mesa(rs.getString("NomeMestre"), rs.getString("EmailMestre"),jooj.read(rs.getInt("codeMesa")), rs.getInt("IdadeMin"),
                            rs.getInt("LimiteJogador"),camp.read(rs.getInt("codeMesa")),rs.getDate("Data"),rs.getInt("codeMesa")));
                }
            }
        } catch (SQLException e) {e.printStackTrace();}
        return MesaBase;
    }

}
