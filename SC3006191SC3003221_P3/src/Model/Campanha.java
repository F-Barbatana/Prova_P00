package Model;

import Utilities.RpgTiposLista;
import Utilities.TiposDeDados;

import java.util.ArrayList;
import java.util.List;

public class Campanha {

    private String nome;
    private String descricao;
    private int numDados;
    private List<Enum<TiposDeDados>> TipoDados;
    private Enum<RpgTiposLista> tipoRPG;
    private int code;


    public Campanha(String nome, String descricao, int numDados, String tipodeDados, String tipoRPG, int code) {
        this.nome = nome;
        this.descricao = descricao;
        this.numDados = numDados;
        ConverterTipoDados(tipodeDados);
        ConverterTipoRpg(tipoRPG);
        this.code = code;
    }

    private void ConverterTipoRpg(String tipoRPG) {

        switch (tipoRPG){
            case "Vampiro":
                this.tipoRPG =  RpgTiposLista.Vampiro;
                break;
            case "DeD":
                this.tipoRPG =   RpgTiposLista.DeD;
                break;
            case "Lobisomen":
                this.tipoRPG =  RpgTiposLista.Lobisomen;
                break;
            case "Cthulhu":
                this.tipoRPG =  RpgTiposLista.Cthulhu;
                break;
            case "Policial":
                this.tipoRPG =  RpgTiposLista.Policial;
                break;
            case "Cyberpunk":
                this.tipoRPG = RpgTiposLista.Cyberpunk;
                break;
            case "Steampunk":
                this.tipoRPG = RpgTiposLista.Steampunk;
                break;
            default:
                this.tipoRPG = RpgTiposLista.Outro;
                break;
        }
    }


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

    public void ConverterTipoDados(String tipoDados) {
        List<Enum<TiposDeDados>> Final =  new ArrayList<>();


        for (String s :tipoDados.split(";")){
            Enum<TiposDeDados> t = null;
            switch (s){
                case "Vinte":
                    Final.add(TiposDeDados.Vinte);
                    break;
                case "Doze":
                    Final.add(TiposDeDados.Doze);
                    break;
                case "Dez":
                    Final.add(TiposDeDados.Dez);
                    break;
                case "Oito":
                    Final.add(TiposDeDados.Oito);
                    break;
                case "Seis":
                    Final.add(TiposDeDados.Seis);
                    break;
                case "Quatro":
                    Final.add(TiposDeDados.Quatro);
                    break;
            }



        }


        TipoDados = Final;
    }

    public Enum<RpgTiposLista> getTipoRPG() {
        return tipoRPG;
    }

    public void setTipoRPG(Enum<RpgTiposLista> tipoRPG) {
        this.tipoRPG = tipoRPG;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTipoDadosString() {

        StringBuilder str = new StringBuilder();

        for (Enum<TiposDeDados> g : this.TipoDados) {
            str.append(g);
        }

        return str.toString();
    }

    public String getTipoRPGString() {
        return ""+ this.tipoRPG;
    }
}
