package usuarios;

import java.util.ArrayList;
import java.util.List;
import interfaces.Vendible; //Implementación de vendible
import funcionales.Producto; //Uso de la clase Producto para la lista de productos

public class Campesino extends Usuario implements Vendible {

    private String ubicacion;
    public List<Producto> productos;
    public List<String> ventas; //Lista con informacion de ventas

    //Constructor campesino
    public Campesino(String idUsuario, String nombre, String correo, String contraseña, String tipoUsuario, String ubicacion) {
        super(idUsuario, nombre, correo, contraseña, tipoUsuario = "Campesino");
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

    public void añadirVenta(Producto p, int cantidad) {
        double valorProducto = p.getPrecio()+(((p.getPrecio()*(p.getImpuesto()/100))
                +(p.getPrecio()*(p.getComision()/100)))),//Calcular valor total de producto con impuestos y comision
                valorTotal = 0;
        for (int i = 0; i < cantidad; i++) {
           valorTotal += valorProducto;
        }
        String infoVenta = "Venta #: " + ventas.size()
                + "\nProducto: " + p.getNombre()+ "($"+p.getPrecio()+") x "+ cantidad
                + "\n Comision: $"+(p.getPrecio()*(p.getComision()/100))
                + "\n IVA: $"+ (p.getPrecio()*(p.getImpuesto()/100))
                + "\n Cantidad Total: $" + valorTotal;
        /*Ejemplo de salida
        Venta #: 1
        Producto: limpiapisos ($2000) x 2
        Comisión: $50
        IVA: $50
        Cantidad Total: $4200
        */
        ventas.add(infoVenta);
    }

    public String verVentasRealizadas() {
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
        String infoCampesino
                = "Nombre: " + nombre + " - " + tipoUsuario
                + "Correo: " + correo
                + "Ubicación" + ubicacion;
        //Usar infocampesino
        System.out.println(infoCampesino);
    }

    @Override
    public void publicarProducto(Producto productoPublicar) {
        productos.add(productoPublicar);
        // aqui podria ir un mensaje cuando se publica el producto
    }

    public void editarProducto(Producto productoAntiguo, Producto productoNuevo) {
        //Si el producto esta registrado realizara el cambio
        if (productos.contains(productoAntiguo)) {
            productos.set(productos.indexOf(productoAntiguo), productoNuevo);
            //aqui podria ir un mensaje cuando se edita el producto  
        } //Si el producto no esta registrado
        else {
            //Un mensaje indicando que el producto que va a editar no se encuentra registrado
        }
    }

    @Override
    public void eliminarProducto(Producto productoEliminar) {
        //Aquí podríamos confirmar la eliminación
        if (true) {
            if (productos.contains(productoEliminar)) {
                productos.remove(productoEliminar);
                //Aqui podria ir un mensaje cuando se ha eliminado el producto
            } else {
                //Un mensaje indicando que el producto que va a eliminar no está en la lista
            }
        }else{
            //Un mensaje indicando que se canceló la eliminación.
        return;
        }
    }

}
