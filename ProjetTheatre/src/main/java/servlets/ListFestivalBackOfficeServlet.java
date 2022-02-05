package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Festival;
import ejbs.GestionFestivals;

/**
 * Servlet implementation class ListPieceBackOfficeServlet
 */
@WebServlet("/bo/festival")
public class ListFestivalBackOfficeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	GestionFestivals gestionFestivals;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListFestivalBackOfficeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Festival> festivals = gestionFestivals.findAll();
		request.setAttribute("festivals", festivals);
		request.setAttribute("pageName", "Festival");
		getServletContext().getRequestDispatcher("/FestivalBackOfficeList.jsp").forward(request, response); 
	}

}
