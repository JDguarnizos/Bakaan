
package funcionales;

import java.util.ArrayList;
import java.util.List;
import usuarios.Campesino;

/**
 *
 * @author Carol
 */
public class Controlador {
    
    private List<Campesino>campesinos= new ArrayList<>();
    private List<Producto>productos = new ArrayList<>();
    private List<Transacciones> ventas = new ArrayList<>();
    
    public void agregarProductos(Producto p){
        productos.add(p);
    }
    
    public void eliminarProducto(Producto p){
       productos.remove(p);
    }
    
    public List<Producto> getProductos() { 
        return productos; }
    
    public void registrarVenta(Transacciones v) {
        ventas.add(v); }
    
    public List<Transacciones> getVentas() { 
        return ventas; }
    
    public void actualizarProductoGlobal(Producto antiguo, Producto nuevo) {
        int idx = productos.indexOf(antiguo);
        if (idx >= 0) productos.set(idx, nuevo);
    }
}
