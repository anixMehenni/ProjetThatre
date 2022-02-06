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
		
        for(Utilisateur user : resultatQuery) {
        	Utilisateur u = new Utilisateur();
        	u.setId(user.getId());
        	u.setEmail(user.getEmail());
        	u.setMotDePasse(user.getAdresse());
        	
        	users.add(u);
        }
        
        
        boolean exist = false;
        
        for(Utilisateur user : users) {
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
    
    public int ajouterNouveauModerateur (String nom, String prenom, 
    		String email, String motDePasse, String telephone, String adresse,String role) throws NoResultException{
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction et = em.getTransaction();
    	
    	Query query = em.createQuery("SELECT u FROM Utilisateur as u");
        List <Utilisateur> resultatQuery = query.getResultList();
        ArrayList<Utilisateur>  users = new ArrayList<Utilisateur>();
        
        for(Utilisateur user : resultatQuery) {
        	Utilisateur u = new Utilisateur();
        	u.setId(user.getId());
        	u.setEmail(user.getEmail());
        	u.setMotDePasse(user.getMotDePasse());
        	users.add(u);
        }
        
        boolean exist = false;
        
		for (Utilisateur user : users) {
			if (user.getEmail().equals(email)) {
				exist = true;
			}
		}
		        
        if (exist == false && role.equals("Modérateur")) {
        	Utilisateur newAbonne = new Utilisateur();
        	newAbonne.setNom(nom);
        	newAbonne.setPrenom(prenom);
        	newAbonne.setEmail(email);
        	newAbonne.setMotDePasse(motDePasse);
        	newAbonne.setAdresse(adresse);
        	newAbonne.setTelephone(telephone);
        	newAbonne.setDateCreation(new Date());
        	newAbonne.setRole("MODERATEUR");
        	
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
    
    public Utilisateur modifierInfos (Utilisateur curentInfos, String nom, String prenom, 
    		String email, String motDePasse, String telephone, String adresse) throws NoResultException{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
        Query query = em
                .createQuery("SELECT u FROM Utilisateur as u where u.id like :id");
        query.setParameter("id", curentInfos.getId());
        
        Utilisateur resultatQuery = (Utilisateur) query.getSingleResult();
        
        Utilisateur user = new Utilisateur();
        user.setNom(resultatQuery.getNom());
        user.setPrenom(resultatQuery.getPrenom());
        user.setEmail(resultatQuery.getEmail());
        user.setMotDePasse(resultatQuery.getMotDePasse());
        user.setTelephone(resultatQuery.getTelephone());
        user.setAdresse(resultatQuery.getAdresse());
        
        if (!user.getNom().equals(nom)) {
        	resultatQuery.setNom(nom);
        }
        if (!user.getPrenom().equals(prenom)) {
        	resultatQuery.setPrenom(prenom);
        }
        if (!user.getEmail().equals(email)) {
        	resultatQuery.setEmail(email);
        }
        if (!user.getMotDePasse().equals(motDePasse)) {
        	resultatQuery.setMotDePasse(motDePasse);
        }
        if (!user.getTelephone().equals(telephone)) {
        	resultatQuery.setTelephone(telephone);
        }
        if (!user.getAdresse().equals(adresse)) {
        	resultatQuery.setAdresse(adresse);
        }
        
        et.begin();
    	em.merge(resultatQuery);
    	et.commit();
        
        resultatQuery = (Utilisateur) query.getSingleResult();
        return resultatQuery;

	
}

}
