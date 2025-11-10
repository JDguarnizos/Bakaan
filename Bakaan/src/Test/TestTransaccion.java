package Test;

import funcionales.Pedido;
import funcionales.Producto;
import funcionales.Transacciones;
import funcionales.CarritoCompra;
import usuarios.Cliente;
import usuarios.Campesino;
import java.util.ArrayList;
import java.util.List;

public class TestTransaccion {
    static public ArrayList<Campesino> campesinosRegs = new ArrayList<>();
    static public ArrayList<Cliente> clienteRegs = new ArrayList<>();
    public static void main(String[] args) {
        
        
        // 1. Crear el campesino propietario
        Campesino c1 = new Campesino(
                "C001",
                "Don José",
                "donjose@correo.com",
                "1234",
                "Campesino",
                "Boyacá"
        );
        
        campesinosRegs.add(c1);
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
                c1
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
                c1
        );

        c1.publicarProducto(p1);
        c1.publicarProducto(p2);
        

        // 4. Crear un cliente real
        Cliente Cl1 = new Cliente(
                "U001",
                "Juan Pérez",
                "juanperez@correo.com",
                "abcd",
                "Cliente",
                "Calle 123 #45-67"
        );

        // 5. Crear un pedido real
        CarritoCompra pedido1 = new CarritoCompra(Cl1);
        pedido1.agregarProducto(p2, 1);
        pedido1.agregarProducto(p1, 1);

        // 6. Crear la transacción
        Transacciones transaccion = new Transacciones(pedido, "Efectivo");

        // 7. Probar métodos Pagable
        transaccion.procesarPago();
        transaccion.generarRecibo();
    }
}
