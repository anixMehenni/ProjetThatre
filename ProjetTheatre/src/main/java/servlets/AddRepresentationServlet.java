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

import beans.Festival;
import beans.Lieu;
import beans.Piece;
import ejbs.GestionFestivals;
import ejbs.GestionLieux;
import ejbs.GestionPieces;
import ejbs.GestionRepresentations;

/**
 * Servlet implementation class AddRepresentationServlet
 */
@WebServlet("/representation/add")
public class AddRepresentationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//	@EJB
//	GestionFestivals gestionFestivals;
	
	@EJB
	GestionLieux gestionLieux;
	
	@EJB
	GestionPieces gestionPieces;
	
	@EJB
	GestionRepresentations gestionRepresentations; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRepresentationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Piece piece = gestionPieces.findOne(Integer.parseInt(request.getParameter("piece")));
//		List<Festival> festivals = gestionFestivals.findAll();
		List<Lieu> lieux = gestionLieux.findAll();
		request.setAttribute("piece", piece);
//		request.setAttribute("festivals", festivals);
		request.setAttribute("lieux", lieux);
		request.setAttribute("pageName", "Ajout Représentation");
		getServletContext().getRequestDispatcher("/RepresentationForm.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> formValues = request.getParameterMap();
		gestionRepresentations.addMultiple(formValues);
		response.sendRedirect(request.getContextPath() + "/bo/piece");
	}

}
