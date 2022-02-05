package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Commentaire;
import beans.Piece;
import ejbs.GestionCommentaires;
import ejbs.GestionPieces;

/**
 * Servlet implementation class ListCommentaireBackOfficeServlet
 */
@WebServlet("/commentaire/validation")
public class ListCommentaireBackOfficeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB 
	GestionPieces gestionPieces;
	@EJB
	GestionCommentaires gestionCommentaires;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCommentaireBackOfficeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Commentaire> commentaires = gestionCommentaires.findAll(request.getParameterMap());
		List<Piece> pieces = gestionPieces.findAll();
		request.setAttribute("commentaires", commentaires);
		request.setAttribute("pieces", pieces);
		request.setAttribute("statuts", Commentaire.StatutEnum.values());
		request.setAttribute("pageName", "Gestion des commentaires");		
		getServletContext().getRequestDispatcher("/CommentaireBackOfficeList.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("commentaire"));
		String newStatut = request.getParameter("newStatut");
		gestionCommentaires.changeStatus(id, newStatut);
		doGet(request, response);
	}

}
