package beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categorie_place database table.
 * 
 */
@Entity
@Table(name="categorie_place")
@NamedQuery(name="CategoriePlace.findAll", query="SELECT c FROM CategoriePlace c")
public class CategoriePlace implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String nom;

	private double prix;

	//bi-directional many-to-one association to Place
	@OneToMany(mappedBy="categoriePlace")
	private List<Place> places;

	public CategoriePlace() {
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

	public double getPrix() {
		return this.prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public List<Place> getPlaces() {
		return this.places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}

	public Place addPlace(Place place) {
		getPlaces().add(place);
		place.setCategoriePlace(this);

		return place;
	}

	public Place removePlace(Place place) {
		getPlaces().remove(place);
		place.setCategoriePlace(null);

		return place;
	}

}