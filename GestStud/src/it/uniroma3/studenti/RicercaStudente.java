package it.uniroma3.studenti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.List;

import it.uniroma3.persistence.StudenteJDBC;

import javax.servlet.RequestDispatcher;


/**
 * Servlet implementation class RicercaStudente
 */
@WebServlet("/seleziona")
public class RicercaStudente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RicercaStudente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String matricola = request.getParameter("matricola");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		StudenteJDBC studenteJdbc = new StudenteJDBC();
		
		
		Studente studente = new Studente();
		studente = studenteJdbc.findMatricola(matricola);
		if (studente != null) {
			request.setAttribute("studente", studente);
			RequestDispatcher rd = request.getRequestDispatcher("/RicercaEffett.jsp");
			rd.forward(request, response);
		}
		else{
			List<Studente> studenti = new LinkedList<>();
			studenti = studenteJdbc.findNomeCognome(nome,cognome);
			request.setAttribute("studenti", studenti);
			RequestDispatcher rd = request.getRequestDispatcher("/RicercaEffett2.jsp");
			rd.forward(request, response);
		} 
	}
		
}
