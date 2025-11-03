package Nicolas;

import java.util.List;

public class Pedido {
    
    private int idPedido;
    private Cliente cliente;
    private List<Pedido> listaProductos;
    private double total;
    private String estado;
    
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Pedido> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Pedido> listaProductos) {
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
    
      public double calcularTotal() {
        double suma = 0.0;
        for (Pedido producto : listaProductos) {
            suma += producto.getPrecio();
        }
        return suma;
    }
      public void mostrarDetalle() {
        System.out.println("Pedido #" + idPedido);
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Estado: " + estado);
        System.out.println("Productos:");
        for (Pedido producto : listaProductos) {
            System.out.println(" - " + producto.getNombre() + ": $" + producto.getPrecio());
        }
        System.out.println("Total: $" + total);
    }
}
