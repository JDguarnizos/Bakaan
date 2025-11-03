
package Nicolas;

import java.time.LocalDateTime;

public class Transaccion {
     private static int contadorTransacciones = 0; // Contador de IDs
    private int idTransaccion;
    private Pedido pedido;
    private String metodoPago;
    private LocalDateTime fecha;
    
    // Constructor
    
    public Transaccion(Pedido pedido, String metodoPago) {
        this.idTransaccion = ++contadorTransacciones;
        this.pedido = pedido;
        this.metodoPago = metodoPago;
        this.fecha = LocalDateTime.now(); // guarda la fecha y hora actual
    }
    // set and getter 
    
    public int getIdTransaccion() {
        return idTransaccion;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    public void procesarPago() {
        System.out.println("Procesando pago del pedido #" + pedido.getIdPedido());
        System.out.println("Método de pago: " + metodoPago);
        System.out.println("Total a pagar: $" + pedido.getTotal());
        System.out.println("Pago realizado con éxito ✅");
    }

    public void generarRecibo() {
        System.out.println("\n===== RECIBO DE TRANSACCIÓN =====");
        System.out.println("ID Transacción: " + idTransaccion);
        System.out.println("Fecha: " + fecha);
        System.out.println("Pedido: #" + pedido.getIdPedido());
        System.out.println("Cliente: " + pedido.getCliente().getNombre());
        System.out.println("Total: $" + pedido.getTotal());
        System.out.println("Método de Pago: " + metodoPago);
        System.out.println("=================================");
    }

}
