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
public class Puesto {
    private int Puesto_ID;
    private String Puesto;
    private int SalarioBase;
    private String Moneda;
    private int Area_ID;
    
    public Puesto(int Puesto_ID, String Puesto) {
        this.Puesto_ID = Puesto_ID;
        this.Puesto = Puesto;
    }
    
    //Setters and Getters

    public int getPuesto_ID() {
        return Puesto_ID;
    }

    public void setPuesto_ID(int Puesto_ID) {
        this.Puesto_ID = Puesto_ID;
    }

    public String getPuesto() {
        return Puesto;
    }

    public void setPuesto(String Puesto) {
        this.Puesto = Puesto;
    }

    public int getSalarioBase() {
        return SalarioBase;
    }

    public void setSalarioBase(int SalarioBase) {
        this.SalarioBase = SalarioBase;
    }

    public String getMoneda() {
        return Moneda;
    }

    public void setMoneda(String Moneda) {
        this.Moneda = Moneda;
    }

    public int getArea_ID() {
        return Area_ID;
    }

    public void setArea_ID(int Area_ID) {
        this.Area_ID = Area_ID;
    }
    
     @Override
    public String toString() {
        return "Puesto{" +
                "Puesto_ID=" + Puesto_ID +
                ", Puesto='" + Puesto + '\'' +
                ", SalarioBase=" + SalarioBase + 
                ", Moneda='" + Moneda + '\'' +
                ", Area_ID=" + Area_ID +
                '}';
    }
}
