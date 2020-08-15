package DAO;

import MethodFactory.ConectionFactory;
import Model.Jogador;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JogadorDAO {

    public void save(Jogador p,int key){
        String sql = "INSERT INTO Jogadores (codeJogador, NomeJogador, NomePersonagem, email, Idade, codeMesa) values (?,?,?,?,?,?)";
        ConectionFactory factory = new ConectionFactory();
        try (PreparedStatement stmt = factory.createPreparedStatement(sql)) {
            stmt.setInt(1, p.getCodigo());
            stmt.setString(2, p.getNome());
            stmt.setString(3, p.getNomePersonagem());
            stmt.setString(4, p.getEmail());
            stmt.setInt(5, p.getIdade());
            stmt.setInt(6, key);
            stmt.execute();
        }catch (SQLException e){e.printStackTrace();}
    }

    public void update(Jogador p,int key){
        String sql = "INSERT INTO Jogadores (codeJogador, NomeJogador, NomePersonagem, email, Idade, codeMesa) values (?,?,?,?,?,?)";
        ConectionFactory factory = new ConectionFactory();
        try (PreparedStatement stmt = factory.createPreparedStatement(sql)) {
            stmt.setInt(1, p.getCodigo());
            stmt.setString(2, p.getNome());
            stmt.setString(3, p.getNomePersonagem());
            stmt.setString(4, p.getEmail());
            stmt.setInt(5, p.getIdade());
            stmt.setInt(6, key);
            stmt.executeUpdate();
        } catch (SQLException e) {e.printStackTrace();}
    }

    public void delete(long key){
        String sql = "DELETE FROM Jogadores WHERE code = ?" ;
        ConectionFactory factory = new ConectionFactory();
        try (PreparedStatement stmt = factory.createPreparedStatement(sql)) {
            stmt.setLong(1, key);
            stmt.execute();
        } catch (SQLException e) {e.printStackTrace();}
    }

    public Jogador read(long JKey,int Mkey) {
        String sql = "SELECT * FROM Jogadores WHERE codeJogador = ?";
        Jogador p = null;
        ConectionFactory factory = new ConectionFactory();
        try (PreparedStatement stmt = factory.createPreparedStatement(sql)) {
            stmt.setLong(1, JKey);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
                p = new Jogador(rs.getString("NomeJogador"), rs.getString("NomePersonagem"),rs.getString("email"),
                        rs.getInt("Idade"),rs.getInt("codeJogador"));
        } catch (SQLException e) {e.printStackTrace();}
        return p;
    }

    public List<Jogador> read(int key) {
        String sql = "SELECT * FROM Jogadores WHERE codeMesa = ?";
        List<Jogador> JogadorBase;
        JogadorBase = new ArrayList<>();
        ConectionFactory factory = new ConectionFactory();
        try (PreparedStatement stmt = factory.createPreparedStatement(sql)) {
            stmt.setLong(1, key);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){

                if(!rs.isClosed()){
                    JogadorBase.add(new Jogador(rs.getString("NomeJogador"), rs.getString("NomePersonagem"),rs.getString("email"),
                            rs.getInt("Idade"),rs.getInt("codeJogador")));
                }

            };

        } catch (SQLException e) {e.printStackTrace();}
        return JogadorBase;
    }


}
