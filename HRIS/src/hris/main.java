/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hris;
import javax.swing.*;
/**
 *
 * @author aa-ol
 */
public class main {
    public static void main (String[] args){
        SQLcomands dbConnection = new implementCommands();
        MainUser asds = new MainUser();
        asds.setVisible(true);
    }
}
