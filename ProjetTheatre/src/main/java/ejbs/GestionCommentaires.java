package ejbs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import beans.Commentaire;

/**
 * Session Bean implementation class GestionCommentaires
 */
@Stateless
@LocalBean
@TransactionManagement(value=TransactionManagementType.BEAN)
public class GestionCommentaires {

	
	@PersistenceUnit
    private EntityManagerFactory emf;
	
	
    /**
     * Default constructor. 
     */
    public GestionCommentaires() {
    }
    
    public List<Commentaire> findAll() {
    	EntityManager em = emf.createEntityManager();
    	TypedQuery<Commentaire> query = em.createQuery("from Commentaire", Commentaire.class);
    	return query.getResultList();
    }
    
    public void changeStatus(int id, String status) {
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction et = em.getTransaction();
    	Commentaire commentaire = em.find(Commentaire.class, id);
    	commentaire.setStatut(status);
    	et.begin();
    	em.persist(commentaire);
    	et.commit();
    }

}
