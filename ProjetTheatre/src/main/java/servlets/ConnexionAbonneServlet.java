package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import ejbs.GestionUtilisateurs;


/**
 * Servlet implementation class ConnexionAbonneServlet
 */
@WebServlet("/ConnexionAbonneServlet")
public class ConnexionAbonneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	GestionUtilisateurs gestionUtilisateurs;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionAbonneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
        String email = request.getParameter("email");
        String motDePasse = request.getParameter("motDePasse");
        
        Utilisateur currentUser =  gestionUtilisateurs.seConnecter(email, motDePasse);
        System.out.println(currentUser.getPrenom());
        
        
        	 
                 response.setContentType("text/html");
            
                 HttpSession session = request.getSession();
                 session.setAttribute(Utilisateur._UTILISATEUR_COURANT, currentUser);
                 getServletContext().getRequestDispatcher("/connexionReussie.jsp")
                         .forward(request, response);
             
		     }catch (NoResultException e) {
		    	 getServletContext().getRequestDispatcher("/connexionEchouee.jsp")
                 .forward(request, response);
             }
		
			catch (Exception e) {
				getServletContext().getRequestDispatcher("/connexionEchouee.jsp")
                .forward(request, response);
             }
        }
	

}
