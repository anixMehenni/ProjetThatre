package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Piece;
import ejbs.VisualisationPieces;

/**
 * Servlet implementation class VisualiserPiece
 */
@WebServlet("/VisualiserPiece")
public class VisualiserPiece extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualiserPiece() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    VisualisationPieces pieces = new VisualisationPieces();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Piece piece = pieces.recupererPiece(Integer.valueOf(request.getParameter("id")));
		request.setAttribute("auteurPiece",piece.getAuteur());	
		request.setAttribute("nom",piece.getNom());	
		request.setAttribute("description",piece.getDescription());	
		getServletContext().getRequestDispatcher("/PieceTheatrePage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
