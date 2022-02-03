package ejbs;

import java.util.List;
import java.util.Map;

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
import beans.Piece;
import beans.Utilisateur;

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
    
    public Commentaire add(Map<String, String[]> formValues, Utilisateur utilisateur) {
    	EntityManager em = emf.createEntityManager();
		Commentaire newCommentaire = new Commentaire();
		newCommentaire.setNote(Short.parseShort(formValues.get("note")[0]));
		newCommentaire.setCommentaire(formValues.get("commentaire")[0]);
		newCommentaire.setPiece(em.getReference(Piece.class, Integer.parseInt(formValues.get("piece")[0])));
		newCommentaire.setUtilisateur(utilisateur);
		newCommentaire.setStatut(Commentaire.StatutEnum.CREE.toString());

    	EntityTransaction et = em.getTransaction();
    	et.begin();
    	em.persist(newCommentaire);
    	et.commit();
    	
		return newCommentaire;
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
