package servlets;

import java.io.IOException;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utilisateur;
import ejbs.GestionCommentaires;

/**
 * Servlet implementation class AddCommentaireServlet
 */
@WebServlet("/commentaire/add")
public class AddCommentaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@EJB
	GestionCommentaires gestionCommentaires;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentaireServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> formValues = request.getParameterMap();
		
		Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute(Utilisateur._UTILISATEUR_COURANT);
		gestionCommentaires.add(formValues, utilisateur);
		request.getSession().setAttribute("createdComment", true);
		response.sendRedirect(request.getContextPath() + "/piece/view?id=" + request.getParameter("piece"));
	}

}
