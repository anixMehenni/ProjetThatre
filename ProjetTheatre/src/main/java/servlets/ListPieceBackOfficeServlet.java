package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Piece;
import ejbs.GestionPieces;

/**
 * Servlet implementation class ListPieceBackOfficeServlet
 */
@WebServlet("/bo/piece")
public class ListPieceBackOfficeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	GestionPieces gestionPieces;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPieceBackOfficeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Piece> pieces = gestionPieces.findAll();
		request.setAttribute("pieces", pieces);
		request.setAttribute("pageName", "Pièces");
		getServletContext().getRequestDispatcher("/PieceBackOfficeList.jsp").forward(request, response); 
	}

}
