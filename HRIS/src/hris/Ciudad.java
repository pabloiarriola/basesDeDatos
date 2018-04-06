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
public class Ciudad {
    private int Ciudad_ID;
    private String Ciudad;
    
    public Ciudad(int Ciudad_ID, String Ciudad) {
        this.Ciudad_ID = Ciudad_ID;
        this.Ciudad = Ciudad;
    }
    
    //Setters and getters

    public int getCiudad_ID() {
        return Ciudad_ID;
    }

    public void setCiudad_ID(int Ciudad_ID) {
        this.Ciudad_ID = Ciudad_ID;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }
    
    @Override
    public String toString() {
        return "Ciudad{" +
                "Ciudad_ID=" + Ciudad_ID +
                ", Ciudad='" + Ciudad + '\'' +
                '}';
    }
}
