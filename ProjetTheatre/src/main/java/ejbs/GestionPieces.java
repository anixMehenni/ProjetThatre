package ejbs;

import java.util.ArrayList;
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

import beans.Comedien;
import beans.ComedienPiece;
import beans.EquipeTechnique;
import beans.Personne;
import beans.Piece;
import beans.Role;

/**
 * Session Bean implementation class GestionPieces
 */
@Stateless
@LocalBean
@TransactionManagement(value=TransactionManagementType.BEAN)
public class GestionPieces {

	
	@PersistenceUnit
    private EntityManagerFactory emf;
	
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public GestionPieces() {
    }
    
    private List<ComedienPiece> createComediensPiece(Piece piece, String[] comedienIds, String[] comedienRoles) {
    	List<ComedienPiece> comediensPiece = new ArrayList<>();
    	for (int i = 0; i < comedienIds.length; i++) {
    		ComedienPiece comedienPiece = new ComedienPiece();
    		comedienPiece.setPiece(piece);
    		comedienPiece.setRole(comedienRoles[i]);
    		comedienPiece.setComedien(em.getReference(Comedien.class, Integer.parseInt(comedienIds[i])));
    		comediensPiece.add(comedienPiece);
    		
    	}
    	return comediensPiece;
    }
    
    private List<EquipeTechnique> createEquipeTechnique(Piece piece, String[] personneIds, String[] personneRoles) {
    	List<EquipeTechnique> equipeTechnique = new ArrayList<>();
    	for (int i = 0; i < personneIds.length; i++) {
    		EquipeTechnique personneRole = new EquipeTechnique();
    		personneRole.setPiece(piece);
    		personneRole.setPersonne(em.getReference(Personne.class, Integer.parseInt(personneIds[i])));
    		personneRole.setRole(em.getReference(Role.class, Integer.parseInt(personneRoles[i])));
    		equipeTechnique.add(personneRole);
    		
    	}
    	return equipeTechnique;
    }
    
    public Piece create(Map<String, String[]> formValues) {
    	em = emf.createEntityManager();
    	EntityTransaction et = em.getTransaction();
    	
    	Piece newPiece = new Piece();
    	newPiece.setNom(formValues.get("nom")[0]);
    	newPiece.setAuteur(formValues.get("auteur")[0]);
    	newPiece.setDescription(formValues.get("description")[0]);
    	newPiece.setNom(formValues.get("nom")[0]);
    	List<ComedienPiece> comediensPiece = createComediensPiece(newPiece, formValues.get("comediens"), formValues.get("rolesComediens"));
    	List<EquipeTechnique> equipeTechnique = createEquipeTechnique(newPiece, formValues.get("personnes"), formValues.get("rolesPersonnes"));
    	newPiece.setComedienPieces(comediensPiece);
    	newPiece.setEquipeTechniques(equipeTechnique);

    	et.begin();
    	em.persist(newPiece);
    	et.commit();
    	return newPiece;
    }
    
    public Piece findOne(int id) {
    	return emf.createEntityManager().find(Piece.class, id);
    }

}
