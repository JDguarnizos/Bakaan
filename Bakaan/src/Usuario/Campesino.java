
package Usuario;

import java.util.ArrayList;
import java.util.List;
import interfaces.Vendible;

public class Campesino extends Usuario implements Vendible{
    private String ubicacion;
    public List<String>productos;
    
 //Constructor campesino
 public Campesino(String idUsuario, String nombre, String correo, String contraseña, String tipoUsuario, String ubicacion){
     super (idUsuario, nombre, correo, contraseña, tipoUsuario);
     this.ubicacion = ubicacion;
     this.productos = new ArrayList<>();
 }   
 //Getters y Setters
    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<String> getProductos() {
        return productos;
    }

    public void setProductos(List<String> productos) {
        this.productos = productos;
    }
  //Metodos de campesino
    
    public void publicarProducto(String producto){
        productos.add(producto);
        // aqui podria ir un mensaje cuando se publica el producto
    }
    
    public void editarProducto(String productoAntiguo, String productoNuevo){
        //Si el producto esta registrado realizara el cambio
        if(productos.contains(productoAntiguo)){
           productos.set(productos.indexOf(productoAntiguo), productoNuevo);
           //aqui podria ir un mensaje cuando se edita el producto  
        }
        //Si el producto no esta registrado
        else{
            //Un mensaje indicando que el producto que va a editar no se encuentra registrado
        }
    }
    
    public void verVentasRealizadas(){
        // Pendiente por realizar
    }
    
    //Metodo Abstracto de la super clase 

    @Override
    public void mostrarPerfil() {
        // pendiente por realizar
    }
    
    @Override
    public void publicarProducto() {
        // pendiente por realizar
    }

    @Override
    public void editarProducto() {
        // pendiente por realizar
    }

    @Override
    public void eliminarProducto() {
        // pendiente por realizar
    }
}
