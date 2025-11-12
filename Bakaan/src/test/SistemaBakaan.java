package test;

import usuarios.Cliente;
import usuarios.Campesino;
import usuarios.Usuario;
import funcionales.Producto;
import grafica.CarritoCompraVista;
import grafica.CatalagoProductosVista;
import grafica.inicioRegistro;
import grafica.menuCampesino;
import java.util.ArrayList;

public class SistemaBakaan {

    private static SistemaBakaan instance;
    private Usuario usuarioActual;
    private ArrayList<Campesino> campesinosRegs = new ArrayList<>();
    private ArrayList<Cliente> clienteRegs = new ArrayList<>();
    private ArrayList<Producto> catalogoProductos = new ArrayList<>();

    private inicioRegistro ventanaInicio;
    private menuCampesino ventanaMenuCampesino;
    private CarritoCompraVista ventanaCarrito;
    private CatalagoProductosVista ventanaCatalogo;

    private SistemaBakaan() {
        inicializarDatosPrueba();
    }

    public static SistemaBakaan getInstance() {
        if (instance == null) {
            instance = new SistemaBakaan();
        }
        return instance;
    }

    private void inicializarDatosPrueba() {
        // Crear campesino de prueba
        Campesino c1 = new Campesino(
                "C001",
                "Don José",
                "donjose@correo.com",
                "1234",
                "Campesino",
                "Boyacá"
        );
        campesinosRegs.add(c1);

        // Crear productos de prueba
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

        // Agregar productos al catálogo general
        catalogoProductos.add(p1);
        catalogoProductos.add(p2);

        // Crear cliente de prueba
        Cliente cl1 = new Cliente(
                "U001",
                "Juan Pérez",
                "juanperez@correo.com",
                "abcd",
                "Cliente",
                "Calle 123 #45-67"
        );
        clienteRegs.add(cl1);
    }

    public boolean iniciarSesion(String correo, String contraseña) {
        // Buscar en campesinos
        for (Campesino campesino : campesinosRegs) {
            if (campesino.login(correo, contraseña)) {
                usuarioActual = campesino;
                return true;
            }
        }

        // Buscar en clientes
        for (Cliente cliente : clienteRegs) {
            if (cliente.login(correo, contraseña)) {
                usuarioActual = cliente;
                return true;
            }
        }

        return false;
    }

    public void mostrarInterfazSegunTipoUsuario() {
        if (usuarioActual == null) {
            return;
        }

        if (ventanaInicio != null) {
            ventanaInicio.dispose();
        }

        if (usuarioActual instanceof Campesino) {
            if (ventanaMenuCampesino == null) {
                ventanaMenuCampesino = new menuCampesino();
            }
            ventanaMenuCampesino.setVisible(true);
        } else if (usuarioActual instanceof Cliente) {
            if (ventanaCatalogo == null) {
                ventanaCarrito = new CarritoCompraVista();
                ventanaCatalogo = new CatalagoProductosVista(catalogoProductos, ventanaCarrito);
            }
            ventanaCatalogo.setVisible(true);
        }
    }

    // Getters
    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public ArrayList<Producto> getCatalogoProductos() {
        return catalogoProductos;
    }

    public ArrayList<Campesino> getCampesinos() {
        return campesinosRegs;
    }

    public ArrayList<Cliente> getClientes() {
        return clienteRegs;
    }

    public static void main(String[] args) {
        // Iniciar con la ventana de inicio de sesión
        java.awt.EventQueue.invokeLater(() -> {
            inicioRegistro ventana = new inicioRegistro();
            ventana.setVisible(true);
        });
    }
}
