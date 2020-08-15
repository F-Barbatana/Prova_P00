package Model;

public class Jogador {

    private String nome;
    private String nomePersonagem;
    private String email;
    private int idade;
    private int codigo;

    public Jogador(String nome, String nomePersonagem, String email, int idade, int codigo) {
        this.nome = nome;
        this.nomePersonagem = nomePersonagem;
        this.email = email;
        this.idade = idade;
        this.codigo = codigo;
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
