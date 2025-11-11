
package funcionales;

import java.util.ArrayList;
import usuarios.Cliente;

//Recibe los productos que posiblemente sean comprados
//También como lista de productos, se vacia una vez finalizada una compra
public class CarritoCompra {
    
    //Atributos
    private ArrayList<Producto> productos; //Lista de productos agregados
    private ArrayList<Integer> cantidades; //Cantidad por cada producto
    
    //Constructor
    public CarritoCompra(){
        this.productos = new ArrayList<>();//Lista productos
        this.cantidades = new ArrayList<>();
    }
    
    //Métodos funcionales 
    
    //Métodos para agregar un producto al carrito
    public void agregarProducto(Producto producto, int cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor a 0.");
            return;
        }

        if (cantidad > producto.getCantidadDisponible()) {
            System.out.println("No hay suficiente stock del producto.");
            return;
        }

        // Si el producto ya está en el carrito, aumentar la cantidad
        if (productos.contains(producto)) {
            int index = productos.indexOf(producto);
            cantidades.set(index, cantidades.get(index) + cantidad);
        } else {
            productos.add(producto);
            cantidades.add(cantidad);
        }

        System.out.println("Producto agregado correctamente al carrito.");
    }
    
    //Método para elimnar producto completamente del carrito
    public  void eliminarProducto(Producto producto){
        if(productos.contains(producto)){
            int index = productos.indexOf(producto);
            productos.remove(index);
            cantidades.remove(index);
            System.out.println("Producto eliminado del carrito correctamente.");
        }else{
            System.out.println("El proucto no está en el carrito. ");
        }
    }
    
    //Método para vaciar el carrito 
    public void vaciarCarrito(){
        productos.clear();
        cantidades.clear();
        System.out.println("El carrito ha sido vaciado. ");
    }
    
    //Método para calcular el total del carrito
    public double calcularTotal(){
        double total = 0;
        
        for (int i = 0; i < productos.size(); i++) {
            total += productos.get(i).getPrecio() * cantidades.get(i);
        }
        return total;
    }
    //Método para mostrar el contenido del carrito
    public void mostrarCarrito(){
        if (productos.isEmpty()){
            System.out.println("El carrito esta vácio.");
            return;
        }
        System.out.println("\t Carrito de compras");
        for (int i = 0; i < productos.size(); i++) {
            System.out.println(productos.get(i).getNombre()+ "\n Cantidad: " 
                    + cantidades.get(i) + "\nPrecio unitario" +productos.get(i).getPrecio());
        }
        System.out.println("Total: $ "+calcularTotal());
    }
    
    //Getter & Setters    
    public ArrayList<Producto> getProductos(){
        return productos;
    }
    public ArrayList<Integer> getCantidades(){
        return cantidades;
    }
}
