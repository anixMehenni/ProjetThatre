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

import beans.Organisateur;
import beans.Sponsor;
import ejbs.GestionFestivals;
import ejbs.GestionOrganisateurs;
import ejbs.GestionSponsors;

/**
 * Servlet implementation class CreateFestivalServlet
 */
@WebServlet("/festival/create")
@MultipartConfig
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
		getServletContext().getRequestDispatcher("/FestivalForm.jsp").forward(request, response);     
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
		gestionFestivals.create(formValues, photos, uploadPath);
		response.sendRedirect(request.getContextPath() + "/bo/festival");
	}

}
