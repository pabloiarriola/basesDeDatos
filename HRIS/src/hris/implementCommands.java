/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hris;

import java.sql.*;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author aa-ol
 */
public class implementCommands implements SQLcomands{
    Connection c = null; 
    Statement statement = null;
    String sql = null;
    String output = null; 
    static String DB_URL = "jdbc:postgresql://localhost:5432/HRIS";
    
    @Override
    public boolean Connect(String username, String password){
        try {
            if (password == null)
                password = "";
            Class.forName("org.postgresql.Driver"); 
            c = DriverManager
                    .getConnection(DB_URL, username, password);
        } catch (Exception e){
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            return false;
        }
        System.out.println("connection successful");
        return false;
        
    }
    
    @Override
    public boolean SELECT(String select, String fromTable){
        try{
            
            statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT " + select + " FROM "+ fromTable);
            while (rs.next()) {
		output = rs.getString(select);
		System.out.println(output);
            }
            statement.close();
            c.close(); 

        } catch (SQLException e) {
		e.printStackTrace();
		return false;
        }
        return true;
    }
    
    @Override
    public boolean INSERTINTO(String name, String insertar){
        try {
            statement = c.createStatement();
            sql = "DROP TABLE "+name;
            statement.executeUpdate(sql);
            statement.close();
            c.close(); 
	} catch (SQLException e) {
            return false;
	}
	return true;
    }
    
    @Override
    public boolean DATABASELOGIN(String name, String username, String password){
        try{
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/"+name,
							username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
	}
	System.out.println("success to: "+name);

	return true;
    }
    
