package objetsMetier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the paiement database table.
 * 
 */
@Entity
@NamedQuery(name="Paiement.findAll", query="SELECT p FROM Paiement p")
public class Paiement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="cryptogramme_visuel")
	private byte cryptogrammeVisuel;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_expiration")
	private Date dateExpiration;

	@Column(name="numero_carte")
	private String numeroCarte;

	//bi-directional many-to-one association to Panier
	@OneToMany(mappedBy="paiement")
	private List<Panier> paniers;

	public Paiement() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getCryptogrammeVisuel() {
		return this.cryptogrammeVisuel;
	}

	public void setCryptogrammeVisuel(byte cryptogrammeVisuel) {
		this.cryptogrammeVisuel = cryptogrammeVisuel;
	}

	public Date getDateExpiration() {
		return this.dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public String getNumeroCarte() {
		return this.numeroCarte;
	}

	public void setNumeroCarte(String numeroCarte) {
		this.numeroCarte = numeroCarte;
	}

	public List<Panier> getPaniers() {
		return this.paniers;
	}

	public void setPaniers(List<Panier> paniers) {
		this.paniers = paniers;
	}

	public Panier addPanier(Panier panier) {
		getPaniers().add(panier);
		panier.setPaiement(this);

		return panier;
	}

	public Panier removePanier(Panier panier) {
		getPaniers().remove(panier);
		panier.setPaiement(null);

		return panier;
	}

}