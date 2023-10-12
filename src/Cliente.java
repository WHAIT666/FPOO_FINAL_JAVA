import java.util.ArrayList;

public class Cliente extends Pessoa implements ICliente {

    private Contrato contrato;
    private ArrayList<Sessao> sessoes = new ArrayList<>();

    public Cliente(String nif, String morada, String nome, String dataNascimento, Contrato contrato) {
        super(nif, morada, nome, dataNascimento);
        this.contrato = contrato;

    }

    @Override
    public Contrato getContrato() {
        return contrato;
    }

    @Override
    public void adicionarSessao(Sessao s) {
        this.sessoes.add(s);
    }

    @Override
    public void mudarDuracaoContrato(DuracaoContrato d) {
        this.contrato.setDuracaoContrato(d);
    }

    @Override
    public boolean removerSessao(String data, String horaInicio) {
        return this.sessoes.removeIf(s -> s.getData().equals(data) && s.getHoraInicio().equals(horaInicio));
    }

    @Override
    public ArrayList<Sessao> getSessoes() {
        return sessoes;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nif=" + this.getNif() +
                ", morada=" + this.getMorada() +
                ", nome=" + this.getNome() +
                ", dataNascimento=" + this.getDataNascimento() +
                '}';
    }
}
