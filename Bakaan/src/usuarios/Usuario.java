
package usuarios;
import interfaces.Autenticable;

public abstract class Usuario implements Autenticable {
    //Atributos
    protected String idUsuario;
    protected String nombre;
    protected String correo;
    private String contraseña;
    protected String tipoUsuario;
    protected boolean sesionActiva;
    
    //Constructor de la SuperClase
    public Usuario(String idUsuario, String nombre, String correo, String contraseña, String tipoUsuario) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.tipoUsuario = tipoUsuario;
        this.sesionActiva = false;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    //Metodos implementados de la interfaz autenticable
    @Override
    public boolean login(String correo, String Contraseña) {
        if( this.correo.equals(correo) && this.contraseña.equals(contraseña)){
            sesionActiva = true;
            return true;
        }else{
            return false;
        }
    }
    @Override
    public void logout() {
        if(sesionActiva){
            sesionActiva = false;
        }else{  
        }
    }
    //Metodos 
    public  void iniciarSesion(String correo, String Contraseña){
        login(correo, Contraseña);
    }
    public void cerrarSesion(){
        logout();
    }
    public abstract void mostrarPerfil();
 
}
