package ejbs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import beans.Billet;
import beans.Comedien;
import beans.Panier;
import beans.Place;
import beans.Representation;
import beans.Utilisateur;

/**
 * Session Bean implementation class GestionBillets
 */
@Stateless
@LocalBean
@TransactionManagement(value=TransactionManagementType.BEAN)
public class GestionBillets {

	
	@PersistenceUnit
    private EntityManagerFactory emf;
	
	@EJB
	private GestionPaniers gestionPaniers;
    /**
     * Default constructor. 
     */
    public GestionBillets() {
    }
    
    public Billet add(Map<String, String[]> formValues, Utilisateur utilisateur) {
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction et = em.getTransaction();
    	int representationId = Integer.parseInt(formValues.get("representationId")[0]);
    	List<String> placeIds = Arrays.asList(formValues.get("places"));
    	
    	List<Place> places = placeIds
    			.stream().map(id -> em.getReference(Place.class, Integer.parseInt(id)))
    			.collect(Collectors.toList()); 
    	Panier panier = gestionPaniers.getLastPanier(utilisateur);
    	
    	Billet newBillet = new Billet();
    	newBillet.setRepresentation(em.getReference(Representation.class, representationId));
    	newBillet.setPlaces(places);
    	newBillet.setPanier(panier);
    	
    	et.begin();
    	em.persist(newBillet);
    	et.commit();
    	
    	return newBillet;
    }
      

}
