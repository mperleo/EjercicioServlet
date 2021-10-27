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
import DTO.Departamento;

/**
 * Servlet implementation class verDepartamentos
 */
@WebServlet("/verDepartamentos")
public class verDepartamentos extends HttpServlet {
	
	private static Logger logger = LogManager.getLogger(verDepartamentos.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verDepartamentos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Departamento> departamentos = DepartamentoDAO.seleccionarUsuarios();
		if(departamentos != null) {
			tablaDepartamentos(response.getWriter(), departamentos);
		}
		else {
			logger.warn("tabla departamentos sin datos");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Departamento> departamentos = DepartamentoDAO.seleccionarUsuarios();
		if(departamentos != null) {
			tablaDepartamentos(response.getWriter(), departamentos);
		}
		else {
			logger.warn("tabla departamentos sin datos");
		}
	}
	
	private PrintWriter tablaDepartamentos(PrintWriter out, ArrayList<Departamento> departs) {
		out.println("<html>");
			out.println("<title>Tabla departamentos</title>");
			out.println("<body>");
				out.println("<table>");
					out.println("<tr>");
						out.println("<th>Codigo</th>");
						out.println("<th>nombre</th>");
						out.println("<th>responsable</th>");
					out.println("</tr>");
					for (Departamento departamento : departs) {
						out.println("<tr>");
							out.println("<th>"+departamento.getCodigo()+("</th>"));
							out.println("</th>"+departamento.getNombre()+"</tr>");
							out.println("</th>"+departamento.getCodResponsable()+"</tr>");
						out.println("</tr>");
					}
				out.println("</table>");
			out.println("</body>");
		out.println("</html>");
		
		return out;
	}

}
