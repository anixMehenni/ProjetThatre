package beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the panier database table.
 * 
 */
@Entity
@NamedQuery(name="Panier.findAll", query="SELECT p FROM Panier p")
public class Panier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_creation")
	private Date dateCreation = new Date();

	private String statut = "A PAYER";

	//bi-directional many-to-one association to Billet
	@OneToMany(mappedBy="panier")
	private List<Billet> billets;

	//bi-directional many-to-one association to Paiement
	@ManyToOne
	@JoinColumn(name="id_paiement")
	private Paiement paiement;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="id_utilisateur")
	private Utilisateur utilisateur;

	public Panier() {
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

	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public List<Billet> getBillets() {
		return this.billets;
	}

	public void setBillets(List<Billet> billets) {
		this.billets = billets;
	}

	public Billet addBillet(Billet billet) {
		getBillets().add(billet);
		billet.setPanier(this);

		return billet;
	}

	public Billet removeBillet(Billet billet) {
		getBillets().remove(billet);
		billet.setPanier(null);

		return billet;
	}

	public Paiement getPaiement() {
		return this.paiement;
	}

	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}