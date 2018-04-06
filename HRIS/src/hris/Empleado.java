/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hris;
//Objeto
/**
 *
 * @author aa-ol
 */
public class Empleado {

    
    private int Empleado_ID;
    private int Ciudad_ID;
    private int Depto_ID;
    private int Puesto_ID;
    private String Nombre;
    private String Apellido;
    private int DPI;
    private String Fecha_Nacimiento;
    private String Genero;
    private String User_Twitter;
    private int Telefono;
    private String Dirreccion;
    private int Bonificacion;
    private String Fecha_Contrato;
    private String Foto;
    
    
    //Setters y Getters
    public int getEmpleado_ID() {
        return Empleado_ID;
    }

    public void setEmpleado_ID(int Empleado_ID) {
        this.Empleado_ID = Empleado_ID;
    }

    public int getCiudad_ID() {
        return Ciudad_ID;
    }

    public void setCiudad_ID(int Ciudad_ID) {
        this.Ciudad_ID = Ciudad_ID;
    }

    public int getDepto_ID() {
        return Depto_ID;
    }

    public void setDepto_ID(int Depto_ID) {
        this.Depto_ID = Depto_ID;
    }

    public int getPuesto_ID() {
        return Puesto_ID;
    }

    public void setPuesto_ID(int Puesto_ID) {
        this.Puesto_ID = Puesto_ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getDPI() {
        return DPI;
    }

    public void setDPI(int DPI) {
        this.DPI = DPI;
    }

    public String getFecha_Nacimiento() {
        return Fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(String Fecha_Nacimiento) {
        this.Fecha_Nacimiento = Fecha_Nacimiento;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getUser_Twitter() {
        return User_Twitter;
    }

    public void setUser_Twitter(String User_Twitter) {
        this.User_Twitter = User_Twitter;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public String getDirreccion() {
        return Dirreccion;
    }

    public void setDirreccion(String Dirreccion) {
        this.Dirreccion = Dirreccion;
    }

    public int getBonificacion() {
        return Bonificacion;
    }

    public void setBonificacion(int Bonificacion) {
        this.Bonificacion = Bonificacion;
    }

    public String getFecha_Contrato() {
        return Fecha_Contrato;
    }

    public void setFecha_Contrato(String Fecha_Contrato) {
        this.Fecha_Contrato = Fecha_Contrato;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String Foto) {
        this.Foto = Foto;
    }
    
    public String[] stringArray(){
        String[] lista = new String [15];
        lista[0] = "" + Empleado_ID;
        lista[1] = "" + Ciudad_ID;
        lista[2] = "" + Depto_ID;
        lista[3] = "" + Puesto_ID;
        lista[4] = Nombre;
        lista[5] = Apellido;
        lista[6] = "" + DPI;
        lista[7] = Fecha_Nacimiento;
        lista[8] = Genero;
        lista[9] = User_Twitter;
        lista[10] = "" + Telefono;
        lista[11] = Dirreccion;
        lista[12] = "" + Bonificacion;
        lista[13] = Fecha_Contrato;
        lista[14] = Foto;
        return lista;
    }
    
   @Override
    public String toString() {
        return "Empleado{" +
                "Empleado_ID=" + Empleado_ID +
                ", Ciudad_ID=" + Ciudad_ID +
                ", Depto_ID=" + Depto_ID +
                ", Puesto_ID=" + Puesto_ID +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", DPI=" + DPI +
                ", Fecha_Nacimiento='" + Fecha_Nacimiento + '\'' +
                ", Genero='" + Genero + '\'' +
                ", User_Twitter='" + User_Twitter + '\'' +
                ", Telefono=" + Telefono +
                ", Dirreccion='" + Dirreccion + '\'' +
                ", Bonificacion=" + Bonificacion +
                ", Fecha_Contrato='" + Fecha_Contrato + '\'' +
                ", Foto='" + Foto + '\'' +
                '}';
    }
}
