package it.uniroma3.studenti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import it.uniroma3.persistence.*;

/**
 * Servlet implementation class InserisciStudente
 */
@WebServlet("/inserisci")
public class InserisciStudente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserisciStudente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Studente studente = new Studente();
		studente.setMatricola(request.getParameter("matricola"));
		studente.setNome(request.getParameter("nome"));
		studente.setCognome(request.getParameter("cognome"));
		studente.setIndirizzo(request.getParameter("indirizzo"));
		studente.setTelefono(request.getParameter("telefono"));
		StudenteJDBC studenteJdbc = new StudenteJDBC();
		if (studenteJdbc.save(studente)) {
			RequestDispatcher rd = request.getRequestDispatcher("/success.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/error.html");
			rd.forward(request, response);
		}
		 
	}
} 
