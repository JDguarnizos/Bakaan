
package funcionales;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Transacciones {
    private ArrayList<CarritoCompra> listaTransacciones = new ArrayList<>(); // Contador de IDs
    private int idTransaccion;
    private CarritoCompra compra;
    private String metodoPago;
    private LocalDateTime fecha;
    
    // Constructor
    
    // set and getter 
    
    public int getIdTransaccion() {
        return idTransaccion;
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
}
