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

import beans.CategoriePlace;
import beans.Panier;
import beans.Place;
import beans.Representation;
import beans.Utilisateur;
import ejbs.GestionBillets;
import ejbs.GestionPaniers;
import ejbs.GestionPlaces;
import ejbs.GestionRepresentations;

/**
 * Servlet implementation class BookPlace
 */
@WebServlet("/reservation/add")
public class AddBillet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	GestionBillets gestionBillets;
	
	@EJB
	GestionPaniers gestionPaniers;

	@EJB
	GestionPlaces gestionPlaces;
	
	@EJB
	GestionRepresentations gestionRepresentations;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBillet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int representationId = Integer.parseInt(request.getParameter("representation"));
		List<CategoriePlace> categories = gestionPlaces.findAllCategories();
		List<Integer> reservations = gestionPlaces.findReservedByRepresentation(representationId);
		Representation representation = gestionRepresentations.findOne(representationId);
		request.setAttribute("categories", categories);
		request.setAttribute("reservations", reservations);
		request.setAttribute("pageName", "Réservation");
		request.setAttribute("representation", representation);
		getServletContext().getRequestDispatcher("/PlaceForm.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute(Utilisateur._UTILISATEUR_COURANT);
		Map<String, String[]> formValues = request.getParameterMap();
		gestionBillets.add(formValues, utilisateur);
		doGet(request, response);
	}

}
