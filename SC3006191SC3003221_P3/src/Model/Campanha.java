package Model;

import Utilities.RpgTiposLista;
import Utilities.TiposDeDados;

import java.util.List;

public class Campanha {

    private String nome;
    private String descricao;
    private int numDados;
    private List<Enum<TiposDeDados>> TipoDados;
    private Enum<RpgTiposLista> tipoRPG;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumDados() {
        return numDados;
    }

    public void setNumDados(int numDados) {
        this.numDados = numDados;
    }

    public List<Enum<TiposDeDados>> getTipoDados() {
        return TipoDados;
    }

    public void setTipoDados(List<Enum<TiposDeDados>> tipoDados) {
        TipoDados = tipoDados;
    }

    public Enum<RpgTiposLista> getTipoRPG() {
        return tipoRPG;
    }

    public void setTipoRPG(Enum<RpgTiposLista> tipoRPG) {
        this.tipoRPG = tipoRPG;
    }


}
