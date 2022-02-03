package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbs.GestionUtilisateurs;

/**
 * Servlet implementation class CreationCompteModerateur
 */
@WebServlet("/CreationCompteModerateurServlet")
public class CreationCompteModerateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	GestionUtilisateurs gestionUtilisateurs;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationCompteModerateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/createModerateur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nom = request.getParameter("nom");
	        String prenom = request.getParameter("prenom");
	        String email = request.getParameter("email");
	        String motDePasse = request.getParameter("motDePasse");
	        String telephone = request.getParameter("telephone");
	        String adresse = request.getParameter("adresse");
	        String role = request.getParameter("type");
	        
	        int resultat = gestionUtilisateurs.ajouterNouveauModerateur(nom, prenom, email, motDePasse, telephone, adresse, role);
	        
	        if (resultat == 1) {
	        getServletContext().getRequestDispatcher("/abonneAjouteSucces.jsp").forward(request, response);
	        }else {
	        	getServletContext().getRequestDispatcher("/abonneAjouteEchec.jsp").forward(request, response);
	        }
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
}	
