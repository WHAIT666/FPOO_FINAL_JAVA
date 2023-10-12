public class Sessao implements ISessao {
    private String data;
    private int duracao;
    private String horaInicio;


    public Sessao(String data, int duracao, String horaInicio) {
        this.data = data;
        this.duracao = duracao;
        this.horaInicio = horaInicio;
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public String getHoraInicio() {
        return horaInicio;
    }

    @Override
    public String toString() {
        return "Sessao{" +
                "data='" + data + '\'' +
                ", duracao=" + duracao +
                ", horaInicio='" + horaInicio + '\'' +
                '}';
    }
}
