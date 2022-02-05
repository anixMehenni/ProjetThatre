package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbs.GestionPaniers;

/**
 * Servlet implementation class PayPanierServlet
 */
@WebServlet("/panier/pay")
public class PayPanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	GestionPaniers gestionPaniers;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayPanierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		gestionPaniers.pay(id);
		response.sendRedirect(request.getContextPath() + "/paniers");
	}

}
