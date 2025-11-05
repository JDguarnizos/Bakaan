package funcionales;

import java.util.List;
import usuarios.Cliente;

public class Pedido {
    // atributos
    private int idPedido;
    private Cliente cliente;
    private List<Producto> listaProductos;
    private double total;
    private String estado;
    
    // set and getters 
    public int getIdPedido() {
        return idPedido;
    }
    
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
        this.total = calcularTotal(); // recalcula total si cambia la lista
    }

    public double getTotal() {
        return total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    // mtodo calcular total 
      public double calcularTotal() {
        double suma = 0.0;
        for (Producto p : listaProductos) {
            suma += p.getPrecio();
        }
        return suma;
    }
      //metodo mostrar pedido
      public void mostrarDetalle() {
        System.out.println("Pedido #" + idPedido);
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Estado: " + estado);
        System.out.println("Productos:");
        for (Producto p : listaProductos) {
            System.out.println(" - " + p.getNombre() + ": $" + p.getPrecio());
        }
        System.out.println("Total: $" + total);
    }
      
}
