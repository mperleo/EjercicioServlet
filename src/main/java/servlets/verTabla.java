package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import DAO.DepartamentoDAO;

/**
 * Servlet implementation class verTabla
 */
@WebServlet("/verTabla")
public class verTabla extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LogManager.getLogger(DepartamentoDAO.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verTabla() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tabla = request.getParameter("tabla");
		if(tabla!=null)
		{
			if(tabla.equals("empleado"))
			{	
				request.getRequestDispatcher("/verEmpleados").forward(request, response);
			}
			else if(tabla.equals("departamento"))
			{
				request.getRequestDispatcher("/verDepartamentos").forward(request, response);
			}
			else {
				logger.info("parametro no valido indicado, nombre de tabla incorrecto");
			}
		}
		else {
			logger.info("parametro no valido indicado");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tabla = request.getParameter("tabla");
		if(tabla!=null)
		{
			if(tabla.equals("empleado"))
			{	
				request.getRequestDispatcher("/verEmpleados").forward(request, response);
			}
			else if(tabla.equals("departamento"))
			{
				request.getRequestDispatcher("/verDepartamentos").forward(request, response);
			}
			else {
				logger.info("parametro no valido indicado, nombre de tabla incorrecto");
			}
		}
		else {
			logger.info("parametro no valido indicado");
		}
	}

}
