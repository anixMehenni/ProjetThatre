package servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Comedien;
import beans.Personne;
import beans.Role;
import ejbs.GestionComediens;
import ejbs.GestionPersonnes;
import ejbs.GestionPieces;
import ejbs.GestionRoles;
import ejbs.GestionUtilisateurs;

/**
 * Servlet implementation class EmptyServlet
 */
@WebServlet("/theatre/create")
public class CreatePieceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@EJB
	GestionComediens gestionComediens;	

	@EJB
	GestionPersonnes gestionPersonnes;	

	@EJB
	GestionPieces gestionPieces;
	
	@EJB
	GestionRoles gestionRoles;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePieceServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Comedien> comediens = gestionComediens.findAll();
		List<Role> roles = gestionRoles.findAll();
		List<Personne> personnes = gestionPersonnes.findAll();
		request.setAttribute("comediens", comediens);
		request.setAttribute("personnes", personnes);
		request.setAttribute("roles", roles);
		request.setAttribute("pageName", "Création pièce de théâtre");
		getServletContext().getRequestDispatcher("/pages/PieceForm.jsp").forward(request, response);     
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> formValues = request.getParameterMap();
		gestionPieces.create(formValues);
		doGet(request, response);
	}

}
