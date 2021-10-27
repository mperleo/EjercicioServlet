package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.Departamento;

public class DepartamentoDAO {
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
            e.printStackTrace();
        } 
        
        Conexion.desconectar();
        return departamentos;
    }
}