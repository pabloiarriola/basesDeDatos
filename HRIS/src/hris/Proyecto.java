/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hris;

/**
 *
 * @author aa-ol
 */
public class Proyecto {
    private int Proyecto_ID;
    private String Nombre;
    private int Empleado_ID;
    
    public Proyecto() {
    }

    public Proyecto(int Proyecto_ID, String Nombre, int Empleado_ID) {
        this.Proyecto_ID = Proyecto_ID;
        this.Nombre = Nombre;
        this.Empleado_ID = Empleado_ID;
    }
    
    //Getters and Setters

    public int getProyecto_ID() {
        return Proyecto_ID;
    }

    public void setProyecto_ID(int Proyecto_ID) {
        this.Proyecto_ID = Proyecto_ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getEmpleado_ID() {
        return Empleado_ID;
    }

    public void setEmpleado_ID(int Empleado_ID) {
        this.Empleado_ID = Empleado_ID;
    }
    
    @Override
    public String toString() {
        return "Proyecto{" +
                "Proyecto_ID=" + Proyecto_ID +
                ", Nombre='" + Nombre + '\'' +
                ", Empleado_ID=" + Empleado_ID +
                '}';
    }
}
