
package usuarios;

import java.util.ArrayList;
import java.util.List;
import interfaces.Vendible; //Implementación de vendible
import funcionales.Producto; //Uso de la clase Producto para la lista de productos

public class Campesino extends Usuario implements Vendible{
    private String ubicacion;
    public List<Producto> productos;
    public List<String> ventas; //Lista con informacion de ventas
    
 //Constructor campesino
 public Campesino(String idUsuario, String nombre, String correo, String contraseña, String tipoUsuario, String ubicacion){
     super (idUsuario, nombre, correo, contraseña, tipoUsuario = "Campesino");
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

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
  //Metodos de campesino
    
    public void publicarProducto(Producto p){
        productos.add(p);
        // aqui podria ir un mensaje cuando se publica el producto
    }
    
    public void editarProducto(Producto productoAntiguo, Producto productoNuevo){
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
    
    public void añadirVenta(Producto p, int cantidad){
        double valorTotal = 0;
        for (int i = 0; i < cantidad; i++) {
            //Si necesitamos código extra sobre costos y así podemos hacerlo acá
            valorTotal += p.getPrecio();
        }
        String infoVenta = "Venta #: "+productos.size()+
                "\nProducto: "+p.getNombre()+
                "\n Cantidad Total de venta: "+valorTotal;
        ventas.add(infoVenta);
    }
    
    public String verVentasRealizadas(){
        String ventasFormato = "";
        for (String s : ventas) {
            ventasFormato += s;
        }
        return ventasFormato;
        //Usar s
    }
    
    //Metodo Abstracto de la super clase 

    @Override
    public void mostrarPerfil() {
        String infoCampesino =
                "Nombre: "+nombre+ " - "+tipoUsuario+
                "Correo: "+correo+
                "Ubicación" + ubicacion
                ;
        //Usar infocampesino
        System.out.println(infoCampesino);
    }
    
    //De aquí en adelante tengo dudas sobre pedir argumentos o
    //Hacerlo todo en interfaces gráficas.
    
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
