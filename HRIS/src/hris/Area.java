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
public class Area {
    private int Area_ID;
    private String Area;
    
    //Setters and Getters

    public int getArea_ID() {
        return Area_ID;
    }

    public void setArea_ID(int Area_ID) {
        this.Area_ID = Area_ID;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }
    
    @Override
    public String toString() {
        return "Area{" +
                "Area_ID=" + Area_ID +
                ", Area='" + Area + '\'' + 
                '}';
    }
}
