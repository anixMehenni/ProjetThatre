package ejbs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import beans.Utilisateur;

/**
 * Session Bean implementation class GestionUtilisateurs
 */
@Stateless
@LocalBean
@TransactionManagement(value=TransactionManagementType.BEAN)
public class GestionUtilisateurs {

	
	@PersistenceUnit
    private EntityManagerFactory emf;
	
    /**
     * Default constructor. 
     */
    public GestionUtilisateurs() {
        // TODO Auto-generated constructor stub
    }
    
    public void ajouterNouveauAbonne (String nom, String prenom, 
    		String email, String motDePasse, String telephone, String adresse){
    	try{EntityManager em = emf.createEntityManager();
    	EntityTransaction et = em.getTransaction();
    	
    	Utilisateur newAbonne = new Utilisateur();
    	newAbonne.setNom(nom);
    	newAbonne.setPrenom(prenom);
    	newAbonne.setEmail(email);
    	newAbonne.setMotDePasse(motDePasse);
    	newAbonne.setAdresse(adresse);
    	newAbonne.setTelephone(telephone);
    	newAbonne.setDateCreation(new Date());
    	
    	newAbonne.setRole("ABONNE");
    	
    	et.begin();
    	em.persist(newAbonne);
    	et.commit();}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    }
    
    public Utilisateur seConnecter (String email, String motDePasse){
    		EntityManager em = emf.createEntityManager();
            Query query = em
                    .createQuery("SELECT u FROM Utilisateur as u where u.email like :email");
            query.setParameter("email", email);
            Utilisateur resultatQuery = (Utilisateur) query.getSingleResult();
            
            Utilisateur currentUser = new Utilisateur();
            currentUser.setPrenom(resultatQuery.getPrenom());
            currentUser.setAdresse(resultatQuery.getAdresse());
            currentUser.setActif(resultatQuery.getActif());
            
            
            if (resultatQuery.getMotDePasse() == motDePasse) {
            	return currentUser;
            }
            return currentUser;

    	
    }

}
