
package Usuario;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends usuario{
    //Atributos cliente
  private String direccionEntrega;
  public List<String>historialCompras;
  
  //Constructor de cliente
  public Cliente(String idUsuario, String nombre, String correo, String contraseña, String tipoUsuario, String direccionEntrega){
     super (idUsuario, nombre, correo, contraseña, tipoUsuario);
     this.direccionEntrega = direccionEntrega;
     this.historialCompras= new ArrayList<>();
 }   
 //Getters y setters 

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public List<String> getHistorialCompras() {
        return historialCompras;
    }

    public void setHistorialCompras(List<String> historialCompras) {
        this.historialCompras = historialCompras;
    }
  //Metodos de cliente
    
    public void realizarCompra(String producto){
        //Agrega el producto a la lista historial de compras
        historialCompras.add(producto);
    }
    public void calificarProducto(){
        //Pendiente a realizar
    }
    public void verCarrito(){
        //Pendiente a realizar
    }
    // Metodo abstracto de la super clase usuario
    @Override
    public void mostrarPerfil() {
        // pendiente por realizar
    }
  
}
