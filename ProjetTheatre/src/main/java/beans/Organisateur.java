package beans;

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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String nom;

	//bi-directional many-to-many association to Festival
	@ManyToMany(mappedBy="organisateurs")
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

}