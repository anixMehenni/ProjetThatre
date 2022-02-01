package beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the festival database table.
 * 
 */
@Entity
@NamedQuery(name="Festival.findAll", query="SELECT f FROM Festival f")
public class Festival implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_creation")
	private Date dateCreation;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_debut")
	private Date dateDebut;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_fin")
	private Date dateFin;

	@Lob
	private String description;

	private String nom;

	private String ville;

	//bi-directional many-to-one association to Organisateur
	@ManyToOne
	@JoinColumn(name="id_organisateur")
	private Organisateur organisateur;

	//bi-directional many-to-one association to Sponsor
	@ManyToOne
	@JoinColumn(name="id_sponsor")
	private Sponsor sponsor;

	//bi-directional many-to-one association to Representation
	@OneToMany(mappedBy="festival")
	private List<Representation> representations;

	public Festival() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateDebut() {
		return this.dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Organisateur getOrganisateur() {
		return this.organisateur;
	}

	public void setOrganisateur(Organisateur organisateur) {
		this.organisateur = organisateur;
	}

	public Sponsor getSponsor() {
		return this.sponsor;
	}

	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}

	public List<Representation> getRepresentations() {
		return this.representations;
	}

	public void setRepresentations(List<Representation> representations) {
		this.representations = representations;
	}

	public Representation addRepresentation(Representation representation) {
		getRepresentations().add(representation);
		representation.setFestival(this);

		return representation;
	}

	public Representation removeRepresentation(Representation representation) {
		getRepresentations().remove(representation);
		representation.setFestival(null);

		return representation;
	}

}