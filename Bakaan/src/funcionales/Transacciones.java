
package funcionales;

import java.util.ArrayList;

//Transacciones se encarga de recopilar los pedidos y permitir su acceso
//Este debe estar inicializado dentro de cliente
public class Transacciones {
    private ArrayList<Pedido> listaTransacciones = new ArrayList<>();
    
    public void registrarCompra (Pedido pedido, String metodoPago){
        pedido.procesarPago(metodoPago);
        listaTransacciones.add(pedido);
        listaTransacciones.get(listaTransacciones.size() - 1).setIdPedido(listaTransacciones.size());
    }


    public ArrayList<Pedido> getListaTransacciones() {
        return listaTransacciones;
    }
    
}
