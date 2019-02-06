package it.uniroma3.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import it.uniroma3.studenti.*;

import org.apache.log4j.Logger;

public class StudenteJDBC{
	final static Logger logger = Logger.getLogger(StudenteJDBC.class);
	private DataSource dataSource; //this prende questa

	public StudenteJDBC() {
		this.dataSource = new DataSource(); //this prende la variabile più esterna
	}

	public boolean save(Studente studente) {
		Connection connection = this.dataSource.getConnection();
		boolean done = false;
		try {
			String insert = "insert into stud(matricola, nome, cognome, indirizzo, telefono) values (?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, studente.getMatricola());
			statement.setString(2, studente.getNome());
			statement.setString(3, studente.getCognome());
			statement.setString(4, studente.getIndirizzo());
			statement.setString(5, studente.getTelefono());
			logger.debug(statement);
			statement.executeUpdate();
		} catch (SQLException e) {
			logger.error(e);
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
				done = true;
			} catch (SQLException e) {
				logger.error(e);
				throw new PersistenceException(e.getMessage());
			}
		}
		return done;
	}  

	public Studente findMatricola(String matricola) {
		Connection connection = this.dataSource.getConnection();
		Studente studente = null;
		try {
			PreparedStatement statement;
			String query = "select * from stud where matricola = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, matricola);
			logger.info(statement);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				studente = new Studente();
				studente.setMatricola(result.getString("matricola"));				
				studente.setNome(result.getString("nome"));
				studente.setCognome(result.getString("cognome"));
				studente.setIndirizzo(result.getString("indirizzo"));
				studente.setTelefono(result.getString("telefono"));
				}
		} catch (SQLException e) {
			logger.error(e);
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				logger.error(e);
				throw new PersistenceException(e.getMessage());
			}
		}	
		return studente;
	}

	public List<Studente> findNomeCognome(String Nome, String Cognome) {
		Connection connection = this.dataSource.getConnection();
		List<Studente> studenti = new LinkedList<>();
		try {
			Studente studente;
			PreparedStatement statement;
			String query = "select * from stud where nome=? and cognome=?";
			statement = connection.prepareStatement(query);
			statement.setString(1, Nome);
			statement.setString(2, Cognome);
			logger.info(statement);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				studente = new Studente();
				studente.setMatricola(result.getString("matricola"));				
				studente.setNome(result.getString("nome"));
				studente.setCognome(result.getString("cognome"));
				studente.setIndirizzo(result.getString("indirizzo"));
				studente.setTelefono(result.getString("telefono"));
				studenti.add(studente);
			}
		} catch (SQLException e) {
			logger.error(e);
			throw new PersistenceException(e.getMessage());
		}	 finally {
			try {
				connection.close();
			} catch (SQLException e) {
				logger.error(e);
				throw new PersistenceException(e.getMessage());
			}
		}
		return studenti;
	}

	public boolean delete(String matricola) {
		boolean done = false;
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM stud WHERE matricola = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, matricola);
			logger.info(statement);
			statement.executeUpdate();
		} catch (SQLException e) {
			logger.error(e);
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
				done = true;
			} catch (SQLException e) {
				logger.error(e);
				throw new PersistenceException(e.getMessage());
			}
		}
		return done;
	}
}
