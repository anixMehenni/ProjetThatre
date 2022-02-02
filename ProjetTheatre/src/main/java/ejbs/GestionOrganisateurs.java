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

import beans.Organisateur;

/**
 * Session Bean implementation class GestionOrganisateurs
 */
@Stateless
@LocalBean
@TransactionManagement(value=TransactionManagementType.BEAN)
public class GestionOrganisateurs {

	
	@PersistenceUnit
    private EntityManagerFactory emf;
	
	
    /**
     * Default constructor. 
     */
    public GestionOrganisateurs() {
    }
    
    public List<Organisateur> findAll() {
    	EntityManager em = emf.createEntityManager();
    	TypedQuery<Organisateur> query = em.createQuery("from Organisateur", Organisateur.class);
    	return query.getResultList();
    }

}
