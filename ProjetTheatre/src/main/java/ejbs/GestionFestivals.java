package ejbs;

import java.io.File;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.servlet.http.Part;

import beans.Festival;
import beans.Organisateur;
import beans.Photo;
import beans.Sponsor;

/**
 * Session Bean implementation class GestionFestivals
 */
@Stateless
@LocalBean
@TransactionManagement(value=TransactionManagementType.BEAN)
public class GestionFestivals {

	
	@PersistenceUnit
    private EntityManagerFactory emf;
	
	@EJB
	GestionPhotos gestionPhotos;	
	
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public GestionFestivals() {
    }
    
    public Festival create(Map<String, String[]> formValues, List<Part> photos,  String uploadPath) {
    	Festival newFestival = new Festival();
    	try {
	    	em = emf.createEntityManager();
	    	EntityTransaction et = em.getTransaction();
	    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE);
	    	
	    	newFestival.setNom(formValues.get("nom")[0]);
	    	newFestival.setVille(formValues.get("ville")[0]);
	    	newFestival.setDescription(formValues.get("description")[0]);
	    	newFestival.setDateDebut(formatter.parse(formValues.get("dateDebut")[0]));
	    	newFestival.setDateFin(formatter.parse(formValues.get("dateFin")[0]));
	    	
	    	List<Sponsor> sponsors = Arrays.stream(formValues.get("sponsors"))
				.map(sponsorId -> em.getReference(Sponsor.class, Integer.parseInt(sponsorId)))
				.collect(Collectors.toList());
	    	List<Organisateur> organisateurs = Arrays.stream(formValues.get("organisateurs"))
	    		.map(organisateurId -> em.getReference(Organisateur.class, Integer.parseInt(organisateurId)))
	    		.collect(Collectors.toList());

	    	newFestival.setSponsors(sponsors);
	    	newFestival.setOrganisateurs(organisateurs);
	    	
	    	List<Photo> newPhotos = gestionPhotos.savePhotos(photos, uploadPath);
	    	newPhotos.stream().forEach(photo -> photo.setFestival(newFestival));
    		newFestival.setPhotos(newPhotos);
	
	    	et.begin();
	    	em.persist(newFestival);
	    	et.commit();
	    	
    	} catch(Exception e) {	
    		
    	}

		return newFestival;
    }
    
    public List<Festival> findAll() {
    	EntityManager em = emf.createEntityManager();
    	TypedQuery<Festival> query = em.createQuery("from Festival", Festival.class);
    	return query.getResultList();
    }

}