    @Override
    public ArrayList<Empleado> getEmpleados(){
        try {
            Empleado newEmpleado;
            ArrayList<Empleado> toReturn = new ArrayList<>();
            statement = c.createStatement();
            sql = "Select * FROM Empleado ORDER BY Empleado_ID ASC;";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                newEmpleado = new Empleado();
                newEmpleado.setEmpleado_ID(Integer.parseInt(rs.getString(1)));
                newEmpleado.setNombre(rs.getString(2));
                newEmpleado.setApellido(rs.getString(3));
                newEmpleado.setBonificacion(Integer.parseInt(rs.getString(4)));
                toReturn.add(newEmpleado);
            }
            
        statement.close();    
        return toReturn;
        } catch (SQLException e) {
            System.out.println("Error Consiguiendo datos");
            System.out.println(e);
            return null;
	}
    }
    
    
   
    public ArrayList<Empleado> getEmpleado(String name){
        try{
            Empleado newEmpleado;
            ArrayList<Empleado> toReturn = new ArrayList<>();
            statement = c.createStatement();
            sql = "Select * FROM Empleado WHERE LOWER(Nombre) LIKE \'%" + name.replaceAll("[^a-zA-Z]", "") + "%\';";
            
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                newEmpleado = new Empleado();
                newEmpleado.setEmpleado_ID(Integer.parseInt(rs.getString(1)));
                newEmpleado.setNombre(rs.getString(2));
                newEmpleado.setApellido(rs.getString(3));
                newEmpleado.setBonificacion(Integer.parseInt(rs.getString(4)));
                toReturn.add(newEmpleado);
            }
            statement.close();
            return toReturn;
        } catch (SQLException e) {
            System.out.println("Error Consiguiendo datos");

            //e.printStackTrace();
            System.out.println(e);
            return null;
        }
    }
    
    public ArrayList<Empleado> getEmpleadoLastName(String name){
        try{
            Empleado newEmpleado;
            ArrayList<Empleado> toReturn = new ArrayList<>();
            statement = c.createStatement();
            sql = "Select * FROM Empleado WHERE LOWER(Apellido) LIKE \'%" + name.replaceAll("[^a-zA-Z]", "") + "%\';";
            
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                newEmpleado = new Empleado();
                newEmpleado.setEmpleado_ID(Integer.parseInt(rs.getString(1)));
                newEmpleado.setNombre(rs.getString(2));
                newEmpleado.setApellido(rs.getString(3));
                newEmpleado.setBonificacion(Integer.parseInt(rs.getString(4)));
                toReturn.add(newEmpleado);
            }
            statement.close();
            return toReturn;
        } catch (SQLException e) {
            System.out.println("Error Consiguiendo datos");

            //e.printStackTrace();
            System.out.println(e);
            return null;
        }
    }
    
    @Override
    public boolean addEmpleado(Empleado empleadoToAdd){
        String[] toAdd = empleadoToAdd.stringArray();
        boolean isCreating = false;
        try{
            statement = c.createStatement();
            sql = "SELECT Empleado_ID FROM Empleado WHERE id =" + empleadoToAdd.getEmpleado_ID();
            ResultSet rs = statement.executeQuery(sql);
            rs.next();
            if (rs.getString(1) == null)
                isCreating = true;
            else
                isCreating = false;
            statement.close();
        } catch (SQLException e) {
            isCreating = true;
        }
        if (isCreating){
            try{
                statement = c.createStatement();
                sql = "insert INTO Empleado (Empleado_ID, Ciudad_ID, Deepto_ID, Puesto_ID, Nombre, Apellido"
                        + "DPI, Fecha_Nacimiento, Genero, User_Nacimiento, Genero, User_twitter, Telefono,"
                        + " Dirreccion, Bonificacion, Fecha_Contrato, Foto) Values (";
               
                        for (String s : toAdd) {
                    if (s == null) {
                        s = "null";
                        sql += s + ",";
                    } else
                        sql += "\'" + s + "\',";
                }
                sql = sql.substring(0, sql.length() - 1);
                sql += ");";
                statement.executeUpdate(sql);
                statement.close();
            }catch (SQLException e) {
                System.out.println("ERROR: addEmpleado");
                e.printStackTrace();
                return false;
            }
        } else {
            try {
                statement = c.createStatement();
                sql = "UPDATE Empleado" +
                        "SET (Empleado_ID, Ciudad_ID, Deepto_ID, Puesto_ID, Nombre, Apellido"
                        + "DPI, Fecha_Nacimiento, Genero, User_Nacimiento, Genero, User_twitter, Telefono,"
                        + " Dirreccion, Bonificacion, Fecha_Contrato, Foto)\n = (";
                for (String s : toAdd) {
                    if (s == null) {
                        s = "null";
                        sql += s + ",";
                    } else
                        sql += "\'" + s + "\',";
                }
                sql = sql.substring(0, sql.length() - 1);
                sql += ") WHERE id = " + toAdd[0];
                statement.executeUpdate(sql);
                statement.close();
                return true;
            } catch (SQLException e) {
                System.out.println("ERROR: addEmpleado");
                e.printStackTrace();
                return false;
            }
        
        }  
        return true;
    }
    
    @Override
    public boolean addColumnasExtras(int id, String nombre, String valor){
        try{
        int idDeCol = 1;
        statement = c.createStatement();
        sql = "SELECT Columna_ID FROM Columna ORDER BY Columna_ID DESC LIMIT 1;";
        ResultSet rs = statement.executeQuery(sql);
        if (rs != null) {
                rs.next();
                idDeCol = rs.getInt(1) + 1;
            } else {
                idDeCol = 1;
            }
            statement.close();
            
            statement = c.createStatement();
            sql = "INSERT INTO Columna VALUES(" + idDeCol + ", " + nombre + ")";
            statement.executeQuery(sql);
            statement.close();
            
            
            //Revisar este SQL
            statement = c.createStatement();
            sql = "INSERT INTO Columna VALUES (" + idDeCol + ", '" + nombre +  "')";
            statement.executeUpdate(sql);
            statement.close();
                    
            // GET NEW ID VALUE
            int idDeVal = 1;
            statement = c.createStatement();
            sql = "SELECT Cant_ID FROM \"Cant\" ORDER BY id DESC LIMIT 1;";
            rs = statement.executeQuery(sql);
            if (rs != null) {
                rs.next();
                idDeVal = Integer.parseInt(rs.getString(1)) + 1;
            } else {
                idDeVal = 1;
            }
            statement.close();

            // INSERT IN VALUES
            statement = c.createStatement();
            sql = "INSERT INTO \"Valor\" VALUES (\'" + valor + "\', " + idDeCol + ", " + id + ", " + idDeVal + ")";
            statement.executeUpdate(sql);
            statement.close();
            return true;
            
        } catch (SQLException e) {
            System.out.println("ERROR: addColumnasExtras");
            e.printStackTrace();
            return false;
        }
    }
    

    
    public void alterColumnExtras(int idColumna, int idValor, String nombreDeColumna, String value){
        // Se necesita 2 SQL UPDATES
        try {
            // Alterar columna
            statement = c.createStatement();
            sql = "UPDATE public.\"Columna\"\n" +
                    "   SET Nombre=\'" + nombreDeColumna + "\'\n" +
                    " WHERE Columna_ID = " + idColumna +";";
            
                System.out.println("SUCCESS");
            // Alterar Valor
            statement = c.createStatement();
            sql = "UPDATE public.\"Cant\"\n" +
                    "   SET Valor=\'"+value+"\'\n" +
                    " WHERE Cant_ID = "+idValor+";";
            
                System.out.println("SUCCESS");

        } catch (SQLException e){
            System.err.println("ERROR: (alterando Columna)\n"+e);
        }

    }
    @Override
    public ArrayList<Proyecto> getProyectos() {
        try {
            ArrayList<Proyecto> proyectosToReturn = new ArrayList<>();
            Proyecto newProyecto;
            statement = c.createStatement();
            sql = "SELECT * FROM public.\"Proyecto\";";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                newProyecto = new Proyecto(Integer.parseInt(rs.getString(1)), rs.getString(2), Integer.parseInt(rs.getString(3)));
                proyectosToReturn.add(newProyecto);
            }
            return proyectosToReturn;
        } catch (SQLException e) {
            System.out.println("ERROR: Recibiendo Proyectos");
            System.out.println(e);
        }
        return null;
    }
    
    @Override
    public ArrayList<ColumnasExtras> getColumnasConValor(int empleado) {
        try {
            ArrayList<ColumnasExtras> columnasExtras = new ArrayList<>();
            ColumnasExtras columnasExtra;
            statement = c.createStatement();
            sql = "SELECT c.Columna_ID, c.Nombre, ca.Cant_ID, ca.Valor FROM \"Cant\" ca INNER JOIN \"Columna\" c ON (v.Columna_ID = c.Columna_ID)\n" +
                    "WHERE v.Empleado_ID = " + empleado;
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                columnasExtra = new ColumnasExtras(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3), Integer.parseInt(rs.getString(4)));
                columnasExtras.add(columnasExtra);
            }
            return columnasExtras;
        } catch (SQLException e) {
            System.out.println("ERROR: Recibiendo Columnas Extras Con Relacion a Usuario");
            System.out.println(e);
        }
        return null;
    }
    
    @Override
    public ArrayList<Puesto> getPuesto() {
        try {
            ArrayList<Puesto> puestosToReturn = new ArrayList<>();
            Puesto newPuesto;
            statement = c.createStatement();
            sql = "SELECT PuestoID, Puesto FROM public.\"Puesto\";";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                newPuesto = new Puesto(Integer.parseInt(rs.getString(1)), rs.getString(2));
                puestosToReturn.add(newPuesto);
            }
            return puestosToReturn;
        } catch (SQLException e) {
            System.out.println("ERROR: Recibiendo Puestos");
        }
        return null;
    }
    
     @Override
    public ArrayList<Ciudad> getCiudad() {
        try {
            ArrayList<Ciudad> ciudadToReturn = new ArrayList<>();
            Ciudad newCiudad;
            statement = c.createStatement();
            sql = "SELECT Ciudad_ID, Ciudad FROM public.\"Ciudad\";";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                newCiudad = new Ciudad(Integer.parseInt(rs.getString(1)), rs.getString(2));
                ciudadToReturn.add(newCiudad);
            }
            return ciudadToReturn;
        } catch (SQLException e) {
            System.out.println("ERROR: Recibiendo Puestos");
        }
        return null;
    }
    
     @Override
    public ArrayList<Departamento> getDepartamento() {
        try {
            ArrayList<Departamento> DepartamentoToReturn = new ArrayList<>();
            Departamento newDepartamento;
            statement = c.createStatement();
            sql = "SELECT Departamento_ID, Departamento FROM public.\"Departamento\";";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                newDepartamento = new Departamento(Integer.parseInt(rs.getString(1)), rs.getString(2));
                DepartamentoToReturn.add(newDepartamento);
            }
            return DepartamentoToReturn;
        } catch (SQLException e) {
            System.out.println("ERROR: Recibiendo Puestos");
        }
        return null;
    }
    
    
    @Override
    public boolean addValorExtra(int idEmpleado, int idColumna, String valor) {
        try {
            // GET NEW ID VALUE
            int idDeVal = 1;
            statement = c.createStatement();
            sql = "SELECT Cant_ID FROM \"Cant\" ORDER BY id DESC LIMIT 1;";
            ResultSet rs = statement.executeQuery(sql);
            if (!rs.next()) {
                idDeVal = 1;
            } else {
                //rs.next();
                idDeVal = Integer.parseInt(rs.getString(1)) + 1;
            }
            statement.close();

            // INSERT IN VALUES
            statement = c.createStatement();
            sql = "INSERT INTO \"Cant\" VALUES (" + idColumna + ", " + idEmpleado + ", " + idDeVal + ",\'" + valor + "\')";
            statement.executeUpdate(sql);
            statement.close();
            return true;

        } catch (SQLException e) {
            System.err.println("ERROR: addValor Extra");
            e.printStackTrace();
            return false;
        }
    }
    
    
    
    
    @Override
    public int getNewID() {
        try {
            int toReturn = -1;
            statement = c.createStatement();
            sql = "SELECT Empleado_ID FROM \"Empleado\" ORDER BY id DESC LIMIT 1";
            ResultSet rs = statement.executeQuery(sql);
            rs.next();
            toReturn = Integer.parseInt(rs.getString(1));
            toReturn += 1;
            statement.close();
            return toReturn;
        } catch (SQLException e) {
            System.out.println("ERROR: getNewID");
            System.out.println(e);
            return -1;
        }
    }
    
    private boolean checkIfValorExist(int id){
        return false; // TODO
    }

    @Override
    public ArrayList<Empleado> getEmpleados(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Empleado> getEmpleadosLastName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
