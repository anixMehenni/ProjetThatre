package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbs.GestionUtilisateurs;

/**
 * Servlet implementation class CreationCompteAbonneServlet
 */
@WebServlet("/CreationCompteAbonneServlet")
public class CreationCompteAbonneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	GestionUtilisateurs gestionUtilisateurs;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationCompteAbonneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/signupPage.jsp").forward(request, response);
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
	        
	        int resultat = gestionUtilisateurs.ajouterNouveauAbonne(nom, prenom, email, motDePasse, telephone, adresse);
	        
	        if (resultat == 1) {
	        getServletContext().getRequestDispatcher("/ConnexionAbonneServlet").forward(request, response);
	        }else {
	        	getServletContext().getRequestDispatcher("/CreationCompteAbonneServlet").forward(request, response);
	        }
		}catch(Exception e) {
			e.printStackTrace();
		}
}
	}


