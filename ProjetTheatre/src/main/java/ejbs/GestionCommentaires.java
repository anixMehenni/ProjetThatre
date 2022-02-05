package ejbs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.mail.FetchProfile.Item;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
    
    public List<Commentaire> findAll(Map<String, String[]> formValues) {
    	Integer pieceId = formValues.get("piece") != null ? Integer.parseInt(formValues.get("piece")[0]) : null;
    	String statut = formValues.get("statut") != null && !formValues.get("statut")[0].isEmpty() ? formValues.get("statut")[0] : null;
    	if (pieceId != null) {    		
	    	EntityManager em = emf.createEntityManager();
	    	CriteriaBuilder cb = em.getCriteriaBuilder();
    		CriteriaQuery<Commentaire> cr = cb.createQuery(Commentaire.class);
    		Root<Commentaire> root = cr.from(Commentaire.class);
    		
    		List<Predicate> predicates = new ArrayList<>();
    		predicates.add(
				cb.equal(root.get("piece"), em.getReference(Piece.class, pieceId))
			);    		
    		if (statut != null) {
    			predicates.add(cb.equal(root.get("statut"), statut));
    		}    		
    		Predicate finalPredicate = cb.and(predicates.toArray(new Predicate[predicates.size()]));

    		cr.select(root)
    			.where(finalPredicate)
    			.orderBy(cb.desc(root.get("id")));
    		TypedQuery<Commentaire> query = em.createQuery(cr);
    			    	
	    	return query.getResultList();
    	} else {
    		return new ArrayList<Commentaire>();
    	}
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
