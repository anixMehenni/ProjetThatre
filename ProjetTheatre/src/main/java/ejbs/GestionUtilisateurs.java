package ejbs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
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
    
    public int ajouterNouveauAbonne (String nom, String prenom, 
    		String email, String motDePasse, String telephone, String adresse) throws NoResultException{
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction et = em.getTransaction();
    	
    	Query query = em.createQuery("SELECT u FROM Utilisateur as u");
        List <Utilisateur> resultatQuery = query.getResultList();
        ArrayList <Utilisateur> users = new ArrayList <Utilisateur>();
        boolean exist = false;
		
        for(Utilisateur user : resultatQuery) {
        	Utilisateur u = new Utilisateur();
        	u.setId(user.getId());
        	u.setEmail(user.getEmail());
        	u.setMotDePasse(user.getAdresse());
        	
        	users.add(u);
        }
        
        for(Utilisateur user : users) {
        System.out.print(user.getEmail());
        if(user.getEmail().equals(email)) {exist = true;}
        }
        
        if (exist == false) {
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
        	et.commit();
        	return 1;
        }else {
        	return 0;
        }
    	
    	
    }
    
    public Utilisateur seConnecter (String email, String motDePasse) throws NoResultException{
    		EntityManager em = emf.createEntityManager();
            Query query = em
                    .createQuery("SELECT u FROM Utilisateur as u where u.email like :email and u.motDePasse like :motDePasse");
            query.setParameter("email", email);
            query.setParameter("motDePasse", motDePasse);
            Utilisateur resultatQuery = (Utilisateur) query.getSingleResult();
            
            Utilisateur currentUser = new Utilisateur();
            currentUser.setPrenom(resultatQuery.getPrenom());
            currentUser.setAdresse(resultatQuery.getAdresse());
            currentUser.setActif(resultatQuery.getActif());
            
            return resultatQuery;

    	
    }

}
