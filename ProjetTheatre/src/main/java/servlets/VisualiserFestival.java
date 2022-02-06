package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Festival;
import ejbs.VisualisationFestivals;


@WebServlet("/VisualiserFestival")
public class VisualiserFestival extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	VisualisationFestivals festival = new VisualisationFestivals();

    public VisualiserFestival() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Festival fest = festival.recupererFestival();
		String sponsor = festival.recupererSponsor(fest.getId());
		List<String> photos = festival.recupererPhotosPieces(fest.getId());
		List<String> Ids = festival.recupererIdsPieces(fest.getId());
		List<String> organisateurs = festival.recupererOrganisateurs(fest.getId());
		System.out.println("HEEEEEY" +organisateurs.get(0));
		request.setAttribute("nomFestival",fest.getNom());
		request.setAttribute("villeFestival",fest.getVille());
		request.setAttribute("descriptionFestival",fest.getDescription());
		request.setAttribute("DateDebutFestival",fest.getDateDebut());
		request.setAttribute("DateFinFestival",fest.getDateFin());
		request.setAttribute("sponsor",sponsor);
		request.setAttribute("photos",photos);
		request.setAttribute("Ids", Ids);
		request.setAttribute("organisateurs", organisateurs);
		getServletContext().getRequestDispatcher("/festivalPage.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
