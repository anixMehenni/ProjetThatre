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

import beans.Lieu;

/**
 * Session Bean implementation class GestionLieux
 */
@Stateless
@LocalBean
@TransactionManagement(value=TransactionManagementType.BEAN)
public class GestionLieux {

	
	@PersistenceUnit
    private EntityManagerFactory emf;
	
	
    /**
     * Default constructor. 
     */
    public GestionLieux() {
    }
    
    public List<Lieu> findAll() {
    	EntityManager em = emf.createEntityManager();
    	TypedQuery<Lieu> query = em.createQuery("from Lieu", Lieu.class);
    	return query.getResultList();
    }

}
