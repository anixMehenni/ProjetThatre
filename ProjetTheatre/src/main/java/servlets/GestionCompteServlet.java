package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utilisateur;
import ejbs.GestionUtilisateurs;

/**
 * Servlet implementation class GestionCompteServlet
 */
@WebServlet("/GestionCompteServlet")
public class GestionCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	GestionUtilisateurs gestionUtilisateurs;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionCompteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/profilePage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String nom = request.getParameter("nom");
	        String prenom = request.getParameter("prenom");
	        String email = request.getParameter("email");
	        String motDePasse = request.getParameter("motDePasse");
	        String telephone = request.getParameter("telephone");
	        String adresse = request.getParameter("adresse");
	        
			Utilisateur currentInfos = (Utilisateur) request.getSession().getAttribute("_UTILISATEUR_COURANT");
			
			Utilisateur user = gestionUtilisateurs.modifierInfos(currentInfos, nom, prenom, email, motDePasse, telephone, adresse);
			
			request.getSession().setAttribute(Utilisateur._UTILISATEUR_COURANT, user);
			
			getServletContext().getRequestDispatcher("/profilePage.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
