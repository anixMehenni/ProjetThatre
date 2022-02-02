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

import beans.Organisateur;
import beans.Sponsor;
import ejbs.GestionFestivals;
import ejbs.GestionOrganisateurs;
import ejbs.GestionSponsors;

/**
 * Servlet implementation class CreateFestivalServlet
 */
@WebServlet("/festival/create")
public class CreateFestivalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@EJB
	GestionOrganisateurs gestionOrganisateurs;	

	@EJB
	GestionSponsors gestionSponsors;	
	
	@EJB
	GestionFestivals gestionFestivals;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateFestivalServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Organisateur> organisateurs = gestionOrganisateurs.findAll();
		List<Sponsor> sponsors = gestionSponsors.findAll();
		request.setAttribute("organisateurs", organisateurs);
		request.setAttribute("sponsors", sponsors);
		request.setAttribute("pageName", "Création festival");
		getServletContext().getRequestDispatcher("/pages/FestivalForm.jsp").forward(request, response);     
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> formValues = request.getParameterMap();
		gestionFestivals.create(formValues);
		doGet(request, response);
	}

}
