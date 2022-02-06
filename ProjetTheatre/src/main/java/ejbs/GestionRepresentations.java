package ejbs;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import beans.Festival;
import beans.Lieu;
import beans.Piece;
import beans.Representation;

/**
 * Session Bean implementation class GestionRepresentations
 */
@Stateless
@LocalBean
@TransactionManagement(value=TransactionManagementType.BEAN)
public class GestionRepresentations {

	
	@PersistenceUnit
    private EntityManagerFactory emf;
	
	
    /**
     * Default constructor. 
     */
    public GestionRepresentations() {
    }
    
    public List<Representation> addMultiple(Map<String, String[]> formValues) {
    	String[] festivalIds = formValues.get("festivals");
    	String[] lieuIds = formValues.get("lieux");
    	String[] dates = formValues.get("dates");
    	String[] heures = formValues.get("heures");
    	Integer pieceId = Integer.parseInt(formValues.get("piece")[0]);
    	

    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.FRANCE);
    	EntityManager em = emf.createEntityManager();    
    	EntityTransaction et = em.getTransaction();	
    	List<Representation> newRepresentations = new ArrayList<>();

    	et.begin();
    	for (int i = 0; i < festivalIds.length; i++) {
    		try {
    			Representation newRepresentation = new Representation();
    			newRepresentation.setPiece(em.getReference(Piece.class, pieceId));
    			newRepresentation.setFestival(em.getReference(Festival.class, Integer.parseInt(festivalIds[i])));
    			newRepresentation.setLieu(em.getReference(Lieu.class, Integer.parseInt(lieuIds[i])));
    			String fullDate = dates[i].concat(" ").concat(heures[i]);
    			newRepresentation.setDate(formatter.parse(fullDate));

    			newRepresentations.add(newRepresentation);
    			em.persist(newRepresentation);    			
    		} catch(Exception e) {}    		
    	}
    	
    	et.commit();
    	
    	return newRepresentations;
    }
    
    public Representation findOne(int id) {
    	EntityManager em = emf.createEntityManager();    
    	return em.find(Representation.class, id);
    }

}
