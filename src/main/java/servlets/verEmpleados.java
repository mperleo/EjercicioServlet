package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import DAO.DepartamentoDAO;
import DAO.EmpleadoDAO;
import DTO.Departamento;
import DTO.Empleado;

/**
 * Servlet implementation class verEmpleados
 */
@WebServlet("/verEmpleados")
public class verEmpleados extends HttpServlet {
	
	private static Logger logger = LogManager.getLogger(verDepartamentos.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verEmpleados() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Empleado> empleados = EmpleadoDAO.seleccionarUsuarios();
		if(empleados != null) {
			tablaEmpleados(response.getWriter(), empleados);
		}
		else {
			logger.warn("tabla departamentos sin datos");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Empleado> empleados = EmpleadoDAO.seleccionarUsuarios();
		if(empleados != null) {
			tablaEmpleados(response.getWriter(), empleados);
		}
		else {
			logger.warn("tabla departamentos sin datos");
		}
	}
	
	private PrintWriter tablaEmpleados(PrintWriter out, ArrayList<Empleado> emps) {
		out.println("<html>");
			out.println("<title>Tabla empleados</title>");
			out.println("<body>");
				out.println("<table>");
					out.println("<tr>");
						out.println("<th>Codigo</th>");
						out.println("<th>nombre</th>");
						out.println("<th>apellido1</th>");
						out.println("<th>apellido2</th>");
						out.println("<th>fecha nac</th>");
						out.println("<th>lugar nac</th>");
						out.println("<th>direccion</th>");
						out.println("<th>telefono</th>");
						out.println("<th>puesto</th>");
						out.println("<th>departamento</th>");
					out.println("</tr>");
					for (Empleado empleado : emps) {
						out.println("<tr>");
							out.println("<th>"+empleado.getCodigo()+("</th>"));
							out.println("</th>"+empleado.getNombre()+"</tr>");
							out.println("</th>"+empleado.getApellido1()+"</tr>");
							out.println("</th>"+empleado.getApellido2()+"</tr>");
							out.println("</th>"+empleado.getFechaNacimiento()+"</tr>");
							out.println("</th>"+empleado.getLugarNacimiento()+"</tr>");
							out.println("</th>"+empleado.getDireccion()+"</tr>");
							out.println("</th>"+empleado.getTelefono()+"</tr>");
							out.println("</th>"+empleado.getPuesto()+"</tr>");
							out.println("</th>"+empleado.getCodDepartamento()+"</tr>");
						out.println("</tr>");
					}
				out.println("</table>");
			out.println("</body>");
		out.println("</html>");
		
		return out;
	}

}
