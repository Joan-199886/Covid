package com.example.login;

public class Usuario
{
    int id;
    String nombre,apellido,documento,direccion,telefono,password,correo;

    public String getDocumento() {
        return documento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isNull()
    {   if (nombre.equals("")&&apellido.equals("")&&documento.equals("")&&direccion.equals("")&&telefono.equals("")&&password.equals("")&&correo.equals("")
            ||nombre.equals("")||apellido.equals("")||documento.equals("")||direccion.equals("")||telefono.equals("")||password.equals("")||correo.equals(""))
    {
        return false;
    }
    else {return true;}

    }

    public Usuario(String nombre,String apellido,String documento,String direccion,String telefono,String password,String correo)
    {
        nombre = nombre;
        apellido = apellido;
        documento = documento;
        direccion = direccion;
        telefono = telefono;
        password = password;
        correo=correo;

    }

    public Usuario()
    {

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
