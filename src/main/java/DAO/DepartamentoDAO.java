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

import DTO.Departamento;

public class DepartamentoDAO {
	
	private static Logger logger = LogManager.getLogger(DepartamentoDAO.class);
	
    public static ArrayList<Departamento> seleccionarUsuarios(){
        ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
        
        Connection con = Conexion.getConexion();
    

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM departamento");
	        
	        ResultSet resultado = ps.executeQuery();
	        
	        while(resultado.next()) {
	        	Departamento departamento = new Departamento(resultado.getInt("codigo"),
	        												 resultado.getString("nombre"), 
	        											     resultado.getInt("cod_responsable")
	        											    );  
	        	departamentos.add(departamento);
	        }
	        ps.close();
        } catch (SQLException e) {
        	logger.error("Fallo al recuperar datos de la base de datos" + e.getMessage());
            e.printStackTrace();
        } 
        
        Conexion.desconectar();
        return departamentos;
    }
}