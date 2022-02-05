package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Piece;
import ejbs.GestionPieces;

/**
 * Servlet implementation class ViewPiece
 */
@WebServlet("/piece/view")
public class ViewPiece extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	GestionPieces gestionPieces;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPiece() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Piece piece = gestionPieces.findOne(id);
		request.setAttribute("piece", piece);
		request.setAttribute("pageName", piece.getNom());
		HttpSession session = request.getSession();
		if (session.getAttribute("createdComment") != null) {			
			request.setAttribute("createdComment", true);
			session.removeAttribute("createdComment");
		}
		getServletContext().getRequestDispatcher("/Piece.jsp").forward(request, response);     
	}

}
