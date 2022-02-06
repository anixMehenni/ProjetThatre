package beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the place database table.
 * 
 */
@Entity
@NamedQuery(name="Place.findAll", query="SELECT p FROM Place p")
public class Place implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int numero;

	//bi-directional many-to-many association to Billet
	@ManyToMany(mappedBy="places")
	private List<Billet> billets;

	//bi-directional many-to-one association to CategoriePlace
	@ManyToOne
	@JoinColumn(name="id_categorie_place")
	private CategoriePlace categoriePlace;

	public Place() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public List<Billet> getBillets() {
		return this.billets;
	}

	public void setBillets(List<Billet> billets) {
		this.billets = billets;
	}

	public CategoriePlace getCategoriePlace() {
		return this.categoriePlace;
	}

	public void setCategoriePlace(CategoriePlace categoriePlace) {
		this.categoriePlace = categoriePlace;
	}

}