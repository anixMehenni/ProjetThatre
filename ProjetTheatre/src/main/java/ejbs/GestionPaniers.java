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

import beans.Lieu;
import beans.Panier;
import beans.Piece;
import beans.Utilisateur;

/**
 * Session Bean implementation class GestionPaniers
 */
@Stateless
@LocalBean
@TransactionManagement(value=TransactionManagementType.BEAN)
public class GestionPaniers {

	
	@PersistenceUnit
    private EntityManagerFactory emf;
	
	
    /**
     * Default constructor. 
     */
    public GestionPaniers() {
    }
    
    public Panier getLastPanier(Utilisateur utilisateur) {
    	EntityManager em = emf.createEntityManager();
    	TypedQuery<Panier> query = em.createQuery(
    			"from Panier p WHERE p.utilisateur = :utilisateur and p.statut = :statut ORDER BY p.dateCreation DESC", 
    			Panier.class
			);    	
    	query.setParameter("utilisateur", utilisateur)
    		.setParameter("statut", "A PAYER")
    		.setMaxResults(1);
    	
    	Panier panier =	query.getResultStream().findFirst().orElse(null);
    	if (panier != null) {
    		return panier;   		
    	} else {
    		Panier newPanier = new Panier();
    		newPanier.setUtilisateur(utilisateur);
    		EntityTransaction et = em.getTransaction();
    		et.begin();
    		em.persist(newPanier);
    		et.commit();
    		
    		return newPanier;
    	}
    }
    
    public List<Panier> findAll(Utilisateur utilisateur) {
    	EntityManager em = emf.createEntityManager();
    	TypedQuery<Panier> query = em.createQuery(
    			"from Panier p WHERE p.utilisateur = :utilisateur ORDER BY p.dateCreation DESC", 
    			Panier.class
			);    	
    	query.setParameter("utilisateur", utilisateur);

    	return query.getResultList();
    }

}
