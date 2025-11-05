package interfaces;

public interface Autenticable {
    //Método para Iniciar sesión y cerrar sesión para las clases derivadas de usuario
    //Por ahora serán void hasta que requiera un dato de regreso
   boolean login (String correo, String Contraseña);
   void logout ();
}
