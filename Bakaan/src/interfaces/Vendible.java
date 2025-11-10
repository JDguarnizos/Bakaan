package interfaces;
import funcionales.Producto;

public interface Vendible {
    //Métodos para los usuarios de tipo campesino
    //Por ahora serán de tipo void hasta que requiera algún dato de regreso
    void publicarProducto(Producto productoPublicar);
    void editarProducto(Producto productoAntiguo, Producto productoNuevo);
    void eliminarProducto(Producto prodcutoEliminar);
}
