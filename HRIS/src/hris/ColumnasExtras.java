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
public class ColumnasExtras {
    private int Cant_ID;
    private int Empleado_ID;
    private int Columna_ID;
    private String Valor;
    private boolean existe = false;
    private String Nombre;
    
    
    public ColumnasExtras(int Columna_ID , String Nombre, String Valor, int Cant_ID) {
        this.Cant_ID = Cant_ID;
        this.Empleado_ID = Empleado_ID;
        this.Columna_ID = Columna_ID;
        this.Valor = Valor;
        this.existe = false;
        this.Nombre = Nombre;
    }

    public ColumnasExtras(int Columna_ID , String Nombre, String Valor, int Cant_ID, boolean existe) {
        this.Cant_ID = Cant_ID;
        this.Empleado_ID = Empleado_ID;
        this.Columna_ID = Columna_ID;
        this.Valor = Valor;
        this.existe = existe;
        this.Nombre = Nombre;
    }

    
    
    
    //Setters And Getters

    public int getCant_ID() {
        return Cant_ID;
    }

    public void setCant_ID(int Cant_ID) {
        this.Cant_ID = Cant_ID;
    }

    public int getEmpleado_ID() {
        return Empleado_ID;
    }

    public void setEmpleado_ID(int Empleado_ID) {
        this.Empleado_ID = Empleado_ID;
    }

    public int getColumna_ID() {
        return Columna_ID;
    }

    public void setColumna_ID(int Columna_ID) {
        this.Columna_ID = Columna_ID;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String Valor) {
        this.Valor = Valor;
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
     @Override
    public String toString() {
        return "ColumnasExtras{" +
                "Cant_ID=" + Cant_ID +
                ", Empleado_ID='" + Empleado_ID + '\'' +
                ", Columna_ID='" + Columna_ID + '\'' +
                ", Valor=" + Valor +
                ", existe=" + existe +
                ", Nombre='" + Nombre + '\'' +
                '}';
    }

    public String[] toArray(){
        String[] toReturn = {""+getColumna_ID(),""+getNombre(),""+getValor()};
        return toReturn;
    }
}
