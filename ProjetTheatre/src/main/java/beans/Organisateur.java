package objetsMetier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the organisateur database table.
 * 
 */
@Entity
@NamedQuery(name="Organisateur.findAll", query="SELECT o FROM Organisateur o")
public class Organisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nom;

	//bi-directional many-to-one association to Festival
	@OneToMany(mappedBy="organisateur")
	private List<Festival> festivals;

	public Organisateur() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Festival> getFestivals() {
		return this.festivals;
	}

	public void setFestivals(List<Festival> festivals) {
		this.festivals = festivals;
	}

	public Festival addFestival(Festival festival) {
		getFestivals().add(festival);
		festival.setOrganisateur(this);

		return festival;
	}

	public Festival removeFestival(Festival festival) {
		getFestivals().remove(festival);
		festival.setOrganisateur(null);

		return festival;
	}

}