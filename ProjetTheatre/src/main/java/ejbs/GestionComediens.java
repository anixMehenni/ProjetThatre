package ejbs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import beans.Comedien;

/**
 * Session Bean implementation class GestionComediens
 */
@Stateless
@LocalBean
@TransactionManagement(value=TransactionManagementType.BEAN)
public class GestionComediens {

	
	@PersistenceUnit
    private EntityManagerFactory emf;
	
	
    /**
     * Default constructor. 
     */
    public GestionComediens() {
    }
    
    public List<Comedien> findAll() {
    	EntityManager em = emf.createEntityManager();
    	TypedQuery<Comedien> query = em.createQuery("from Comedien", Comedien.class);
    	return query.getResultList();
    }

}
