package Model;

public class Jogador {

    private String nome;
    private String nomePersonagem;
    private String email;
    private int idade;

    public Jogador(String nome, String nomePersonagem, String email, int idade) {
        this.nome = nome;
        this.nomePersonagem = nomePersonagem;
        this.email = email;
        this.idade = idade;
    }


    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    private void setNomePersonagem(String nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    private void setIdade(int idade) {
        this.idade = idade;
    }
}
