package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import DTO.Empleado;

public class EmpleadoDAO {
	
	private static Logger logger = LogManager.getLogger(DepartamentoDAO.class);
	
    public static ArrayList<Empleado> seleccionarUsuarios(){
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        
        Connection con = Conexion.getConexion();
    

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM empleado");
	        
	        ResultSet resultado = ps.executeQuery();
	        
	        while(resultado.next()) {
	        	Empleado empleado = new Empleado(resultado.getInt("codigo"),
	        									 resultado.getString("nombre"),
	        									 resultado.getString("apellido1"),
	        									 resultado.getString("apellido2"),
	        									 resultado.getString("lugar_nacimiento"),
	        									 resultado.getString("fecha_nacimiento"),
	        									 resultado.getString("direccion"),
	        									 resultado.getString("telefono"),
	        									 resultado.getString("puesto"),
	        									 resultado.getInt("cod_departamento")
	        									);  

	        	empleados.add(empleado);
	        }
	        ps.close();
        } catch (SQLException e) {
        	logger.error("Fallo al recuperar datos de la base de datos" + e.getMessage());
            e.printStackTrace();
        } 
        
        Conexion.desconectar();
        return empleados;
    }
}