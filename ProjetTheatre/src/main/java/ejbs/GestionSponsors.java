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

import beans.Sponsor;

/**
 * Session Bean implementation class GestionSponsors
 */
@Stateless
@LocalBean
@TransactionManagement(value=TransactionManagementType.BEAN)
public class GestionSponsors {

	
	@PersistenceUnit
    private EntityManagerFactory emf;
	
	
    /**
     * Default constructor. 
     */
    public GestionSponsors() {
    }
    
    public List<Sponsor> findAll() {
    	EntityManager em = emf.createEntityManager();
    	TypedQuery<Sponsor> query = em.createQuery("from Sponsor", Sponsor.class);
    	return query.getResultList();
    }

}
