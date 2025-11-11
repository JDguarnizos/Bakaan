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
        Cliente CL1 = new Cliente(
                "U001",
                "Juan Pérez",
                "juanperez@correo.com",
                "abcd",
                "Cliente",
                "Calle 123 #45-67"
        );

        // 5. Añadir Productos a carrito de compra del cliente
        CL1.getCarrito().agregarProducto(p2, 1);
        CL1.getCarrito().agregarProducto(p2, 1);

        // 6. Crear el pedido
        Pedido ped1 = new Pedido(CL1,CL1.getCarrito());//Pide el cliente
        
        //7. Pagar el pedido y registrarlo en la transaccion
        CL1.confirmarTransaccion(ped1,"Efectivo");
    }
}
