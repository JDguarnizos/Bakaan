
package Usuario;

public abstract class usuario {
    //Atributos
    protected String idUsuario;
    protected String nombre;
    protected String correo;
    protected String contraseña;
    protected String tipoUsuario;
    
    //Constructor de la SuperClase
    public usuario(String idUsuario, String nombre, String correo, String contraseña, String tipoUsuario) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.tipoUsuario = tipoUsuario;
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
    
    //Metodos abstractos(por el momento)
    
    public  void iniciarSesion(){
        // No pueden ser abstracto
    }
    public void cerrarSesion(){
        // No puede ser abstracto
    }
    public abstract void mostrarPerfil();
    
    
    
    
}
