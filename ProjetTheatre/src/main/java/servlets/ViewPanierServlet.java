package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Panier;
import beans.Utilisateur;
import ejbs.GestionPaniers;

/**
 * Servlet implementation class ViewPanier
 */
@WebServlet("/paniers")
public class ViewPanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	GestionPaniers gestionPaniers;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPanierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute(Utilisateur._UTILISATEUR_COURANT);
		List<Panier> paniers = gestionPaniers.findAll(utilisateur);
		request.setAttribute("paniers", paniers);
		request.setAttribute("pageName", "Mes paniers");
		getServletContext().getRequestDispatcher("/Paniers.jsp").forward(request, response); 
	}

}
