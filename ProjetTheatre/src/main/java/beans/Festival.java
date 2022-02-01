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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	//bi-directional many-to-many association to Organisateur
	@ManyToMany
	@JoinTable(
		name="festival_organisateur"
		, joinColumns={
			@JoinColumn(name="id_festival")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_organisateur")
			}
		)
	private List<Organisateur> organisateurs;

	//bi-directional many-to-many association to Sponsor
	@ManyToMany
	@JoinTable(
		name="festival_sponsor"
		, joinColumns={
			@JoinColumn(name="id_festival")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_sponsor")
			}
		)
	private List<Sponsor> sponsors;

	//bi-directional many-to-one association to Photo
	@OneToMany(mappedBy="festival")
	private List<Photo> photos;

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

	public List<Organisateur> getOrganisateurs() {
		return this.organisateurs;
	}

	public void setOrganisateurs(List<Organisateur> organisateurs) {
		this.organisateurs = organisateurs;
	}

	public List<Sponsor> getSponsors() {
		return this.sponsors;
	}

	public void setSponsors(List<Sponsor> sponsors) {
		this.sponsors = sponsors;
	}

	public List<Photo> getPhotos() {
		return this.photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public Photo addPhoto(Photo photo) {
		getPhotos().add(photo);
		photo.setFestival(this);

		return photo;
	}

	public Photo removePhoto(Photo photo) {
		getPhotos().remove(photo);
		photo.setFestival(null);

		return photo;
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