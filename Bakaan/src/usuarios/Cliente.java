
package usuarios;

import funcionales.CarritoCompra;
import funcionales.Pedido;
import funcionales.Producto;
import java.util.ArrayList;
import java.util.List;
import funcionales.Transacciones;

public class Cliente extends Usuario{
    //Atributos cliente
  private String direccionEntrega;
  private List<Integer> calificaciones;
  private CarritoCompra carrito;
  private Transacciones listaTransacciones;
  
  //Constructor de cliente
  public Cliente(String idUsuario, String nombre, String correo, String contraseña, String tipoUsuario, String direccionEntrega){
     super (idUsuario, nombre, correo, contraseña, tipoUsuario);
     this.direccionEntrega = direccionEntrega;
     this.calificaciones = new ArrayList<>();
     this.carrito = new CarritoCompra();
     this.listaTransacciones = new Transacciones();
 }   
  
 //Getters y setters 

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }
    
    public List<Integer> getCalificaciones() {
        return calificaciones;
    }

    public CarritoCompra getCarrito() {
        return carrito;
    }

    public void setCarrito(CarritoCompra carrito) {
        this.carrito = carrito;
    }

    public Transacciones getListaTransacciones() {
        return listaTransacciones;
    }

    public void setListaTransacciones(Transacciones listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }
    
    
    
  //Metodos de cliente
    //Agrega el producto a la lista historial de compras
    public void confirmarTransaccion(Pedido pedidonuevo, String MetodoPago){
        listaTransacciones.registrarCompra(pedidonuevo,MetodoPago);
    }
    
    public void calificarProducto(Producto producto, int calificacion){
        if (calificacion < 1 || calificacion > 5 ) {
            System.out.println("La calificación debe estar en un rango de 1 - 5.");
            return;
        }
        producto.agregarCalificacion(calificacion);
        System.out.println("Has calificado el producto " +producto.getNombre() + " con " + calificacion + "estrellas.");
        }
        
    
    public void verCarrito(){
        System.out.println("Carrito de compras de: "+getNombre());
        carrito.mostrarCarrito();
    }
    
    // Metodo abstracto de la super clase usuario
    @Override
    public void mostrarPerfil() {
         System.out.println("\t PERFIL CLIENTE");
         System.out.println("ID usuario: " +getIdUsuario());
         System.out.println("Nombre: " +getNombre());
         System.out.println("Correo: "+getCorreo());
         System.out.println("Tipo de usuario: "+getTipoUsuario());
         System.out.println("Dirección de entrega: "+direccionEntrega);
    }
  
}
