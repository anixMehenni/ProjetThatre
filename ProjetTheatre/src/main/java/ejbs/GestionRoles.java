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
import beans.Role;

/**
 * Session Bean implementation class GestionRoles
 */
@Stateless
@LocalBean
@TransactionManagement(value=TransactionManagementType.BEAN)
public class GestionRoles {

	
	@PersistenceUnit
    private EntityManagerFactory emf;
	
	
    /**
     * Default constructor. 
     */
    public GestionRoles() {
    }
    
    public List<Role> findAll() {
    	EntityManager em = emf.createEntityManager();
    	TypedQuery<Role> query = em.createQuery("from Role", Role.class);
    	return query.getResultList();
    }

}
