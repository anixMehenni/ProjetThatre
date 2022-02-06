package ejbs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import beans.Billet;
import beans.CategoriePlace;
import beans.Lieu;
import beans.Place;
import beans.Representation;

/**
 * Session Bean implementation class GestionPlaces
 */
@Stateless
@LocalBean
@TransactionManagement(value=TransactionManagementType.BEAN)
public class GestionPlaces {

	
	@PersistenceUnit
    private EntityManagerFactory emf;
	
	
    /**
     * Default constructor. 
     */
    public GestionPlaces() {
    }
    
    public List<CategoriePlace> findAllCategories() {
    	EntityManager em = emf.createEntityManager();
    	TypedQuery<CategoriePlace> query = em.createQuery("from CategoriePlace", CategoriePlace.class);
    	return query.getResultList();
    }
    
    public List<Place> findAll() {
    	EntityManager em = emf.createEntityManager();
    	TypedQuery<Place> query = em.createQuery("from Place", Place.class);
    	return query.getResultList();
    }
    
    public List<Integer> findReservedByRepresentation(int representationId) {
    	EntityManager em = emf.createEntityManager();
    	TypedQuery<Billet> query = em.createQuery(
    			"from Billet as b where b.representation = :representationId and b.estSupprime = 0", 
    			Billet.class
			);
    	query.setParameter("representationId", em.getReference(Representation.class, representationId));
    	List<Billet> billets = query.getResultList();
    	Set<Integer> reservationIds = new HashSet<>();
    	for (Billet billet : billets) {
    		List<Place> places = billet.getPlaces();
    		places.stream().forEach(place -> reservationIds.add(place.getId()));
    	}
    	
    	return new ArrayList<Integer>(reservationIds);
    }

}
