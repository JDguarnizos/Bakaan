package funcionales;

import interfaces.Pagable;
import java.util.List;
import usuarios.Cliente;
import java.time.LocalDateTime;

//Pedido se encarga de el paso final antes de realizar un pago
//Usando un carrito de compras como lista de productos a comprar
public class Pedido implements Pagable{

    // atributos
    private int idPedido;
    private Cliente cliente;
    //Creería que el carrito de compra obtenido está directamente relacionado
    //Con el carrito de compra del usuario, que se vacía cuando se hace una compra
    //Entonces cuando se finaliza una compra, hace una copia del carrito
    //Que se usa como lista productos y cuya información es accesible
    private CarritoCompra carritoCompra,//Carrito con peligro de borrarse
            listaProductos;//Carrito seguro y final
    private double total;
    private Boolean pagado;
    private LocalDateTime fechaDePago;
    private String metodoPago;

    public Pedido(Cliente cliente, CarritoCompra carritoCompra) {
        this.cliente = cliente;
        this.carritoCompra = carritoCompra;
        this.pagado = false;
    }

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
        if (pagado) {
            return listaProductos.getProductos();
        } else {
            return carritoCompra.getProductos();
        }
    }

    public double getTotal() {
        return total;
    }

    public Boolean getEstado() {
        return pagado;
    }

    public Boolean getPagado() {
        return pagado;
    }

    public void setPagado(Boolean pagado) {
        this.pagado = pagado;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setEstado(Boolean pagado) {
        this.pagado = pagado;
    }
    @Override
    public void procesarPago(String metodoPago) {
        this.metodoPago = metodoPago;
        this.fechaDePago = LocalDateTime.now();
        this.pagado = true;
        this.listaProductos = carritoCompra;
        this.carritoCompra.vaciarCarrito();
    }

    // mtodo calcular total 
    public void calcularTotal() {
        double suma = 0.0;
        for (Producto p : carritoCompra.getProductos()) {
            suma += p.getPrecio();
        }
        total = suma;
    }
    //metodo mostrar pedido
    @Override
    public void generarRecibo() {
        System.out.println("Pedido #" + idPedido);
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Pagado: " + pagado);
        System.out.println("Productos:");
        for (Producto p : carritoCompra.getProductos()) {
            System.out.println(" - " + p.getNombre() + ": $" + p.getPrecio());
        }
        System.out.println("Total: $" + total);
    }
}
