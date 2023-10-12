import java.util.ArrayList;

public class Sucursal {
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Colaborador> colaboradores = new ArrayList<>();
    private String nome;

    private int id;

    public Sucursal(int id,String nome) {
        this.id = id;
        this.nome = nome;
    }

    public void adicionarCliente(Cliente c) {
        this.clientes.add(c);
    }

    public void adicionarColaborador(Colaborador c) {
        this.colaboradores.add(c);
    }

    public Cliente encontrarCliente(String nif) {
        for(int i = 0; i < this.clientes.size(); i++) {
            Cliente clienteAtual = this.clientes.get(i);

            if (clienteAtual.getNif().equals(nif)) {
                return clienteAtual;
            }
        }
        return null;
    }

    public int numeroTotalClientesAtivos() {
        int total = 0;
        for(int i = 0; i < this.clientes.size(); i++) {
            Cliente clienteAtual = this.clientes.get(i);

            if(clienteAtual.getContrato() != null) {
                total++;
            }
        }

        return total;
    }

    public int percentagemClientesAtivos() {
        int total = this.clientes.size();
        int totalAtivos = this.numeroTotalClientesAtivos();
        if(total ==0){
            return 0;
        }
        return totalAtivos * 100 / total;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Colaborador> getColaboradores() {
        return colaboradores;
    }

    @Override
    public String toString() {
        return "Sucursal{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
