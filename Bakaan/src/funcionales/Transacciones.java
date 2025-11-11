
package funcionales;

import java.util.ArrayList;

//Transacciones se encarga de recopilar los pedidos y permitir su acceso
//Este debe estar inicializado dentro de cliente
public class Transacciones {
    private ArrayList<Pedido> listaTransacciones = new ArrayList<>();
    
    public void registrarCompra (Pedido pedido){
        pedido.procesarPago();
        listaTransacciones.add(pedido);
        listaTransacciones.getLast().setIdPedido(listaTransacciones.size());
    }

    public ArrayList<Pedido> getListaTransacciones() {
        return listaTransacciones;
    }
    
}
