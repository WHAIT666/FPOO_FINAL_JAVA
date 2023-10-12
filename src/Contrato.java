public class Contrato implements IContrato {
    private String id;

    private DuracaoContrato duracaoContrato;
    private TipoCliente tipoCliente;

    private Acesso acesso;


    public Contrato(String id, DuracaoContrato duracaoContrato, TipoCliente tipoCliente, Acesso acesso) {
        this.id = id;
        this.duracaoContrato = duracaoContrato;
        this.tipoCliente = tipoCliente;
        this.acesso = acesso;
    }

    @Override
    public void setDuracaoContrato(DuracaoContrato duracaoContrato) {
        this.duracaoContrato = duracaoContrato;
    }
    @Override
    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "id='" + id + '\'' +
                ", duracaoContrato=" + duracaoContrato +
                ", tipoCliente=" + tipoCliente +
                ", acesso=" + acesso +
                '}';
    }
}
