import java.util.ArrayList;

public class Ginasio implements IGinasio {

    private ArrayList<Sucursal> sucursais = new ArrayList<>();

    public Ginasio() {

    }
    @Override
    public ArrayList<Sucursal> getSucursais() {
        return sucursais;
    }

    @Override
    public void adicionarSucursal(Sucursal sucursal){
        sucursais.add(sucursal);
    }


    @Override
    public Sucursal encontrarSucursal(int id) {
        for (int i = 0; i < this.getSucursais().size(); i++) {
            Sucursal sucursalAtual = this.getSucursais().get(i);
            if (id == sucursalAtual.getId()) {
                return sucursalAtual;
            }
        }

        return null;
    }
}
