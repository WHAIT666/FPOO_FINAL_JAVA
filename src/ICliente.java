import java.util.ArrayList;

public interface ICliente {
    public void adicionarSessao(Sessao s);

    public void mudarDuracaoContrato(DuracaoContrato d);

    public boolean removerSessao(String data, String horaInicio);
    public Contrato getContrato();
    public ArrayList<Sessao> getSessoes();
}