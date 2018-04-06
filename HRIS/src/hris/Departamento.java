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
public class Departamento {
    private int Departamento_ID;
    private String Departamento;
    
    public Departamento(int Ciudad_ID, String Ciudad) {
        this.Departamento_ID = Departamento_ID;
        this.Departamento = Departamento;
    }
    
    //Setter and Getters

    public int getDepartamento_ID() {
        return Departamento_ID;
    }

    public void setDepartamento_ID(int Departamento_ID) {
        this.Departamento_ID = Departamento_ID;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }
    
    @Override
    public String toString() {
        return "Departamento{" +
                "Departamento_ID=" + Departamento_ID +
                ", Departamento='" + Departamento + '\'' +
                '}';
    }
}
