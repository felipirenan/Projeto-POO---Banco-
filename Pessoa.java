// ------------------------------------------------------------------------------
// |Renan Felipi Saran Pedrao - RGM 27949168                                    |
// ------------------------------------------------------------------------------

public class Pessoa {

    String nome, cpf;

    Pessoa() {
            //vazio
    }

    Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
