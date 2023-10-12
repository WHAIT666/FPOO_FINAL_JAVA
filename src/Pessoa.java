public abstract class Pessoa  {
    private String nif;
    private String morada;
    private String nome;
    private String dataNascimento;

    public Pessoa(String nif, String morada, String nome, String dataNascimento) {
        this.nif = nif;
        this.morada = morada;
        this.nome = nome;
        this.dataNascimento = dataNascimento;

    }


    public String getNif() {
        return nif;
    }

    public String getMorada() {
        return morada;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }
}
