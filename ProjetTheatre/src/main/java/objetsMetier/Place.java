package objetsMetier;

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
	private int id;

	private byte disponible;

	private int numero;

	private int place;

	private byte reserve;

	private int type;

	//bi-directional many-to-one association to BilletPlace
	@OneToMany(mappedBy="place")
	private List<BilletPlace> billetPlaces;

	public Place() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getDisponible() {
		return this.disponible;
	}

	public void setDisponible(byte disponible) {
		this.disponible = disponible;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getPlace() {
		return this.place;
	}

	public void setPlace(int place) {
		this.place = place;
	}

	public byte getReserve() {
		return this.reserve;
	}

	public void setReserve(byte reserve) {
		this.reserve = reserve;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<BilletPlace> getBilletPlaces() {
		return this.billetPlaces;
	}

	public void setBilletPlaces(List<BilletPlace> billetPlaces) {
		this.billetPlaces = billetPlaces;
	}

	public BilletPlace addBilletPlace(BilletPlace billetPlace) {
		getBilletPlaces().add(billetPlace);
		billetPlace.setPlace(this);

		return billetPlace;
	}

	public BilletPlace removeBilletPlace(BilletPlace billetPlace) {
		getBilletPlaces().remove(billetPlace);
		billetPlace.setPlace(null);

		return billetPlace;
	}

}