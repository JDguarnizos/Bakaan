
package funcionales;
import java.util.ArrayList;
import usuarios.Campesino;//Necesario para usar campesino

public class Producto {
    // Atributos
    private int idProducto;
    private String nombre;
    private String categoria;
    private double precio;
    private int cantidadDisponible;
    private int cantidadVendidas = 0;
    private String descripcion;
    private ArrayList<Integer> calificaciones = new ArrayList<>();
    
    
    //Asociacion 
    private Campesino campesinoPropietario;
    
    //Constructor 
    public Producto(int idProducto, String nombre, String categoria, double precio
            , int cantidadDisponible, String descripcion, Campesino campesinoPropietario){
        this.idProducto= idProducto;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
        this.descripcion = descripcion;
        this.campesinoPropietario = campesinoPropietario;
    }
    
    //Getters and Setters

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        //Verificación de que el precio no sea 0
        if (precio > 0 ) {
            this.precio = precio;
        } else {
            System.out.println("El precio debe ser mayor a 0");
        }
        
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        //Verificación de que la cantidad disponible sea positiva
        if (cantidadDisponible >= 0 ) {
            this.cantidadDisponible = cantidadDisponible;
        }else{ 
            System.out.println("La cantidad debe ser positiva ");
        }
    }

    public int getCantidadVendidas() {
        return cantidadVendidas;
    }

    public void setCantidadVendidas(int cantidadVendidas) {
        this.cantidadVendidas = cantidadVendidas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Campesino getCampesinoPropietario() {
        return campesinoPropietario;
    }

    public void setCampesinoPropietario(Campesino campesinoPropietario) {
        this.campesinoPropietario = campesinoPropietario;
    }
    
    //Métodos Funcionales
    
    //Método para disminuir el stock al vender un producto
    public void actualizarStock(int cantidadVendida){
        if(cantidadVendida > 0 && cantidadVendida <= cantidadDisponible){
            cantidadDisponible -= cantidadVendida;
        }else {
            System.out.println("Cantidad inválida o el inventario se encuentra sin stock");
        }
    }
    
    //Metodo para agregar una calificacion
    
    public void agregarCalificacion(int calificacion){
        if (calificacion >= 1 && calificacion <= 5) {
            calificaciones.add(calificacion);
            System.out.println("Calificación registrada con exito para el producto: " + nombre);
        } else{
            System.out.println("Error. La calificación debe de estar en un rango de 1 - 5.");
        }
    }
    
    
    //Metodo para obtener el promedio de calificaciones

    public double getPromedioCalificacion(){
        if (calificaciones.isEmpty()) return 0;
        double suma = 0;
        for (int c : calificaciones){
            suma += c;
        }
        return suma / calificaciones.size();
    }
    
    //Método información completa del producto
    public void mostrarInformacion(){
        System.out.println("\t PRODUCTO");
        System.out.println("ID: "+ idProducto);
        System.out.println("Nombre: "+ nombre);
        System.out.println("Categoria: "+categoria);
        System.out.println("Precio: $"+precio);
        System.out.println("Cantidad disponible: " + cantidadDisponible);
        System.out.println("Descripción: "+descripcion);
        System.out.println("Campesino: "+campesinoPropietario.getNombre()); 
        System.out.println("Promedio de calificación: "+getPromedioCalificacion());
    }
}
