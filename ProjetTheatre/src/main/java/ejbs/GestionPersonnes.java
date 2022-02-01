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

import beans.Personne;

/**
 * Session Bean implementation class GestionPersonnes
 */
@Stateless
@LocalBean
@TransactionManagement(value=TransactionManagementType.BEAN)
public class GestionPersonnes {

	
	@PersistenceUnit
    private EntityManagerFactory emf;
	
	
    /**
     * Default constructor. 
     */
    public GestionPersonnes() {
    }
    
    public List<Personne> findAll() {
    	EntityManager em = emf.createEntityManager();
    	TypedQuery<Personne> query = em.createQuery("from Personne", Personne.class);
    	return query.getResultList();
    }

}
