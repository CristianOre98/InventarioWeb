package Model;

public class Usuario {
    int id;
    String nombre;
    String apellido;
    String correo;
    String usuario;
    String clave;
    int tipo;
    int estado;
    String pregunta;
    String respuesta;
    String fecharegistro;

    public Usuario() {
        this.nombre = "";
        this.apellido = "";
        this.correo = "";
        this.clave = "";
        this.usuario = "";
        this.pregunta = "";
        this.respuesta = "";
        this.estado = 1;
        this.tipo = 1;
    }

    public Usuario(int id, String nombre, String apellido, String correo, String usuario, String clave, int tipo, int estado, String pregunta, String respuesta, String fecharegistro) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.usuario = usuario;
        this.clave = clave;
        this.tipo = tipo;
        this.estado = estado;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.fecharegistro = fecharegistro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(String fecharegistro) {
        this.fecharegistro = fecharegistro;
    }
    
    
    
    
    
}
