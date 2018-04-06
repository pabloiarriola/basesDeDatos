/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hris;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author aa-ol
 */
public interface SQLcomands {
    public boolean Connect(String username, String password);
    public boolean SELECT(String select, String fromTable);
    public boolean INSERTINTO(String name, String insertar);
    public boolean DATABASELOGIN(String name, String username, String password);
    public ArrayList<Empleado> getEmpleados();
    public ArrayList<Empleado> getEmpleados(String name);
    public ArrayList<Empleado> getEmpleadosLastName(String name);
    public boolean addEmpleado(Empleado userToAdd);
    public boolean addColumnasExtras(int id, String nombre, String valor);
    public void alterColumnExtras(int idColumna, int idValor, String nombreDeColumna, String value); 
    public ArrayList<Proyecto> getProyectos(); 
    public ArrayList<Puesto> getPuesto();
    public ArrayList<Departamento> getDepartamento();
    public ArrayList<Ciudad> getCiudad();
    public int getNewID();
    public ArrayList<ColumnasExtras> getColumnasConValor(int empleado); 
    public boolean addValorExtra(int idEmpleado, int idColumna, String valor);
}
