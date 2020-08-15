package Model;


import java.util.Date;
import java.util.List;

public class Mesa {

    private String nomeMestre;
    private String emailMestre;
    private List<Jogador> Jogadores;
    private int classificacaoEtaria;
    private int limeteJogadores;
    private Campanha campanha;
    private Date data;
    private int code;



    public Mesa(String nomeMestre, String emailMestre, List<Jogador> jogadores, int classificacaoEtaria, int limeteJogadores, Campanha campanha, Date data, int code) {
        this.nomeMestre = nomeMestre;
        this.emailMestre = emailMestre;
        Jogadores = jogadores;
        this.classificacaoEtaria = classificacaoEtaria;
        this.limeteJogadores = limeteJogadores;
        this.campanha = campanha;
        this.data = data;
        this.code = code;
    }



    public String getNomeMestre() {
        return nomeMestre;
    }

    private void setNomeMestre(String nomeMestre) {
        this.nomeMestre = nomeMestre;
    }

    public String getEmailMestre() {
        return emailMestre;
    }

    private void setEmailMestre(String emailMestre) {
        this.emailMestre = emailMestre;
    }

    public List<Jogador> getJogadoresBase() {
        return Jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        Jogadores = jogadores;
    }

    public int getClassificacaoEtaria() {
        return classificacaoEtaria;
    }

    private void setClassificacaoEtaria(int classificacaoEtaria) {
        this.classificacaoEtaria = classificacaoEtaria;
    }

    public int getLimeteJogadores() {
        return limeteJogadores;
    }

    private void setLimeteJogadores(int limeteJogadores) {
        this.limeteJogadores = limeteJogadores;
    }

    public Campanha getCampanha() {
        return campanha;
    }

    public void setCampanha(Campanha campanha) {
        this.campanha = campanha;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
