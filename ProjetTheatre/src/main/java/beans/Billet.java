package beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the billet database table.
 * 
 */
@Entity
@NamedQuery(name="Billet.findAll", query="SELECT b FROM Billet b")
public class Billet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_reservation")
	private Date dateReservation = new Date();

	@Column(name="est_supprime")
	private byte estSupprime = 0;

	@Column(name="lien_telechargement")
	private String lienTelechargement;

	//bi-directional many-to-one association to Panier
	@ManyToOne()
	@JoinColumn(name="id_panier")
	private Panier panier;

	//bi-directional many-to-many association to Place
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
		name="billet_place"
		, joinColumns={
			@JoinColumn(name="id_billet")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_place")
			}		
		)
	private List<Place> places;

	//bi-directional many-to-one association to Representation
	@ManyToOne
	@JoinColumn(name="id_representation")
	private Representation representation;

	public Billet() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateReservation() {
		return this.dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	public byte getEstSupprime() {
		return this.estSupprime;
	}

	public void setEstSupprime(byte estSupprime) {
		this.estSupprime = estSupprime;
	}

	public String getLienTelechargement() {
		return this.lienTelechargement;
	}

	public void setLienTelechargement(String lienTelechargement) {
		this.lienTelechargement = lienTelechargement;
	}

	public Panier getPanier() {
		return this.panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public List<Place> getPlaces() {
		return this.places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}

	public Representation getRepresentation() {
		return this.representation;
	}

	public void setRepresentation(Representation representation) {
		this.representation = representation;
	}

}