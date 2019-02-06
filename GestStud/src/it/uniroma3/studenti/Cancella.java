package it.uniroma3.studenti;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma3.persistence.StudenteJDBC;

/**
 * Servlet implementation class Cancella
 */
@WebServlet("/cancella")
public class Cancella extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cancella() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudenteJDBC studenteJdbc = new StudenteJDBC();
		if (studenteJdbc.delete(request.getParameter("matricola"))) {
			RequestDispatcher rd = request.getRequestDispatcher("/successCanc.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/PaginaIniziale.html");
			rd.forward(request, response);
		}
	}
}
