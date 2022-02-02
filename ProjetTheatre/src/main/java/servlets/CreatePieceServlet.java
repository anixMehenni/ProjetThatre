package servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import beans.Comedien;
import beans.Personne;
import beans.Role;
import ejbs.GestionComediens;
import ejbs.GestionPersonnes;
import ejbs.GestionPieces;
import ejbs.GestionRoles;
import ejbs.GestionUtilisateurs;

/**
 * Servlet implementation class CreatePieceServlet
 */
@WebServlet("/piece/create")
@MultipartConfig
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
		String uploadPath = getServletContext().getRealPath("") + File.separator + "images";
		List<Part> photos = request.getParts()
	    		.stream()
	    		.filter(part -> "photos".equals(part.getName()) && part.getSize() > 0)
	    		.collect(Collectors.toList());
		Map<String, String[]> formValues = request.getParameterMap();
		gestionPieces.create(formValues, photos, uploadPath);
		doGet(request, response);
	}

}
