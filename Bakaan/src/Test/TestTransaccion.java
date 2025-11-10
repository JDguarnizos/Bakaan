package Test;

import funcionales.Pedido;
import funcionales.Producto;
import funcionales.Transaccion;
import usuarios.Cliente;
import usuarios.Campesino;
import java.util.ArrayList;
import java.util.List;

public class TestTransaccion {

    public static void main(String[] args) {

        // 1. Crear el campesino propietario
        Campesino campesino = new Campesino(
                "C001",
                "Don José",
                "donjose@correo.com",
                "1234",
                "Campesino",
                "Boyacá"
        );

        // 2. Crear productos usando constructor
        Producto p1 = new Producto(
                1,
                "Tomate Chonto",
                "Verdura",
                4500,
                0,
                10.0,
                20,
                "Tomates frescos cosechados hoy",
                campesino
        );

        Producto p2 = new Producto(
                2,
                "Papa Criolla",
                "Tubérculo",
                8000,
                0,
                10.0,
                15,
                "Papa criolla de excelente calidad",
                campesino
        );

        // 3. Agregar los productos a una lista
        List<Producto> productos = new ArrayList<>();
        productos.add(p1);
        productos.add(p2);

        // 4. Crear un cliente real
        Cliente cliente = new Cliente(
                "U001",
                "Juan Pérez",
                "juanperez@correo.com",
                "abcd",
                "Cliente",
                "Calle 123 #45-67"
        );

        // 5. Crear un pedido real
        Pedido pedido = new Pedido();
        pedido.setIdPedido(101);
        pedido.setCliente(cliente);
        pedido.setListaProductos(productos);
        pedido.setEstado("PENDIENTE");

        // 6. Crear la transacción
        Transaccion transaccion = new Transaccion(pedido, "Efectivo");

        // 7. Probar métodos Pagable
        transaccion.procesarPago();
        transaccion.generarRecibo();
    }
}
